package org.corporateforce.server.session;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
	
	@Autowired
	private UsersBean usersBean;

	public void setUsersBean(UsersBean usersBean) {
		this.usersBean = usersBean;
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
		Map<String, Integer> result = new TreeMap<String, Integer>();
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
	
	public Boolean actionDelete() {
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
		try {
			Integer id = Integer.parseInt(params.get("deleteProfileId"));
			if (id==usersBean.getCurrentUser().getProfiles().getId()) return false;
			profilesDao.deleteEntity(id);
			refreshProfilesList();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
}
