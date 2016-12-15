package com.supinfo.supmessing.dao;

import java.util.List;

import com.supinfo.supmessing.entity.Friend;

public interface FriendDao {
	void addFriend(Friend r);
	List<Friend> testFriend(String username1,String username2);
	List<Friend> listFriend(String username);
	

}
