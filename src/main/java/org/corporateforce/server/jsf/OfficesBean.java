package org.corporateforce.server.jsf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.corporateforce.server.dao.OfficesDao;
import org.corporateforce.server.model.Offices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class OfficesBean implements Serializable {
	
	@Autowired
	private OfficesDao officesDao;

	public OfficesDao getOfficesDao() {
		return officesDao;
	}

	public void setOfficesDao(OfficesDao officesDao) {
		this.officesDao = officesDao;
	}
	
	public Map<String, Integer> getOfficesMap() throws Exception {
		List<Offices> offices = this.officesDao.getEntityList();
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Offices p : offices) {
			result.put(p.getName(), p.getId());
		}
		return result;
	}

}
