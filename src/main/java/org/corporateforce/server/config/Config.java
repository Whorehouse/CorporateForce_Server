package org.corporateforce.server.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	public static Properties properties;
	
	static {
		properties = new Properties();
		InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("/corporateforce.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isEnabledModule(String module) {
		return (properties.containsKey("enable"+module) && Integer.valueOf(properties.getProperty("enable"+module,"0"))==1) ? true : false;
	}
	
	public String getUriModule(String module) {
		return isEnabledModule(module) ? properties.getProperty("uri"+module,"http://localhost:8080/") : null;
	}
}
