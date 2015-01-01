package org.corporateforce.server.dao;

import java.util.List;

import org.corporateforce.server.model.Users;

public interface UsersDao {
	 public boolean addEntity(Users entity) throws Exception;
	 public Users getEntityById(long id) throws Exception;
	 public List<Users> getEntityList() throws Exception;
	 public boolean deleteEntity(long id) throws Exception;
}
