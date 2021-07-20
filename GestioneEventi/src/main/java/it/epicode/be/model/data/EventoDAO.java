package it.epicode.be.model.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import it.epicode.be.model.Evento;
import it.epicode.be.utils.JpaUtil;

public class EventoDAO {

	private EntityManagerFactory factory;

	public EventoDAO(JpaUtil ju) {
		factory = JpaUtil.getEntityManagerFactory();
	}

	public void save(Evento ev) {

		EntityManager em = factory.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(ev);
			em.getTransaction().commit();

		} finally {
			em.close();
			// factory.close();
		}
	}

	public Evento getById(Long id) {

		EntityManager em = factory.createEntityManager();
		try {
			Evento found = em.find(Evento.class, id);
			return found;
		} finally {
			em.close();
			// factory.close();
		}

	}

	public void delete(Long id) {

		EntityManager em = factory.createEntityManager();
		try {
			Evento del = em.find(Evento.class, id);
			em.getTransaction().begin();
			em.remove(del);
			em.getTransaction().commit();
		} catch (IllegalArgumentException e) {
			System.out.println("Evento già eliminato");
		} finally {
			em.close();
			// factory.close();
		}
	}

	public void refresh(Evento ev) {

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
			// factory.close();
		}
	}

}
