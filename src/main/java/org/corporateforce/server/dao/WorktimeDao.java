package org.corporateforce.server.dao;

import java.util.Date;
import java.util.List;

import org.corporateforce.server.model.Users;
import org.corporateforce.server.model.Worktime;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class WorktimeDao extends AbstractDao<Worktime> {

	public WorktimeDao() {
		super(Worktime.class);
	}

	public WorktimeDao(Class<Worktime> entityClass) {
		super(entityClass);
	}
	
	@SuppressWarnings("unchecked")
	public List<Worktime> listByUser(Users u) throws Exception {
		List<Worktime> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Worktime.class)
					.add(Restrictions.eq("users",u))
					.addOrder(Order.asc("day"))
					.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Worktime> listByUserAndDay(Users u, Date day) throws Exception {
		List<Worktime> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Worktime.class).add(Restrictions.eq("users",u)).add(Restrictions.eq("day",day)).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Worktime> listByRangeOverlap(Users u, Date startDate, Date endDate) throws Exception {
		List<Worktime> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria query = session.createCriteria(Worktime.class);
			query.add(Restrictions.ge("day", startDate));
			query.add(Restrictions.le("day", endDate));
			query.add(Restrictions.eq("users",u));
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

