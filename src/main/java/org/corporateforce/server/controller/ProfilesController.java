package org.corporateforce.server.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.corporateforce.server.model.Profiles;
import org.corporateforce.server.session.ProfilesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ProfilesController extends PaginationController implements Serializable {
	private static final long serialVersionUID = 1L;

	// session beans

	@Autowired
	private ProfilesBean profilesBean;
	
	// constants

	private final String PROFILE_UPSERT_ERROR = "error_upsert";
	private final String PROFILES_ERROR_EMPTY_FIELDS = "error_empty_fields";

	// page variables

	private String errorMessage = null;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		//this.errorMessage = errorMessage;
	}

	private Profiles editProfile = null;

	public Profiles getEditProfile() {
		return editProfile;
	}

	public void setEditProfile(Profiles editProfile) {
		this.editProfile = editProfile;	
	}

	private List<ProfilesWrapper> profilesList = null;

	public List<ProfilesWrapper> getProfilesList() {
		if (profilesList == null) refreshController();
		return profilesList;
	}


	// controller methods

	public void refreshController() {
		try {
			List<Profiles> result = this.profilesBean.getProfilesList();
			this.setRecordCount(result.size());
			profilesList = new ArrayList<ProfilesWrapper>();
			for (int i=0; i<result.size(); i++) {
				profilesList.add(new ProfilesWrapper(i, result.get(i)));
			}
		} catch (Exception e) {
			this.setRecordCount(0);
			profilesList = null;
			System.out.println(e.getMessage());
		} finally {
			resetController();
		}
	}
	
	public void resetController() {
		this.editProfile = null;
		this.errorMessage = null;
	}
	
	public void createProfile() {
		editProfile = new Profiles();
	}
	
	public void deleteSelectedProfiles() {
		for (ProfilesWrapper u : profilesList) {
			if (u.selected) {
				this.profilesBean.remove(u.instance);
			}
		}
		this.refreshController();
	}
	
	public void saveEditProfile() throws Exception {
		this.errorMessage = null;
		if (this.editProfile.getName()==null || this.editProfile.getName().trim().equals("")) {
			this.errorMessage = PROFILES_ERROR_EMPTY_FIELDS;
			return;
		}
		if ((this.editProfile.getId() == null && !this.profilesBean.create(this.editProfile)) 
			|| (this.editProfile.getId() != null && !this.profilesBean.update(this.editProfile))) {
			this.errorMessage = PROFILE_UPSERT_ERROR;
			return;
		}
		refreshController();		
	}

	// wrapper

	public class ProfilesWrapper {
		private Profiles instance;
		private Integer listIndex;
		private Boolean selected;

		public ProfilesWrapper(Integer number, Profiles profile) {
			this.instance = profile;
			this.listIndex = number;
			this.selected = false;
		}
		
		public Profiles getInstance() {
			return instance;
		}

		public void setInstance(Profiles instance) {
			this.instance = instance;
		}

		public Integer getListIndex() {
			return listIndex;
		}

		public Integer getNumber() {
			return listIndex + 1;
		}

		public Boolean getSelected() {
			return selected;
		}

		public void setSelected(Boolean selected) {
			this.selected = selected;
		}

	}
}
