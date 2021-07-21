package it.epicode.be.model.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.epicode.be.model.Persona;
import it.epicode.be.utils.JpaUtil;

public class PersonaDAO {
	
	private EntityManagerFactory factory;
	
	public PersonaDAO(JpaUtil ju) {
		factory = JpaUtil.getEntityManagerFactory();
		// em = JpaUtil.getEntityManager();
		// em.getTransaction().begin();
	}
	public void closeFA() {
		// em.getTransaction().commit();
		factory.close();
		// em.close();
	}
	public void save(Persona ev) {
		EntityManager em = JpaUtil.getEntityManager();
		
			System.out.println(em.isOpen());
			em.getTransaction().begin();
			em.persist(ev);
			em.getTransaction().commit();
		
	}
	public Persona getById(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		Persona found = em.find(Persona.class, id);
		
		return found;
	}
	public void delete(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Persona del = em.find(Persona.class, id);
			em.getTransaction().begin();
			em.remove(del);
		} catch (IllegalArgumentException e) {
			System.out.println("Persona già eliminata");
		}finally {
			em.getTransaction().commit();
		}
	}
	public void refresh(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		Persona ref = em.find(Persona.class, id);
		em.refresh(ref);
	}
	public void refresh(Persona ev) {
		EntityManager em = JpaUtil.getEntityManager();
		em.refresh(ev);
	}
	
}
