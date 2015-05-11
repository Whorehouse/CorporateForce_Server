package org.corporateforce.server.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.corporateforce.server.dao.SettingsDao;
import org.corporateforce.server.model.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Config {
	
	@Autowired
	private static SettingsDao settingsDao;

	public void setSettingsDao(SettingsDao settingsDao) {
		Config.settingsDao = settingsDao;
	}

	private static Map<String, String> properties;

	public static String getProperty(String pname, String pdefault) {
		if (properties.containsKey(pname)) {
			return properties.get(pname);
		} else {
			return pdefault;
		}
	}
	
	static {
		properties = new TreeMap<String, String>();
		List<Settings> settings = null;
		try {
			settings = settingsDao.getEntityList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Settings s : settings) {
			properties.put(s.getPname(), s.getPvalue());
		}
	}

	public static boolean isEnabledModule(String module) {
		return (properties.containsKey("enable" + module) && Integer
				.valueOf(getProperty("enable" + module, "0")) == 1) ? true
				: false;
	}

	public static String getUriModule(String module) {
		return isEnabledModule(module) ? getProperty("uri" + module,
				"http://localhost:8080/") : null;
	}

	public static Map<String, String> getModules() {
		Map<String, String> res = new HashMap<String, String>();
		if (properties.containsKey("clients")) {
			String[] modules = getProperty("clients","").split(",");
			for (String module : modules) {
				String uri = getUriModule(module);
				if (uri != null)
					res.put(module, uri);
			}
		}
		return res;
	}

	public static String getResourcesPath() {
		return getProperty("resourcesPath","C:\\uploadFiles\\");
	}
}
