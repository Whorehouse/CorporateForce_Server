package org.corporateforce.server.dao;

import org.corporateforce.server.model.Offices;
import org.springframework.stereotype.Service;

@Service
public class OfficesDao extends AbstractDao<Offices> {

	public OfficesDao() {
		super(Offices.class);
	}

	public OfficesDao(Class<Offices> entityClass) {
		super(entityClass);
	}


}
