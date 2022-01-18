package com.revature.repository;

import com.revature.model.UserLogin;

public interface UserRepository {

	void save(UserLogin user);
	UserLogin userLogin(UserLogin user);
}
