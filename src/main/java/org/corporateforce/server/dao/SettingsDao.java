package org.corporateforce.server.dao;

import org.corporateforce.server.model.Settings;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
public class SettingsDao extends AbstractDao<Settings> {

	public SettingsDao() {
		super(Settings.class);
	}

	public SettingsDao(Class<Settings> entityClass) {
		super(entityClass);
	}

	public Settings settingsCreate(String pname, String pvalue) throws Exception {
		Settings res = null;		
		Integer id = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			id = (Integer) session
				.createSQLQuery(
						"SELECT `settingsCreate`(:pname, :pvalue)")
				.setString("pname", pname)
				.setString("pvalue", pvalue)
				.uniqueResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		if (id > 0) {
			res = this.getEntityById(id);
		}
		return res;
	}
	
	public void settingsUpdate(String pname, String pvalue)
			throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			session.createSQLQuery("CALL `settingsUpdate`(:pname, :pvalue)")
					.setString("pname", pname)
					.setString("pvalue", pvalue)
					.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public void settingsRemove(String pname)
			throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			session.createSQLQuery("CALL `settingsRemove`(:pname)")
					.setString("pname", pname)
					.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
}