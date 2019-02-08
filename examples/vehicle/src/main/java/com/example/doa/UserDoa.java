package com.example.doa;

import java.util.Optional;

import com.example.models.User;

public interface UserDoa {
	Optional<User> login(String username, String password) throws Exception;
	Optional<User> addUser(String username, String password, Boolean isAdmin);
}
