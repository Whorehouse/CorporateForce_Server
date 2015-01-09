package org.corporateforce.server.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T> {

	@Autowired
	public SessionFactory sessionFactory;

	public Class<T> entityClass;
	public Session session = null;
	public Transaction tx = null;

	public AbstractDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T addEntity(T entity) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		session.close();
		return entity;
	}

	public T updateEntity(T entity) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
		return entity;
	}

	public T getEntityById(int id) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		T entity = (T)session.get(entityClass, new Integer(id));
		tx.commit();
		session.close();
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> getEntityList() throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<T> entityList = session.createCriteria(entityClass).list();
		tx.commit();
		session.close();
		return entityList;
	}

	@SuppressWarnings("unchecked")
	public List<T> getEntityListExclude(int id) throws Exception {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		List<T> entityList = session.createCriteria(entityClass)
				.add(Restrictions.ne("ID", id)).list();
		tx.commit();
		session.close();
		return entityList;
	}

	public boolean deleteEntity(int id) throws Exception {
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		Object o = session.load(entityClass, id);
		session.delete(o);
		tx.commit();
		session.close();
		return false;
	}

	public int countEntities() throws Exception {
		Long res = (long) 0;
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		res = (Long) session.createCriteria(entityClass)
				.setProjection(Projections.rowCount()).uniqueResult();
		tx.commit();
		session.close();
		return res.intValue();
	}
}
