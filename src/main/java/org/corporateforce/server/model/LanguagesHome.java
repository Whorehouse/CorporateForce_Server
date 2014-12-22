package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Languages.
 * @see com.corporateforce.server.hibernate.Languages
 * @author Hibernate Tools
 */
@Stateless
public class LanguagesHome {

	private static final Log log = LogFactory.getLog(LanguagesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Languages transientInstance) {
		log.debug("persisting Languages instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Languages persistentInstance) {
		log.debug("removing Languages instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Languages merge(Languages detachedInstance) {
		log.debug("merging Languages instance");
		try {
			Languages result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Languages findById(Integer id) {
		log.debug("getting Languages instance with id: " + id);
		try {
			Languages instance = entityManager.find(Languages.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
