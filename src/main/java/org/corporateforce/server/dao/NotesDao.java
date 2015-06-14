package org.corporateforce.server.dao;

import java.util.Date;
import java.util.List;

import org.corporateforce.server.model.Users;
import org.corporateforce.server.model.Notes;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class NotesDao extends AbstractDao<Notes> {

	public NotesDao() {
		super(Notes.class);
	}

	public NotesDao(Class<Notes> entityClass) {
		super(entityClass);
	}
	
	@SuppressWarnings("unchecked")
	public List<Notes> listByUser(Users u) throws Exception {
		List<Notes> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Notes.class).add(Restrictions.eq("users",u)).addOrder(Order.desc("priority")).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Notes> listByUserAndDay(Users u, Date day) throws Exception {
		List<Notes> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Notes.class).add(Restrictions.eq("users",u)).add(Restrictions.eq("day",day)).addOrder(Order.desc("priority")).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Notes> listByRangeOverlap(Users u, Date startDate, Date endDate) throws Exception {
		List<Notes> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria query = session.createCriteria(Notes.class);
			query.add(Restrictions.ge("day", startDate));
			query.add(Restrictions.le("day", endDate));
			query.add(Restrictions.eq("users",u));
			query.addOrder(Order.desc("priority"));
			res = query.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

}

