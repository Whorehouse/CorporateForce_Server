package org.corporateforce.server.rest;

import java.io.File;
import java.io.IOException;

import org.corporateforce.server.dao.ResourcesDao;
import org.corporateforce.server.helper.FileGetter;
import org.corporateforce.server.helper.FileUploader;
import org.corporateforce.server.model.Resources;
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
@RequestMapping("Resources")
public class ResourcesRest extends AbstractRest<Resources, ResourcesDao> {
	
	@Autowired
	FileUploader fileUploader;
	
	@Autowired
	FileGetter fileGetter;
	
	public void setFileUploader(FileUploader fileUploader) {
		this.fileUploader = fileUploader;
	}

	public void setFileGetter(FileGetter fileGetter) {
		this.fileGetter = fileGetter;
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody Resources uploadFile(
			@RequestParam MultipartFile file,
			@RequestParam("users") String jsonUsers)
			throws Exception {
		Resources res = null;
		Users users = jsonToModel(jsonUsers, Users.class);
		File savedFile = fileUploader.saveFileForUser(users, file);		
		Resources resource = new Resources();
		resource.setUsers(users);
		resource.setFilename(savedFile.getName());
		resource.setName(file.getOriginalFilename());
		resource.setFiletype(fileGetter.getExtension(file.getOriginalFilename()));
		res = daoService.addEntity(resource);
		return res;
	}

	@RequestMapping("/showFile/{id}/{filename:.+}")
	public ResponseEntity<byte[]> showImage(@PathVariable int id,
			@PathVariable String filename) throws IOException {
		return fileGetter.responseFileForUser(id, filename);
	}

	@RequestMapping("/showResource/{id}")
	public ResponseEntity<byte[]> showResource(@PathVariable int id) throws Exception {
		return fileGetter.responseFileForResource(daoService.getEntityById(id));
	}
}
