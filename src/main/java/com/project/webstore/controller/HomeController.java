package com.project.webstore.controller;

import java.util.Map;

import javax.swing.text.View;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceView;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping
	public String welcome(Model model, RedirectAttributes redirectAttributes) {
		model.addAttribute("greeting", "Welcome to Udemy!");
		model.addAttribute("tagline", "Choose your course and start learning now");

		redirectAttributes.addFlashAttribute("greeting", "Welcome to Udemy!");
		redirectAttributes.addFlashAttribute("tagline", "We offer the best tech courses");
		    
		return "redirect:/welcome/greeting";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
	   return "welcome";
	}

}
