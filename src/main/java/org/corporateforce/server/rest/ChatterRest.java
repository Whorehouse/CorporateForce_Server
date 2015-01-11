package org.corporateforce.server.rest;

import java.util.List;

import org.corporateforce.server.dao.ChatterDao;
import org.corporateforce.server.dao.UsersDao;
import org.corporateforce.server.model.Chatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Chatter")
public class ChatterRest extends AbstractRest<Chatter, ChatterDao> {
	
	@Autowired
	UsersDao usersDao;

	@RequestMapping(value = "/listForParent/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Chatter> listForParent(@PathVariable int id) {
		List<Chatter> entities = null;
		try {
			entities = daoService.getListForParent(usersDao.getEntityById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
	}
	
	@RequestMapping(value = "/listForCreator/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Chatter> listForCreator(@PathVariable int id) {
		List<Chatter> entities = null;
		try {
			entities = daoService.getListForCreator(usersDao.getEntityById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
	}
	
}
