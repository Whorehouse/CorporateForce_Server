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
	private final Integer SIDEBAR_LINK_ROLES = 3;
	private final Integer SIDEBAR_LINK_OFFICES = 4;
	private final Integer SIDEBAR_LINK_SETTINGS = 5;
	private final Integer SIDEBAR_LINK_SUPPORT = 6;

	// page variables
	
	private Integer selectedSidebarLink = SIDEBAR_LINK_NOTSELECTED;

	public Integer getSelectedSidebarLink() {
		return selectedSidebarLink;
	}
	
	// controller methods

	// actived links

	public Boolean sidebarLinkNotSelected() {
		return selectedSidebarLink == SIDEBAR_LINK_NOTSELECTED;
	}

	public Boolean sidebarLinkUsers() {
		return selectedSidebarLink == SIDEBAR_LINK_USERS;
	}

	public Boolean sidebarLinkProfiles() {
		return selectedSidebarLink == SIDEBAR_LINK_PROFILES;
	}

	public Boolean sidebarLinkRoles() {
		return selectedSidebarLink == SIDEBAR_LINK_ROLES;
	}

	public Boolean sidebarLinkOffices() {
		return selectedSidebarLink == SIDEBAR_LINK_OFFICES;
	}

	public Boolean sidebarLinkSettings() {
		return selectedSidebarLink == SIDEBAR_LINK_SETTINGS;
	}

	public Boolean sidebarLinkSupport() {
		return selectedSidebarLink == SIDEBAR_LINK_SUPPORT;
	}

	// select links

	public void sidebarSelectLinkUsers() {
		this.selectedSidebarLink = SIDEBAR_LINK_USERS;
	}

	public void sidebarSelectLinkProfiles() {
		this.selectedSidebarLink = SIDEBAR_LINK_PROFILES;
	}

	public void sidebarSelectLinkRoles() {
		this.selectedSidebarLink = SIDEBAR_LINK_ROLES;
	}

	public void sidebarSelectLinkOffices() {
		this.selectedSidebarLink = SIDEBAR_LINK_OFFICES;
	}

	public void sidebarSelectLinkSettings() {
		this.selectedSidebarLink = SIDEBAR_LINK_SETTINGS;
	}

	public void sidebarSelectLinkSupport() {
		this.selectedSidebarLink = SIDEBAR_LINK_SUPPORT;
	}

}
