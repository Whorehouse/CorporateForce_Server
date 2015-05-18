package org.corporateforce.server.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.corporateforce.server.model.Roles;
import org.corporateforce.server.session.RolesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class RolesController extends PaginationController implements Serializable {
	private static final long serialVersionUID = 1L;

	// session beans

	@Autowired
	private RolesBean rolesBean;
		
	// constants

	private final String ROLES_ERROR_UPSERT = "error_upsert";
	private final String ROLES_ERROR_EMPTY_FIELDS = "error_empty_fields";

	// page variables

	private String errorMessage = null;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		//this.errorMessage = errorMessage;
	}

	private Roles editRole = null;

	public Roles getEditRole() {
		return editRole;
	}

	public void setEditRole(Roles editRole) {
		this.editRole = editRole;
		if (this.editRole.getRoles()==null) this.editRole.setRoles(new Roles());	
	}

	private List<RolesWrapper> rolesList = null;

	public List<RolesWrapper> getRolesList() {
		if (rolesList == null) refreshController();
		return rolesList;
	}

	// controller methods

	public void refreshController() {
		try {
			List<Roles> result = this.rolesBean.getRolesList();
			this.setRecordCount(result.size());
			rolesList = new ArrayList<RolesWrapper>();
			for (int i=0; i<result.size(); i++) {
				rolesList.add(new RolesWrapper(i, result.get(i)));
			}
		} catch (Exception e) {
			this.setRecordCount(0);
			rolesList = null;
			System.out.println(e.getMessage());
		} finally {
			resetController();
		}
	}
	
	public void resetController() {
		this.editRole = null;
		this.errorMessage = null;
	}
	
	public void createRole() {
		editRole = new Roles();
		editRole.setRoles(new Roles());
	}
	
	public void deleteSelectedRoles() {
		for (RolesWrapper u : rolesList) {
			if (u.selected) {
				this.rolesBean.remove(u.instance);
			}
		}
		this.refreshController();
	}
	
	public void saveEditRole() throws Exception {
		this.errorMessage = null;
		if (editRole.getRoles().getId()==0) editRole.getRoles().setId(null);
		if (editRole.getName() != null && !editRole.getName().trim().equals("")) {
			if ((this.editRole.getId() == null && !this.rolesBean.create(this.editRole)) 
					|| (this.editRole.getId() != null && !this.rolesBean.update(this.editRole))) {
				this.errorMessage = ROLES_ERROR_UPSERT;
				return;
			}
			refreshController();
			return;
		}
		this.errorMessage = ROLES_ERROR_EMPTY_FIELDS;
	}
	
	public Map<String, Integer> getRolesMap() {
		try {
			return editRole!=null ? rolesBean.getRolesMap(editRole.getId()) : rolesBean.getRolesMap(null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new HashMap<String, Integer>();
		}
	}

	// wrapper

	public class RolesWrapper {
		private Roles instance;
		private Integer listIndex;
		private Boolean selected;

		public RolesWrapper(Integer number, Roles role) {
			this.instance = role;
			this.listIndex = number;
			this.selected = false;
		}
		
		public Roles getInstance() {
			return instance;
		}

		public void setInstance(Roles instance) {
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
