package org.corporateforce.server.dao;

import java.util.List;

import org.corporateforce.server.model.Tickets;
import org.corporateforce.server.model.Projects;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class TicketsDao extends AbstractDao<Tickets> {

	public TicketsDao() {
		super(Tickets.class);
	}

	public TicketsDao(Class<Tickets> entityClass) {
		super(entityClass);
	}

	public List<Tickets> listByProject(Projects t) throws Exception {
		List<Tickets> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Tickets.class).add(Restrictions.eq("projects",t)).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

}
