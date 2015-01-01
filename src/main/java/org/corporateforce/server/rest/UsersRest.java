package org.corporateforce.server.rest;
import java.util.List;

import org.apache.log4j.Logger;
import org.corporateforce.server.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import org.corporateforce.server.model.Users;
import org.corporateforce.server.services.UsersServices;

@Controller
@RequestMapping("/usersrest")
public class UsersRest {

 @Autowired
 UsersServices usersService;

 static final Logger logger = Logger.getLogger(UsersRest.class);

 /* Submit form in Spring Restful Services */
 @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
 public @ResponseBody
 Status addEntity(@RequestBody Users entity) {
  try {
   usersService.addEntity(entity);
   return new Status(1, "Entity added Successfully !");
  } catch (Exception e) {
   // e.printStackTrace();
   return new Status(0, e.toString());
  }

 }

 /* Ger a single objct in Json form in Spring Rest Services */
 @RequestMapping(value = "/{id}", method = RequestMethod.GET)
 public @ResponseBody
 Users getEntity(@PathVariable("id") long id) {
  Users entity = null;
  try {
   entity = usersService.getEntityById(id);

  } catch (Exception e) {
   e.printStackTrace();
  }
  return entity;
 }

 /* Getting List of objects in Json format in Spring Restful Services */
 @RequestMapping(value = "/list", method = RequestMethod.GET)
 public @ResponseBody
 List<Users> getEntities() {

  List<Users> entities = null;
  try {
   entities= usersService.getEntityList();

  } catch (Exception e) {
   e.printStackTrace();
  }

  return entities;
 }

 /* Delete an object from DB in Spring Restful Services */
 @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
 public @ResponseBody
 Status deleteEntity(@PathVariable("id") long id) {
  try {
   usersService.deleteEntity(id);
   return new Status(1, "Entity deleted Successfully !");
  } catch (Exception e) {
   return new Status(0, e.toString());
  }

 }
}

