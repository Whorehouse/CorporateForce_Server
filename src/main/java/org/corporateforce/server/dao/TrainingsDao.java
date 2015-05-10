package org.corporateforce.server.dao;

import java.math.BigInteger;

import org.corporateforce.server.model.Trainings;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
public class TrainingsDao extends AbstractDao<Trainings> {

	public TrainingsDao() {
		super(Trainings.class);
	}

	public TrainingsDao(Class<Trainings> entityClass) {
		super(entityClass);
	}
	
	public boolean isTutorialed(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		boolean res = false;
		try {			
			BigInteger countTutorial = (BigInteger)session.createSQLQuery("SELECT COUNT(*) FROM `tutorials` WHERE `tutorials`.`TRAINING`=:id")
					.setLong("id", id).uniqueResult();
			System.out.println(countTutorial);
			tx.commit();
			if (countTutorial.intValue()>0) {
				res=true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
}
