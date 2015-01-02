package org.corporateforce.server.dao;

import org.corporateforce.server.model.Users;

public class UsersDaoImpl extends AbstractDao<Users> {

	public UsersDaoImpl() {
		super(Users.class);
	}
	
	public UsersDaoImpl(Class<Users> entityClass) {
		super(entityClass);
		// TODO Auto-generated constructor stub
	}

}
