package it.epicode.be.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Location {
	@Id
	@SequenceGenerator(name="chiaveLocation", sequenceName = "location_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="chiaveLocation")
	private Long id;
	private String nome;
	private String citta;
	@OneToMany(mappedBy = "location")
	private List<Evento> eventi;

	
	public Location() {
	}
	
	public Location(String nome, String citta) {
		this.nome = nome;
		this.citta = citta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}
	
	
}
