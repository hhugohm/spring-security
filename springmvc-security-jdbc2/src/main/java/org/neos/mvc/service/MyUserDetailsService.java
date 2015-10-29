package org.neos.mvc.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.neos.mv.domain.UserRole;
import org.neos.mvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@username: "+username);
		
		org.neos.mv.domain.User user = userDao.findUserByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(userDao.findRoleByUserName(username));
		
		return buildUserForAuthentication(user, authorities);
	}
	
	private User buildUserForAuthentication(org.neos.mv.domain.User user, 
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
