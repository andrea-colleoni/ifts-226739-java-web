package ifts.webdeveloper.springbootrestapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Autore {
	
	@Id
	private String email;
	private String nome;
	private String cognome;

	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Libro> libri;


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
	 * @return the libri
	 */
	public List<Libro> getLibri() {
		return libri;
	}


	/**
	 * @param libri the libri to set
	 */
	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}

}
