package org.corporateforce.server.dao;

import java.util.List;

import org.corporateforce.server.model.Answers;
import org.corporateforce.server.model.Questions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class AnswersDao extends AbstractDao<Answers> {

	public AnswersDao() {
		super(Answers.class);
	}

	public AnswersDao(Class<Answers> entityClass) {
		super(entityClass);
	}
	
	public List<Answers> getEntityList() throws Exception {
		return getEntityListOrderBy("body");
	}
	
	public List<Answers> listByQuestions(Questions q) throws Exception {
		List<Answers> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Answers.class).add(Restrictions.eq("questions",q)).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
}
