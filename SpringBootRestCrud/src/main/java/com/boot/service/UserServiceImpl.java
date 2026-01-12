package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.User;
import com.boot.exception.UserNotFoundException;
import com.boot.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public Integer createUser(User user) {
		
		 user = repo.save(user);
		
		return user.getUserId();
	}

	@Override
	public String updateUser(User user) {
		/*
		 * if(user.getUserId()==null){ throw new
		 * UserNotFoundException(String.format("User Not found %d",user.getUserId())); }
		 * user = repo.save(user);
		 */
		
		User user1 = getUserById(user.getUserId());
		
//		User newUser = user1.builder().userName(user.getUserName()).userEmail(user.getUserEmail())
//		    .userPhno(user.getUserPhno()).build();
		
		
		  user1.setUserName(user.getUserName());
		  user1.setUserEmail(user.getUserEmail());
		  user1.setUserPhno(user.getUserPhno());
		 
		
		/*
		 * user1.setUserName(user.getUserName()); user1.setUserPhno(user.getUserPhno());
		 */
		
		
		//User save = repo.save(newUser);
		
		User user2 = repo.save(user1);
		
		return String.format("User Id : %d updated Successfully...",user2.getUserId());
	}

	@Override
	public User getUserById(Integer id) {
           User user = repo.findById(id).orElseThrow(()->
        	   new UserNotFoundException(" User Not Found With Id : "+id));
		return user;
	}

	@Override
	public List<User> getAllUser() {
	
		return repo.findAll();
	}

	@Override
	public String deleteUserById(Integer id) {
		 User user = getUserById(id);
		 
		 repo.delete(user);
		 
		return String.format(" User Id Deleted : %d ",user.getUserId());
	}

}
