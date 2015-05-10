package org.corporateforce.server.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.corporateforce.server.config.Config;
import org.corporateforce.server.dao.UsersDao;
import org.corporateforce.server.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class UsersBean implements Serializable {
	private static final long serialVersionUID = 1L;

	// autowired objects

	@Autowired
	private UsersDao usersDao;

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	// variables

	private Users currentUser;

	// methods

	public Boolean isUserSignedIn() {
		return currentUser != null;
	}

	public Boolean signIn(String username, String password) {
		try {
			Users result = usersDao.loginUsers(username, password);
			if (result != null && isLoginEnabledAccess(result)) {
				this.currentUser = result;
				return true;
			} else {
				this.currentUser = null;
				return false;
			}
		} catch (Exception e) {
			System.out.println("DEBUG: UsersBean error: " + e.getMessage());
			return false;
		}
	}

	public Boolean signUp(String username, String password) {
		try {
			Users result = usersDao.createSimpleUsers(1, 1, 1, 6, username, password);
			if (result != null) {
				this.currentUser = result;
				return true;
			} else return false;
		} catch (Exception e) {
			System.out.println("DEBUG: UsersBean error: " + e.getMessage());
			return false;
		}
	}



	// ------------------------------------------------------------
	// ------------------------------------------------------------

	private Boolean validateInputValues() {
		if (!username.equals("") && !password.equals("")
				&& (!signUpMode || (signUpMode && passwordRepeat.equals(password)))) {
			return true;
		}
		if (username.equals(""))
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Empty username"));
		if (password.equals(""))
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:", "Empty password"));
		if (!password.equals("") && !passwordRepeat.equals(password))
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR:",
							"Passwords is not equals"));
		return false;
	}
	
	public Boolean signUpMode = false;

	private String username;
	private String password;
	private String passwordRepeat;

	private Users editUser;

	private List<Users> usersList = null;

	public List<Users> getUsersList() throws Exception {
		if (usersList != null)
			return usersList;
		usersList = usersDao.getEntityList();
		return usersList;
	}

	public void refreshUsersList() throws Exception {
		usersList = usersDao.getEntityList();
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

	public void setSignUpMode(Boolean value) {
		signUpMode = value;
		clearInputValues();
	}

	public Boolean getSignUpMode() {
		return signUpMode;
	}

	public boolean isSignedIn() {
		return currentUser != null;
	}

	public boolean isLoginEnabledAccess() {
		return isLoginEnabledAccess(currentUser);
	}

	public boolean isLoginEnabledAccess(Users u) {
		return u != null && u.getProfiles() != null && u.getProfiles().isLoginEnabled();
	}

	public boolean isManageUsersAccess() {
		return isManageUsersAccess(currentUser);
	}

	public boolean isManageUsersAccess(Users u) {
		return u != null && u.getProfiles() != null && u.getProfiles().isManageUsers();
	}

	public boolean isSystemControlAccess() {
		return isSystemControlAccess(currentUser);
	}

	public boolean isSystemControlAccess(Users u) {
		return u != null && u.getProfiles() != null && u.getProfiles().isSystemControl();
	}

	public void updateUser() throws Exception {
		if (currentUser != null) {
			//setCurrentUser(usersDao.getEntityById(currentUser.getId()));
		}
	}



	public void logout() throws Exception {
		currentUser = null;
		// ExternalContext context =
		// FacesContext.getCurrentInstance().getExternalContext();
		// context.redirect(context.getRequestContextPath() + "/index.jsf");
	}

	public List<String> outerModulesURLs() {
		return new ArrayList<String>(Config.getModules().values());
	}

	public void clearInputValues() {
		username = "";
		password = "";
		passwordRepeat = "";
	}

	public boolean isExistContacts() {
		return isExistContacts(currentUser);
	}

	public boolean isExistAvatar() {
		return isExistAvatar(currentUser);
	}

	public boolean isExistContacts(Users u) {
		return (u != null && u.getContacts() != null) ? true : false;
	}

	public boolean isExistAvatar(Users u) {
		return (isExistContacts(u) && u.getContacts().getAvatars() != null) ? true : false;
	}

	public String getAvatar() {
		if (isExistAvatar()) {
			return "Avatars/showAvatar/" + currentUser.getContacts().getAvatars().getId();
		} else {
			return "resources/images/img_no_photo.png";
		}
	}

	/**
	 * @return the editUser
	 */
	public Users getEditUser() {
		return editUser;
	}

	/**
	 * @param editUser
	 *            the editUser to set
	 */
	public void setEditUser(Users editUser) {
		System.out.println("DEBUG: editUser: " + editUser);
		this.editUser = editUser;
		if (this.editUser.getUsers() == null)
			this.editUser.setUsers(new Users());
	}

	public void actionEdit() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String id = params.get("editUserId");
		try {
			this.setEditUser(usersDao.getEntityById(Integer.parseInt(id)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Map<String, Integer> getUsersMap() throws Exception {
		List<Users> users = editUser != null ? this.usersDao.getEntityListExclude(editUser.getId())
				: this.usersDao.getEntityList();
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Users u : users) {
			result.put(u.getUsername(), u.getId());
		}
		return result;
	}

	public void saveEditUser() throws Exception {
		usersDao.updateEntity(editUser);
		refreshUsersList();
	}

	public void actionDelete() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String id = params.get("deleteUserId");
		try {
			usersDao.deleteEntity(Integer.parseInt(id));
			refreshUsersList();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
