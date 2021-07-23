package it.epicode.be.model;


import java.time.LocalDate;
import java.util.Set;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
@Entity
@Inheritance(strategy = InheritanceType.JOINED) //schema2
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //schema3
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //schema1
@NamedQuery(name = "eventiConPartecipanti", query = "SELECT DISTINCT a FROM Evento a JOIN a.partecipazioni b ")
@NamedQuery(name = "eventiPerSpettatore", query = "SELECT b FROM Partecipazione a JOIN a.evento b WHERE a.persona = :invitato")
@NamedQuery(name = "eventiSoldOut", query = "SELECT DISTINCT  b FROM Partecipazione a JOIN a.evento b   WHERE numeroMassimoPartecipanti = SIZE(b.partecipazioni)")

public class Evento {
	@Id
	@SequenceGenerator(name="chiaveEvento", sequenceName = "evento_seq", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="chiaveEvento")
	private Long id;
	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	public enum TipoEvento {PUBBLICO, PRIVATO};
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	private int numeroMassimoPartecipanti;
	@OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
	//@OrderBy("dataEvento ASC")
	private Set<Partecipazione> partecipazioni;
	@ManyToOne(fetch = FetchType.EAGER)
	private Location location;
	private int numeroPartecipanti;

	public Evento() {
		
	}
	
	public Evento(Long id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti) {
		this.id = id;
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}
	
	public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location) {
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.location = location;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public LocalDate getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public int getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}
	public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public Set<Partecipazione> getPartecipazioni() {
		return partecipazioni;
	}

	public void setPartecipazioni(Set<Partecipazione> partecipazioni) {
		this.partecipazioni = partecipazioni;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public int getNumeroPartecipanti() {
		return numeroPartecipanti;
	}

	public void setNumeroPartecipanti(int numeroPartecipanti) {
		this.numeroPartecipanti = numeroPartecipanti;
	}
	public void addPartecipante() {
		this.numeroPartecipanti ++;
	}

	
}
