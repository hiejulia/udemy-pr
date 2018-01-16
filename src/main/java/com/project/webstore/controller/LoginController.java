package com.project.webstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	/**
	 * LOGIN PAGE
	 * @return
	 */
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public String login() {
      return "login";
   }
   
   
}
