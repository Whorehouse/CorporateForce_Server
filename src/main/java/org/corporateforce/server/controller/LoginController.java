package org.corporateforce.server.controller;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.corporateforce.server.helper.Constants;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class LoginController extends AbstractController implements Serializable {
	private static final long serialVersionUID = 1L;

	// session beans

	// constants

	private final Integer LOGIN_MODE_SIGNIN = 0;
	private final Integer LOGIN_MODE_REGISTRATION = 1;

	private final String LOGIN_ERROR_USERNAME_OR_PASSWORD = "error_username_or_password";
	private final String LOGIN_ERROR_USERNAME_EXISTS = "error_username_exists";
	private final String LOGIN_ERROR_EMPTY_FIELDS = "error_empty_fields";
	private final String LOGIN_ERROR_PASSWORDS_DONT_MATCH = "error_passwords_dont_match";

	// page variables
	
	private Integer loginMode = LOGIN_MODE_SIGNIN;

	public Integer getLoginMode() {
		return loginMode;
	}
	
	private String username;
	private String password;
	private String passwordRepeat;

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
	
	private String errorMessage = null;

	public String getErrorMessage() {
		return errorMessage;
	}

	// controller methods
	
	private void resetController() {
		this.username= "";
		this.password = "";
		this.passwordRepeat = "";
		this.errorMessage = null;
	}

	public void toogleMode() {
		this.loginMode = this.loginMode == LOGIN_MODE_REGISTRATION ? LOGIN_MODE_SIGNIN : LOGIN_MODE_REGISTRATION;
		resetController();
	}
	
	public Boolean modeSignIn() {
		return this.loginMode == LOGIN_MODE_REGISTRATION ? false : true;
	}

	private void doRedirect() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect(context.getRequestContextPath() + "/" + Constants.PAGE_MAIN);
		} catch (Exception e) {
			System.out.println("DEBUG: UsersBean error: " + e.getMessage());
		}
	}

	public void acceptInputValues() {
		this.errorMessage = null;
		if ((username != null && password != null) &&
			(!username.equals("") && !password.equals(""))) {
				if (modeSignIn()) {
					if (!usersBean.signIn(this.username, this.password)) {
						this.errorMessage = LOGIN_ERROR_USERNAME_OR_PASSWORD;
						return;
					}
					resetController();
					doRedirect();
					return;
				} else if (!modeSignIn()) {
					if (!passwordRepeat.equals(password)) {
						this.errorMessage = LOGIN_ERROR_PASSWORDS_DONT_MATCH;
						return;
					}
					if (!usersBean.signUp(this.username, this.password)) {
						this.errorMessage = LOGIN_ERROR_USERNAME_EXISTS;
						return;
					}
					resetController();
					doRedirect();
					return;
				}
			}
		this.errorMessage = LOGIN_ERROR_EMPTY_FIELDS;
	}

}
