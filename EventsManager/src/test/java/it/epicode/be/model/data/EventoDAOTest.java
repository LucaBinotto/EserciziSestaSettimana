package it.epicode.be.model.data;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import it.epicode.be.model.*;
import it.epicode.be.model.Concerto.Genere;
import it.epicode.be.model.Evento.TipoEvento;
import it.epicode.be.model.Partecipazione.Stato;
import it.epicode.be.model.Persona.Sesso;
import it.epicode.be.utils.JpaUtil;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
class EventoDAOTest {
	EventoDAO ed = new EventoDAO(new JpaUtil());

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Location lo = new Location("Villa Razzi", "Palermo");
		Location lo2 = new Location("Parco Wandel", "Mosca");
		Location lo3 = new Location("Stadio Allianz", "Dublino");

		Evento matrimonio = new Evento("giulia e marco", LocalDate.of(2022, 3, 15), "fascia alta", TipoEvento.PRIVATO,
				80, lo);
		Evento matrimonio2 = new Evento("gatto e cane", LocalDate.of(2022, 2, 15), "fascia bassa", TipoEvento.PUBBLICO,
				4, lo);
		matrimonio2.setLocation(lo2);

		PartitaDiCalcio partita = new PartitaDiCalcio("Italia-Inghilterra", LocalDate.of(2021, 12, 15), "finale",
				TipoEvento.PUBBLICO, 50000, lo3, "Italia", "Inghilterra", "Italia", 3, 2);
		PartitaDiCalcio partita2 = new PartitaDiCalcio("Italia-Napoli", LocalDate.of(2021, 12, 15), "semifinale",
				TipoEvento.PUBBLICO, 50000, lo3, "Italia", "Napoli", null, 2, 2);
		PartitaDiCalcio partita3 = new PartitaDiCalcio("Inghilterra-Napoli", LocalDate.of(2021, 12, 15), "semifinale",
				TipoEvento.PUBBLICO, 50000, lo3, "Inghilterra", "Napoli", "Napoli", 1, 2);
		PartitaDiCalcio partita4 = new PartitaDiCalcio("Svezia-Svizzera", LocalDate.of(2021, 12, 15), "amichevole",
				TipoEvento.PUBBLICO, 50000, lo3, "Svezia", "Svizzera", "Svezia", 3, 2);
		PartitaDiCalcio partita5 = new PartitaDiCalcio("Roma-Lazio", LocalDate.of(2021, 12, 15), "Serie A",
				TipoEvento.PUBBLICO, 50000, lo3, "Roma", "Lazio", "Lazio", 0, 4);
		PartitaDiCalcio partita6 = new PartitaDiCalcio("Milan-Inter", LocalDate.of(2021, 12, 15), "Serie A",
				TipoEvento.PUBBLICO, 50000, lo3, "Milan", "Inter", null, 0, 0);

		GaraDiAtletica gara = new GaraDiAtletica("Corsa", LocalDate.of(2021, 9, 30), "lunga e affascinante",
				TipoEvento.PRIVATO, 7, lo2);
		GaraDiAtletica gara2 = new GaraDiAtletica("Corsa Siepi", LocalDate.of(2021, 10, 30), "corta e saltellosa",
				TipoEvento.PRIVATO, 300, lo2);
		Concerto concerto = new Concerto("Metallica", LocalDate.of(2023, 4, 7), "rumoroso", TipoEvento.PUBBLICO, 20000,
				lo3, Genere.ROCK, false);
		Concerto concerto2 = new Concerto("KDA", LocalDate.of(2023, 5, 7), "rumoroso", TipoEvento.PUBBLICO, 20000, lo3,
				Genere.POP, true);
		Concerto concerto3 = new Concerto("ACDC", LocalDate.of(2023, 6, 7), "rumoroso", TipoEvento.PUBBLICO, 20000, lo3,
				Genere.ROCK, false);
		Concerto concerto4 = new Concerto("Mozart", LocalDate.of(2023, 7, 7), "rumoroso", TipoEvento.PUBBLICO, 20000,
				lo3, Genere.CLASSICO, false);
		Concerto concerto5 = new Concerto("Billie Eilish", LocalDate.of(2023, 8, 7), "rumoroso", TipoEvento.PUBBLICO,
				20000, lo3, Genere.POP, true);
		Concerto concerto6 = new Concerto("Bach", LocalDate.of(2023, 9, 7), "rumoroso", TipoEvento.PUBBLICO, 20000, lo3,
				Genere.CLASSICO, true);

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
		Partecipazione pa42 = new Partecipazione(pe, gara, Stato.DA_CONFERMARE);
		Partecipazione pa43 = new Partecipazione(pe2, gara, Stato.DA_CONFERMARE);
		Partecipazione pa44 = new Partecipazione(pe3, gara, Stato.DA_CONFERMARE);
		Partecipazione pa45 = new Partecipazione(pe4, gara, Stato.DA_CONFERMARE);
		Partecipazione pa46 = new Partecipazione(pe5, gara, Stato.CONFERMATA);
		Partecipazione pa47 = new Partecipazione(pe6, gara, Stato.DA_CONFERMARE);

		Partecipazione pa5 = new Partecipazione(pe, gara2, Stato.CONFERMATA);
		Partecipazione pa52 = new Partecipazione(pe2, gara2, Stato.CONFERMATA);
		Partecipazione pa53 = new Partecipazione(pe3, gara2, Stato.DA_CONFERMARE);
		Partecipazione pa54 = new Partecipazione(pe4, gara2, Stato.CONFERMATA);
		Partecipazione pa55 = new Partecipazione(pe5, gara2, Stato.CONFERMATA);

