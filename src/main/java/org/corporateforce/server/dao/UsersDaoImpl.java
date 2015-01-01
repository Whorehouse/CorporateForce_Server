package org.corporateforce.server.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.corporateforce.server.model.Users;

public class UsersDaoImpl implements UsersDao {

	 @Autowired
	 SessionFactory sessionFactory;

	 Session session = null;
	 Transaction tx = null;

	@Override
	public boolean addEntity(Users entity) throws Exception {
		  session = sessionFactory.openSession();
		  tx = session.beginTransaction();
		  session.save(entity);
		  tx.commit();
		  session.close();
		  return false;
	}

	@Override
	public Users getEntityById(long id) throws Exception {
		  session = sessionFactory.openSession();
		  Users entity = (Users) session.load(Users.class,
		    new Long(id));
		  tx = session.getTransaction();
		  session.beginTransaction();
		  tx.commit();
		  return entity;
	}

	 @SuppressWarnings("unchecked")
	@Override
	public List<Users> getEntityList() throws Exception {
		 session = sessionFactory.openSession();
		  tx = session.beginTransaction();
		  List<Users> entityList = session.createCriteria(Users.class)
		    .list();
		  tx.commit();
		  System.out.println("DANGEROS!!! List users!");
		  System.out.println(entityList.size());
		  session.close();
		  return entityList;
	}

	@Override
	public boolean deleteEntity(long id) throws Exception {
		  session = sessionFactory.openSession();
		  Object o = session.load(Users.class, id);
		  tx = session.getTransaction();
		  session.beginTransaction();
		  session.delete(o);
		  tx.commit();
		  return false;
	}

}
