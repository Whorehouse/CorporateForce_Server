package org.corporateforce.server.rest;

import java.util.List;

import org.corporateforce.server.dao.QuestionsDao;
import org.corporateforce.server.dao.TrainingsDao;
import org.corporateforce.server.model.Trainings;
import org.corporateforce.server.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Questions")
public class QuestionsRest extends AbstractRest<Questions, QuestionsDao>  {
	
	@Autowired
	TrainingsDao trainingsDao;
	
	@RequestMapping(value = "/listByTrainings/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Questions> listByTrainings(@PathVariable("id") int id) throws Exception {
		Trainings trainings = trainingsDao.getEntityById(id);
		List<Questions> entities = null;
		try {
			entities = daoService.listByTrainings(trainings);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;		
	}
}
