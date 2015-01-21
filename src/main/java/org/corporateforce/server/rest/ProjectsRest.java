package org.corporateforce.server.rest;

import org.corporateforce.server.dao.ProjectsDao;
import org.corporateforce.server.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Projects")
public class ProjectsRest extends AbstractRest<Projects, ProjectsDao>  {
	
	@Autowired
	ProjectsDao ProjectsDao;

}
