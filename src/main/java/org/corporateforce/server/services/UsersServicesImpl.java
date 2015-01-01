package org.corporateforce.server.services;

import java.util.List;

import org.corporateforce.server.dao.UsersDao;
import org.corporateforce.server.model.Users;
import org.springframework.beans.factory.annotation.Autowired;

public class UsersServicesImpl implements UsersServices {
	@Autowired
	UsersDao entityDao;

	@Override
	public boolean addEntity(Users entity) throws Exception {
		return entityDao.addEntity(entity);
	}

	@Override
	public Users getEntityById(long id) throws Exception {
		return entityDao.getEntityById(id);
	}

	@Override
	public List<Users> getEntityList() throws Exception {
		return entityDao.getEntityList();
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		return entityDao.deleteEntity(id);
	}

}
