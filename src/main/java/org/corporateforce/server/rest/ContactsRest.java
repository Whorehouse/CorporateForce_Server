package org.corporateforce.server.rest;

import org.corporateforce.server.dao.ContactsDao;
import org.corporateforce.server.model.Contacts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("Contacts")
public class ContactsRest extends AbstractRest<Contacts, ContactsDao>  {

}
