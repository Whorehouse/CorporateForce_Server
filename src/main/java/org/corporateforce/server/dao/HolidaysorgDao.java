package org.corporateforce.server.dao;

import java.util.Date;
import java.util.List;

import org.corporateforce.server.model.Holidaysorg;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

@Service
public class HolidaysorgDao extends AbstractDao<Holidaysorg> {

	public HolidaysorgDao() {
		super(Holidaysorg.class);
	}

	public HolidaysorgDao(Class<Holidaysorg> entityClass) {
		super(entityClass);
	}
	
	@SuppressWarnings("unchecked")
	public List<Holidaysorg> listByRangeOverlap(Date startDate, Date endDate) throws Exception {
		List<Holidaysorg> res = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Criteria query = session.createCriteria(Holidaysorg.class);
			query.add(Restrictions.ge("end", startDate));
			query.add(Restrictions.le("start", endDate));
			res = query.list();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return res;
	}

}

