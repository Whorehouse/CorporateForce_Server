package org.corporateforce.server.dao;

import java.util.ArrayList;
import java.util.List;

import org.corporateforce.server.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

public abstract class AbstractFacade<T> {

	Class<T> entityClass;
	protected Session session;

	public AbstractFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	public T create(T entity) {
		try {
			session.clear();
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.clear();
		}
		return entity;
	}

	public void edit(T entity) {
		try {
			session.clear();
			this.session.beginTransaction();
			session.update(entity);
			this.session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.clear();
		}
	}

	public void delete(T entity) {
		try {
			session.clear();
			this.session.beginTransaction();
			session.delete(entity);
			this.session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.clear();
		}
	}

	public T get(int id) {
		T res = null;
		try {
			this.session.beginTransaction();
			T t = (T) session.get(entityClass, id);
			res = t;
			this.session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
		return res;
	}

	public List<T> list() {
		List entities = new ArrayList<T>();
		try {
			this.session.beginTransaction();
			entities = session.createCriteria(entityClass).list();
			this.session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("ОШИБКА findAll: " + e.getMessage());
		}
		return entities;
	}

	public int count() {
		Long res = (long) 0;
		try {
			this.session.beginTransaction();
			res = (Long) session.createCriteria(entityClass)
					.setProjection(Projections.rowCount()).uniqueResult();
			this.session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return res.intValue();
	}
}
