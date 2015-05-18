package org.corporateforce.server.session;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.corporateforce.server.dao.RolesDao;
import org.corporateforce.server.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class RolesBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

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
	
	public Map<String, Integer> getRolesMap(Integer excludeId) throws Exception {
		List<Roles> roles = excludeId != null ? this.rolesDao.getEntityListExclude(excludeId)
				: this.rolesDao.getEntityList();
		Map<String, Integer> result = new TreeMap<String, Integer>();
		result.put("--Не выбрано--", 0);
		for (Roles u : roles) {
			result.put(u.getName(), u.getId());
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

	public boolean refreshRolesList() throws Exception {
		rolesList = rolesDao.getEntityList();
		return true;
	}
	
	public boolean create(Roles p) {
		try {
			if (p.getName()==null || p.getName().equals("")) return false;
			Roles result = rolesDao.createRoles(p.getRoles().getId(), p.getName());
			return (result != null && result.getId()!=null && refreshRolesList());
		} catch(Exception e) {
			System.out.println("DEBUG: RolesBean error: " + e.getMessage());
			return false;
		}
	}

	public boolean update(Roles p) {
		try {
			rolesDao.updateRoles(p.getId(), p.getRoles().getId(), p.getName());
			refreshRolesList();
			return true;
		} catch(Exception e) {
			System.out.println("DEBUG: RolesBean error: " + e.getMessage());
			return false;
		}
	}
	
	public Boolean update() {
		return (editRole!=null && update(editRole));
	}
	
	public Boolean remove(Roles p) {
		try {
			if (p.getId()==usersBean.getCurrentUser().getRoles().getId()) return false;
			rolesDao.deleteEntity(p.getId());
			refreshRolesList();
			return true;
		} catch(Exception e) {
			System.out.println("DEBUG: RolesBean error: " + e.getMessage());
			return false;
		}
	}
}
