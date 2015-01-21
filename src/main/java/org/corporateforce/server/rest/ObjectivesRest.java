package org.corporateforce.server.rest;

import java.util.List;

import org.corporateforce.server.dao.ObjectivesDao;
import org.corporateforce.server.dao.ProjectsDao;
import org.corporateforce.server.model.Objectives;
import org.corporateforce.server.model.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Objectives")
public class ObjectivesRest extends AbstractRest<Objectives, ObjectivesDao>  {
	
	@Autowired
	ProjectsDao projectsDao;
	
	@RequestMapping(value = "/listByProject/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Objectives> listByProject(@PathVariable("id") int id) throws Exception {
		Projects projects = projectsDao.getEntityById(id);
		List<Objectives> entities = null;
		try {
			entities = daoService.listByProject(projects);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;		
	}
}
