package org.corporateforce.server.session;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.corporateforce.server.dao.ProfilesDao;
import org.corporateforce.server.model.Profiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class ProfilesBean implements Serializable {

	private static final long serialVersionUID = 1L;

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

	public boolean refreshProfilesList() throws Exception {
		profilesList = profilesDao.getEntityList();
		return true;
	}
	
	public Map<String, Integer> getProfilesMap() throws Exception {
		List<Profiles> profiels = this.profilesDao.getEntityList();
		Map<String, Integer> result = new TreeMap<String, Integer>();
		for (Profiles p : profiels) {
			result.put(p.getName(), p.getId());
		}
		return result;
	}
	
	public boolean create(Profiles p) {
		try {
			if (p.getName()==null || p.getName().equals("")) return false;
			Profiles result = profilesDao.addEntity(p);
			return (result != null && result.getId()!=null && refreshProfilesList());
		} catch(Exception e) {
			System.out.println("DEBUG: ProfilesBean error: " + e.getMessage());
			return false;
		}
	}

	public boolean update(Profiles p) {
		try {
			return (profilesDao.updateEntity(p)!=null && refreshProfilesList());
		} catch(Exception e) {
			System.out.println("DEBUG: ProfilesBean error: " + e.getMessage());
			return false;
		}
	}
	
	public Boolean update() {
		return (editProfile!=null && update(editProfile));
	}
	
	public Boolean remove(Profiles p) {
		try {
			if (p.getId()==usersBean.getCurrentUser().getProfiles().getId()) return false;
			profilesDao.deleteEntity(p.getId());
			refreshProfilesList();
			return true;
		} catch(Exception e) {
			System.out.println("DEBUG: ProfilesBean error: " + e.getMessage());
			return false;
		}
	}
}
