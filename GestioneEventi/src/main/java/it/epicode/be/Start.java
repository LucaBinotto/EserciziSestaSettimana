package it.epicode.be;

import java.util.Date;

import it.epicode.be.model.Evento;
import it.epicode.be.model.Evento.TipoEvento;
import it.epicode.be.model.Location;
import it.epicode.be.model.Partecipazione;
import it.epicode.be.model.Persona;
import it.epicode.be.model.data.EventoDAO;
import it.epicode.be.model.data.LocationDAO;
import it.epicode.be.model.data.PartecipazioneDAO;
import it.epicode.be.model.data.PersonaDAO;
import it.epicode.be.utils.JpaUtil;

public class Start {

	public static void main(String[] args) {
		
		Evento matrimonio = new Evento("giulia e marco", new Date(), "fascia alta", TipoEvento.PRIVATO, 80);
		Evento matrimonio2 = new Evento("gatto e cane", new Date(), "fascia bassa", TipoEvento.PUBBLICO, 4);
		Persona pe = new Persona();
		Partecipazione pa = new Partecipazione();
		Location lo = new Location();
		
		
		EventoDAO ed = new EventoDAO(new JpaUtil());
		PersonaDAO pd = new PersonaDAO(new JpaUtil());
		PartecipazioneDAO pad = new PartecipazioneDAO(new JpaUtil());
		LocationDAO ld = new LocationDAO(new JpaUtil());
		
		ed.save(matrimonio);
		ed.save(matrimonio2);
		
		pd.save(pe);
		pad.save(pa);
		ld.save(lo);
		
		
		
		/*
		Evento matr = ed.getById(9l);
		ed.delete(10l);
		
		System.out.println(matr.getDescrizione());
		
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