		Partecipazione pa6 = new Partecipazione(pe, concerto, Stato.CONFERMATA);

		Partecipazione pa7 = new Partecipazione(pe5, concerto2, Stato.CONFERMATA);
		Partecipazione pa72 = new Partecipazione(pe5, concerto4, Stato.CONFERMATA);
		Partecipazione pa73 = new Partecipazione(pe5, concerto5, Stato.DA_CONFERMARE);
		Partecipazione pa74 = new Partecipazione(pe5, partita6, Stato.CONFERMATA);

		Partecipazione pa23 = new Partecipazione(pe2, matrimonio2, Stato.CONFERMATA);
		Partecipazione pa24 = new Partecipazione(pe3, matrimonio2, Stato.CONFERMATA);
		Partecipazione pa25 = new Partecipazione(pe4, matrimonio2, Stato.CONFERMATA);

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
		ed.save(partita2);
		ed.save(partita3);
		ed.save(partita4);
		ed.save(partita5);
		ed.save(partita6);

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

		pad.save(pa7);
		pad.save(pa72);
		pad.save(pa73);
		pad.save(pa74);

		pad.save(pa23);
		pad.save(pa24);
		pad.save(pa25);

		GaraDiAtletica x = (GaraDiAtletica) ed.getById(10l);
		x.addAtleta(pd.getById(1l));
		x.addAtleta(pd.getById(2l));
		x.addAtleta(pd.getById(3l));

		x.setVincitore(pd.getById(3l));
		ed.update(x);

		GaraDiAtletica y = (GaraDiAtletica) ed.getById(9l);
		y.setVincitore(pd.getById(3l));
		ed.update(y);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		JpaUtil.close();
	}

	@Test
	@Order(1)
	void testGetById() {
		Location lo = new Location("Villa Razzi", "Palermo");
		Evento test = new Evento("giulia e marco", LocalDate.of(2022, 3, 15), "fascia alta", TipoEvento.PRIVATO, 80,
				lo);
		Evento retrieved = ed.getById(1l);
		assertEquals(test, retrieved);
	}

	@Test
	@Order(2)
	void testSave() {
		Evento prova = new Evento("PROVASAVE", LocalDate.of(2015, 2, 24), "prov", TipoEvento.PRIVATO, 10, null);
		ed.save(prova);
		assertEquals(ed.getById(17l), prova);
	}

	@Test
	@Order(3)
	void testRefreshLong() {
		Evento lettoDaDatabase = ed.getById(17l);
		lettoDaDatabase.setTitolo("modificato");
		ed.refresh(17l);
		assertEquals("PROVASAVE", lettoDaDatabase.getTitolo());
	}

	@Test
	@Order(4)
	void testRefreshEvento() {
		Evento lettoDaDatabase = ed.getById(17l);
		lettoDaDatabase.setTitolo("modificato");
		ed.refresh(lettoDaDatabase);
		assertEquals("PROVASAVE", lettoDaDatabase.getTitolo());
	}

	@Test
	@Order(5)
	void testUpdateEvento() {
		Evento lettoDaDatabase = ed.getById(17l);
		lettoDaDatabase.setTitolo("Potato");
		ed.update(lettoDaDatabase);
		Evento riletto = ed.getById(17l);
		assertEquals("Potato", riletto.getTitolo());
	}

	@Test
	@Order(6)
	void testUpdateLongEvento() {
		Evento lettoDaDatabase = ed.getById(17l);
		lettoDaDatabase.setTitolo("Banana");
		ed.update(17l, lettoDaDatabase);
		Evento riletto = ed.getById(17l);
		assertEquals("Banana", riletto.getTitolo());
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	@Order(7)
	void testGetConcertiInStreaming() {
		List<Concerto> streamedByMethod = ed.getConcertiInStreaming(true);
		List<Concerto> streamed = new ArrayList<Concerto>();
		streamed.add((Concerto) ed.getById(12l));
		streamed.add((Concerto) ed.getById(15l));
		streamed.add((Concerto) ed.getById(16l));
		assertEquals(new HashSet(streamedByMethod), new HashSet(streamed));
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	@Order(8)
	void testGetConcertiPerGenereListOfGenere() {
		List<Genere> generi = new ArrayList<>();
		generi.add(Genere.CLASSICO);
		List<Concerto> generedByMethod = ed.getConcertiPerGenere(generi);
		List<Concerto> genered = new ArrayList<>();
		genered.add((Concerto) ed.getById(16l));
		genered.add((Concerto) ed.getById(14l));
		assertEquals(new HashSet(generedByMethod), new HashSet(genered));

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	@Order(9)
	void testGetConcertiPerGenereGenereArray() {
		List<Concerto> generedByMethod = ed.getConcertiPerGenere(Genere.POP,Genere.ROCK);
		List<Concerto> genered = new ArrayList<>();
		genered.add((Concerto) ed.getById(15l));
		genered.add((Concerto) ed.getById(13l));
		genered.add((Concerto) ed.getById(12l));
		genered.add((Concerto) ed.getById(11l));
		assertEquals(new HashSet(generedByMethod), new HashSet(genered));
	}

	@Test
	@Order(10)
	void testDelete() {
		ed.delete(17l);
		assertNull(ed.getById(17l));
	}

}
