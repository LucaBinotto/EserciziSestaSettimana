package it.epicode.be.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Entity
public class Concerto extends Evento{
	
	public enum Genere {CLASSICO, ROCK, POP};
	@Enumerated(EnumType.STRING)
	private Genere genere;
	private boolean	inStreaming;
	
	public Concerto() {
	}
	
	public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, Genere genere, boolean inStreaming) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.genere = genere;
		this.inStreaming = inStreaming;
	}

	public Genere getGenere() {
		return genere;
	}
	public void setGenere(Genere genere) {
		this.genere = genere;
	}
	public boolean isInStreaming() {
		return inStreaming;
	}
	public void setInStreaming(boolean inStreaming) {
		this.inStreaming = inStreaming;
	}
	
	
	
	
}
