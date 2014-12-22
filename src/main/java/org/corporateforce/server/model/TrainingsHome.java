package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Trainings.
 * @see com.corporateforce.server.hibernate.Trainings
 * @author Hibernate Tools
 */
@Stateless
public class TrainingsHome {

	private static final Log log = LogFactory.getLog(TrainingsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Trainings transientInstance) {
		log.debug("persisting Trainings instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Trainings persistentInstance) {
		log.debug("removing Trainings instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Trainings merge(Trainings detachedInstance) {
		log.debug("merging Trainings instance");
		try {
			Trainings result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Trainings findById(Integer id) {
		log.debug("getting Trainings instance with id: " + id);
		try {
			Trainings instance = entityManager.find(Trainings.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
