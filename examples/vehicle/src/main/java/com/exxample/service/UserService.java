package com.exxample.service;

import java.util.Optional;

import com.example.doa.UserDoa;
import com.example.doa.UserOracle;
import com.example.models.User;

public class UserService {
	private static UserService service;
	private static UserDoa dao = UserOracle.getDao();
	
	private UserService() {
		
	}
	
	public static UserService getService() {
		if(service == null) {
			service = new UserService();
		}
		
		return service;
	}
	
	/**
	 * Returns the user object that has logged in
	 * 
	 * Exception will be thrown for incorrect login information
	 * Empty Optional is for the connection or other back end error
	 * 
	 * @return
	 * @throws Exception
	 */
	public Optional<User> login(String username, String password) throws Exception {
		return dao.login(username, password);
	}
	
	public Optional<User> addUser(String username, String password, Boolean isAdmin) {
		return dao.addUser(username, password, isAdmin);
	}
	
	
}
