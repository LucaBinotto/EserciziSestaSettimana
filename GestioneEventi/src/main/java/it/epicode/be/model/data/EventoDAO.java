package it.epicode.be.model.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.epicode.be.model.Evento;
import it.epicode.be.utils.JpaUtil;

public class EventoDAO {
	private EntityManagerFactory factory;
	private EntityManager em;
	
	
	public EventoDAO(JpaUtil ju) {
		factory = JpaUtil.getEntityManagerFactory();
		em = JpaUtil.getEntityManager();
		em.getTransaction().begin();
	}
	
	public void closeEM() {
		factory.close();
		em.close();
	}

	public void save(Evento ev) {
		
			//em.getTransaction().begin();
			em.persist(ev);
			em.getTransaction().commit();
	}

	public Evento getById(Long id) {
			Evento found = em.find(Evento.class, id);
			return found;
		}

	public void delete(Long id) {
		try {
			Evento del = em.find(Evento.class, id);
			//em.getTransaction().begin();
			em.remove(del);
			em.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println("Evento già eliminato");
		} 
	}

	public void update(Evento ev) {

			Evento updated = em.find(Evento.class, ev.getId());
			updated.setTitolo(ev.getTitolo());
			updated.setDataEvento(ev.getDataEvento());
			updated.setDescrizione(ev.getDescrizione());
			updated.setTipoEvento(ev.getTipoEvento());
			updated.setNumeroMassimoPartecipanti(ev.getNumeroMassimoPartecipanti());

			//em.getTransaction().begin();
			em.persist(updated);
			em.getTransaction().commit();
	}
	
	public void refresh(Long id) {
			Evento ref = em.find(Evento.class, id);
			em.refresh(ref);
		
	}
	
	public void refresh(Evento ev) {
			em.refresh(ev);
	}

}
