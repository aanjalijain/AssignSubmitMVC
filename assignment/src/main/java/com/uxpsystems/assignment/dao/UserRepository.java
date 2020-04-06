package com.uxpsystems.assignment.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.uxpsystems.assignment.model.UserDetail;


@Repository
@Transactional
public class UserRepository{

	    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
	
	    @Autowired
	    SessionFactory sessionFactory; 
	    
	    @Autowired
	    HibernateTemplate hibernateTemplate;
	    
	    //Get ALL User Details
        @SuppressWarnings("unchecked")
		public List<UserDetail> getAllUsers() {
        	
        	String hql = "FROM UserDetail";
    		return (List<UserDetail>) hibernateTemplate.find(hql);
        
	}
       
        //Get user by ID
        public UserDetail getUserById(long userId) {
        
        	return hibernateTemplate.get(UserDetail.class, userId);
       
    	}
        
        public void insertUser(UserDetail user) {
        	hibernateTemplate.save(user);
        	System.out.println("user saved");
    		
        }
        
        public void updateUserDetails(long userId,UserDetail user) {
        	UserDetail user2 = getUserById(userId);
        	user2.setUserName(user.getUserName());
        	user2.setUserPassword(user.getUserPassword());
        	user2.setUserStatus(user.getUserStatus());
    		
        	hibernateTemplate.update(user2);
    	}
        
        public void deleteUserDetails(long userId) {
        	
    		UserDetail u = getUserById(userId);
    		if(null !=u){
    			hibernateTemplate.delete(u);
    		}
    		logger.info("User deleted successfully");
    	}
    	
}
