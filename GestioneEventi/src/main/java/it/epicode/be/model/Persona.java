package it.epicode.be.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity
public class Persona {
	
	public enum Sesso{Maschio, Femmina};
	@Id
	@SequenceGenerator(name="chiavePersona", sequenceName = "persona_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="chiavePersona")
	private Long id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate  dataDiNascita;
	@Enumerated(EnumType.STRING)
	private Sesso sesso;
	@OneToMany(mappedBy = "persona", cascade = CascadeType.REMOVE)
	private List<Partecipazione> listaPartecipazioni; // (ordinata per dataEvento)
	
	
	
	public Persona() {
	}

	public Persona(String nome, String cognome, String email, LocalDate dataDiNascita, Sesso sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public Sesso getSesso() {
		return sesso;
	}
	public void setSesso(Sesso sesso) {
		this.sesso = sesso;
	}
	public List<Partecipazione> getListaPartecipazioni() {
		return listaPartecipazioni;
	}
	public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
		this.listaPartecipazioni = listaPartecipazioni;
	}
	
	
	
	
	
	
}
