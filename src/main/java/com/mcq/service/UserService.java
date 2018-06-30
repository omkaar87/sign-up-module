package com.mcq.service;

import java.util.List;

import com.mcq.user.ResetPassword;

/**
 * @author Omkar Shivadekar
 * Date : 28-Jun-2018
 * Time : 11:58:39 PM
 */

public interface UserService {

	public List<ResetPassword> findUserByEmail(String email);
	public List<ResetPassword> findUserByRestToken(String resetToken);
	public void save(ResetPassword rp);
	public List getUserName(String token);
	
	
}
