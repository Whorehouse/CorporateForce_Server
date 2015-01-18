package org.corporateforce.server.dao;

import java.util.List;

import org.corporateforce.server.model.Holidays;
import org.corporateforce.server.model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class HolidaysDao extends AbstractDao<Holidays> {

	public HolidaysDao() {
		super(Holidays.class);
	}

	public HolidaysDao(Class<Holidays> entityClass) {
		super(entityClass);
	}

	public List<Holidays> listByUsers(Users u) {
		List<Holidays> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			res = session.createCriteria(Holidays.class).add(Restrictions.eq("users",u)).list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}
}
