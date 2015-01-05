package org.corporateforce.server.rest;

import java.util.List;

import org.corporateforce.server.dao.UsersDaoImpl;
import org.corporateforce.server.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
