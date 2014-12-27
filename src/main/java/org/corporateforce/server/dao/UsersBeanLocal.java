package org.corporateforce.server.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import org.corporateforce.server.model.Users;

@Local
public interface UsersBeanLocal {
	public Users create(Users entity);
	public void edit(Users entity);
	public void delete(Users entity);
	public Users get(int id);
	public List<Users> list();
	public int count();
	
	public Users loginUsers(String username, String password);
	public Users createUsers(int profile, int office, int role, int manager, String username, String password);
	public Users createWithContactsUsers(int profile, int office, int role, int manager, String username, String password, String firstname, String lastname, int gender, Date date);
	public void changePasswordUsers(Integer id, String password);
	public void changePasswordSecureUsers(Integer id, String oldpassword, String newpassword);
	public List<Users> listByUsernameUsers();
	public void changeManagerUsers(int id, int manager);
	public void changeOfficeUsers(int id, int office);
	public void changeProfileUsers(int id, int profile);
	public void changeRoleUsers(int id, int role);
}
