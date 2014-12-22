package com.corporateforce.server.hibernate;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Profiles.
 * @see com.corporateforce.server.hibernate.Profiles
 * @author Hibernate Tools
 */
@Stateless
public class ProfilesHome {

	private static final Log log = LogFactory.getLog(ProfilesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Profiles transientInstance) {
		log.debug("persisting Profiles instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Profiles persistentInstance) {
		log.debug("removing Profiles instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Profiles merge(Profiles detachedInstance) {
		log.debug("merging Profiles instance");
		try {
			Profiles result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Profiles findById(Integer id) {
		log.debug("getting Profiles instance with id: " + id);
		try {
			Profiles instance = entityManager.find(Profiles.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
