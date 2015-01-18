package org.corporateforce.server.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.corporateforce.server.model.Roles;
import org.corporateforce.server.model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

@Service
public class UsersDao extends AbstractDao<Users> {

	public UsersDao() {
		super(Users.class);
	}

	public UsersDao(Class<Users> entityClass) {
		super(entityClass);
	}

	public Users loginUsers(String username, String password) throws Exception {
		Users res = null;
		int id = 0;
		System.out.println("--> DAO Users login begin!");
		System.out.println("--> Open session");
		Session session = sessionFactory.openSession();
		System.out.println("--> Begin transaction");
		Transaction tx = session.beginTransaction();
		try {
			System.out.println("--> Create SQL Query");
			id = (Integer) session
					.createSQLQuery("SELECT `userSignIn`(:username, :password)")
					.setString("username", username)
					.setString("password", password).uniqueResult();
			System.out.println("--> Commit transaction");
			tx.commit();
			System.out.println("--> Close session");
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		if (id > 0) {
			System.out.println("--> Get Users, if id>0");
			res = this.getEntityById(id);
		}
		System.out.println("--> Return DAO login");
		return res;
	}

	public Users createSimpleUsers(int profile, int office, int role,
			int manager, String username, String password) throws Exception {
		Users res = null;		
		Integer id = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			id = (Integer) session
				.createSQLQuery(
						"CALL `userCreate`(:profile, :office, :role, :manager, :username, :password)")
				.setLong("profile", profile).setLong("office", office)
				.setLong("role", role).setLong("manager", manager)
				.setString("username", username)
				.setString("password", password).uniqueResult();
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

	public Users createWithContactsUsers(int profile, int office, int role,
			int manager, String username, String password, String firstname,
			String lastname, int gender, Date date) throws Exception {
		Users res = null;		
		Integer id = 0;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			id = (Integer) session
				.createSQLQuery(
						"CALL `userCreateWithContact`(:profile, :office, :role, :manager, :username, :password, :firstname, :lastname, :gender, :date)")
				.setLong("profile", profile).setLong("office", office)
				.setLong("role", role).setLong("manager", manager)
				.setString("username", username)
				.setString("password", password)
				.setString("firstname", firstname)
				.setString("lastname", lastname).setInteger("gender", gender)
				.setDate("date", date).uniqueResult();
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

	public void changePasswordUsers(Integer id, String password)
			throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			session.createSQLQuery("CALL `userChangePassword`(:id, :password)")
					.setLong("id", id).setString("password", password)
					.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	public void changePasswordSecureUsers(Integer id, String oldpassword,
			String newpassword) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			session.createSQLQuery(
					"CALL `userChangePasswordSecure`(:id, :oldpassword, :newpassword)")
					.setLong("id", id).setString("oldpassword", oldpassword)
					.setString("newpassword", newpassword).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}

	}

	public List<Users> listByUsernameUsers() throws Exception {			
		List<Users> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Users.class).addOrder(Order.asc("username")).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

	public void changeManagerUsers(int id, int manager) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			session.createSQLQuery("CALL `userChangeManager`(:id, :manager)")
					.setLong("id", id).setLong("manager", manager).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	public void changeOfficeUsers(int id, int office) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			session.createSQLQuery("CALL `userChangeOffice`(:id, :office)")
					.setLong("id", id).setLong("office", office).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}

	}

	public void changeProfileUsers(int id, int profile) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			session.createSQLQuery("CALL `userChangeProfile`(:id, :profile)")
					.setLong("id", id).setLong("profile", profile).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}

	}

	public void changeRoleUsers(int id, int role) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			session.createSQLQuery("CALL `userChangeRole`(:id, :role)")
					.setLong("id", id).setLong("role", role).executeUpdate();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

}
