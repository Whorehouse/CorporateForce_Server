package org.corporateforce.server.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.corporateforce.server.config.Config;
import org.corporateforce.server.dao.UsersDaoImpl;
import org.corporateforce.server.model.Status;
import org.corporateforce.server.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

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
	
	public boolean isAuth() {
		return currentUser!=null;
	}
	
	public boolean isLoginEnabledAccess() {
		return isLoginEnabledAccess(currentUser);
	}
	
	public boolean isLoginEnabledAccess(Users u) {
		return u!=null && u.getProfiles()!=null && u.getProfiles().isLoginEnabled();
	}
	
	public boolean isManageUsersAccess() {
		return isManageUsersAccess(currentUser);
	}
	
	public boolean isManageUsersAccess(Users u) {
		return u!=null && u.getProfiles()!=null && u.getProfiles().isManageUsers();
	}
	
	public boolean isSystemControlAccess() {
		return isSystemControlAccess(currentUser);
	}
	
	public boolean isSystemControlAccess(Users u) {
		return u!=null && u.getProfiles()!=null && u.getProfiles().isSystemControl();
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
			if (result != null && isLoginEnabledAccess(result)) {
				currentUser = result;
				password = "";
				if (isSystemControlAccess()) {
					context.redirect(context.getRequestContextPath() + "/view/console.jsf");
				} else {
					context.redirect(context.getRequestContextPath() + "/view/welcome.jsf");
				}
			} else {
				currentUser = null;
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Incorrect username or password"));
			}
		} catch (Exception ex) {
			System.err.println("DEBUG: UsersBean error: " + ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", ex.getMessage()));
		}
	}

	public void signUp() throws Exception {
		if (!validateInputValues())
			return;
		try {
			Users result = usersDao.createSimpleUsers(0, 0, 0, 0, username, password);
			System.err.println("DEBUG: UsersBean User: " + result);
			if (result != null) {
				passwordRepeat = "";
				this.signIn();
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Incorrect username or password"));
			}
		} catch (Exception ex) {
			System.err.println("DEBUG: UsersBean error: " + ex.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", ex.getMessage()));
		}
	}
	
	public void logout() throws Exception {
		currentUser = null;
		//ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		//context.redirect(context.getRequestContextPath() + "/view/login.jsf");
	}
	
	public List<String> outerModulesURLs() {
		return new ArrayList<String>(Config.getModules().values());
	}
	
	public static void clearInputValues() {
		username = "";
		password = "";
		passwordRepeat = "";
	}
}
