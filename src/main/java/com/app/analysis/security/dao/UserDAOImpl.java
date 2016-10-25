package com.app.analysis.security.dao;

import org.springframework.stereotype.Repository;

import com.app.analysis.security.model.UserProfile;

@Repository
public class UserDAOImpl implements UserDAO{

	@Override
	public UserProfile findUserByName(String username) {
		UserProfile userProfile = new UserProfile("ali", "1234", "ROLE_USER", true);
		return userProfile;
	}
	
}
