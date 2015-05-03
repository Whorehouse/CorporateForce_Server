package org.corporateforce.server.session;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

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
	
	public Map<String, Integer> getOfficesMap() throws Exception {
		List<Offices> offices = this.officesDao.getEntityList();
		Map<String, Integer> result = new HashMap<String, Integer>();
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

	public void refreshOfficesList() throws Exception {
		officesList = officesDao.getEntityList();
	}
	
	public void actionEdit() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String id = params.get("editOfficeId");
		try {
			this.setEditOffice(officesDao.getEntityById(Integer.parseInt(id)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveEditOffice() throws Exception {
		officesDao.updateEntity(editOffice);
		refreshOfficesList();
	}
	
	public void actionDelete() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String id = params.get("deleteOfficeId");
		try {
			officesDao.deleteEntity(Integer.parseInt(id));
			refreshOfficesList();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}