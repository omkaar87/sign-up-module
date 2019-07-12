package com.mcq.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String userName;
	

	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String password;

    
    private String role;


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }


	public User(@NotNull(message = "is required") @Size(min = 1, message = "is required") String userName,
			@NotNull(message = "is required") @Size(min = 1, message = "is required") String password, String role) {
		this.userName = userName;
		this.password = password;
        this.role=role;
	}
	
	public User() {

	}
	
	
	
	
	
	
	
	
	
	
	
}
