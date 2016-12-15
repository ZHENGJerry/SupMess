package com.supinfo.supmessing.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.supinfo.supmessing.dao.MessageDao;
import com.supinfo.supmessing.entity.Message;

public class JpaMessageDao implements MessageDao {
	
	private EntityManagerFactory emf = null;
	

	public JpaMessageDao(EntityManagerFactory emf) {
		this.emf = emf;
	}


	@Override
	public void sendMessage(Message mess) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(mess);
		em.getTransaction().commit();
		em.close();
	}


	@Override
	public Long getMessageNum() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Long num = (Long) em.createQuery("SELECT COUNT(m) FROM Message m").getSingleResult();
		
		em.getTransaction().commit();
		em.close();	
		return num;
	}


	@Override
	public List<Message> getMessageHistory(String sender,String receiver) {
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Message> list = em.createQuery("SELECT m FROM Message m WHERE (m.sender='"+sender+"' AND m.receiver='"+receiver+"')OR(m.receiver='"+sender+"' AND m.sender='"+receiver+"') ORDER BY m.ts DESC").getResultList();
		
		em.getTransaction().commit();
		em.close();	
		return list;
	}


	@Override
	public List<Message> getListMessageHistory(String receiver) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Message> list = em.createQuery("SELECT m FROM Message m WHERE m.receiver='"+receiver+"' ORDER BY m.ts DESC").setMaxResults(5).getResultList();
		
		em.getTransaction().commit();
		em.close();	
		return list;
	}

}
