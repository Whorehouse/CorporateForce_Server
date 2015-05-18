package org.corporateforce.server.dao;

import org.corporateforce.server.model.Roles;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
public class RolesDao extends AbstractDao<Roles> {

	public RolesDao() {
		super(Roles.class);
	}

	public RolesDao(Class<Roles> entityClass) {
		super(entityClass);
	}
	
	public Roles createRoles(Integer parent, String name) throws Exception {
		Roles res = null;		
		Integer id = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String paramHQL = parent==null ? "NULL, " : ":parent, ";
			Query query = session
				.createSQLQuery(
						"SELECT `roleCreate`("+paramHQL+":name)");
			if (parent!=null) query.setLong("parent", parent);
			query.setString("name", name);
			id = (Integer) query.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
		} finally {
			session.close();
		}
		if (id > 0) {
			res = this.getEntityById(id);
		}
		return res;
	}
	
	public void updateRoles(Integer id, Integer parent, String name) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			String paramHQL = parent==null ? "NULL" : ":parent";
			Query query = session.createSQLQuery("CALL `roleUpdate`(:id, "+paramHQL+", :name)");
			query.setLong("id", id);
			if (parent!=null) query.setLong("parent", parent);
			query.setString("name", name);
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			tx.rollback();
		} finally {
			session.close();
		}

	}
}