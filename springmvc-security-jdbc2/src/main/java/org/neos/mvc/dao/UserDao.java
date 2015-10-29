package org.neos.mvc.dao;

import java.util.List;

import org.neos.mv.domain.User;
import org.neos.mv.domain.UserRole;

public interface UserDao {
	
	public User findUserByUserName(String username);
	public List<UserRole> findRoleByUserName(String username);

}
