package com.jason.dao;

import java.util.List;

import com.jason.bean.UserBean;

public interface IUserDao {

	void addUser(UserBean user);
	
	void updateUser(UserBean user);
	
	void delete(UserBean user);
	
	List<UserBean> getInfo();
	
}
