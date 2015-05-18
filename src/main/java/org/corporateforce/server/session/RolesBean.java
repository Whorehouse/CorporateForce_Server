package org.corporateforce.server.session;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.faces.context.FacesContext;

import org.corporateforce.server.dao.RolesDao;
import org.corporateforce.server.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class RolesBean implements Serializable {
	
	@Autowired
	private RolesDao rolesDao;

	private Roles editRole;
	
	private List<Roles> rolesList = null;
	
	public RolesDao getRolesDao() {
		return rolesDao;
	}

	public void setRolesDao(RolesDao rolesDao) {
		this.rolesDao = rolesDao;
	}
	
	@Autowired
	private UsersBean usersBean;

	public void setUsersBean(UsersBean usersBean) {
		this.usersBean = usersBean;
	}
	
	public Map<String, Integer> getRolesMap() throws Exception {
		List<Roles> roles = this.rolesDao.getEntityList();
		Map<String, Integer> result = new TreeMap<String, Integer>();
		result.put("--Не выбрано--", 0);
		for (Roles p : roles) {
			result.put(p.getName(), p.getId());
		}
		return result;
	}

	/**
	 * @return the editRole
	 */
	public Roles getEditRole() {
		return editRole;
	}

	/**
	 * @param editRole the editRole to set
	 */
	public void setEditRole(Roles editRole) {
		this.editRole = editRole;
		if (this.editRole.getRoles() == null)
			this.editRole.setRoles(new Roles());
	}

	public List<Roles> getRolesList() throws Exception {
		if (rolesList != null)
			return rolesList;
		rolesList = rolesDao.getEntityList();
		return rolesList;
	}

	public void refreshRolesList() throws Exception {
		rolesList = rolesDao.getEntityList();
	}
	
	public void actionEdit() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String id = params.get("editRoleId");
		try {
			this.setEditRole(rolesDao.getEntityById(Integer.parseInt(id)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveEditRole() throws Exception {
		rolesDao.updateEntity(editRole);
		refreshRolesList();
	}
	
	public Boolean actionDelete() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		try {
			Integer id = Integer.parseInt(params.get("deleteRoleId"));
			if (id==usersBean.getCurrentUser().getRoles().getId()) return false;
			rolesDao.deleteEntity(id);
			refreshRolesList();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
}
