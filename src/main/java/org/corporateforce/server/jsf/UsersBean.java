package org.corporateforce.server.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.corporateforce.server.dao.UsersDaoImpl;
import org.corporateforce.server.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class UsersBean {
	
	@Autowired	
	private UsersDaoImpl usersDao;	
	
	private Users currentUser;
	private String username;
	private String password;

	public void setUsersDao(UsersDaoImpl usersDao) {
		this.usersDao = usersDao;
	}
	
	public Users getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Users currentUser) {
		this.currentUser = currentUser;
	}

	public String getUsername() {
		System.out.println("DEBUG: username: " + username);
		return username;
	}

	public void setUsername(String value) {
		this.username = value;
	}

	public String getPassword() {
		System.out.println("DEBUG: password: " + password);
		return password;
	}

	public void setPassword(String value) {
		this.password = value;
	}
	
	public void signIn() throws Exception {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        if (username != null && password != null) {
            try {
                Users result = usersDao.loginUsers(username, password);
                System.err.println("DEBUG: UsersBean User: " + result);
                if (result != null) {
                    currentUser=result;
                    password = "";
                    context.redirect(context.getRequestContextPath() + "/view/console.jsf");
                } else {
                    currentUser=null;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", "Incorrect username or password"));
                }
            } catch (Exception ex) {
                System.err.println("DEBUG: UsersBean error: " + ex.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR", ex.getMessage()));
            }
        }
    }
}
