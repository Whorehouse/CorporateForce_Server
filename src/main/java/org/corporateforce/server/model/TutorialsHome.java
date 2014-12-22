package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Tutorials.
 * @see org.corporateforce.server.model.Tutorials
 * @author Hibernate Tools
 */
@Stateless
public class TutorialsHome {

	private static final Log log = LogFactory.getLog(TutorialsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Tutorials transientInstance) {
		log.debug("persisting Tutorials instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Tutorials persistentInstance) {
		log.debug("removing Tutorials instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Tutorials merge(Tutorials detachedInstance) {
		log.debug("merging Tutorials instance");
		try {
			Tutorials result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tutorials findById(Integer id) {
		log.debug("getting Tutorials instance with id: " + id);
		try {
			Tutorials instance = entityManager.find(Tutorials.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
