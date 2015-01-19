package org.corporateforce.server.rest;

import org.corporateforce.server.dao.TrainingsDao;
import org.corporateforce.server.model.Trainings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Trainings")
public class TrainingsRest extends AbstractRest<Trainings, TrainingsDao>  {
	
	@RequestMapping(value = "/isTutorialed/{id}", method = RequestMethod.GET)
	public @ResponseBody boolean isTutorialed(@PathVariable("id") int id) throws Exception {
		return daoService.isTutorialed(id);		
	}
}
