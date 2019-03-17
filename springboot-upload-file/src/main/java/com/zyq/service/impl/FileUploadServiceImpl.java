package com.zyq.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.zyq.config.FileUploadProperties;
import com.zyq.service.FileUploadService;

@Service
@EnableConfigurationProperties({ FileUploadProperties.class })
public class FileUploadServiceImpl implements FileUploadService {

	private final Path rootLocation;
	
	@Autowired
	public FileUploadServiceImpl(FileUploadProperties fileUploadProperties) {
		this.rootLocation = Paths.get(fileUploadProperties.getLocation());
	}

	@Override
	public void store(MultipartFile file) throws Exception {
		try {
			if (file.isEmpty()) {
				throw new Exception("Failed to store empty file " + file.getOriginalFilename());
			}
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (IOException e) {
			throw new Exception("Failed to store file " + file.getOriginalFilename(), e);
		}
	}

	@Override
	public Stream<Path> loadAll() throws Exception {
		try {
			return Files.walk(this.rootLocation, 1).filter(path -> !path.equals(this.rootLocation)).map(path -> this.rootLocation.relativize(path));
		} catch (IOException e) {
			throw new Exception("Failed to read stored files", e);
		}

	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) throws Exception {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new Exception("Could not read file: " + filename);

			}
		} catch (MalformedURLException e) {
			throw new Exception("Could not read file: " + filename, e);
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	@Override
	public void init() throws Exception {
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			throw new Exception("Could not initialize storage", e);
		}
	}
}
