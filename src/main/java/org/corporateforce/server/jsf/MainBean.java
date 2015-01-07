package org.corporateforce.server.jsf;

import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Scope("session")
public class MainBean implements Serializable {

	private static final String PAGE_LOGIN = "/view/login.jsf";
	private static final String PAGE_INFO = "/view/info.jsf";
	private static final String PAGE_CONSOLE = "/view/console.jsf";
	private static final String PAGE_LOGOUT = "/view/logout.jsf";
	private static final String PAGE_INDEX = "/index.jsf";

	private void redirect(String page) throws Exception {
		ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		context.redirect(context.getRequestContextPath() + page);
	}

	public void actionLogin() throws Exception {
		UsersBean.setSignUpMode(false);
		this.redirect(PAGE_LOGIN);
	}

	public void actionSignUp() throws Exception {
		UsersBean.setSignUpMode(true);
		this.redirect(PAGE_LOGIN);
	}

	public void actionMainPage() throws Exception {
		this.redirect(PAGE_INDEX);
	}

	public void actionInfo() throws Exception {
		this.redirect(PAGE_INFO);
	}

	public void actionConsole() throws Exception {
		this.redirect(PAGE_CONSOLE);
	}

	public void actionLogout() throws Exception {
		this.redirect(PAGE_LOGOUT);
	}
}
