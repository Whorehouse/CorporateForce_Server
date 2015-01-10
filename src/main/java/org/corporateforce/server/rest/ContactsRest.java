package org.corporateforce.server.rest;

import org.corporateforce.server.dao.ContactsDao;
import org.corporateforce.server.model.Contacts;
import org.corporateforce.server.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Contacts")
public class ContactsRest extends AbstractRest<Contacts, ContactsDao> {

	@RequestMapping(value="/getByUsers", method=RequestMethod.POST)
    public @ResponseBody Contacts getByUsers(@RequestBody Users u){
		Contacts entity = null;
		try {
			entity = daoService.getByUsers(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
    }
	
}
