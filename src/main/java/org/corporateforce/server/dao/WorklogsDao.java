package org.corporateforce.server.dao;

import java.util.List;

import org.corporateforce.server.model.Tickets;
import org.corporateforce.server.model.Users;
import org.corporateforce.server.model.Worklogs;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class WorklogsDao extends AbstractDao<Worklogs> {

	public WorklogsDao() {
		super(Worklogs.class);
	}

	public WorklogsDao(Class<Worklogs> entityClass) {
		super(entityClass);
	}

	public List<Worklogs> listByTicket(Tickets t) throws Exception {
		List<Worklogs> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Worklogs.class).add(Restrictions.eq("tickets",t)).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	public List<Worklogs> listByTicketAndUser(Tickets t, Users u) throws Exception {
		List<Worklogs> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Worklogs.class).add(Restrictions.eq("tickets",t)).add(Restrictions.eq("users",u)).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

}
