package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Corso {
	// chiave, titolo, descrizione, data inizio, data fine, 
	// monte ore, elenco studenti iscritti, elenco lezioni
	@Id
	@Column(length = 20)
	private String codiceCorso;
	@Column(nullable = false, length = 100)
	private String titolo;
	private String descrizione;
	
	@Temporal(TemporalType.DATE)
	private Date dataInizio;
	@Temporal(TemporalType.DATE)
	private Date dataFine;
	
	private Integer monteOre;
	
	@ManyToMany(mappedBy = "corsiFrequentati")
	private List<Studente> iscritti;
	@OneToMany(mappedBy = "corso")
	private List<Lezione> lezioni;
	
	/**
	 * @param codiceCorso
	 * @param titolo
	 * @param descrizione
	 * @param monteOre
	 */
	public Corso(String codiceCorso, String titolo, String descrizione, Integer monteOre) {
		this.codiceCorso = codiceCorso;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.monteOre = monteOre;
	}
	
	/**
	 * 
	 */
	public Corso() {
	}

	/**
	 * @return the codiceCorso
	 */
	public String getCodiceCorso() {
		return codiceCorso;
	}
	/**
	 * @param codiceCorso the codiceCorso to set
	 */
	public void setCodiceCorso(String codiceCorso) {
		this.codiceCorso = codiceCorso;
	}
	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}
	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	/**
	 * @return the descrizione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	/**
	 * @return the dataInizio
	 */
	public Date getDataInizio() {
		return dataInizio;
	}
	/**
	 * @param dataInizio the dataInizio to set
	 */
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	/**
	 * @return the dataFine
	 */
	public Date getDataFine() {
		return dataFine;
	}
	/**
	 * @param dataFine the dataFine to set
	 */
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	/**
	 * @return the monteOre
	 */
	public Integer getMonteOre() {
		return monteOre;
	}
	/**
	 * @param monteOre the monteOre to set
	 */
	public void setMonteOre(Integer monteOre) {
		this.monteOre = monteOre;
	}
	/**
	 * @return the iscritti
	 */
	public List<Studente> getIscritti() {
		return iscritti;
	}
	/**
	 * @param iscritti the iscritti to set
	 */
	public void setIscritti(List<Studente> iscritti) {
		this.iscritti = iscritti;
	}
	/**
	 * @return the lezioni
	 */
	public List<Lezione> getLezioni() {
		return lezioni;
	}
	/**
	 * @param lezioni the lezioni to set
	 */
	public void setLezioni(List<Lezione> lezioni) {
		this.lezioni = lezioni;
	}
	@Override
	public String toString() {
		return "Corso [codiceCorso=" + codiceCorso + ", titolo=" + titolo + ", descrizione=" + descrizione
				+ ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", monteOre=" + monteOre + "]";
	}	
}
