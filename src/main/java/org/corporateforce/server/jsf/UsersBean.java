package org.corporateforce.server.jsf;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.corporateforce.server.dao.UsersDaoImpl;
import org.corporateforce.server.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class UsersBean implements Serializable {

	public static Boolean signUpMode = false;

	@Autowired
	private UsersDaoImpl usersDao;

	private Users currentUser;
	private static String username;
	private static String password;
	private static String passwordRepeat;

	public void setUsersDao(UsersDaoImpl usersDao) {
		this.usersDao = usersDao;
	}

	public Users getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Users currentUser) {
		this.currentUser = currentUser;
	}

	public String getUsername() {
		System.out.println("DEBUG: username: " + username);
		return username;
	}

	public void setUsername(String value) {
		username = value;
	}

	public String getPassword() {
		System.out.println("DEBUG: password: " + password);
		return password;
	}

	public void setPassword(String value) {
		password = value;
	}

	public String getPasswordRepeat() {
		System.out.println("DEBUG: passwordRepeat: " + passwordRepeat);
		return passwordRepeat;
	}

	public void setPasswordRepeat(String value) {
		passwordRepeat = value;
	}

	public static void setSignUpMode(Boolean value) {
		signUpMode = value;
		clearInputValues();
	}

	public Boolean getSignUpMode() {
		return signUpMode;
	}

	private Boolean validateInputValues() {
		if (!username.equals("") && !password.equals("") && (!signUpMode || (signUpMode && passwordRepeat.equals(password)))) {
			return true;
		}
		if (username.equals(""))
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Empty username"));
		if (password.equals(""))
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Empty password"));
		if (!password.equals("") && !passwordRepeat.equals(password))
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Passwords is not equals"));
		return false;
	}

	public void signIn() throws Exception {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		if (!validateInputValues())
			return;
		try {
			Users result = usersDao.loginUsers(username, password);
			System.err.println("DEBUG: UsersBean User: " + result);
			if (result != null) {
				currentUser = result;
				password = "";
				passwordRepeat = "";
				context.redirect(context.getRequestContextPath() + "/view/console.jsf");
			} else {
				currentUser = null;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Incorrect username or password"));
			}
		} catch (Exception ex) {
			System.err.println("DEBUG: UsersBean error: " + ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", ex.getMessage()));
		}
	}
	
	public static void clearInputValues() {
		username = "";
		password = "";
		passwordRepeat = "";
	}
}
