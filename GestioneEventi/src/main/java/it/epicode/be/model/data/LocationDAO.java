package it.epicode.be.model.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.epicode.be.model.Location;
import it.epicode.be.utils.JpaUtil;

public class LocationDAO {

	private EntityManagerFactory factory;
	
	public LocationDAO(JpaUtil ju) {
		factory = JpaUtil.getEntityManagerFactory();
		// em = JpaUtil.getEntityManager();
		// em.getTransaction().begin();
	}
	public void closeFA() {
		// em.getTransaction().commit();
		factory.close();
		// em.close();
	}
	public void save(Location ev) {
		EntityManager em = JpaUtil.getEntityManager();
		
			System.out.println(em.isOpen());
			em.getTransaction().begin();
			em.persist(ev);
			em.getTransaction().commit();
		
	}
	public Location getById(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		Location found = em.find(Location.class, id);
		
		return found;
	}
	public void delete(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Location del = em.find(Location.class, id);
			em.getTransaction().begin();
			em.remove(del);
			em.getTransaction().commit();
			
		} catch (IllegalArgumentException e) {
			System.out.println("Location già eliminata");
		}
	}
	public void refresh(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		Location ref = em.find(Location.class, id);
		em.refresh(ref);

	}
	
}
