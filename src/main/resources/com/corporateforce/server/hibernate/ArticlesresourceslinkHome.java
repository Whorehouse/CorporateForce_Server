package com.corporateforce.server.hibernate;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Articlesresourceslink.
 * @see com.corporateforce.server.hibernate.Articlesresourceslink
 * @author Hibernate Tools
 */
@Stateless
public class ArticlesresourceslinkHome {

	private static final Log log = LogFactory
			.getLog(ArticlesresourceslinkHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Articlesresourceslink transientInstance) {
		log.debug("persisting Articlesresourceslink instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Articlesresourceslink persistentInstance) {
		log.debug("removing Articlesresourceslink instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Articlesresourceslink merge(Articlesresourceslink detachedInstance) {
		log.debug("merging Articlesresourceslink instance");
		try {
			Articlesresourceslink result = entityManager
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Articlesresourceslink findById(Integer id) {
		log.debug("getting Articlesresourceslink instance with id: " + id);
		try {
			Articlesresourceslink instance = entityManager.find(
					Articlesresourceslink.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
