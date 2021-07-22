package it.epicode.be;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import it.epicode.be.model.Concerto;
import it.epicode.be.model.Concerto.Genere;
import it.epicode.be.model.Evento;
import it.epicode.be.model.Evento.TipoEvento;
import it.epicode.be.model.GaraDiAtletica;
import it.epicode.be.model.Persona.Sesso;
import it.epicode.be.model.Location;
import it.epicode.be.model.Partecipazione;
import it.epicode.be.model.Partecipazione.Stato;
import it.epicode.be.model.PartitaDiCalcio;
import it.epicode.be.model.Persona;
import it.epicode.be.model.data.EventoDAO;
import it.epicode.be.model.data.LocationDAO;
import it.epicode.be.model.data.PartecipazioneDAO;
import it.epicode.be.model.data.PersonaDAO;
import it.epicode.be.utils.JpaUtil;

public class Start {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		//creazioneLoEvPePaESalvataggio();

		LocationDAO ld = new LocationDAO(new JpaUtil());
		EventoDAO ed = new EventoDAO(new JpaUtil());
		PersonaDAO pd = new PersonaDAO(new JpaUtil());
		PartecipazioneDAO pad = new PartecipazioneDAO(new JpaUtil());

		
		GaraDiAtletica x = (GaraDiAtletica) ed.getById(5l);
		x.addAtleta(pd.getById(1l));
		x.addAtleta(pd.getById(2l));
		x.addAtleta(pd.getById(3l));
		
		x.setVincitore(pd.getById(3l));
		ed.update(x);
		
		GaraDiAtletica y = (GaraDiAtletica) ed.getById(4l);
		y.setVincitore(pd.getById(3l));
		ed.update(y);
		
		System.out.println(Genere.CLASSICO);
		
		List<Concerto> streamed = ed.getConcertiInStreaming(true);
		streamed.forEach(c ->System.out.println(c.getTitolo()));
		
		List<Genere> daCercare = new ArrayList<>();
		//daCercare.add(Genere.ROCK);
		daCercare.add(Genere.CLASSICO);
		daCercare.add(Genere.POP);
		
		List<Concerto> gotFromGenere = ed.getConcertiPerGenere(daCercare);
		List<Concerto> gotFromGenere2 = ed.getConcertiPerGenere(Genere.ROCK,Genere.POP);

		gotFromGenere.forEach(c ->System.out.println(c.getTitolo()));
		System.out.println();
		gotFromGenere2.forEach(c ->System.out.println(c.getTitolo()));
		/*
		 * NON FUNZIONA Evento toUpdate = ed.getById(2l); toUpdate.setLocation(lo2);
		 * ed.update(2l, toUpdate);
		 */
		
