package org.corporateforce.server.rest;

import java.util.List;

import org.corporateforce.server.dao.WorklogsDao;
import org.corporateforce.server.dao.TicketsDao;
import org.corporateforce.server.dao.UsersDao;
import org.corporateforce.server.model.Users;
import org.corporateforce.server.model.Worklogs;
import org.corporateforce.server.model.Tickets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Worklogs")
public class WorklogsRest extends AbstractRest<Worklogs, WorklogsDao>  {
	
	@Autowired
	TicketsDao ticketsDao;
	@Autowired
	UsersDao usersDao;
	
	@RequestMapping(value = "/listByTicket/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Worklogs> listByTicket(@PathVariable("id") int id) throws Exception {
		Tickets tickets = ticketsDao.getEntityById(id);
		List<Worklogs> entities = null;
		try {
			entities = daoService.listByTicket(tickets);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;		
	}
	
	@RequestMapping(value = "/listByTicketAndUser/{id}/{id}", method = RequestMethod.GET)
	public @ResponseBody List<Worklogs> listByTicket(@PathVariable("id") int tid, @PathVariable("id") int uid) throws Exception {
		Tickets tickets = ticketsDao.getEntityById(tid);
		Users users = usersDao.getEntityById(uid);
		List<Worklogs> entities = null;
		try {
			entities = daoService.listByTicketAndUser(tickets, users);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;		
	}
}
