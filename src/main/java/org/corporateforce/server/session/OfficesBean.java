package org.corporateforce.server.session;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


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

	private Offices editOffice;
	
	private List<Offices> officesList = null;
	
	public OfficesDao getOfficesDao() {
		return officesDao;
	}

	public void setOfficesDao(OfficesDao officesDao) {
		this.officesDao = officesDao;
	}
	
	@Autowired
	private UsersBean usersBean;

	public void setUsersBean(UsersBean usersBean) {
		this.usersBean = usersBean;
	}
	
	public Map<String, Integer> getOfficesMap() throws Exception {
		List<Offices> offices = this.officesDao.getEntityList();
		Map<String, Integer> result = new TreeMap<String, Integer>();
		result.put("--Не выбрано--", 0);
		for (Offices p : offices) {
			result.put(p.getName(), p.getId());
		}
		return result;
	}

	public Offices getEditOffice() {
		return editOffice;
	}

	public void setEditOffice(Offices editOffice) {
		this.editOffice = editOffice;
	}

	public List<Offices> getOfficesList() throws Exception {
		if (officesList != null)
			return officesList;
		officesList = officesDao.getEntityList();
		return officesList;
	}

	public boolean refreshOfficesList() throws Exception {
		officesList = officesDao.getEntityList();
		return true;
	}
	
	public boolean create(Offices p) {
		try {
			if (p.getName()==null || p.getName().equals("")) return false;
			Offices result = officesDao.addEntity(p);
			return (result != null && result.getId()!=null && refreshOfficesList());
		} catch(Exception e) {
			System.out.println("DEBUG: OfficesBean error: " + e.getMessage());
			return false;
		}
	}

	public boolean update(Offices p) {
		try {
			return (officesDao.updateEntity(p)!=null && refreshOfficesList());
		} catch(Exception e) {
			System.out.println("DEBUG: OfficesBean error: " + e.getMessage());
			return false;
		}
	}
	
	public Boolean update() {
		return (editOffice!=null && update(editOffice));
	}
	
	public Boolean remove(Offices p) {
		try {
			if (p.getId()==usersBean.getCurrentUser().getOffices().getId()) return false;
			officesDao.deleteEntity(p.getId());
			refreshOfficesList();
			return true;
		} catch(Exception e) {
			System.out.println("DEBUG: OfficesBean error: " + e.getMessage());
			return false;
		}
	}
}
