package org.corporateforce.server.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.context.FacesContext;

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

	public Users getCurrentUser() {
		return currentUser;
	}

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

	public Boolean signOut() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			return true;
		} catch (Exception e) {
			System.out.println("DEBUG: UsersBean error: " + e.getMessage());
			return false;
		}
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
		Map<String, Integer> result = new TreeMap<String, Integer>();
		result.put("--Не выбрано--", 0);
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

	public boolean create(Users u) {
		try {
			if (u.getPassword()==null || u.getPassword().equals("")) return false;
			Users result = usersDao.createSimpleUsers(u.getProfiles().getId(), u.getOffices().getId(), u.getRoles().getId(), u.getUsers().getId(), u.getUsername(), u.getPassword());
			return result != null;
		} catch(Exception e) {
			System.out.println("DEBUG: UsersBean error: " + e.getMessage());
			return false;
		}
	}

	public boolean update(Users u) {
		try {
			usersDao.updateUsers(u.getId(), u.getUsername(), u.getProfiles().getId(), u.getOffices().getId(), 
					u.getRoles().getId(), u.getUsers().getId());
			if (u.getPassword()!=null && !u.getPassword().equals("")) {
				usersDao.changePasswordUsers(u.getId(), u.getPassword());
				u.setPassword(null);
			}
			return true;
		} catch(Exception e) {
			System.out.println("DEBUG: UsersBean error: " + e.getMessage());
			return false;
		}
	}
	
	public Boolean update() {
		return (currentUser!=null && update(currentUser));
	}
	
	public Boolean remove(Users u) {
		try {
			if (u.getId()==currentUser.getId()) return false;
			usersDao.deleteEntity(u.getId());
			return true;
		} catch(Exception e) {
			System.out.println("DEBUG: UsersBean error: " + e.getMessage());
			return false;
		}
	}
}
