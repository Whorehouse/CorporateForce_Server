package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Offices.
 * @see com.corporateforce.server.hibernate.Offices
 * @author Hibernate Tools
 */
@Stateless
public class OfficesHome {

	private static final Log log = LogFactory.getLog(OfficesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Offices transientInstance) {
		log.debug("persisting Offices instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Offices persistentInstance) {
		log.debug("removing Offices instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Offices merge(Offices detachedInstance) {
		log.debug("merging Offices instance");
		try {
			Offices result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Offices findById(Integer id) {
		log.debug("getting Offices instance with id: " + id);
		try {
			Offices instance = entityManager.find(Offices.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
