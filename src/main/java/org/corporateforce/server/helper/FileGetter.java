package org.corporateforce.server.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.corporateforce.server.config.Config;
import org.corporateforce.server.model.Avatars;
import org.corporateforce.server.model.Resources;
import org.corporateforce.server.model.Users;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class FileGetter {
	
	public static ResponseEntity<byte[]> responseFile(String relativePathDir, String filename) throws FileNotFoundException, IOException {
		File file = new File(Config.getResourcesPath() + File.separator	+ relativePathDir + File.separator + filename);
		if (!file.exists()) {
			final HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_PNG);
			return new ResponseEntity<byte[]>(IOUtils.toByteArray(FileGetter.class.getClassLoader().getResourceAsStream("/img_no_photo.png")), headers, HttpStatus.CREATED);
		}
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(getFileType(filename));
		return new ResponseEntity<byte[]>(IOUtils.toByteArray(new FileInputStream(file)), headers, HttpStatus.CREATED);
	}
	
	
	public static ResponseEntity<byte[]> responseFileForUser(String type, int u, String filename) throws FileNotFoundException, IOException {
		return responseFile(type+File.separator+u, filename);
	}
	
	public static ResponseEntity<byte[]> responseFileForUser(String type, Users u, String filename) throws FileNotFoundException, IOException {
		return responseFileForUser(type, u.getId(), filename);
	}
	
	
	public static ResponseEntity<byte[]> responseFileForUser(int u, String filename) throws FileNotFoundException, IOException {
		return responseFileForUser(getExtension(filename), u, filename);
	}
	
	public static ResponseEntity<byte[]> responseFileForUser(Users u, String filename) throws FileNotFoundException, IOException {
		return responseFileForUser(getExtension(filename), u, filename);
	}
	
	
	public static ResponseEntity<byte[]> responseFileForResource(Resources resources) throws FileNotFoundException, IOException {
		return responseFileForUser(resources.getFiletype(), resources.getUsers(), resources.getFilename());
	}
	
	public static ResponseEntity<byte[]> responseFileForAvatar(Avatars avatars) throws FileNotFoundException, IOException {
		return responseFile("avatar", avatars.getFilename());
	}

	
	public static String getExtension(String filename) {
		return FilenameUtils.getExtension(filename);
	}

	public static MediaType getFileType(String filename) {
		if (getExtension(filename).equalsIgnoreCase("jpeg")
				|| getExtension(filename).equalsIgnoreCase("jpg")) {
			return MediaType.IMAGE_JPEG;
		} else if (getExtension(filename).equalsIgnoreCase("png")) {
			return MediaType.IMAGE_PNG;
		} else {
			return MediaType.ALL;
		}
	}
}
