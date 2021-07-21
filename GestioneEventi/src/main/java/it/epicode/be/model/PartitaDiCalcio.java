package it.epicode.be.model;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class PartitaDiCalcio extends Evento{
	
	private String squadraDiCasa;
	private String squadraInTrasferta;
	private String squadraVincente; // [null se pareggio]
	private int golSquadraDiCasa;
	private int golSquadraInTrasferta;
	
	public PartitaDiCalcio() {
	}
	
	public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			int numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraInTrasferta, String squadraVincente,
			int golSquadraDiCasa, int golSquadraInTrasferta) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.squadraDiCasa = squadraDiCasa;
		this.squadraInTrasferta = squadraInTrasferta;
		this.squadraVincente = squadraVincente;
		this.golSquadraDiCasa = golSquadraDiCasa;
		this.golSquadraInTrasferta = golSquadraInTrasferta;
	}

	public String getSquadraDiCasa() {
		return squadraDiCasa;
	}

	public void setSquadraDiCasa(String squadraDiCasa) {
		this.squadraDiCasa = squadraDiCasa;
	}

	public String getSquadraInTrasferta() {
		return squadraInTrasferta;
	}

	public void setSquadraInTrasferta(String squadraInTrasferta) {
		this.squadraInTrasferta = squadraInTrasferta;
	}

	public String getSquadraVincente() {
		return squadraVincente;
	}

	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}

	public int getGolSquadraDiCasa() {
		return golSquadraDiCasa;
	}

	public void setGolSquadraDiCasa(int golSquadraDiCasa) {
		this.golSquadraDiCasa = golSquadraDiCasa;
	}

	public int getGolSquadraInTrasferta() {
		return golSquadraInTrasferta;
	}

	public void setGolSquadraInTrasferta(int golSquadraInTrasferta) {
		this.golSquadraInTrasferta = golSquadraInTrasferta;
	}

	
}
