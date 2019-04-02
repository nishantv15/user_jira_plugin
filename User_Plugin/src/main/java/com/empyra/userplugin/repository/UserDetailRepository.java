package com.empyra.userplugin.repository;

import java.util.List;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.sal.api.transaction.TransactionCallback;
import com.empyra.userplugin.ao.CreateUser;
import com.empyra.userplugin.dto.CreateUserDTO;
import com.empyra.userplugin.exception.EmpyraWSException;
import com.google.common.collect.Lists;

public class UserDetailRepository {

	private ActiveObjects activeObjects;

	public UserDetailRepository() {

	}

	public UserDetailRepository(ActiveObjects activeObjects) {
		this.activeObjects = activeObjects;
	}

	public CreateUser saveUserDetails(final CreateUserDTO createUserDTO) throws EmpyraWSException {
		System.out.println("-----------------------------------------" + createUserDTO.getPassword());
		try {
			return activeObjects.executeInTransaction(new TransactionCallback<CreateUser>() {

				@Override
				public CreateUser doInTransaction() {
					CreateUser createUser = activeObjects.create(CreateUser.class);
					createUser.setEmail(createUserDTO.getEmail());
					createUser.setFullName(createUserDTO.getFullName());
					createUser.setUserName(createUserDTO.getUserName());
					createUser.setPassword(createUserDTO.getPassword());
					createUser.save();
					return createUser;
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new EmpyraWSException("E501", "Exception occurred while saving ProjectDetails entity in DB.", ex);
		}
	}

	public List<CreateUser> getUserDetails() throws EmpyraWSException {
		try {
			return activeObjects.executeInTransaction(new TransactionCallback<List<CreateUser>>() {

				@Override
				public List<CreateUser> doInTransaction() {
					return Lists.newArrayList(activeObjects.find(CreateUser.class));
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new EmpyraWSException("E501", "Exception occurred while fetching System Field entity from DB.", ex);
		}
	}

}
