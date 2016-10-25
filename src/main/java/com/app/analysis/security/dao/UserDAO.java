package com.app.analysis.security.dao;

import com.app.analysis.security.model.UserProfile;

public interface UserDAO {
	UserProfile findUserByName(String username);
}
