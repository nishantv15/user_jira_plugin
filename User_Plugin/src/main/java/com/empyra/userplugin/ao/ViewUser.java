package com.empyra.userplugin.ao;

import net.java.ao.Entity;
import net.java.ao.Preload;

@Preload
public interface ViewUser extends Entity {

	String getEmail();

	void setEmail(String email);

	String getFullName();

	void setFullName(String fullName);

	String getUserName();

	void setUserName(String userName);

}
