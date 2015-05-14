package org.corporateforce.server.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.corporateforce.server.dao.UsersDao;
import org.corporateforce.server.helper.Constants;
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
			Users result = usersDao.createSimpleUsers(1, null, null, null, username, password);
			if (result == null)
				return false;
			this.currentUser = result;
			return true;
		} catch (Exception e) {
			System.out.println("DEBUG: UsersBean error: " + e.getMessage());
			return false;
		}
	}

	public void signOut() {
		this.currentUser = null;
	}

	public String getUserPictureURL() {
		return isExistUserPicture() && isUserSignedIn() ? Constants.PATH_USER_PICTURES
				+ currentUser.getContacts().getAvatars().getId() : Constants.IMAGE_NO_USER_PICTURE;
	}

	public List<Users> getUsersList() throws Exception {
		return this.usersDao.getEntityList();
	}

	public Map<String, Integer> getUsersMap(Integer excludeId) throws Exception {
		List<Users> users = excludeId != null ? this.usersDao.getEntityListExclude(excludeId)
				: this.usersDao.getEntityList();
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Users u : users) {
			result.put(u.getUsername(), u.getId());
		}
		return result;
	}

	public String getCurrentUserFullName() {
		if (this.currentUser == null) return null;
		return isExistContact() ? this.currentUser.getContacts().getFirstname() + " "
				+ this.currentUser.getContacts().getLastname() : this.currentUser.getUsername();
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

	public boolean isExistContact() {
		return isExistContact(currentUser);
	}

	public boolean isExistContact(Users u) {
		return (u != null && u.getContacts() != null) ? true : false;
	}

	public boolean isExistUserPicture() {
		return isExistUserPicture(currentUser);
	}

	public boolean isExistUserPicture(Users u) {
		return (isExistContact(u) && u.getContacts().getAvatars() != null) ? true : false;
	}

	/*
	 * public void actionEdit() { FacesContext fc =
	 * FacesContext.getCurrentInstance(); Map<String, String> params =
	 * fc.getExternalContext().getRequestParameterMap(); String id =
	 * params.get("editUserId"); try { //
	 * this.setEditUser(usersDao.getEntityById(Integer.parseInt(id))); } catch
	 * (NumberFormatException e) { e.printStackTrace(); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * public void saveEditUser() throws Exception { //
	 * usersDao.updateEntity(editUser); // refreshUsersList(); }
	 * 
	 * public void actionDelete() { FacesContext fc =
	 * FacesContext.getCurrentInstance(); Map<String, String> params =
	 * fc.getExternalContext().getRequestParameterMap(); String id =
	 * params.get("deleteUserId"); try {
	 * usersDao.deleteEntity(Integer.parseInt(id)); // refreshUsersList(); }
	 * catch (NumberFormatException e) { e.printStackTrace(); } catch (Exception
	 * e) { e.printStackTrace(); } }
	 */
}
