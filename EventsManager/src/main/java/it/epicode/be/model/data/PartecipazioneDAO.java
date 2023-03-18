package it.epicode.be.model.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import it.epicode.be.model.Evento;
import it.epicode.be.model.Partecipazione;
import it.epicode.be.model.Partecipazione.Stato;
import it.epicode.be.utils.JpaUtil;

public class PartecipazioneDAO {

	private EntityManagerFactory factory;
	
	public PartecipazioneDAO(JpaUtil ju) {
		factory = JpaUtil.getEntityManagerFactory();
		// em = JpaUtil.getEntityManager();
		// em.getTransaction().begin();
	}
	public void closeFA() {
		// em.getTransaction().commit();
		factory.close();
		// em.close();
	}
	public void save(Partecipazione ev) {
		EntityManager em = JpaUtil.getEntityManager();
		
			//System.out.println(em.isOpen());
			em.getTransaction().begin();
			em.persist(ev);
			em.getTransaction().commit();
		
	}
	public Partecipazione getById(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		Partecipazione found = em.find(Partecipazione.class, id);
		
		return found;
	}
	public void delete(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Partecipazione del = em.find(Partecipazione.class, id);
			em.getTransaction().begin();
			em.remove(del);		
		} catch (IllegalArgumentException e) {
			System.out.println("Partecipazione già eliminata");
		}finally {
			em.getTransaction().commit();
		}
	}
	public void refresh(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		Partecipazione ref = em.find(Partecipazione.class, id);
		em.refresh(ref);
	}
	public void refresh(Partecipazione ev) {
		EntityManager em = JpaUtil.getEntityManager();
		em.refresh(ev);
	}
	@SuppressWarnings("unchecked")
	public List<Partecipazione> getPartecipazioniDaConfermarePerEvento(Evento evento){
		EntityManager em = JpaUtil.getEntityManager();
		Query query = em.createNamedQuery("getPartecipazioniDaConfermarePerEvento");
		query.setParameter("stato", Stato.DA_CONFERMARE);
		query.setParameter("evento", evento);
		List<Partecipazione> result = query.getResultList();
		return result;
		
	}
}
