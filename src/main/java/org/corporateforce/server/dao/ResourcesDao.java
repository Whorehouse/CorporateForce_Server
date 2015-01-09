package org.corporateforce.server.dao;

import org.corporateforce.server.model.Resources;
import org.springframework.stereotype.Service;

@Service
public class ResourcesDao extends AbstractDao<Resources> {
	
	public ResourcesDao() {
		super(Resources.class);
	}

	public ResourcesDao(Class<Resources> entityClass) {
		super(entityClass);
	}
}
