package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Lezione {
	
	// corso, data, argomento, note, presenze studenti
	
	// dato che la lezione non ha una chiave naturale, uso una chiave surrogata
	// l'id che imposto come auto-incrementante => @GeneratedValue
	// @GeneratedValue dice che il valore del campo sarà generato dal DB, ma non ci dice come
	// noi vorremmo dire al DB di generare numeri in sequenza => strategy
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// per i tipi data devo specificare quale parte della data voglio salvare sul DB
	@Temporal(TemporalType.DATE)
	private Date dataLezione;
	@Column(length = 200)
	private String argomento;
	private String note;
	
	@ManyToOne
	private Corso corso;
	@ManyToMany
	private List<Studente> presenze;
	
	/**
	 * @param argomento
	 * @param note
	 */
	public Lezione(String argomento, String note) {
		this.argomento = argomento;
		this.note = note;
	}

	/**
	 * 
	 */
	public Lezione() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the dataLezione
	 */
	public Date getDataLezione() {
		return dataLezione;
	}
	/**
	 * @param dataLezione the dataLezione to set
	 */
	public void setDataLezione(Date dataLezione) {
		this.dataLezione = dataLezione;
	}
	/**
	 * @return the argomento
	 */
	public String getArgomento() {
		return argomento;
	}
	/**
	 * @param argomento the argomento to set
	 */
	public void setArgomento(String argomento) {
		this.argomento = argomento;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the corso
	 */
	public Corso getCorso() {
		return corso;
	}
	/**
	 * @param corso the corso to set
	 */
	public void setCorso(Corso corso) {
		this.corso = corso;
	}
	/**
	 * @return the presenze
	 */
	public List<Studente> getPresenze() {
		return presenze;
	}
	/**
	 * @param presenze the presenze to set
	 */
	public void setPresenze(List<Studente> presenze) {
		this.presenze = presenze;
	}

	@Override
	public String toString() {
		return "Lezione [id=" + id + ", dataLezione=" + dataLezione + ", argomento=" + argomento + ", note=" + note
				+ "]";
	}
	
}
