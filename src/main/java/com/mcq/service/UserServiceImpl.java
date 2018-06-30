package com.mcq.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcq.repository.UserRepository;
import com.mcq.user.ResetPassword;

/**
 * @author Omkar Shivadekar
 * Date : 29-Jun-2018
 * Time : 12:01:29 AM
 */
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public List<ResetPassword> findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	@Transactional
	public List<ResetPassword> findUserByRestToken(String resetToken) {
		return userRepository.findByResetToken(resetToken);
	}

	@Override
	@Transactional
	public void save(ResetPassword rp) {
		userRepository.saveUserDetails(rp);
	}

	@Override
	@Transactional
	public List getUserName(String token) {
		return userRepository.getUserName(token);
	}

}
