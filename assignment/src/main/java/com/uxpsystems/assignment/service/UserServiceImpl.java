package com.uxpsystems.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.uxpsystems.assignment.dao.UserRepository;
import com.uxpsystems.assignment.model.UserDetail;


@Service
public class UserServiceImpl{

	 @Autowired(required=true)
	 UserRepository repository;
	
	 
	public List<UserDetail> findAllUsers() {
		// TODO Auto-generated method stub
		
		List<UserDetail> users=repository.getAllUsers();
	    return users;
		}
		
	public UserDetail getUserById(long userId) {
		// TODO Auto-generated method stub
		UserDetail user=repository.getUserById(userId);
		 System.out.println("User Service"+user);
		System.out.println("id here Service"+user.getUserId());
		return user;
		
	}
	public void insertUser(UserDetail user) {
		// TODO Auto-generated method stub
		repository.insertUser(user);
		
	}
	
	public void updateUserDetails(long userId,UserDetail user) {
	//	user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
		repository.updateUserDetails(userId,user);
		
		// TODO Auto-generated method stub
		
	}
	public void deleteUserDetails(long userId) {
		repository.deleteUserDetails(userId);
		// TODO Auto-generated method stub
		
	}


	
	
	

}
