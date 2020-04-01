package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contatto {
	
	// uso il pattern di encapsulation
	// => JavaBean: campi privati, getter e setters, costruttore vuoto
	// aggiungo anche altri metodi utili: costruttore con campi, toString
	
	private String nome;
	private String cognome;
	@Id
	private String email;
	private String numeroTelefono;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascita;
	
	public Contatto() {
	}

	public Contatto(String nome, String cognome, String email, String numeroTelefono, Date dataNascita) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.numeroTelefono = numeroTelefono;
		this.dataNascita = dataNascita;
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
	 * @return the dataNascita
	 */
	public Date getDataNascita() {
		return dataNascita;
	}
	/**
	 * @param dataNascita the dataNascita to set
	 */
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Contatto [nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", numeroTelefono="
				+ numeroTelefono + ", dataNascita=" + dataNascita + "]";
	}
	
}
