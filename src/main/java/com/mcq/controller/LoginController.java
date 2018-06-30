package com.mcq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	
	@GetMapping("/loginPage")
	public String shoMyLoginPage()
	{
		return "login-page";
	}
	
	//add  request mapping for leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		
		return "leaders";
	}
	
	//add  request mapping for systems
	@GetMapping("/systems")
	public String showSystems() {
		
		return "systems";
	}
	
	//access denied
	@GetMapping("/access-denied")
	public String access()
	{
		return "access-denied";
	}
}
