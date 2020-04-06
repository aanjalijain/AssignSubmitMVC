package com.uxpsystems.assignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userDetail")
public class UserDetail {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String userName;
	
	private String userPassword;
	
	private String userStatus;


	public UserDetail() {
		super();
	}
	
	public UserDetail(Long userId, String userName, String userPassword, String userStatus) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userStatus = userStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	@Override
	public String toString() {
		return "UserDetail [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userStatus=" + userStatus + "]";
	}
	

	

		
}
