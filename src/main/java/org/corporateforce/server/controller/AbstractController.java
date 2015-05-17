package org.corporateforce.server.controller;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.corporateforce.server.helper.Constants;
import org.corporateforce.server.helper.TextLabels;
import org.corporateforce.server.session.UsersBean;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController {

	// session beans

	@Autowired
	protected UsersBean usersBean;

	public void setUsersBean(UsersBean usersBean) {
		this.usersBean = usersBean;
	}

	// controller methods

	public String getTextLabel(String ident) {
		return TextLabels.getTextLabel(ident);
	}

	public void initController() {
		FacesContext context = FacesContext.getCurrentInstance();
		String pageName = context.getExternalContext().getRequestServletPath();
		if (this.usersBean.isUserSignedIn() && pageName.equals(Constants.PAGE_LOGIN_PATH)) doRedirect(Constants.PAGE_MAIN);
		else if (!this.usersBean.isUserSignedIn() && !pageName.equals(Constants.PAGE_LOGIN_PATH)) doRedirect("");
	}

	private void doRedirect(String redirectPath) {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		try {
			context.redirect(context.getRequestContextPath() + "/" + redirectPath);
		} catch (Exception e) {
			System.out.println("DEBUG: UsersBean error: " + e.getMessage());
		}
	}

	public Boolean isSystemControlRights() {
		return this.usersBean.isSystemControlAccess();
	}

	public Boolean isUsersManageRights() {
		return this.usersBean.isManageUsersAccess();
	}
}