		/*
		List<Evento> rr = ld.getById(1l).getEventi();
		rr.stream().forEach(xx -> System.out.println(xx.getTitolo()));
		List<Partecipazione> yy = pd.getById(1l).getListaPartecipazioni();
		yy.stream().forEach(xx -> System.out.println(xx.getEvento().getTitolo()));
		 */

	}

	public static void creazioneLoEvPePaESalvataggio() {
		Location lo = new Location("Villa Razzi", "Palermo");
		Location lo2 = new Location("Parco Wandel", "Mosca");
		Location lo3 = new Location("Stadio Allianz", "Dublino");
		
		
		Evento matrimonio = new Evento("giulia e marco", LocalDate.of(2022, 3, 15), "fascia alta", TipoEvento.PRIVATO,80, lo);
		Evento matrimonio2 = new Evento("gatto e cane", LocalDate.of(2022, 2, 15), "fascia bassa", TipoEvento.PUBBLICO,4, lo);
		matrimonio2.setLocation(lo2);
		PartitaDiCalcio partita = new PartitaDiCalcio("Italia-Inghilterra", LocalDate.of(2021, 12, 15), "finale", TipoEvento.PUBBLICO, 50000, lo3, "Italia", "Inghilterra", "Italia", 3, 2);
		GaraDiAtletica gara = new GaraDiAtletica("Corsa", LocalDate.of(2021, 9, 30), "lunga e affascinante", TipoEvento.PRIVATO, 600, lo2);
		GaraDiAtletica gara2 = new GaraDiAtletica("Corsa Siepi", LocalDate.of(2021, 10, 30), "corta e saltellosa", TipoEvento.PRIVATO, 300, lo2);
		Concerto concerto = new Concerto("Metallica", LocalDate.of(2023, 4, 7), "rumoroso", TipoEvento.PUBBLICO, 20000, lo3, Genere.ROCK, false);
		Concerto concerto2 = new Concerto("KDA", LocalDate.of(2023, 5, 7), "rumoroso", TipoEvento.PUBBLICO, 20000, lo3, Genere.POP, true);
		Concerto concerto3 = new Concerto("ACDC", LocalDate.of(2023, 6, 7), "rumoroso", TipoEvento.PUBBLICO, 20000, lo3, Genere.ROCK, false);
		Concerto concerto4 = new Concerto("Mozart", LocalDate.of(2023, 7, 7), "rumoroso", TipoEvento.PUBBLICO, 20000, lo3, Genere.CLASSICO, false);
		Concerto concerto5 = new Concerto("Billie Eilish", LocalDate.of(2023, 8, 7), "rumoroso", TipoEvento.PUBBLICO, 20000, lo3, Genere.POP, true);
		Concerto concerto6 = new Concerto("Bach", LocalDate.of(2023, 9, 7), "rumoroso", TipoEvento.PUBBLICO, 20000, lo3, Genere.CLASSICO, true);

		
		
		Persona pe = new Persona("Luca", "Binotto", "1@2.3", LocalDate.of(1994, 2, 15), Sesso.Maschio);
		Persona pe2 = new Persona("Tizia", "Rossi", "1@2.3", LocalDate.of(1285, 5, 26), Sesso.Femmina);
		Persona pe3 = new Persona("Alfio", "Rondo", "1@2.3", LocalDate.of(1944, 2, 15), Sesso.Maschio);
		Persona pe4 = new Persona("Alberto", "Fragola", "1@2.3", LocalDate.of(1997, 2, 15), Sesso.Maschio);
		Persona pe5 = new Persona("Ciccio", "Pasticcio", "1@2.3", LocalDate.of(1964, 2, 15), Sesso.Maschio);
		Persona pe6 = new Persona("Adja", "Binotto", "1@2.3", LocalDate.of(1934, 2, 15), Sesso.Femmina);
		
		
		
		Partecipazione pa = new Partecipazione(pe, matrimonio, Stato.CONFERMATA);
		Partecipazione pa2 = new Partecipazione(pe, matrimonio2, Stato.CONFERMATA);
		
		Partecipazione pa3 = new Partecipazione(pe, partita, Stato.CONFERMATA);
		Partecipazione pa4 = new Partecipazione(pe, gara, Stato.CONFERMATA);
		Partecipazione pa42 = new Partecipazione(pe, gara, Stato.CONFERMATA);
		Partecipazione pa43 = new Partecipazione(pe2, gara, Stato.CONFERMATA);
		Partecipazione pa44 = new Partecipazione(pe3, gara, Stato.CONFERMATA);
		Partecipazione pa45 = new Partecipazione(pe4, gara, Stato.DA_CONFERMARE);
		Partecipazione pa46 = new Partecipazione(pe5, gara, Stato.CONFERMATA);
		Partecipazione pa47 = new Partecipazione(pe6, gara, Stato.CONFERMATA);
		
		Partecipazione pa5 = new Partecipazione(pe, gara2, Stato.CONFERMATA);
		Partecipazione pa52 = new Partecipazione(pe2, gara2, Stato.CONFERMATA);
		Partecipazione pa53 = new Partecipazione(pe3, gara2, Stato.DA_CONFERMARE);
		Partecipazione pa54 = new Partecipazione(pe4, gara2, Stato.CONFERMATA);
		Partecipazione pa55 = new Partecipazione(pe5, gara2, Stato.CONFERMATA);
		
		Partecipazione pa6 = new Partecipazione(pe, concerto, Stato.CONFERMATA);

		
		LocationDAO ld = new LocationDAO(new JpaUtil());
		EventoDAO ed = new EventoDAO(new JpaUtil());
		PersonaDAO pd = new PersonaDAO(new JpaUtil());
		PartecipazioneDAO pad = new PartecipazioneDAO(new JpaUtil());
		
		ld.save(lo);
		ld.save(lo2);
		ld.save(lo3);
		
		ed.save(matrimonio); 
		ed.save(matrimonio2);
		ed.save(partita);
		ed.save(gara);
		ed.save(gara2);
		ed.save(concerto);
		ed.save(concerto2);
		ed.save(concerto3);
		ed.save(concerto4);
		ed.save(concerto5);
		ed.save(concerto6);
		
		pd.save(pe); 
		pd.save(pe2); 
		pd.save(pe3); 
		pd.save(pe4); 
		pd.save(pe5); 
		pd.save(pe6); 
		
		gara.addAtleta(pe);
		gara.addAtleta(pe2);
		gara.addAtleta(pe3);
		gara.addAtleta(pe4);
		gara.addAtleta(pe5);
		gara.addAtleta(pe6);
		
		pad.save(pa);
		pad.save(pa2); 
		pad.save(pa3); 
		pad.save(pa4);
		pad.save(pa42);
		pad.save(pa43);
		pad.save(pa44);
		pad.save(pa45);
		pad.save(pa46);
		pad.save(pa47);

		pad.save(pa5);
		pad.save(pa52);
		pad.save(pa53);
		pad.save(pa54);
		pad.save(pa55);
		
		pad.save(pa6); 
	}
	
}
