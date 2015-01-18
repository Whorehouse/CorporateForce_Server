package org.corporateforce.server.rest;

import java.util.List;

import org.corporateforce.server.dao.HolidaysDao;
import org.corporateforce.server.dao.UsersDao;
import org.corporateforce.server.model.Holidays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Holidays")
public class HolidaysRest extends AbstractRest<Holidays, HolidaysDao> {
	
	@Autowired
	UsersDao usersDao;

	@RequestMapping(value = "/listByUsers/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Holidays> listByUsers(@PathVariable int id) {
		List<Holidays> entities = null;
		try {
			entities = daoService.listByUsers(usersDao.getEntityById(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
	}
	
}
