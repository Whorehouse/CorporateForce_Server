package org.corporateforce.server.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T> {

	 @Autowired
	 SessionFactory sessionFactory;
	 
	 Class<T> entityClass;
	 Session session = null;
	 Transaction tx = null;
	 
	 public AbstractDao(Class<T> entityClass) {
	        this.entityClass = entityClass;
	 }

	public boolean addEntity(T entity) throws Exception {
		  session = sessionFactory.openSession();
		  tx = session.beginTransaction();
		  session.save(entity);
		  tx.commit();
		  session.close();
		  return false;
	}

	public T getEntityById(int id) throws Exception {
		  session = sessionFactory.openSession();
		  T entity = (T) session.load(entityClass, new Integer(id));
		  tx = session.getTransaction();
		  session.beginTransaction();
		  tx.commit();
		  return entity;
	}

	 @SuppressWarnings("unchecked")
	public List<T> getEntityList() throws Exception {
		 session = sessionFactory.openSession();
		  tx = session.beginTransaction();
		  List<T> entityList = session.createCriteria(entityClass)
		    .list();
		  tx.commit();
		  System.out.println("DANGEROS!!! List users!");
		  System.out.println(entityList.size());
		  session.close();
		  return entityList;
	}

	public boolean deleteEntity(int id) throws Exception {
		  session = sessionFactory.openSession();
		  Object o = session.load(entityClass, id);
		  tx = session.getTransaction();
		  session.beginTransaction();
		  session.delete(o);
		  tx.commit();
		  return false;
	}
}
