package org.corporateforce.server.controller;

import java.io.Serializable;
import java.util.List;

import org.corporateforce.server.model.Users;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class UsersController extends PaginationController implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Users> usersList = null;

	public List<Users> getUsersList() {
		if (usersList == null) refreshController();
		return usersList;
	}

	public void refreshController() {
		try {
			usersList = this.usersBean.getUsersList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	private class UsersWrapper {
		
	}
}
