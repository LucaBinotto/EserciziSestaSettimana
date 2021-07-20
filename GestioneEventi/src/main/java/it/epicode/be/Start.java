package it.epicode.be;

import java.util.Date;

import it.epicode.be.model.Evento;
import it.epicode.be.model.Evento.TipoEvento;
import it.epicode.be.model.data.EventoDAO;
import it.epicode.be.utils.JpaUtil;

public class Start {

	public static void main(String[] args) {
		
		//Evento matrimonio = new Evento(1l, "giulia e marco", new Date(), "fascia alta", TipoEvento.PRIVATO, 80);
		//Evento matrimonio2 = new Evento(2l, "gatto e cane", new Date(), "fascia bassa", TipoEvento.PUBBLICO, 4);

		EventoDAO ed = new EventoDAO(new JpaUtil());
		//ed.save(matrimonio);
		//ed.save(matrimonio2);
		
		Evento matr = ed.getById(1l);
		ed.delete(2l);
		
		System.out.println(matr.getDescrizione());
		Evento matrimonio = new Evento(1l, "giulia e marco", new Date(), "fascia alta", TipoEvento.PRIVATO, 120);
		ed.refresh(matrimonio);
	
	}

}
