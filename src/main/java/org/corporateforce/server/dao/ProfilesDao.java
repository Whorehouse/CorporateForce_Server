package org.corporateforce.server.dao;

import org.corporateforce.server.model.Profiles;
import org.springframework.stereotype.Service;

@Service
public class ProfilesDao extends AbstractDao<Profiles> {

	public ProfilesDao() {
		super(Profiles.class);
	}

	public ProfilesDao(Class<Profiles> entityClass) {
		super(entityClass);
	}


}
