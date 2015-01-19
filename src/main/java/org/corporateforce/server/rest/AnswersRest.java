package org.corporateforce.server.rest;

import java.util.List;

import org.corporateforce.server.dao.AnswersDao;
import org.corporateforce.server.dao.QuestionsDao;
import org.corporateforce.server.model.Answers;
import org.corporateforce.server.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Answers")
public class AnswersRest extends AbstractRest<Answers, AnswersDao>  {
	
	@Autowired
	QuestionsDao questionsDao;
	
	@RequestMapping(value = "/listByQuestions/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Answers> listByQuestions(@PathVariable("id") int id) throws Exception {
		Questions questions = questionsDao.getEntityById(id);
		List<Answers> entities = null;
		try {
			entities = daoService.listByQuestions(questions);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;		
	}
}
