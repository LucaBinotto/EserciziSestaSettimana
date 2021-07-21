package it.epicode.be.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class GaraDiAtletica extends Evento{
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Persona> setAtleti = new HashSet<>();
	@ManyToOne
	private Persona vincitore;
	
	public GaraDiAtletica() {
	}
	public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, Set<Persona> setAtleti, Persona vincitore) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.setAtleti = setAtleti;
		this.vincitore = vincitore;
	}
	public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
	}
	
	public Set<Persona> getSetAtleti() {
		return setAtleti;
	}
	public Persona getVincitore() {
		return vincitore;
	}
	public void setVincitore(Persona vincitore) {
		this.vincitore = vincitore;
	}
	
	public void addAtleta(Persona per) {
		setAtleti.add(per);
	}
	
	
}
