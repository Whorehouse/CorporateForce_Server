package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Objectives.
 * @see com.corporateforce.server.hibernate.Objectives
 * @author Hibernate Tools
 */
@Stateless
public class ObjectivesHome {

	private static final Log log = LogFactory.getLog(ObjectivesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Objectives transientInstance) {
		log.debug("persisting Objectives instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Objectives persistentInstance) {
		log.debug("removing Objectives instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Objectives merge(Objectives detachedInstance) {
		log.debug("merging Objectives instance");
		try {
			Objectives result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Objectives findById(Integer id) {
		log.debug("getting Objectives instance with id: " + id);
		try {
			Objectives instance = entityManager.find(Objectives.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
