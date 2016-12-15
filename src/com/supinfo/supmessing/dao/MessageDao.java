package com.supinfo.supmessing.dao;

import java.util.List;

import com.supinfo.supmessing.entity.Message;

public interface MessageDao {

	void sendMessage(Message mess);
	Long getMessageNum();
	List<Message> getMessageHistory(String sender,String receiver);
	List<Message> getListMessageHistory(String receiver);
}
