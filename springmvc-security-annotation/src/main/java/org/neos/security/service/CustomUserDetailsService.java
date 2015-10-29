package org.neos.security.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.neos.security.dao.UserDao;
import org.neos.security.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserDao userDao;

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@username: "+username);
		
		org.neos.security.model.User user = userDao.findUserByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(userDao.findRoleByUserName(username));
		
		return buildUserForAuthentication(user, authorities);
	}
	
	private User buildUserForAuthentication(org.neos.security.model.User user, 
			List<GrantedAuthority> authorities) {
			return new User(user.getUsername(), 
				user.getPassword(), user.isEnabled(), 
	                        true, true, true, authorities);
		}

	
	private List<GrantedAuthority> buildUserAuthority(List<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

		return result;
	}

	
}
