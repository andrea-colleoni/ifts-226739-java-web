package ifts.webdeveloper.springbootrestapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Genere {

	@Id
	private String nome;
	private String descrizione;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Libro> libri;

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
