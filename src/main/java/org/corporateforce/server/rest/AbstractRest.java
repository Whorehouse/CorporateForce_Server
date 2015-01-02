package org.corporateforce.server.rest;

import java.util.List;

import org.corporateforce.server.dao.AbstractDao;
import org.corporateforce.server.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class AbstractRest<MODEL, DAO extends AbstractDao<MODEL>> {
	@Autowired
	DAO daoService;
	
	/* Submit form in Spring Restful Services */
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Status addEntity(@RequestBody MODEL entity) {
		try {
			daoService.addEntity(entity);
			return new Status(1, "Entity added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	/* Ger a single objct in Json form in Spring Rest Services */
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public @ResponseBody MODEL getEntity(@PathVariable("id") int id) {
		MODEL entity = null;
		try {
			entity = daoService.getEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	/* Getting List of objects in Json format in Spring Restful Services */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<MODEL> getEntities() {

		List<MODEL> entities = null;
		try {
			entities = daoService.getEntityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return entities;
	}

	/* Delete an object from DB in Spring Restful Services */
	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteEntity(@PathVariable("id") int id) {
		try {
			daoService.deleteEntity(id);
			return new Status(1, "Entity deleted Successfully!");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
