package it.epicode.be;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.epicode.be.model.Concerto;
import it.epicode.be.model.Evento;
import it.epicode.be.model.GaraDiAtletica;
import it.epicode.be.model.Location;
import it.epicode.be.model.Partecipazione;
import it.epicode.be.model.PartitaDiCalcio;
import it.epicode.be.model.Persona;
import it.epicode.be.model.Concerto.Genere;
import it.epicode.be.model.Evento.TipoEvento;
import it.epicode.be.model.Partecipazione.Stato;
import it.epicode.be.model.Persona.Sesso;
import it.epicode.be.model.data.EventoDAO;
import it.epicode.be.model.data.LocationDAO;
import it.epicode.be.model.data.PartecipazioneDAO;
import it.epicode.be.model.data.PersonaDAO;
import it.epicode.be.utils.JpaUtil;

public class TestMetodiProgetto {

	LocationDAO ld = new LocationDAO(new JpaUtil());
	EventoDAO ed = new EventoDAO(new JpaUtil());
	PersonaDAO pd = new PersonaDAO(new JpaUtil());
	PartecipazioneDAO pad = new PartecipazioneDAO(new JpaUtil());

	@BeforeClass
	public static void PopolazioneDatabase() throws Exception {
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

		// JpaUtil.close();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		JpaUtil.close();
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Metodo:");
	}

	@After
	public void tearDown() throws Exception {

		try {
			TimeUnit.SECONDS.sleep(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void testPartiteVinteInCasa() {
		List<PartitaDiCalcio> u = ed.getPartiteVinteInCasa();

		PartitaDiCalcio part1 = (PartitaDiCalcio) ed.getById(3l);
		PartitaDiCalcio part2 = (PartitaDiCalcio) ed.getById(6l);

		List<PartitaDiCalcio> confronto = new ArrayList<>();
		confronto.add(part1);
		confronto.add(part2);
		assertEquals(u, confronto);

		System.out.println();
		System.out.println("Partite Vinte in casa:");
		u.forEach(c -> System.out.println(c.getTitolo()));
		System.out.println();
	}

	@Test
	public void testPartiteVinteInTrasferta() {
		List<PartitaDiCalcio> i = ed.getPartiteVinteInTrasferta();

		PartitaDiCalcio part1 = (PartitaDiCalcio) ed.getById(5l);
		PartitaDiCalcio part2 = (PartitaDiCalcio) ed.getById(7l);

		List<PartitaDiCalcio> confronto = new ArrayList<>();
		confronto.add(part1);
		confronto.add(part2);
		assertEquals(i, confronto);

		System.out.println();
		System.out.println("Partite Vinte in trasferta:");
		i.forEach(c -> System.out.println(c.getTitolo()));
		System.out.println();
	}

	@Test
	public void testPartitePareggiate() {
		List<PartitaDiCalcio> o = ed.getPartitePareggiate();

		PartitaDiCalcio part1 = (PartitaDiCalcio) ed.getById(4l);
		PartitaDiCalcio part2 = (PartitaDiCalcio) ed.getById(8l);

		List<PartitaDiCalcio> confronto = new ArrayList<>();
		confronto.add(part1);
		confronto.add(part2);
		assertEquals(o, confronto);

		System.out.println();
		System.out.println("Partite pareggiate:");
		o.forEach(c -> System.out.println(c.getTitolo()));
		System.out.println();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testGareDiAtleticaPerVincitore() {
		List<GaraDiAtletica> p = ed.getGareDiAtleticaPerVincitore(pd.getById(3l));

		GaraDiAtletica gara1 = (GaraDiAtletica) ed.getById(9l);
		GaraDiAtletica gara2 = (GaraDiAtletica) ed.getById(10l);

		List<GaraDiAtletica> confronto = new ArrayList<>();
		confronto.add(gara1);
		confronto.add(gara2);
		assertEquals(new HashSet(p), new HashSet(confronto));

		System.out.println();
		System.out.println("Gare vinte da persona con id 3");
		p.forEach(c -> System.out.println(c.getTitolo()));
		System.out.println();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testGareDiAtleticaPerPartecipante() {
		List<GaraDiAtletica> a = ed.getGareDiAtleticaPerPartecipante(pd.getById(4l));

		GaraDiAtletica gara1 = (GaraDiAtletica) ed.getById(9l);

		List<GaraDiAtletica> confronto = new ArrayList<>();
		confronto.add(gara1);
		assertEquals(new HashSet(a), new HashSet(confronto));

		System.out.println();
		System.out.println("Gare di atletica per partecipante con id 2");
		a.forEach(c -> System.out.println(c.getTitolo()));
		System.out.println();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testEventiSoldOut() {
		List<Evento> j = ed.getEventiSoldOut();

		Evento evento1 = ed.getById(2l);
		Evento evento2 = ed.getById(9l);

		List<Evento> confronto = new ArrayList<>();
		confronto.add(evento1);
		confronto.add(evento2);
		assertEquals(new HashSet(j), new HashSet(confronto));

		System.out.println();
		System.out.println("Eventi sold out:");
		j.forEach(c -> System.out.println(c.getTitolo()));
		System.out.println();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testEventiPerInvitato() {
		List<Evento> listPartForPers = ed.getEventiPerInvitato(pd.getById(5l));

		Evento evento1 = ed.getById(9l);
		Evento evento2 = ed.getById(10l);
		Evento evento3 = ed.getById(12l);
		Evento evento4 = ed.getById(14l);
		Evento evento5 = ed.getById(15l);
		Evento evento6 = ed.getById(8l);

		List<Evento> confronto = new ArrayList<>();
		confronto.add(evento1);
		confronto.add(evento2);
		confronto.add(evento3);
		confronto.add(evento4);
		confronto.add(evento5);
		confronto.add(evento6);
		assertEquals(new HashSet(listPartForPers), new HashSet(confronto));

		System.out.println();
		System.out.println("Eventi a cui partecipa persona con id 5");
		listPartForPers.forEach(c -> System.out.println(c.getTitolo()));
		System.out.println();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testPartecipazioniDaConfermarePerEvento() {
		List<Partecipazione> parNonConf = pad.getPartecipazioniDaConfermarePerEvento(ed.getById(9l));

		Partecipazione partecipa1 = pad.getById(5l);
		Partecipazione partecipa2 = pad.getById(6l);
		Partecipazione partecipa3 = pad.getById(7l);
		Partecipazione partecipa4 = pad.getById(8l);
		Partecipazione partecipa5 = pad.getById(10l);

		List<Partecipazione> confronto = new ArrayList<>();
		confronto.add(partecipa1);
		confronto.add(partecipa2);
		confronto.add(partecipa3);
		confronto.add(partecipa4);
		confronto.add(partecipa5);
		assertEquals(new HashSet(parNonConf), new HashSet(confronto));

		System.out.println();
		System.out.println("Partecipazioni da confermare per evento con id 9");
		parNonConf.forEach(c -> System.out.println(c.getId() + " " + c.getStato()));
		System.out.println();
	}
}
