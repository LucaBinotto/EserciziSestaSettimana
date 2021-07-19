package it.epicode.be.model.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import it.epicode.be.model.Evento;

public class EventoDAO {

	public void save(Evento ev) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestioneEventi");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(ev);
			em.getTransaction().commit();

		} finally {
			em.close();
			factory.close();
		}
	}

	public Evento getById(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestioneEventi");
		EntityManager em = factory.createEntityManager();
		try {
			Evento found = em.find(Evento.class, id);
			return found;
		} finally {
			em.close();
			factory.close();
		}

	}

	public void delete(Long id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestioneEventi");
		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			//em.persist(ev);
			em.getTransaction().commit();
			//TODO
		} finally {
			em.close();
			factory.close();
		}
	}

	public void refresh(Evento ev) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("GestioneEventi");
		EntityManager em = factory.createEntityManager();

		try {

			Evento updated = em.find(Evento.class, ev.getId());
			updated.setTitolo(ev.getTitolo());
			updated.setDataEvento(ev.getDataEvento());
			updated.setDescrizione(ev.getDescrizione());
			updated.setTipoEvento(ev.getTipoEvento());
			updated.setNumeroMassimoPartecipanti(ev.getNumeroMassimoPartecipanti());

			em.getTransaction().begin();
			em.persist(updated);
			em.getTransaction().commit();

		} finally {
			em.close();
			factory.close();
		}
	}

}
