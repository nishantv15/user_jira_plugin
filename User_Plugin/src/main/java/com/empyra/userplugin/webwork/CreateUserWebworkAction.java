package com.empyra.userplugin.webwork;

import java.util.List;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.jira.web.action.JiraWebActionSupport;
import com.empyra.userplugin.ao.CreateUser;
import com.empyra.userplugin.dto.CreateUserDTO;
import com.empyra.userplugin.repository.UserDetailRepository;

public class CreateUserWebworkAction extends JiraWebActionSupport {
	/**
	 * 
	 */
	/*
	 * public String doSave() throws Exception { System.out.println(
	 * "------CreateUserWebworkAction-----------------------------"); return
	 * "create-user"; }
	 */
	private ActiveObjects activeObjects;
	private List<CreateUser> createUser;

	public List<CreateUser> getCreateUser() {
		return createUser;
	}

	public void setCreateUser(List<CreateUser> createUser) {
		this.createUser = createUser;
	}

	public CreateUserWebworkAction(ActiveObjects activeObjects) {
		this.activeObjects = activeObjects;
	}

	public String doDefault() throws Exception {
		System.out.println("------Default----------------------------");
		String email = getHttpRequest().getParameter("email");
		String fullName = getHttpRequest().getParameter("fullName");
		String userName = getHttpRequest().getParameter("userName");
		String password = getHttpRequest().getParameter("password");

		System.out.println("------------------------------------------------------");
		System.out.println("email   : " + email);
		System.out.println("fullName: " + fullName);
		System.out.println("userName: " + userName);
		System.out.println("password: " + password);
		System.out.println("---------------------------------------------------------");

		CreateUserDTO createUserDTO = new CreateUserDTO();
		createUserDTO.setEmail(email);
		createUserDTO.setFullName(fullName);
		createUserDTO.setUserName(userName);
		createUserDTO.setPassword(password);
		System.out.println("password Get: " + createUserDTO.getPassword());
		UserDetailRepository userDetailRepository = new UserDetailRepository(activeObjects);

		try {
			if (!createUserDTO.equals(null)) {
				userDetailRepository.saveUserDetails(createUserDTO);
			} else {
				System.out.println("----------------------null----------------------------");
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		List<CreateUser> createUser = userDetailRepository.getUserDetails();

		this.createUser = createUser;
		return "create-user";
	}

}
