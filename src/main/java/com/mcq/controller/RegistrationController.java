package com.mcq.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mcq.repository.UserRepository;
import com.mcq.service.UserService;
import com.mcq.user.ResetPassword;
import com.mcq.user.User;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	@Autowired
	private UserService userService;
	
	//for encryption
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	//for validation (trim empty string to null)
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping("/showRegistrationForm")
	public String showMyRegistrationPage(Model theModel)
	{
		theModel.addAttribute("user",new User());
		
		return "registration-form";
	}
	
	
	@PostMapping("/processRegistrationForm")
	public ModelAndView processRegistrationForm(
			@Valid @ModelAttribute("user") User theUser,
			BindingResult theBindingResult,
			Model theModel,
			ModelAndView mv)
	{
		
		//form validation
		if(theBindingResult.hasErrors())
		{
			theModel.addAttribute("user",new User());
			theModel.addAttribute("registrationError","username/password cannot be empty");
			
			mv.setViewName("registration-form");
		}
		
		//check the database if user already exist
		if(doesUserExist(theUser.getUserName()))
		{
			theModel.addAttribute("user",new User());
			theModel.addAttribute("registrationError","User already exist");
			
			mv.setViewName("registration-form");
		}
		
		//encrypt the password
		String encodedPassword = passwordEncoder.encode(theUser.getPassword());
		
		//prepend the encoding algorithm id
		encodedPassword = "{bcrypt}" + encodedPassword;
		
		//give user default role of "student"
		List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_STUDENT");
		
		//create user details object
		org.springframework.security.core.userdetails.User tempUser =
				new org.springframework.security.core.userdetails.User
				(theUser.getUserName(),encodedPassword,authorities);
		
		//save user in the database
		userDetailsManager.createUser(tempUser);
		ResetPassword obj = new ResetPassword(theUser.getUserName());
		userService.save(obj);
		
		//status
		
		mv.addObject("status", "User registered successfully!");
		
		mv.setViewName("login-page");
		return mv;
	}
	
	private boolean doesUserExist(String userName)
	{
		// check the database if the user already exists
		boolean exists = userDetailsManager.userExists(userName);
		
		return exists;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
