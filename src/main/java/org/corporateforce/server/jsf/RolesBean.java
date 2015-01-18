package org.corporateforce.server.jsf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public RolesDao getRolesDao() {
		return rolesDao;
	}

	public void setRolesDao(RolesDao rolesDao) {
		this.rolesDao = rolesDao;
	}
	
	public Map<String, Integer> getRolesMap() throws Exception {
		List<Roles> roles = this.rolesDao.getEntityList();
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Roles p : roles) {
			result.put(p.getName(), p.getId());
		}
		return result;
	}

}
