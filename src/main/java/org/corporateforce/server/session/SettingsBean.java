package org.corporateforce.server.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.corporateforce.server.dao.SettingsDao;
import org.corporateforce.server.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SettingsBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SettingsDao settingsDao;

	public void setSettingsDao(SettingsDao settingsDao) {
		this.settingsDao = settingsDao;
	}

	private Map<String, String> properties;

	@PostConstruct
	public boolean refreshSettings() {
		properties = new TreeMap<String, String>();
		List<Settings> settings = null;
		try {
			settings = settingsDao.getEntityList();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		for (Settings s : settings) {
			properties.put(s.getPname(), s.getPvalue());
		}
		return true;
	}
	
	//-------------------------------

	
	public boolean isFullConfig() {
		return (isResourcesPathConfig() && isUriClientsConfig());
	}
	
	public boolean isResourcesPathConfig() {
		return isParam("resourcesPath");
	}
	
	public boolean isUriClientsConfig() {
		return (isParam("uriFaces") && isParam("uriProjects") && isParam("uriTrainings"));
	}
	
	//-------------------------------

	public String getUriModule(String module) {
		String result = getParam("uri" + module);
		return result != null ? result : "#";
	}
	
	public String getUriFaces() {
		return getUriModule("Faces");
	}
	
	public String getUriProjects() {
		return getUriModule("Projects");
	}
	
	public String getUriTrainings() {
		return getUriModule("Trainings");
	}

	public Map<String, String> getModules() {
		Map<String, String> res = new HashMap<String, String>();
		if (isUriClientsConfig()) {
			res.put("Faces", getUriFaces());
			res.put("Projects", getUriProjects());
			res.put("Trainings", getUriTrainings());
		}
		return res;
	}

	public String getResourcesPath() {
		return getParam("resourcesPath");
	}
	
	public List<Settings> getSettingsList(List<String> params) {
		List<Settings> res = new ArrayList<Settings>();
		for (String pname: params) {
			Settings tmp = getParamInstance(pname);
			if (tmp==null) {
				tmp = new Settings();
				tmp.setPname(pname);
			}
			res.add(tmp);
		}
		return res;
	}
	
	//----------------------------
	
	public boolean isParam(String pname) {
		return (properties.containsKey(pname) && !properties.get(pname).trim().equals(""));
	}
	
	public String getParam(String pname) {
		return (isParam(pname)) ? properties.get(pname) : null;
	}
	
	public Settings getParamInstance(String pname) {
		return settingsDao.getByPname(pname);
	}
	
	public Settings setParam(String pname, String pvalue) {
		Settings res = settingsDao.settingsUpsert(pname, pvalue);
		refreshSettings();
		return res;
	}
	
	public boolean setParam(Settings settings) {
		boolean res = false;
		System.out.println("SettingsBean log: "+settings.getPname()+" = "+settings.getPvalue());
		if (settings.getPname()!=null && !settings.getPname().trim().equals("") 
				&& settings.getPvalue()!=null && !settings.getPvalue().trim().equals("") 
				&& settingsDao.settingsUpsert(settings.getPname(), settings.getPvalue())!=null) {
			res = true;
			refreshSettings();
		}
		return res;
	}
}
