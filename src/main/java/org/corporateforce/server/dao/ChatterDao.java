package org.corporateforce.server.dao;

import java.util.List;

import org.corporateforce.server.model.Chatter;
import org.corporateforce.server.model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class ChatterDao extends AbstractDao<Chatter> {
	
	public ChatterDao() {
		super(Chatter.class);
	}

	public ChatterDao(Class<Chatter> entityClass) {
		super(entityClass);
	}
	
	public List<Chatter> getListForParent(Users u) {
		List<Chatter> entityList = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try { 
			entityList = session.createCriteria(entityClass)
				.add(Restrictions.eq("usersByParent", u)).list();
			tx.commit();			
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		System.out.println("ListForParent:"+entityList);
		return entityList;
	}
	
	public List<Chatter> getListForCreator(Users u) {
		List<Chatter> entityList = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try { 
			entityList = session.createCriteria(entityClass)
				.add(Restrictions.eq("usersByCreator", u)).list();
			tx.commit();			
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		System.out.println("ListForCreator:"+entityList);
		return entityList;
	}
}
