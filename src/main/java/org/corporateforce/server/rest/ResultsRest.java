package org.corporateforce.server.rest;

import java.util.List;

import org.corporateforce.server.dao.QuestionsDao;
import org.corporateforce.server.dao.ResultsDao;
import org.corporateforce.server.dao.TrainingsDao;
import org.corporateforce.server.dao.UsersDao;
import org.corporateforce.server.model.Answers;
import org.corporateforce.server.model.Questions;
import org.corporateforce.server.model.Results;
import org.corporateforce.server.model.Trainings;
import org.corporateforce.server.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Results")
public class ResultsRest extends AbstractRest<Results, ResultsDao>  {
	
	@Autowired
	UsersDao usersDao;	
	@Autowired
	TrainingsDao trainingsDao;
	
	@RequestMapping(value = "/listByUsers/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Results> listByUsers(@PathVariable("id") int id) throws Exception {
		Users users = usersDao.getEntityById(id);
		List<Results> entities = null;
		try {
			entities = daoService.listByUsers(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;		
	}
	
	@RequestMapping(value = "/listByTrainings/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Results> listByTrainings(@PathVariable("id") int id) throws Exception {
		Trainings trainings = trainingsDao.getEntityById(id);
		List<Results> entities = null;
		try {
			entities = daoService.listByTrainings(trainings);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;		
	}
}
