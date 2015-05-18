package org.corporateforce.server.dao;

import org.corporateforce.server.model.Settings;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class SettingsDao extends AbstractDao<Settings> {

	public SettingsDao() {
		super(Settings.class);
	}

	public SettingsDao(Class<Settings> entityClass) {
		super(entityClass);
	}
	
	public Settings getByPname(String pname) {
		Settings res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = (Settings) session.createCriteria(Settings.class).add(Restrictions.eq("pname",pname)).uniqueResult();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

	public Settings settingsCreate(String pname, String pvalue) {
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
	
	public Settings settingsUpdate(String pname, String pvalue) {
		Settings res = null;		
		Integer id = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			id = (Integer) session
				.createSQLQuery(
						"SELECT `settingsUpdate`(:pname, :pvalue)")
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
	
	public Settings settingsUpsert(String pname, String pvalue) {
		if (!(pname!=null && !pname.trim().equals("") && pvalue!=null && !pvalue.trim().equals(""))) return null;
		Settings res = null;		
		Integer id = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			id = (Integer) session
				.createSQLQuery(
						"SELECT `settingsUpsert`(:pname, :pvalue)")
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