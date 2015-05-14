package org.corporateforce.server.controller;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.corporateforce.server.helper.Constants;
import org.corporateforce.server.session.UsersBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class HeaderController extends AbstractController implements Serializable {
	private static final long serialVersionUID = 1L;

	// session beans

	@Autowired
	private UsersBean usersBean;

	public void setUsersBean(UsersBean usersBean) {
		this.usersBean = usersBean;
	}

	// controller methods

	public String getUserName() {
		return this.usersBean.getCurrentUserFullName();
	}

	public void signOut() {
		this.usersBean.signOut();
		doRedirect();
	}

	private void doRedirect() {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect(context.getRequestContextPath() + "/");
		} catch (Exception e) {
			System.out.println("DEBUG: UsersBean error: " + e.getMessage());
		}
	}
}
