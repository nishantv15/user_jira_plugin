package com.empyra.userplugin.webwork;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.jira.web.action.JiraWebActionSupport;
import com.empyra.userplugin.ao.CreateUser;
import com.empyra.userplugin.repository.UserDetailRepository;

public class ViewUserWebworkAction extends JiraWebActionSupport {

	private static final long serialVersionUID = 1L;
	private List<CreateUser> createUser;
	private ActiveObjects activeObjects;

	public ViewUserWebworkAction(ActiveObjects activeObjects) {
		this.activeObjects = activeObjects;
	}

	public List<CreateUser> getCreateUser() {
		return createUser;
	}

	public void setCreateUser(List<CreateUser> createUser) {
		this.createUser = createUser;
	}

	@Override
	public String execute() throws Exception {

		/*
		 * System.out.println("------Menu action-----------------------------");
		 * System.out.println("------Default----------------------------"); String email
		 * = getHttpRequest().getParameter("email"); String fullName =
		 * getHttpRequest().getParameter("fullName"); String userName =
		 * getHttpRequest().getParameter("userName");
		 * 
		 * System.out.println("------------------------------------------------------");
		 * System.out.println("email   : " + email); System.out.println("fullName: " +
		 * fullName); System.out.println("userName: " + userName); System.out.println(
		 * "---------------------------------------------------------");
		 * 
		 */
		UserDetailRepository userDetailRepository = new UserDetailRepository(activeObjects);
		try {

		} catch (Exception e) {

		}
		List<CreateUser> createUser = userDetailRepository.getUserDetails();
		this.createUser = createUser;
		return "view-user";
	}
}
