package org.corporateforce.server.dao;

import org.corporateforce.server.model.Contacts;
import org.corporateforce.server.model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class ContactsDao extends AbstractDao<Contacts> {

	public ContactsDao() {
		super(Contacts.class);
	}

	public ContactsDao(Class<Contacts> entityClass) {
		super(entityClass);
	}
	
	public Contacts getByUsers(Users u) throws Exception {
		Contacts entity = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			entity = (Contacts)session.createCriteria(Contacts.class).add(Restrictions.eq("users", u)).uniqueResult();
			tx.commit();			
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return entity;
	}
}
