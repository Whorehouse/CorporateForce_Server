package org.corporateforce.server.dao;

import java.util.List;

import org.corporateforce.server.model.Questions;
import org.corporateforce.server.model.Trainings;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class QuestionsDao extends AbstractDao<Questions> {

	public QuestionsDao() {
		super(Questions.class);
	}

	public QuestionsDao(Class<Questions> entityClass) {
		super(entityClass);
	}
	
	@SuppressWarnings("unchecked")
	public List<Questions> listByTrainings(Trainings t) throws Exception {
		List<Questions> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Questions.class).add(Restrictions.eq("trainings",t)).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
}
