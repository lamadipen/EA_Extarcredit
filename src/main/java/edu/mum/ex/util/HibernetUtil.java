package edu.mum.ex.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernetUtil {
	private static final EntityManagerFactory emf;
	
	static{
		emf = Persistence.createEntityManagerFactory("cs544extra");
		
	}
	
	public static EntityManager getEntityManager()
	{
		return emf.createEntityManager();
	}
}
