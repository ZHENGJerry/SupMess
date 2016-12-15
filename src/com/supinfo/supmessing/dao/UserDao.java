package com.supinfo.supmessing.dao;

import com.supinfo.supmessing.entity.User;

public interface UserDao {

	void addUser(User user);
	User findUser(Class clas,String username);
	void updateUser(User user);
	Long getUserNum();
}
