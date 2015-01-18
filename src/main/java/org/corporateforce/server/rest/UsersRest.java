package org.corporateforce.server.rest;

import java.util.List;

import org.corporateforce.server.dao.UsersDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.corporateforce.server.model.Users;

@Controller
@RequestMapping("Users")
public class UsersRest extends AbstractRest<Users, UsersDao> {
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
    public @ResponseBody Users loginUsers(@RequestParam("login") String login, @RequestParam("password") String password){
		Users entity = null;
		try {
			entity = daoService.loginUsers(login, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
    }
	
	@RequestMapping(value="/isManager/{id}", method=RequestMethod.GET)
    public @ResponseBody boolean isManager(@PathVariable("id") int id){
		boolean res = false;
		try {
			res = daoService.isManager(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
    }
	
	@RequestMapping(value="/isManager/{manager}/{user}", method=RequestMethod.GET)
    public @ResponseBody boolean isManager(@PathVariable("manager") int manager, @PathVariable("user") int user){
		boolean res = false;
		try {
			res = daoService.isManager(manager, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
    }
	
	@RequestMapping(value="/listByManager/{id}", method=RequestMethod.GET)
    public @ResponseBody List<Users> listByManager(@PathVariable("id") int id){
		List<Users> res = null;
		try {
			res = daoService.listByManager(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
    }
}
