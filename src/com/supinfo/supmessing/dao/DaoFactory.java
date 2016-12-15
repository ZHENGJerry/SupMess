package com.supinfo.supmessing.dao;

import javax.persistence.EntityManagerFactory;

import com.supinfo.supmessing.dao.jpa.JpaMessageDao;
import com.supinfo.supmessing.dao.jpa.JpaFriendDao;
import com.supinfo.supmessing.dao.jpa.JpaUserDao;

public class DaoFactory {
	private DaoFactory()
	{
		
	}
	
	public static UserDao getUserDao(EntityManagerFactory emf)
	{
		return new JpaUserDao(emf);
	}
	public static MessageDao getMessageDao(EntityManagerFactory emf)
	{
		return new JpaMessageDao(emf);
	}
	public static FriendDao getFriendDao(EntityManagerFactory emf)
	{
		return new JpaFriendDao(emf);
	}

}
