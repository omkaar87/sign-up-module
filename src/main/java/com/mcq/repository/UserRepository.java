package com.mcq.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mcq.user.ResetPassword;

/**
 * @author Omkar Shivadekar
 * Date : 28-Jun-2018
 * Time : 11:48:27 PM
 */
@Repository
public interface UserRepository {
	
	public List<ResetPassword> findByEmail(String email);
	public List<ResetPassword> findByResetToken(String resetToken);
	public void saveUserDetails(ResetPassword rs);
	public List getUserName(String token);

}
