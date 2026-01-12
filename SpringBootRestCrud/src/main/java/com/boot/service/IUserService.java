package com.boot.service;

import java.util.List;

import com.boot.entity.User;

public interface IUserService {

	Integer createUser(User user );
	String updateUser(User user);
	User getUserById(Integer id);
	List<User> getAllUser();
	String deleteUserById(Integer id);
	
}
