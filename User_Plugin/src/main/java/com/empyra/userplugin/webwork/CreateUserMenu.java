package com.empyra.userplugin.webwork;

import com.atlassian.jira.web.action.JiraWebActionSupport;

public class CreateUserMenu extends JiraWebActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		System.out.println("------Menu action-----------------------------");
		return "create-user";
	}
}

