package com.supinfo.supmessing.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.supinfo.supmessing.dao.FriendDao;
import com.supinfo.supmessing.entity.Friend;

public class JpaFriendDao  implements FriendDao{

	
	private EntityManagerFactory emf;
	
	public JpaFriendDao(EntityManagerFactory emf)
	{
		this.emf = emf;
	}
	@Override
	public void addFriend(Friend r) {
		
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		em.close();	

		
	}
	@Override
	public List<Friend> testFriend(String username1, String username2) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Friend> list = em.createQuery("SELECT r FROM Friend r WHERE r.firstuser = '"+username1+"' AND r.seconduser = '"+username2+"'").getResultList();
		em.getTransaction().commit();
		em.close();
		return list;
	}
	@Override
	public List<Friend> listFriend(String username) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Friend> list = em.createQuery("SELECT r FROM Friend r WHERE r.firstuser = '"+username+"'").getResultList();
		em.getTransaction().commit();
		em.close();
		return list;
	}
	

}
