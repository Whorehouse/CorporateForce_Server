package org.corporateforce.server.dao;

import java.util.List;

import org.corporateforce.server.model.Results;
import org.corporateforce.server.model.Trainings;
import org.corporateforce.server.model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class ResultsDao extends AbstractDao<Results> {

	public ResultsDao() {
		super(Results.class);
	}

	public ResultsDao(Class<Results> entityClass) {
		super(entityClass);
	}
	
	@SuppressWarnings("unchecked")
	public List<Results> listByUsers(Users u) throws Exception {
		List<Results> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Results.class).add(Restrictions.eq("users",u)).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<Results> listByTrainings(Trainings t) throws Exception {
		List<Results> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Results.class).add(Restrictions.eq("trainings",t)).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
}
