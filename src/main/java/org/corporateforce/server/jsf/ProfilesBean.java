package org.corporateforce.server.jsf;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public ProfilesDao getProfilesDao() {
		return profilesDao;
	}

	public void setProfilesDao(ProfilesDao profilesDao) {
		this.profilesDao = profilesDao;
	}
	
	public Map<String, Integer> getProfilesMap() throws Exception {
		List<Profiles> profiels = this.profilesDao.getEntityList();
		Map<String, Integer> result = new HashMap<String, Integer>();
		for (Profiles p : profiels) {
			result.put(p.getName(), p.getId());
		}
		return result;
	}
}
