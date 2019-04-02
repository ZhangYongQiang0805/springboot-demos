package com.zyq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyq.entity.User;
import com.zyq.service.ConsumerService;

@SpringBootApplication
@RestController
@ImportResource(value = {"classpath:dubbo-consumer.xml"})
public class SpringbootDubboConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboConsumerApplication.class, args);
	}
	
	@Autowired
	ConsumerService consumerService;

	@RequestMapping("/getUsers")
    public List<User> getUsers(@RequestParam ("id") String id) {
        return consumerService.getUsers(id);
    }
}
