package org.corporateforce.server.rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.corporateforce.server.config.Config;
import org.corporateforce.server.dao.ResourcesDao;
import org.corporateforce.server.model.Contacts;
import org.corporateforce.server.model.Resources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

	@RequestMapping(value = "/uploadImage", method = RequestMethod.POST)
	public @ResponseBody Resources uploadImage(@RequestParam MultipartFile file, @RequestParam Contacts contacts)
			throws IllegalStateException, IOException {
		Resources res = null;		
		String rootPath = Config.getResourcesPath()+File.separator+"images";
		File dir = new File(rootPath);
		if (!dir.exists())
			dir.mkdirs();
		File serverFile = new File(dir.getAbsolutePath()
				+ File.separator + file.getOriginalFilename());
		
		if (!file.isEmpty()) {
			try {			
				byte[] bytes = file.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println("You successfully uploaded " + serverFile.getAbsolutePath() + "!");
				Resources resource = new Resources();
				resource.setContacts(contacts);
				resource.setFilename(file.getOriginalFilename());
				resource.setName(file.getOriginalFilename());
				resource.setFiletype(getExtension(file.getOriginalFilename()));
				res = daoService.addEntity(resource);
			} catch (Exception e) {
				System.out.println("You failed to upload " + serverFile.getAbsolutePath() + " => " + e.getMessage());
			}
		} else {
			System.out.println("You failed to upload " + serverFile.getAbsolutePath() + " because the file was empty.");
		}
		return res;
	}
	
	@RequestMapping("/showImage/{image:.+}")
	public ResponseEntity<byte[]> showImage(@PathVariable String image) throws IOException {
	    File file = new File(Config.getResourcesPath()+File.separator+"images"+File.separator+image);
	    final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(getFileType(image));
	    return new ResponseEntity<byte[]>(IOUtils.toByteArray(new FileInputStream(file)), headers, HttpStatus.CREATED);
	}
	
	public static String getExtension(String filename) {
		return FilenameUtils.getExtension(filename);		
	}
	
	public MediaType getFileType(String filename) {
		if (getExtension(filename).equalsIgnoreCase("jpeg") || getExtension(filename).equalsIgnoreCase("jpg")) {
			return MediaType.IMAGE_JPEG;
		} else if (getExtension(filename).equalsIgnoreCase("png")) {
			return MediaType.IMAGE_PNG;
		} else {
			return MediaType.ALL;
		}
	}
}
