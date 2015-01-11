package org.corporateforce.server.rest;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MODEL addEntity(@RequestBody MODEL entity) {
		try {
			MODEL res = daoService.addEntity(entity);
			return res;
		} catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody MODEL updateEntity(@RequestBody MODEL entity) {
		try {
			MODEL res = daoService.updateEntity(entity);
			return res;
		} catch (Exception e) {
			// e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public @ResponseBody MODEL getEntity(@PathVariable("id") int id) {
		MODEL entity = null;
		try {
			entity = daoService.getEntityById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody List<MODEL> getEntityList() {
		List<MODEL> entities = null;
		try {
			entities = daoService.getEntityList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return entities;
	}
	
	@RequestMapping(value = "/listExclude/{id}", method = RequestMethod.GET)
	public @ResponseBody List<MODEL> getEntityListExclude(@PathVariable("id") int id) {
		List<MODEL> entities = null;
		try {
			entities = daoService.getEntityListExclude(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entities;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public @ResponseBody Status deleteEntity(@PathVariable("id") int id) {
		try {
			daoService.deleteEntity(id);
			return new Status(1, "Entity deleted Successfully!");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}
	}
	
	@RequestMapping(value = "/count", method = RequestMethod.GET)
	public @ResponseBody int countEntities() {
		try {			
			return daoService.countEntities();
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static <T> T jsonToModel(String json, Class<T> modelClass) throws JsonParseException, JsonMappingException, IOException {
		T res = new ObjectMapper().readValue(json, modelClass);
		return res;
	}
}
