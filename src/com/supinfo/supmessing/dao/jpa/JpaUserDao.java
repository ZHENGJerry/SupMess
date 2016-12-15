package com.supinfo.supmessing.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.supinfo.supmessing.dao.UserDao;
import com.supinfo.supmessing.entity.User;

public class JpaUserDao implements UserDao {
	
	private EntityManagerFactory emf = null;

	public JpaUserDao(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public void addUser(User user) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}

	

	@Override
	public void updateUser(User newuser) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User olduser = em.find(User.class, newuser.getUsername());
		
		olduser.setFirstname(newuser.getFirstname());
		olduser.setLastname(newuser.getLastname());
		olduser.setPassword(newuser.getPassword());
		olduser.setEmail(newuser.getEmail());
		
		em.getTransaction().commit();
		em.close();	
		
	}

	@Override
	public Long getUserNum() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Long num = (Long) em.createQuery("SELECT COUNT(u) FROM User u").getSingleResult();
		
		em.getTransaction().commit();
		em.close();	
		return num;
	}

	@Override
	public User findUser(Class clas, String username) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(clas, username);
		em.getTransaction().commit();
		em.close();	
		return user;
	}
	

}
