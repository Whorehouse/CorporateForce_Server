package org.corporateforce.server.dao;

import java.util.Date;
import java.util.List;

import org.corporateforce.server.model.Users;
import org.corporateforce.server.model.Workperiod;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class WorkperiodDao extends AbstractDao<Workperiod> {

	public WorkperiodDao() {
		super(Workperiod.class);
	}

	public WorkperiodDao(Class<Workperiod> entityClass) {
		super(entityClass);
	}
	
	@SuppressWarnings("unchecked")
	public List<Workperiod> listByUser(Users u) throws Exception {
		List<Workperiod> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Workperiod.class).add(Restrictions.eq("users",u)).addOrder(Order.asc("start")).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Workperiod> listByRangeOverlap(Users u, Date startDate, Date endDate) throws Exception {
		List<Workperiod> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria query = session.createCriteria(Workperiod.class);
			query.add(Restrictions.ge("end", startDate));
			query.add(Restrictions.le("start", endDate));
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

