package com.myproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value="/home")
	public ModelAndView home(){
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/signup")
	public ModelAndView signup(){
		return new ModelAndView("signup");
	}
}
