package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Results.
 * @see com.corporateforce.server.hibernate.Results
 * @author Hibernate Tools
 */
@Stateless
public class ResultsHome {

	private static final Log log = LogFactory.getLog(ResultsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Results transientInstance) {
		log.debug("persisting Results instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Results persistentInstance) {
		log.debug("removing Results instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Results merge(Results detachedInstance) {
		log.debug("merging Results instance");
		try {
			Results result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Results findById(Integer id) {
		log.debug("getting Results instance with id: " + id);
		try {
			Results instance = entityManager.find(Results.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
