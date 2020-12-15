package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello(Model model) {
		
		model.addAttribute("theDate",new Date());
		
		return "helloworld";
	}
	
}
