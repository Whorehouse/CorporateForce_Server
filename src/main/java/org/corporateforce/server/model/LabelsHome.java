package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Labels.
 * @see org.corporateforce.server.model.Labels
 * @author Hibernate Tools
 */
@Stateless
public class LabelsHome {

	private static final Log log = LogFactory.getLog(LabelsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Labels transientInstance) {
		log.debug("persisting Labels instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Labels persistentInstance) {
		log.debug("removing Labels instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Labels merge(Labels detachedInstance) {
		log.debug("merging Labels instance");
		try {
			Labels result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Labels findById(Integer id) {
		log.debug("getting Labels instance with id: " + id);
		try {
			Labels instance = entityManager.find(Labels.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
