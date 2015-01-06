package org.corporateforce.server.rest;

import org.corporateforce.server.dao.UsersDaoImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.corporateforce.server.model.Users;

@Controller
@RequestMapping("Users")
public class UsersRestImpl extends AbstractRest<Users, UsersDaoImpl> {
	
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
}
