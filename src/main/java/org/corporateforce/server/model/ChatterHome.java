package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Chatter.
 * @see org.corporateforce.server.model.Chatter
 * @author Hibernate Tools
 */
@Stateless
public class ChatterHome {

	private static final Log log = LogFactory.getLog(ChatterHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Chatter transientInstance) {
		log.debug("persisting Chatter instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Chatter persistentInstance) {
		log.debug("removing Chatter instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Chatter merge(Chatter detachedInstance) {
		log.debug("merging Chatter instance");
		try {
			Chatter result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Chatter findById(Integer id) {
		log.debug("getting Chatter instance with id: " + id);
		try {
			Chatter instance = entityManager.find(Chatter.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
