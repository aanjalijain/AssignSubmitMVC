package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.model.UserDetail;
import com.uxpsystems.assignment.test.config.TestBeanConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


import static org.junit.Assert.*;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
public class UserControllerTest {
	
	@Autowired
	private UserController userController;

	@Test
	public void listAllUsers_Test() throws JsonProcessingException {

		String result =  userController.listAllUsers();
		assertNotNull(result);
		assertTrue(result.length() > 0);
	}

	@Test
	public void deleteUser_Test() {

		String result =  userController.delete(2);
		assertNotNull(result);
		assertTrue(result.length() > 0);
	}
	
	@Test
	public void getUser_Test() throws JsonProcessingException {

		String result =  userController.get(1);
		assertNotNull(result);
		assertTrue(result.length() > 0);
	}
	
	@Test
	public void updateUser_Test() throws JsonProcessingException {
		UserDetail user=new UserDetail();
		user.setUserName("John");
		user.setUserPassword("Test@1234");
		user.setUserStatus("Deactive");
		String result =  userController.listAllUsers();
		assertNotNull(result);
		assertTrue(result.length() > 0);
	}
	
	@Test
	public void addNewUser_Test() throws JsonProcessingException {
		UserDetail user=new UserDetail();
		user.setUserName("John");
		user.setUserPassword("Test@1234");
		user.setUserStatus("Deactive");
		String result =  userController.listAllUsers();
		assertNotNull(result);
		assertTrue(result.length() > 0);
	/*	ResponseEntity result =  userController.addNewUser(user);
		assertNotNull(result);
		assertEquals(result.length());*/
	}
	
	
}