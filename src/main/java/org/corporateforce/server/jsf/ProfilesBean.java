package org.corporateforce.server.jsf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.corporateforce.server.dao.ProfilesDao;
import org.corporateforce.server.model.Profiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class ProfilesBean implements Serializable {
	
	@Autowired
	private ProfilesDao profilesDao;

	private Profiles editProfile;

	public Profiles getEditProfile() {
		return editProfile;
	}

	public void setEditProfile(Profiles editProfile) {
		this.editProfile = editProfile;
	}

	private List<Profiles> profilesList = null;
	
	public ProfilesDao getProfilesDao() {
		return profilesDao;
	}

	public void setProfilesDao(ProfilesDao profilesDao) {
		this.profilesDao = profilesDao;
	}
	
	public List<Profiles> getProfilesList() throws Exception {
		if (profilesList != null)
			return profilesList;
		profilesList = profilesDao.getEntityList();
		return profilesList;
	}

	public void refreshProfilesList() throws Exception {
		profilesList = profilesDao.getEntityList();
	}
	
	public Map<String, Integer> getProfilesMap() throws Exception {
		List<Profiles> profiels = this.profilesDao.getEntityList();
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Profiles p : profiels) {
			result.put(p.getName(), p.getId());
		}
		return result;
	}
	
	public void actionEdit() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String id = params.get("editProfileId");
		try {
			this.setEditProfile(profilesDao.getEntityById(Integer.parseInt(id)));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveEditProfile() throws Exception {
		profilesDao.updateEntity(editProfile);
		refreshProfilesList();
	}
	
	public void actionDelete() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		String id = params.get("deleteProfileId");
		try {
			profilesDao.deleteEntity(Integer.parseInt(id));
			refreshProfilesList();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
