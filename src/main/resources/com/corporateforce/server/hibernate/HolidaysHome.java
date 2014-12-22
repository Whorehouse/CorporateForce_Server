package com.corporateforce.server.hibernate;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Holidays.
 * @see com.corporateforce.server.hibernate.Holidays
 * @author Hibernate Tools
 */
@Stateless
public class HolidaysHome {

	private static final Log log = LogFactory.getLog(HolidaysHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Holidays transientInstance) {
		log.debug("persisting Holidays instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Holidays persistentInstance) {
		log.debug("removing Holidays instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Holidays merge(Holidays detachedInstance) {
		log.debug("merging Holidays instance");
		try {
			Holidays result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Holidays findById(Integer id) {
		log.debug("getting Holidays instance with id: " + id);
		try {
			Holidays instance = entityManager.find(Holidays.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
