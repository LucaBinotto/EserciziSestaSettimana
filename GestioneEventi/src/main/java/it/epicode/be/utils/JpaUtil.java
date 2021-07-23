package it.epicode.be.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static final EntityManagerFactory entityManagerFactory;
	private static final EntityManager entityManager;
	
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("GestioneEventi");
			entityManager = entityManagerFactory.createEntityManager();
		} catch (Throwable ex) {
			System.err.println("Initial EntityManagerFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public static EntityManager getEntityManager() {
		return entityManager;
	}
	
	public static void close() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
}
