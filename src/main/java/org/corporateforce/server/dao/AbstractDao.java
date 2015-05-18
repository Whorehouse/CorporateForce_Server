package org.corporateforce.server.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<T> {

	@Autowired
	public SessionFactory sessionFactory;

	public Class<T> entityClass;

	public AbstractDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T addEntity(T entity) throws Exception {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			try {				
				session.save(entity);
				tx.commit();
			} catch (Exception e) {
				if (tx!=null) tx.rollback();
			    	throw e;
			} finally {
				session.close();
			}
			return entity;
	}

	public T updateEntity(T entity) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(entity);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.out.println(e);
		} finally {
			session.close();
		}
		return entity;
	}

	public T getEntityById(Integer id) throws Exception {
		T entity = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			entity = (T)session.get(entityClass, new Integer(id));
			tx.commit();			
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> getEntityList() throws Exception {
		return getEntityListOrderBy("id");
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getEntityListOrderBy(String field) throws Exception {
		List<T> entityList = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try { 
			entityList = session.createCriteria(entityClass).addOrder(Order.asc(field)).list();
			tx.commit();			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			tx.rollback();
		} finally {
			session.close();
		}
		return entityList;
	}

	@SuppressWarnings("unchecked")
	public List<T> getEntityListExclude(Integer id) throws Exception {
		List<T> entityList = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try { 
			entityList = session.createCriteria(entityClass)
				.add(Restrictions.not(Restrictions.idEq(id))).list();
			tx.commit();			
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return entityList;
	}

	public boolean deleteEntity(Integer id) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Object o = session.load(entityClass, id);
			session.delete(o);
			tx.commit();			
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	public Integer countEntities() throws Exception {
		Long res = (long) 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {		
			res = (Long) session.createCriteria(entityClass)
					.setProjection(Projections.rowCount()).uniqueResult();
			tx.commit();			
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res.intValue();
	}
}
