package org.corporateforce.server.helper;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.io.FilenameUtils;
import org.corporateforce.server.model.Users;
import org.corporateforce.server.session.SettingsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploader implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SettingsBean settingsBean;
	
	public void setSettingsBean(SettingsBean settingsBean) {
		this.settingsBean = settingsBean;
	}

	public File prepareDir(String relativePath) {
		File dir = new File(settingsBean.getResourcesPath()+File.separator+relativePath);
		if (!dir.exists())
			dir.mkdirs();
		return dir;
	}
	
	public File prepareFile(String relativePathDir, String filename) {
		File dir = prepareDir(relativePathDir);
		File serverFile = new File(dir.getAbsolutePath()+File.separator+filename);
		int sch = 1;
		while (serverFile.exists()) {
			String newFileName = getBase(filename)+sch+"."+getExtension(filename);
			serverFile = new File(dir.getAbsolutePath()+File.separator+newFileName);
			sch++;
		}
		return serverFile;
	}
	
	public File saveFile(String relativePathDir, MultipartFile file) throws IOException {
		File serverFile = prepareFile(relativePathDir, file.getOriginalFilename());
		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
		stream.write(bytes);
		stream.close();
		return serverFile;
	}
	
	public File saveFileForUser(String type, int u, MultipartFile file) throws IOException {
		return saveFile(type+File.separator+u, file);
	}
	
	public File saveFileForUser(String type, Users u, MultipartFile file) throws IOException {
		return saveFile(type+File.separator+u.getId(), file);
	}
		
	public File saveFileForUser(int u, MultipartFile file) throws IOException {
		return saveFile(getExtension(file.getOriginalFilename())+File.separator+u, file);
	}
	
	public File saveFileForUser(Users u, MultipartFile file) throws IOException {
		return saveFile(getExtension(file.getOriginalFilename())+File.separator+u.getId(), file);
	}
	
	public File saveAvatar(MultipartFile file) throws IOException {
		return saveFile("avatar", file);
	}
	
	
	public boolean isImage(String filename) {
		return (getExtension(filename).equalsIgnoreCase("jpeg")	|| getExtension(filename).equalsIgnoreCase("jpg")|| getExtension(filename).equalsIgnoreCase("png")) ? true : false;
	}

	public String getExtension(String filename) {
		return FilenameUtils.getExtension(filename);
	}

	public String getBase(String filename) {
		return FilenameUtils.getBaseName(filename);
	}
}
