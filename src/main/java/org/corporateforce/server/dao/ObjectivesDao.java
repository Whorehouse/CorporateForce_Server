package org.corporateforce.server.dao;

import java.util.List;

import org.corporateforce.server.model.Objectives;
import org.corporateforce.server.model.Projects;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class ObjectivesDao extends AbstractDao<Objectives> {

	public ObjectivesDao() {
		super(Objectives.class);
	}

	public ObjectivesDao(Class<Objectives> entityClass) {
		super(entityClass);
	}

	public List<Objectives> listByProject(Projects t) throws Exception {
		List<Objectives> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Objectives.class).add(Restrictions.eq("projects",t)).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

}
