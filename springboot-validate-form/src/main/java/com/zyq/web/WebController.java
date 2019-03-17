package com.zyq.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zyq.entity.PersonForm;

@Controller
public class WebController extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/")
	public String showForm(PersonForm personForm) {
		return "form";
	}

	@PostMapping("/")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult, RedirectAttributes attr) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		// attr.addAttribute("personForm", personForm); // 相当于在重定向链接地址追加传递的参数，不安全，慎用。
		attr.addFlashAttribute("personForm", personForm);
		return "redirect:/results";
	}
}
