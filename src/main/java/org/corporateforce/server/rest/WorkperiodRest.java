package org.corporateforce.server.rest;

import java.util.Date;
import java.util.List;

import org.corporateforce.server.dao.UsersDao;
import org.corporateforce.server.dao.WorkperiodDao;
import org.corporateforce.server.helper.DateHelper;
import org.corporateforce.server.model.Users;
import org.corporateforce.server.model.Workperiod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Workperiod")
public class WorkperiodRest extends AbstractRest<Workperiod, WorkperiodDao>   {

	@Autowired
	UsersDao usersDao;
	
	@RequestMapping(value = "/listByUser/{uid}", method = RequestMethod.GET)
	public @ResponseBody List<Workperiod> listByUser(@PathVariable("uid") int uid) throws Exception {
		Users users = usersDao.getEntityById(uid);
		List<Workperiod> entities = null;
		try {
			entities = daoService.listByUser(users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;		
	}
	
	@RequestMapping(value = "/listByRangeOverlap/{uid}/{startDate}/{endDate}", method = RequestMethod.GET)
	public @ResponseBody List<Workperiod> listByRangeOverlap(
			@PathVariable("uid") int uid, 
			@PathVariable("startDate") @DateTimeFormat(iso=ISO.DATE) Date startDate, 
			@PathVariable("endDate") @DateTimeFormat(iso=ISO.DATE)  Date endDate
	) throws Exception {
		startDate = DateHelper.removeTimeZoneOffset(startDate);
		endDate = DateHelper.removeTimeZoneOffset(endDate);
		Users users = usersDao.getEntityById(uid);
		List<Workperiod> entities = null;
		try {
			entities = daoService.listByRangeOverlap(users, startDate, endDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;		
	}
}
