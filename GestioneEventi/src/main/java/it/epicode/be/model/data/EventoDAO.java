package it.epicode.be.model.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.epicode.be.model.Evento;
import it.epicode.be.utils.JpaUtil;

public class EventoDAO {
	private EntityManagerFactory factory;
	// private EntityManager em;

	public EventoDAO(JpaUtil ju) {
		factory = JpaUtil.getEntityManagerFactory();
		// em = JpaUtil.getEntityManager();
		// em.getTransaction().begin();
	}

	public void closeFA() {
		// em.getTransaction().commit();
		factory.close();
		// em.close();
	}

	public void save(Evento ev) {
		EntityManager em = JpaUtil.getEntityManager();

		System.out.println(em.isOpen());
		em.getTransaction().begin();
		em.persist(ev);
		em.getTransaction().commit();

	}

	public Evento getById(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		Evento found = em.find(Evento.class, id);

		return found;
	}

	public void delete(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		try {
			Evento del = em.find(Evento.class, id);
			em.getTransaction().begin();
			em.remove(del);
			

		} catch (IllegalArgumentException e) {
			System.out.println("Evento già eliminato");
		}finally {
			em.getTransaction().commit();
		}
	}

	public void refresh(Long id) {
		EntityManager em = JpaUtil.getEntityManager();
		Evento ref = em.find(Evento.class, id);
		em.refresh(ref);

	}
	public void refresh(Evento ev) {
		EntityManager em = JpaUtil.getEntityManager();
		em.refresh(ev);
	}

	@Deprecated
	public void update(Evento ev) {
		EntityManager em = JpaUtil.getEntityManager();

		Evento updated = em.find(Evento.class, ev.getId());
		updated.setTitolo(ev.getTitolo());
		updated.setDataEvento(ev.getDataEvento());
		updated.setDescrizione(ev.getDescrizione());
		updated.setTipoEvento(ev.getTipoEvento());
		updated.setNumeroMassimoPartecipanti(ev.getNumeroMassimoPartecipanti());

		em.getTransaction().begin();
		em.persist(updated);
		em.getTransaction().commit();

	}
	
	public void update(Long id, Evento ev) {
		EntityManager em = JpaUtil.getEntityManager();

		Evento updated = em.find(Evento.class, id);
		updated.setTitolo(ev.getTitolo());
		updated.setDataEvento(ev.getDataEvento());
		updated.setDescrizione(ev.getDescrizione());
		updated.setTipoEvento(ev.getTipoEvento());
		updated.setNumeroMassimoPartecipanti(ev.getNumeroMassimoPartecipanti());
		updated.setLocation(ev.getLocation());
			
		em.getTransaction().begin();
		em.persist(updated);
		em.getTransaction().commit();

	}

	

}
