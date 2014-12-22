package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Chatterresourceslink.
 * @see com.corporateforce.server.hibernate.Chatterresourceslink
 * @author Hibernate Tools
 */
@Stateless
public class ChatterresourceslinkHome {

	private static final Log log = LogFactory
			.getLog(ChatterresourceslinkHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Chatterresourceslink transientInstance) {
		log.debug("persisting Chatterresourceslink instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Chatterresourceslink persistentInstance) {
		log.debug("removing Chatterresourceslink instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Chatterresourceslink merge(Chatterresourceslink detachedInstance) {
		log.debug("merging Chatterresourceslink instance");
		try {
			Chatterresourceslink result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Chatterresourceslink findById(Integer id) {
		log.debug("getting Chatterresourceslink instance with id: " + id);
		try {
			Chatterresourceslink instance = entityManager.find(
					Chatterresourceslink.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
