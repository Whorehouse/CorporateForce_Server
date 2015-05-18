package org.corporateforce.server.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.corporateforce.server.model.Settings;
import org.corporateforce.server.session.SettingsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class SettingsController extends PaginationController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SettingsBean settingsBean;

	public void setSettingsBean(SettingsBean settingsBean) {
		this.settingsBean = settingsBean;
	}
	
	private final String SETTINGS_EMPTY_FIELDS = "error_empty_fields";
	
	//--------------------------
	
	private String errorMessage = null;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		//this.errorMessage = errorMessage;
	}
	
	private List<SettingsWrapper> settingsList = null;

	public List<SettingsWrapper> getSettingsList() {
		if (settingsList == null) refreshController();
		return settingsList;
	}


	// controller methods

	public void refreshController() {
		try {
			List<String> loadParams = new ArrayList<String>();
			loadParams.add("uriFaces");
			loadParams.add("uriProjects");
			loadParams.add("uriTrainings");
			loadParams.add("resourcesPath");
			List<Settings> result = this.settingsBean.getSettingsList(loadParams);
			this.setRecordCount(loadParams.size());
			settingsList = new ArrayList<SettingsWrapper>();
			for (int i=0; i<result.size(); i++) {
				settingsList.add(new SettingsWrapper(i, getTextLabel("settings_"+result.get(i).getPname()), result.get(i)));
			}
		} catch (Exception e) {
			this.setRecordCount(0);
			settingsList = null;
			System.out.println(e.getMessage());
		} finally {
			resetController();
		}
	}
	
	public void resetController() {
		this.errorMessage = null;
	}
	
	public void saveSettings() {
		this.errorMessage = null;
		for (SettingsWrapper wrp: settingsList) {
			if (!settingsBean.setParam(wrp.getInstance())) {
				System.err.println(wrp.name + wrp.instance);
				this.errorMessage = SETTINGS_EMPTY_FIELDS;
				return;
			}
		}
	}
	
	//--------------------------
	
	public class SettingsWrapper {
		private Integer listIndex;
		private String name;
		private Settings instance;
		
		public SettingsWrapper(Integer number, String name, Settings settings) {
			this.listIndex = number;
			this.name = name;
			this.instance = settings;
		}
		
		public Settings getInstance() {
			return instance;
		}

		public void setInstance(Settings instance) {
			this.instance = instance;
		}

		public Integer getListIndex() {
			return listIndex;
		}

		public Integer getNumber() {
			return listIndex + 1;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
