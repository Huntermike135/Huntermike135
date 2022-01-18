package com.revature.UserService;

import com.revature.model.UserLogin;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryImpl;

public class UserService {

	private UserRepository userRepositoryImpl;

	public UserService() {
		this.userRepositoryImpl = new UserRepositoryImpl();
	}

	public void save(UserLogin user) {
		this.userRepositoryImpl.save(user);
	}
}

