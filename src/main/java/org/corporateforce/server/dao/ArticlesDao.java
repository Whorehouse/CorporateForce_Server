package org.corporateforce.server.dao;

import java.util.List;

import org.corporateforce.server.model.Articles;
import org.corporateforce.server.model.Projects;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class ArticlesDao extends AbstractDao<Articles> {

	public ArticlesDao() {
		super(Articles.class);
	}

	public ArticlesDao(Class<Articles> entityClass) {
		super(entityClass);
	}

	public List<Articles> listByProject(Projects t) throws Exception {
		List<Articles> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Articles.class).add(Restrictions.eq("projects",t)).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

}
