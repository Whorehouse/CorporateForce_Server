package org.corporateforce.server.rest;


import org.corporateforce.server.dao.TrainingsDao;
import org.corporateforce.server.dao.TutorialsDao;
import org.corporateforce.server.model.Trainings;
import org.corporateforce.server.model.Tutorials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Tutorials")
public class TutorialsRest extends AbstractRest<Tutorials, TutorialsDao>  {
	
	@Autowired
	TrainingsDao trainingsDao;
	
	@RequestMapping(value = "/getByTrainings/{id}", method = RequestMethod.GET)
	public @ResponseBody Tutorials getByTrainings(@PathVariable("id") int id) throws Exception {
		Trainings trainings = trainingsDao.getEntityById(id);
		Tutorials entity = null;
		try {
			entity = daoService.getByTrainings(trainings);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;		
	}
}
