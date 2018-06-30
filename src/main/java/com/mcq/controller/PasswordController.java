package com.mcq.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mcq.service.EmailService;
import com.mcq.service.UserService;
import com.mcq.user.ResetPassword;

/**
 * @author Omkar Shivadekar
 * Date : 28-Jun-2018
 * Time : 8:03:46 PM
 */

@Controller
public class PasswordController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsManager userDetailsManager;
	
	@Autowired
	private EmailService emailService;
	
	//for encryption
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	
	//for validation (trim empty string to null)
	
	@GetMapping("/forgot")
	public ModelAndView showForgotPasswordPage()
	{
		return new ModelAndView("forgotPassword");
	}
	
	
	@PostMapping("/processForgotPassword")
	public ModelAndView processForgotPasswordForm
	(ModelAndView mv,@RequestParam("email") String userEmail, HttpServletRequest req)
	{
		//System.out.println(userEmail);
		//lookup user in database by email
		List<ResetPassword> user = userService.findUserByEmail(userEmail);
		
		if(user.isEmpty())
		{
			mv.addObject("successMessage", "We didn't find an account for that e-mail address.");
		}
		else
		{

			//generate random 36 character string token for reset password
			ResetPassword rp = user.get(0);
			rp.setResetToken(UUID.randomUUID().toString());
			
			//save token to database
			userService.save(rp);
			
			String appUrl = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort();
			
			//email message
			SimpleMailMessage passwordResetMail = new SimpleMailMessage();
			passwordResetMail.setFrom("omkarshivadekar.os@gmail.com");
			passwordResetMail.setTo(rp.getEmail());
			passwordResetMail.setSubject("Password Reset Request");
			passwordResetMail.setText("To reset your password, click the link below:\n"+appUrl
					+"/reset?token="+rp.getResetToken());
			
			emailService.sendEmail(passwordResetMail);
			
			
			//add success message to view
			mv.addObject("successMessage","A password reset link has been sent to "+userEmail);
			
		}
		
		mv.setViewName("forgotPassword");
		
		return mv;
	}
	
	//display form to reset password
	@GetMapping("/reset")
	public ModelAndView displayResetPasswordPage(ModelAndView mv,
			@RequestParam("token")String token)
	{
		List<ResetPassword> resetToken = userService.findUserByRestToken(token);
		
		if(resetToken.isEmpty())
		{
			//token not found in DB
			mv.addObject("brokenLink", "Oops!  This is an invalid password reset link.");
			mv.setViewName("login-page");
		}
		else
		{
			//token found in DB
			mv.addObject("resetToken", token);
			mv.setViewName("resetPassword");
		}
		
		return mv;
	}
	
	//process reset password form
	@PostMapping("/processReset")
	public ModelAndView setNewPassword(ModelAndView mv,
			@RequestParam("token")String token,
			@RequestParam("password")String password,
			RedirectAttributes rd)
	{
		
		// Find the user associated with the reset token
		List<ResetPassword> user = userService.findUserByRestToken(token);
		
		// This should always be non-null but we check just in case
		if(!user.isEmpty())
		{
			
			ResetPassword resetUser = user.get(0);
			
			System.out.println("ssssss"+password.length());
			if(password.isEmpty())
			{
				mv.addObject("errorMessage", "Oops!  password cannot be empty.");
				mv.addObject("resetToken",token);
				mv.setViewName("resetPassword");	
			}
			else
			{
				//encrypt the password
				String encodedPassword = passwordEncoder.encode(password);
				
				//prepend the encoding algorithm id
				encodedPassword = "{bcrypt}" + encodedPassword;
				
				//get the username / email using token
				String username = resetUser.getEmail();
				
				//give user default role of "student"
				List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_STUDENT");
				
				//spring user obj(auto-config)
				User updateUser = new User(username,encodedPassword,authorities);
				
				//set to reset token to null so it cannot be used again
				resetUser.setResetToken(null);
				
				//save user
				userService.save(resetUser);
				
				//update password
				userDetailsManager.updateUser(updateUser);
				
				rd.addFlashAttribute("status","You have successfully reset your password. You may now login.");
				mv.setViewName("redirect:loginPage");
				
			}
			
			
		}
		else
		{
			mv.addObject("errorMessage", "Oops!  This is an invalid password reset link.");
			mv.setViewName("resetPassword");	
		}
		
		
		return mv;
	}
	
	
	// Going to reset page without a token redirects to login page
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
		return new ModelAndView("redirect:loginPage");
	}
	
	
	
	
	
	
	
	
}
