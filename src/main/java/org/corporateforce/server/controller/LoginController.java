package org.corporateforce.server.controller;

import org.corporateforce.server.session.UsersBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class LoginController {

	// session beans

	@Autowired
	private UsersBean usersBean;
	
	// constants
	
	public final Integer LOGIN_MODE_SIGNIN = 0;
	public final Integer LOGIN_MODE_REGISTRATION = 1;

	// page variables
	
	public Integer loginMode = LOGIN_MODE_SIGNIN;

	public Integer getLoginMode() {
		return loginMode;
	}

	public void setLoginMode(Integer loginMode) {
		this.loginMode = loginMode;
	}
	
	public String username;
	public String password;
	public String passwordRepeat;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	// controller methods

	public void toogleMode() {
		this.loginMode = this.loginMode == LOGIN_MODE_REGISTRATION ? LOGIN_MODE_SIGNIN : LOGIN_MODE_REGISTRATION;
	}
	
	public Boolean modeSignIn() {
		return this.loginMode == LOGIN_MODE_REGISTRATION ? false : true;
	}

	
}
