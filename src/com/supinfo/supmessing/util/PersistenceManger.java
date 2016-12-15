package com.supinfo.supmessing.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManger {
	
	private  static EntityManagerFactory emf = null;
	private PersistenceManger(){
}
	
	public static EntityManagerFactory getEntityManagerFactory(){
		if(emf == null)
		{
			emf = Persistence.createEntityManagerFactory("persistenceUnit");
		}
		return emf;
	}
	
	public static void closeEntityManagerFactory(){
		if(emf !=null&& emf.isOpen())
		{
			emf.close();
		}
	}

}
