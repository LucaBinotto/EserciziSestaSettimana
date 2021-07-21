package it.epicode.be;

import java.time.LocalDate;
import java.util.List;

import it.epicode.be.model.Evento;
import it.epicode.be.model.Evento.TipoEvento;
import it.epicode.be.model.Persona.Sesso;
import it.epicode.be.model.Location;
import it.epicode.be.model.Partecipazione;
import it.epicode.be.model.Partecipazione.Stato;
import it.epicode.be.model.Persona;
import it.epicode.be.model.data.EventoDAO;
import it.epicode.be.model.data.LocationDAO;
import it.epicode.be.model.data.PartecipazioneDAO;
import it.epicode.be.model.data.PersonaDAO;
import it.epicode.be.utils.JpaUtil;

public class Start {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Location lo = new Location("Villa Razzi", "Palermo");
		Location lo2 = new Location("Parco Wandel", "Mosca");

		Evento matrimonio = new Evento("giulia e marco", LocalDate.of(2022, 3, 15), "fascia alta", TipoEvento.PRIVATO, 80, lo);
		Evento matrimonio2 = new Evento("gatto e cane", LocalDate.of(2022, 2, 15), "fascia bassa", TipoEvento.PUBBLICO, 4, lo);
		Persona pe = new Persona("Luca", "Binotto", "1@2.3", LocalDate.of(1994, 2, 15), Sesso.Maschio);
		Persona pe2 = new Persona("Tizia", "Rossi", "1@2.3", LocalDate.of(1985, 5, 26), Sesso.Femmina);
		Partecipazione pa = new Partecipazione(pe, matrimonio, Stato.CONFERMATA);
		Partecipazione pa2 = new Partecipazione(pe, matrimonio2, Stato.CONFERMATA);
		
		matrimonio2.setLocation(lo2);
		
		LocationDAO ld = new LocationDAO(new JpaUtil());
		EventoDAO ed = new EventoDAO(new JpaUtil());
		PersonaDAO pd = new PersonaDAO(new JpaUtil());
		PartecipazioneDAO pad = new PartecipazioneDAO(new JpaUtil());
		
		/*
		Evento toUpdate = ed.getById(2l);
		toUpdate.setLocation(lo2);
		ed.update(2l, toUpdate);
		*/
		
		
		/*
		ld.save(lo);
		ed.save(matrimonio);
		
		pd.save(pe);
		pad.save(pa);
		pad.save(pa2);
		
		pd.save(pe2);
		*/
		List<Evento> rr = ld.getById(1l).getEventi();
		rr.stream().forEach(xx -> System.out.println(xx.getTitolo()));
		List<Partecipazione> yy = pd.getById(1l).getListaPartecipazioni();
		yy.stream().forEach(xx -> System.out.println(xx.getEvento().getTitolo()));
		
		
		/*
		Evento cercato = ed.getById(3l);
		System.out.println(cercato.getDescrizione());
		cercato.setDescrizione("merda alta");
		System.out.println(cercato.getDescrizione());
		ed.refresh(cercato);
		System.out.println(cercato.getDescrizione());
		*/
		
		
		/*
		ed.delete(4l);
		ed.save(matrimonio);
		ed.save(matrimonio2);
	
		pd.save(pe);
		pad.save(pa);
		ld.save(lo);
		*/		
		
		/*
		Evento matr = ed.getById(9l);
		ed.delete(10l);
		
		System.out.println(matr.getDescrizione());
		*/
		
		
		/*
		Evento matrimoniomodif = new Evento(1l, "giulia e marco", new Date(), "fascia alta", TipoEvento.PRIVATO, 50);
		ed.update(matrimoniomodif);
		*/
		
		
		/*
		ed.getById(1l);
		System.out.println(matrimonio.getNumeroMassimoPartecipanti());
		ed.refresh(1l);
		ed.getById(1l);
		System.out.println(matrimonio.getNumeroMassimoPartecipanti());
		System.out.println(matrimonio.getNumeroMassimoPartecipanti());
		ed.closeFA();
		*/
		
	}

}
