package com.mcq.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Omkar Shivadekar
 * Date : 28-Jun-2018
 * Time : 11:23:54 PM
 */

@Entity
@Table(name="reset")
public class ResetPassword {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="resetToken")
	private String resetToken;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}
	
	public ResetPassword(String email) {
		this.email = email;
	}

	public ResetPassword() {

	}
	
	
	
	
	
	
	
	
	
}
