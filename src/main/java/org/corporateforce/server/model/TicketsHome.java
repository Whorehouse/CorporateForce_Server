package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Tickets.
 * @see org.corporateforce.server.model.Tickets
 * @author Hibernate Tools
 */
@Stateless
public class TicketsHome {

	private static final Log log = LogFactory.getLog(TicketsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Tickets transientInstance) {
		log.debug("persisting Tickets instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Tickets persistentInstance) {
		log.debug("removing Tickets instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Tickets merge(Tickets detachedInstance) {
		log.debug("merging Tickets instance");
		try {
			Tickets result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tickets findById(Integer id) {
		log.debug("getting Tickets instance with id: " + id);
		try {
			Tickets instance = entityManager.find(Tickets.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
