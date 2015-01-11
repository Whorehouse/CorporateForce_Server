package org.corporateforce.server.dao;

import org.corporateforce.server.model.Avatars;
import org.springframework.stereotype.Service;

@Service
public class AvatarsDao extends AbstractDao<Avatars> {
	
	public AvatarsDao() {
		super(Avatars.class);
	}

	public AvatarsDao(Class<Avatars> entityClass) {
		super(entityClass);
	}
}
