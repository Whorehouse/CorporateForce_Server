package org.corporateforce.server.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.corporateforce.server.model.Offices;
import org.corporateforce.server.model.Profiles;
import org.corporateforce.server.model.Roles;
import org.corporateforce.server.model.Users;
import org.corporateforce.server.session.OfficesBean;
import org.corporateforce.server.session.ProfilesBean;
import org.corporateforce.server.session.RolesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class UsersController extends PaginationController implements Serializable {
	private static final long serialVersionUID = 1L;

	// session beans

	@Autowired
	private ProfilesBean profilesBean;

	@Autowired
	private RolesBean rolesBean;
	
	@Autowired
	private OfficesBean officesBean;
	
	// constants

	private final String USERS_ERROR_USERNAME_EXISTS = "error_username_exists";
	private final String USERS_ERROR_EMPTY_FIELDS = "error_empty_fields";

	// page variables

	private String errorMessage = null;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		//this.errorMessage = errorMessage;
	}

	private Users editUser = null;

	public Users getEditUser() {
		return editUser;
	}

	public void setEditUser(Users editUser) {
		this.editUser = editUser;
		editUser.setPassword(null);
		if (this.editUser.getUsers()==null) this.editUser.setUsers(new Users());
		if (this.editUser.getProfiles()==null) this.editUser.setProfiles(new Profiles());
		if (this.editUser.getOffices()==null) this.editUser.setOffices(new Offices());
		if (this.editUser.getRoles()==null) this.editUser.setRoles(new Roles());	
	}

	private List<UsersWrapper> usersList = null;

	public List<UsersWrapper> getUsersList() {
		if (usersList == null) refreshController();
		return usersList;
	}

	// controller methods

	public void refreshController() {
		try {
			List<Users> result = this.usersBean.getUsersList();
			this.setRecordCount(result.size());
			usersList = new ArrayList<UsersWrapper>();
			for (int i=0; i<result.size(); i++) {
				usersList.add(new UsersWrapper(i, result.get(i)));
			}
		} catch (Exception e) {
			this.setRecordCount(0);
			usersList = null;
			System.out.println(e.getMessage());
		} finally {
			resetController();
		}
	}
	
	public void resetController() {
		this.editUser = null;
		this.errorMessage = null;
	}
	
	public void createUser() {
		editUser = new Users();
		editUser.setProfiles(new Profiles());
		editUser.setOffices(new Offices());
		editUser.setRoles(new Roles());
		editUser.setUsers(new Users());
	}
	
	public void deleteSelectedUsers() {
		for (UsersWrapper u : usersList) {
			if (u.selected) {
				this.usersBean.remove(u.instance);
			}
		}
		this.refreshController();
	}
	
	public void saveEditUser() throws Exception {
		this.errorMessage = null;
		if (editUser.getOffices().getId()==0) editUser.getOffices().setId(null);
		if (editUser.getRoles().getId()==0) editUser.getRoles().setId(null);
		if (editUser.getUsers().getId()==0) editUser.getUsers().setId(null);
		if (editUser.getUsername() != null && !editUser.getUsername().equals("")) {
			if ((this.editUser.getId() == null && !this.usersBean.create(this.editUser)) 
					|| (this.editUser.getId() != null && !this.usersBean.update(this.editUser))) {
				this.errorMessage = USERS_ERROR_USERNAME_EXISTS;
				return;
			}
			refreshController();
			return;
		}
		this.errorMessage = USERS_ERROR_EMPTY_FIELDS;
	}

	public Map<String, Integer> getProfilesMap() {
		try {
			return profilesBean.getProfilesMap();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new HashMap<String, Integer>();
		}
	}

	public Map<String, Integer> getRolesMap() {
		try {
			return rolesBean.getRolesMap();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new HashMap<String, Integer>();
		}
	}

	public Map<String, Integer> getOfficesMap() {
		try {
			return officesBean.getOfficesMap();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new HashMap<String, Integer>();
		}
	}
	
	public Map<String, Integer> getUsersMap() {
		try {
			return editUser!=null ? usersBean.getUsersMap(editUser.getId()) : usersBean.getUsersMap(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new HashMap<String, Integer>();
		}
	}

	// wrapper

	public class UsersWrapper {
		private Users instance;
		private Integer listIndex;
		private Boolean selected;

		public UsersWrapper(Integer number, Users user) {
			this.instance = user;
			this.listIndex = number;
			this.selected = false;
		}
		
		public Users getInstance() {
			return instance;
		}

		public void setInstance(Users instance) {
			this.instance = instance;
		}

		public Integer getListIndex() {
			return listIndex;
		}

		public Integer getNumber() {
			return listIndex + 1;
		}

		public Boolean getSelected() {
			return selected;
		}

		public void setSelected(Boolean selected) {
			this.selected = selected;
		}

	}
}
