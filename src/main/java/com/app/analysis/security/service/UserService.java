package com.app.analysis.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.analysis.security.dao.UserDAO;
import com.app.analysis.security.model.UserProfile;

@Service("userService")
public class UserService implements UserDetailsService{

	@Autowired UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserProfile userProfile = userDao.findUserByName(username);
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		GrantedAuthority userAuthUSER = new SimpleGrantedAuthority("ROLE_USER");
		GrantedAuthority userAuthADMIN = new SimpleGrantedAuthority("ROLE_ADMIN");
		authorities.add(userAuthUSER);
		authorities.add(userAuthADMIN);
		
		User user = new User(userProfile.getUsername(), userProfile.getPassword(), userProfile.getEnabled(), true, true, true, authorities);
		
		return user;
	}

}
