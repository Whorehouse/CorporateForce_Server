package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Resources.
 * @see org.corporateforce.server.model.Resources
 * @author Hibernate Tools
 */
@Stateless
public class ResourcesHome {

	private static final Log log = LogFactory.getLog(ResourcesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Resources transientInstance) {
		log.debug("persisting Resources instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Resources persistentInstance) {
		log.debug("removing Resources instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Resources merge(Resources detachedInstance) {
		log.debug("merging Resources instance");
		try {
			Resources result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Resources findById(Integer id) {
		log.debug("getting Resources instance with id: " + id);
		try {
			Resources instance = entityManager.find(Resources.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
