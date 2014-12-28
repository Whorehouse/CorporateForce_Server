/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import org.corporateforce.server.model.Users;

/**
 *
 * @author Chep
 */
@Local
public interface UsersFacadeLocal {
    Users createUsers(Users entity);
    void editUsers(Users entity);
    void deleteUsers(Users entity);
    Users getUsers(int id);
    List<Users> listUsers();
    int countUsers();
    
     public Users loginUsers(String username, String password);
     public Users createSimpleUsers(int profile, int office, int role, int manager, String username, String password);
     public Users createWithContactsUsers(int profile, int office, int role,
            int manager, String username, String password, String firstname,
            String lastname, int gender, Date date);
     public void changePasswordUsers(Integer id, String password);
     public void changePasswordSecureUsers(Integer id, String oldpassword,
            String newpassword);
     public List<Users> listByUsernameUsers();
     public void changeManagerUsers(int id, int manager);
     public void changeOfficeUsers(int id, int office);
     public void changeProfileUsers(int id, int profile);
     public void changeRoleUsers(int id, int role);
}
