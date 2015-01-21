package org.corporateforce.server.dao;

import org.corporateforce.server.model.Projects;
import org.springframework.stereotype.Service;

@Service
public class ProjectsDao extends AbstractDao<Projects> {

	public ProjectsDao() {
		super(Projects.class);
	}

	public ProjectsDao(Class<Projects> entityClass) {
		super(entityClass);
	}


}
