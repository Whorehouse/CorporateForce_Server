package com.corporateforce.server.hibernate;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Trainingsuserslink.
 * @see com.corporateforce.server.hibernate.Trainingsuserslink
 * @author Hibernate Tools
 */
@Stateless
public class TrainingsuserslinkHome {

	private static final Log log = LogFactory
			.getLog(TrainingsuserslinkHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Trainingsuserslink transientInstance) {
		log.debug("persisting Trainingsuserslink instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Trainingsuserslink persistentInstance) {
		log.debug("removing Trainingsuserslink instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Trainingsuserslink merge(Trainingsuserslink detachedInstance) {
		log.debug("merging Trainingsuserslink instance");
		try {
			Trainingsuserslink result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Trainingsuserslink findById(Integer id) {
		log.debug("getting Trainingsuserslink instance with id: " + id);
		try {
			Trainingsuserslink instance = entityManager.find(
					Trainingsuserslink.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
