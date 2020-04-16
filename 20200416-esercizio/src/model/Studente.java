package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Studente {
	// chiave (email), nome, cognome, numero di telefono, elenco corsi a cui partecipa
	
	@Id
	// @Id => è già implicitamente non nullable perché nei DB le chiavi non possono essere nullable
	@Column(length = 100)
	private String email;
	// nullable = false => il campo diventa obbligatorio (non lo posso lasciare a null)
	@Column(nullable = false, length = 50)
	private String nome;
	@Column(nullable = false, length = 50)
	private String cognome;
	
	@Column(length = 30)
	private String numeroTelefono;
	
	@ManyToMany
	private List<Corso> corsiFrequentati;
	@ManyToMany(mappedBy = "presenze")
	private List<Lezione> presenze;

	/**
	 * @param email
	 * @param nome
	 * @param cognome
	 * @param numeroTelefono
	 */
	public Studente(String email, String nome, String cognome, String numeroTelefono) {
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.numeroTelefono = numeroTelefono;
	}

	/**
	 * 
	 */
	public Studente() {
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the cognome
	 */
	public String getCognome() {
		return cognome;
	}

	/**
	 * @param cognome the cognome to set
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	/**
	 * @return the numeroTelefono
	 */
	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	/**
	 * @param numeroTelefono the numeroTelefono to set
	 */
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	/**
	 * @return the corsiFrequentati
	 */
	public List<Corso> getCorsiFrequentati() {
		return corsiFrequentati;
	}

	/**
	 * @param corsiFrequentati the corsiFrequentati to set
	 */
	public void setCorsiFrequentati(List<Corso> corsiFrequentati) {
		this.corsiFrequentati = corsiFrequentati;
	}

	/**
	 * @return the presenze
	 */
	public List<Lezione> getPresenze() {
		return presenze;
	}

	/**
	 * @param presenze the presenze to set
	 */
	public void setPresenze(List<Lezione> presenze) {
		this.presenze = presenze;
	}

	@Override
	public String toString() {
		return "Studente [email=" + email + ", nome=" + nome + ", cognome=" + cognome + ", numeroTelefono="
				+ numeroTelefono + "]";
	}
	
	

}
