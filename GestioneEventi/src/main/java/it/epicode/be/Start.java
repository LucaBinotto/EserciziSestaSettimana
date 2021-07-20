package it.epicode.be;

import java.util.Date;

import it.epicode.be.model.Evento;
import it.epicode.be.model.Evento.TipoEvento;
import it.epicode.be.model.data.EventoDAO;
import it.epicode.be.utils.JpaUtil;

public class Start {

	public static void main(String[] args) {
		
		Evento matrimonio = new Evento("giulia e marco", new Date(), "fascia alta", TipoEvento.PRIVATO, 80);
		Evento matrimonio2 = new Evento("gatto e cane", new Date(), "fascia bassa", TipoEvento.PUBBLICO, 4);

		EventoDAO ed = new EventoDAO(new JpaUtil());
		ed.save(matrimonio);
		ed.save(matrimonio2);
		
		/*
		Evento matr = ed.getById(9l);
		ed.delete(17l);
		
		System.out.println(matr.getDescrizione());
		
		/*
		Evento matrimoniomodif = new Evento(1l, "giulia e marco", new Date(), "fascia alta", TipoEvento.PRIVATO, 50);
		ed.update(matrimoniomodif);
		*/
		/*
		ed.getById(22l);
		System.out.println(matrimonio.getNumeroMassimoPartecipanti());
		ed.refresh(26l);
		ed.getById(26l);
		System.out.println(matrimonio.getNumeroMassimoPartecipanti());
		System.out.println(matrimonio.getNumeroMassimoPartecipanti());
		ed.closeFA();
		*/
		
	}

}
