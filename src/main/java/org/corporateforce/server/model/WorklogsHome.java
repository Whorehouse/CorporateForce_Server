package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Worklogs.
 * @see com.corporateforce.server.hibernate.Worklogs
 * @author Hibernate Tools
 */
@Stateless
public class WorklogsHome {

	private static final Log log = LogFactory.getLog(WorklogsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Worklogs transientInstance) {
		log.debug("persisting Worklogs instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Worklogs persistentInstance) {
		log.debug("removing Worklogs instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Worklogs merge(Worklogs detachedInstance) {
		log.debug("merging Worklogs instance");
		try {
			Worklogs result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Worklogs findById(Integer id) {
		log.debug("getting Worklogs instance with id: " + id);
		try {
			Worklogs instance = entityManager.find(Worklogs.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
