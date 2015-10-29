package org.neos.security.dao;

import java.util.List;

import org.neos.security.model.User;
import org.neos.security.model.UserRole;



public interface UserDao {
	
	public User findUserByUserName(String username);
	public List<UserRole> findRoleByUserName(String username);

}
