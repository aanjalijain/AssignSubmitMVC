package com.uxpsystems.assignment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uxpsystems.assignment.model.UserDetail;
import com.uxpsystems.assignment.model.UserDto;
import com.uxpsystems.assignment.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired(required=true)
	UserServiceImpl userService;
	
	   @RequestMapping("/")
	   public ModelAndView firstPage() {
		return new ModelAndView("index");
	    }
	   
	   @RequestMapping(value = "/user/", method = RequestMethod.GET)
	   @ResponseBody
	   public  String listAllUsers() throws JsonProcessingException {
	    List<UserDetail> users = userService.findAllUsers();
	    
	    ObjectMapper objectMapper = new ObjectMapper();
	    String json = objectMapper.writeValueAsString(users);
	    return json;
	   }
	   
	   @GetMapping("/user/{id}")
	   @ResponseStatus(HttpStatus.OK)
	   public  @ResponseBody String get(@PathVariable("id") long id) throws JsonProcessingException {
		   UserDetail user = userService.getUserById(id);
		   System.out.println("User Controller"+user);
		   if(user==null){
			  System.out.println("User with id " + id + " not found");
		   }
		  ObjectMapper objectMapper = new ObjectMapper();
		  String userr=objectMapper.writeValueAsString(user);
		  return userr;
		   
	   }
	   
	     /*---Add new User---*/

	 	  @RequestMapping(value = "/user/addNewUser", method = RequestMethod.POST,consumes = "application/json" )
	 	   public @ResponseBody String  addNewUser(@RequestBody UserDto user) throws JsonProcessingException {
	 		  
	 		  UserDetail userDetail = new UserDetail();
	 		  userDetail.setUserName(user.getUserName());
	 		  userDetail.setUserPassword(user.getUserPassword());
	 		 userDetail.setUserStatus(user.getUserStatus());
	 		  
	 		  
	 	      userService.insertUser(userDetail);
	 	     return "User has been added successfully.";
	 	   }
	 	   
	 	  /*---update  User---*/
	 	  
	 	  @RequestMapping(value = "/user/updateUsersbyId/{id}", method = RequestMethod.PUT,consumes = "application/json" )
	 	  @ResponseBody
		   public String update(@PathVariable("id") long id, @RequestBody UserDto user) {
			  
	 		 UserDetail userDetail = new UserDetail();
	 		 userDetail.setUserName(user.getUserName());
	 		  userDetail.setUserPassword(user.getUserPassword());
	 		 userDetail.setUserStatus(user.getUserStatus());
			  userService.updateUserDetails(id,userDetail);
			  
		      return "User has been updated successfully.";
		   }
	 	  
	 	 /*---Delete a user by userid---*/
		   @DeleteMapping("/user/deleteUsersbyId/{id}")
		   @ResponseBody
		   public String delete(@PathVariable("id") long id) {
			   userService.deleteUserDetails(id);
			   return "User has been deleted successfully.";
		     
		   }
}
