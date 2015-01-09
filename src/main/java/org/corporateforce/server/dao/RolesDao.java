package org.corporateforce.server.dao;

import org.corporateforce.server.model.Roles;
import org.springframework.stereotype.Service;

@Service
public class RolesDao extends AbstractDao<Roles> {

	public RolesDao() {
		super(Roles.class);
	}

	public RolesDao(Class<Roles> entityClass) {
		super(entityClass);
	}
}