package com.jescy.spotter.security.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDaoImpl implements UserDao, UserDetailsService {

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		List<String> roles = new ArrayList<String>();
		String role = null;
		String password = null;
		if ("superadmin".equals(username)) {
			role = "ROLE_SUPER";
			password = "admin";
		} else if ("admin".equals(username)) {
			role = "ROLE_ADMIN";
			password = "admin";
		} else {
			role = "ROLE_USER";
			password = "123";
		}
		roles.add(role);
		UserDetails user = new User(username, password, true, true, true, true,
				getGrantedAuthorities(roles));
		return user;
	}

	public static List<GrantedAuthority> getGrantedAuthorities(
			List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

}
