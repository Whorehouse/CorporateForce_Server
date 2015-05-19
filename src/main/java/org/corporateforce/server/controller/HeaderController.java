package org.corporateforce.server.controller;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.corporateforce.server.session.SettingsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class HeaderController extends AbstractController implements Serializable {
	private static final long serialVersionUID = 1L;

	// session beans

	@Autowired
	protected SettingsBean settingsBean;;

	// variables

	private String urlFaces = null;
	private String urlProjects = null;
	private String urlTrainings = null;

	public String getUrlFaces() {
		if (urlFaces == null) urlFaces = this.settingsBean.getUriFaces();
		return urlFaces;
	}

	public String getUrlProjects() {
		if (urlProjects == null) urlProjects = this.settingsBean.getUriProjects();
		return urlProjects;
	}

	public String getUrlTrainings() {
		if (urlTrainings == null) urlTrainings = this.settingsBean.getUriTrainings();
		return urlTrainings;
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
