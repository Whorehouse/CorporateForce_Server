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
public class InitController implements Serializable {
	private static final long serialVersionUID = 1L;

	// session beans

	@Autowired
	private UsersBean usersBean;

	public void setUsersBean(UsersBean usersBean) {
		this.usersBean = usersBean;
	}

	// controller methods
	
}
