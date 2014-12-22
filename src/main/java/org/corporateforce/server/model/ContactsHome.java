package org.corporateforce.server.model;

// Generated 22.12.2014 22:41:08 by Hibernate Tools 4.3.1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Contacts.
 * @see com.corporateforce.server.hibernate.Contacts
 * @author Hibernate Tools
 */
@Stateless
public class ContactsHome {

	private static final Log log = LogFactory.getLog(ContactsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Contacts transientInstance) {
		log.debug("persisting Contacts instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Contacts persistentInstance) {
		log.debug("removing Contacts instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Contacts merge(Contacts detachedInstance) {
		log.debug("merging Contacts instance");
		try {
			Contacts result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Contacts findById(Integer id) {
		log.debug("getting Contacts instance with id: " + id);
		try {
			Contacts instance = entityManager.find(Contacts.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
