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
	UsersDaoImpl usersDao;	
	
	private Users currentUser;
	private String login;
	private String password;

	public void setUsersDao(UsersDaoImpl usersDao) {
		System.out.println("--> UsersDao set ");
		if (usersDao!=null) {
			System.out.println("--> UsersDao not null ");
		} else {
			System.out.println("--> UsersDao null");
		}
		this.usersDao = usersDao;
	}
	
	public Users getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Users currentUser) {
		this.currentUser = currentUser;
	}

	public String getLogin() {
		System.out.println("--> Get login");
		return login;
	}

	public void setLogin(String login) {
		System.out.println("--> Set login");
		this.login = login;
	}

	public String getPassword() {
		System.out.println("--> Get password");
		return password;
	}

	public void setPassword(String password) {
		System.out.println("--> Set password");
		this.password = password;
	}
	
	public void auth() throws Exception {
        System.out.println("--> Auth begin!");
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        if (login != null && password != null) {
            try {
                Users result = usersDao.loginUsers(login, password);
                System.err.println("--> User, getting from base: " + result);
                if (result != null) {
                    currentUser=result;
                    password = "";
                    context.redirect(context.getRequestContextPath() + "/view/welcome.jsf");
                } else {
                    //setSessionValue("user", null);
                    currentUser=null;
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", "Неверный логин или пароль."));
                }
            } catch (Exception ex) {
                System.err.println("--> Auth exception: " + ex.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ошибка!", ex.getMessage()));
            }
        }
    }
}
