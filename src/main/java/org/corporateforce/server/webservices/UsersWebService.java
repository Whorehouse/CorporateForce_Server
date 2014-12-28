/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.corporateforce.server.webservices;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.corporateforce.server.ejb.UsersFacadeLocal;
import org.corporateforce.server.model.Users;

/**
 *
 * @author Chep
 */
@WebService(serviceName = "UsersWebService")
public class UsersWebService {
    @EJB
    private UsersFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Web Service > Add Operation"

    @WebMethod(operationName = "createUsers")
    public Users createUsers(@WebParam(name = "entity") Users entity) {
        return ejbRef.createUsers(entity);
    }

    @WebMethod(operationName = "editUsers")
    @Oneway
    public void editUsers(@WebParam(name = "entity") Users entity) {
        ejbRef.editUsers(entity);
    }

    @WebMethod(operationName = "deleteUsers")
    @Oneway
    public void deleteUsers(@WebParam(name = "entity") Users entity) {
        ejbRef.deleteUsers(entity);
    }

    @WebMethod(operationName = "getUsers")
    public Users getUsers(@WebParam(name = "id") int id) {
        return ejbRef.getUsers(id);
    }

    @WebMethod(operationName = "listUsers")
    public List<Users> listUsers() {
        return ejbRef.listUsers();
    }

    @WebMethod(operationName = "countUsers")
    public int countUsers() {
        return ejbRef.countUsers();
    }

    @WebMethod(operationName = "loginUsers")
    public Users loginUsers(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        return ejbRef.loginUsers(username, password);
    }

    @WebMethod(operationName = "createSimpleUsers")
    public Users createSimpleUsers(@WebParam(name = "profile") int profile, @WebParam(name = "office") int office, @WebParam(name = "role") int role, @WebParam(name = "manager") int manager, @WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        return ejbRef.createSimpleUsers(profile, office, role, manager, username, password);
    }

    @WebMethod(operationName = "createWithContactsUsers")
    public Users createWithContactsUsers(@WebParam(name = "profile") int profile, @WebParam(name = "office") int office, @WebParam(name = "role") int role, @WebParam(name = "manager") int manager, @WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "firstname") String firstname, @WebParam(name = "lastname") String lastname, @WebParam(name = "gender") int gender, @WebParam(name = "date") Date date) {
        return ejbRef.createWithContactsUsers(profile, office, role, manager, username, password, firstname, lastname, gender, date);
    }

    @WebMethod(operationName = "changePasswordUsers")
    @Oneway
    public void changePasswordUsers(@WebParam(name = "id") Integer id, @WebParam(name = "password") String password) {
        ejbRef.changePasswordUsers(id, password);
    }

    @WebMethod(operationName = "changePasswordSecureUsers")
    @Oneway
    public void changePasswordSecureUsers(@WebParam(name = "id") Integer id, @WebParam(name = "oldpassword") String oldpassword, @WebParam(name = "newpassword") String newpassword) {
        ejbRef.changePasswordSecureUsers(id, oldpassword, newpassword);
    }

    @WebMethod(operationName = "listByUsernameUsers")
    public List<Users> listByUsernameUsers() {
        return ejbRef.listByUsernameUsers();
    }

    @WebMethod(operationName = "changeManagerUsers")
    @Oneway
    public void changeManagerUsers(@WebParam(name = "id") int id, @WebParam(name = "manager") int manager) {
        ejbRef.changeManagerUsers(id, manager);
    }

    @WebMethod(operationName = "changeOfficeUsers")
    @Oneway
    public void changeOfficeUsers(@WebParam(name = "id") int id, @WebParam(name = "office") int office) {
        ejbRef.changeOfficeUsers(id, office);
    }

    @WebMethod(operationName = "changeProfileUsers")
    @Oneway
    public void changeProfileUsers(@WebParam(name = "id") int id, @WebParam(name = "profile") int profile) {
        ejbRef.changeProfileUsers(id, profile);
    }

    @WebMethod(operationName = "changeRoleUsers")
    @Oneway
    public void changeRoleUsers(@WebParam(name = "id") int id, @WebParam(name = "role") int role) {
        ejbRef.changeRoleUsers(id, role);
    }
    
}
