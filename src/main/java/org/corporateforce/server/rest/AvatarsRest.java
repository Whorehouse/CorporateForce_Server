package org.corporateforce.server.rest;

import java.io.File;

import org.corporateforce.server.dao.AvatarsDao;
import org.corporateforce.server.dao.ContactsDao;
import org.corporateforce.server.helper.FileGetter;
import org.corporateforce.server.helper.FileUploader;
import org.corporateforce.server.model.Avatars;
import org.corporateforce.server.model.Contacts;
import org.corporateforce.server.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("Avatars")
public class AvatarsRest extends AbstractRest<Avatars, AvatarsDao>  {
	
	@Autowired
	ContactsDao contactsDao;
	
	@RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST)
	public @ResponseBody Avatars uploadAvatar(
			@RequestParam MultipartFile file,
			@RequestParam("users") String jsonUsers)
			throws Exception {
		Avatars res = null;
		Users users = jsonToModel(jsonUsers, Users.class);
		File savedFile = FileUploader.saveAvatar(file);		
		Avatars avatar = new Avatars();
		avatar.setFilename(savedFile.getName());
		res = daoService.addEntity(avatar);
		Contacts contacts = users.getContacts();
		contacts.setAvatars(res);
		contactsDao.updateEntity(contacts);
		return res;
	}

	@RequestMapping("/showAvatar/{id}")
	public ResponseEntity<byte[]> showAvatar(@PathVariable int id) throws Exception {
		return FileGetter.responseFileForAvatar(daoService.getEntityById(id));
	}
}
