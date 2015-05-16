package org.corporateforce.server.controller;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class MainController extends AbstractController implements Serializable {
	private static final long serialVersionUID = 1L;

	// session beans

	// constants
	
	private final Integer SIDEBAR_LINK_NOTSELECTED = 0;
	private final Integer SIDEBAR_LINK_USERS = 1;
	private final Integer SIDEBAR_LINK_PROFILES = 2;

	// page variables
	
	private Integer selectedSidebarLink = SIDEBAR_LINK_NOTSELECTED;

	public Integer getSelectedSidebarLink() {
		return selectedSidebarLink;
	}
	
	// controller methods

	public Boolean sidebarLinkNotSelected() {
		return selectedSidebarLink == SIDEBAR_LINK_NOTSELECTED;
	}

	public Boolean sidebarLinkUsers() {
		return selectedSidebarLink == SIDEBAR_LINK_USERS;
	}

	public Boolean sidebarLinkProfiles() {
		return selectedSidebarLink == SIDEBAR_LINK_PROFILES;
	}

	public void sidebarSelectLinkUsers() {
		this.selectedSidebarLink = SIDEBAR_LINK_USERS;
	}
}
