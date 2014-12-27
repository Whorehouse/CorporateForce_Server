package org.corporateforce.server.webservices;

import org.corporateforce.server.dao.UsersBeanLocal;
import org.corporateforce.server.model.Users;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService(serviceName = "UserssService")
public class UsersService {
    @EJB
    private UsersBeanLocal ejbRef;
    
    @WebMethod(operationName = "createUsersFromEntity")
    public Users createUsersFromEntity(@WebParam(name = "u") Users u) {
        return ejbRef.create(u);
    }

    @WebMethod(operationName = "editUsersFromEntity")
    @Oneway
    public void editUsersFromEntity(@WebParam(name = "u") Users u) {
        ejbRef.edit(u);
    }

    @WebMethod(operationName = "deleteUsersFromEntity")
    @Oneway
    public void deleteUsersFromEntity(@WebParam(name = "u") Users u) {
        ejbRef.delete(u);
    }

    @WebMethod(operationName = "getUsers")
    public Users getUsers(@WebParam(name = "id") int id) {
        return ejbRef.get(id);
    }

    @WebMethod(operationName = "listUsers")
    public List<Users> listUsers() {
        return ejbRef.list();
    }

    @WebMethod(operationName = "countUsers")
    public int countUsers() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "loginUsers")
    public Users loginUsers(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        return ejbRef.loginUsers(username, password);
    }

    @WebMethod(operationName = "createUsers")
    public Users createUsers(
    		@WebParam(name = "profile") int profile, 
    		@WebParam(name = "office") int office, 
    		@WebParam(name = "role") int role, 
    		@WebParam(name = "manager") int manager,
    		@WebParam(name = "username") String username,
    		@WebParam(name = "password") String password
    ) {
        return ejbRef.createUsers(profile, office, role, manager, username, password);
    }

    @WebMethod(operationName = "createWithContactsUsers")
    public Users createWithContactsUsers(
    		@WebParam(name = "profile") int profile, 
    		@WebParam(name = "office") int office, 
    		@WebParam(name = "role") int role, 
    		@WebParam(name = "manager") int manager, 
    		@WebParam(name = "username") String username,
    		@WebParam(name = "password") String password, 
    		@WebParam(name = "firstname") String firstname, 
    		@WebParam(name = "lastname") String lastname, 
    		@WebParam(name = "gender") int gender, 
    		@WebParam(name = "date") Date date
    ){
    	return ejbRef.createWithContactsUsers(profile, office, role, manager, username, password, firstname, lastname, gender, date);
    }
    
    @WebMethod(operationName = "changePasswordUsers")
	public void changePasswordUsers(@WebParam(name = "id") Integer id, @WebParam(name = "password") String password){
    	ejbRef.changePasswordUsers(id, password);
    }
    
    @WebMethod(operationName = "changePasswordSecureUsers")
	public void changePasswordSecureUsers(@WebParam(name = "id") Integer id, @WebParam(name = "oldpassword") String oldpassword, @WebParam(name = "newpassword") String newpassword){
    	ejbRef.changePasswordSecureUsers(id, oldpassword, newpassword);
    }
    
    @WebMethod(operationName = "listByUsernameUsers")
	public List<Users> listByUsernameUsers(){
    	return ejbRef.listByUsernameUsers();
    }
    
    @WebMethod(operationName = "changeManagerUsers")
	public void changeManagerUsers(@WebParam(name = "id") int id, @WebParam(name = "manager") int manager){
    	ejbRef.changeManagerUsers(id, manager);
    }
    
    @WebMethod(operationName = "changeOfficeUsers")
	public void changeOfficeUsers(@WebParam(name = "id") int id, @WebParam(name = "office") int office){
    	ejbRef.changeOfficeUsers(id, office);
    }
    
    @WebMethod(operationName = "changeProfileUsers")
	public void changeProfileUsers(@WebParam(name = "id") int id, @WebParam(name = "profile") int profile){
    	ejbRef.changeProfileUsers(id, profile);
    }
    
    @WebMethod(operationName = "changeRoleUsers")
	public void changeRoleUsers(@WebParam(name = "id") int id, @WebParam(name = "role") int role){
    	ejbRef.changeRoleUsers(id, role);
    }
}
