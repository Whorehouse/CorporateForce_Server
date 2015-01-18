package org.corporateforce.server.dao;

import org.corporateforce.server.model.Trainings;
import org.corporateforce.server.model.Tutorials;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class TutorialsDao extends AbstractDao<Tutorials> {

	public TutorialsDao() {
		super(Tutorials.class);
	}

	public TutorialsDao(Class<Tutorials> entityClass) {
		super(entityClass);
	}
	
	public Tutorials getByTrainings(Trainings t) throws Exception {
		Tutorials entity = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			entity = (Tutorials)session.createCriteria(Tutorials.class).add(Restrictions.eq("trainings", t)).uniqueResult();
			tx.commit();			
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return entity;
	}
}
