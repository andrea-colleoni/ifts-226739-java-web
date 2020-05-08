package ifts.webdeveloper.springbootrestapi.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Libro {
	
	@Id
	private String isbn;
	private String titolo;
	private String descrizione;
	private int annoPubblicazione;
	private int numeroPagine;
	
	@ManyToMany(mappedBy = "libri", cascade = CascadeType.ALL)
	private List<Autore> autori;
	
	@ManyToMany(mappedBy = "libri", cascade = CascadeType.ALL)
	private List<Genere> generi;

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	 * @return the annoPubblicazione
	 */
	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	/**
	 * @param annoPubblicazione the annoPubblicazione to set
	 */
	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	/**
	 * @return the numeroPagine
	 */
	public int getNumeroPagine() {
		return numeroPagine;
	}

	/**
	 * @param numeroPagine the numeroPagine to set
	 */
	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
	}

	/**
	 * @return the autori
	 */
	public List<Autore> getAutori() {
		return autori;
	}

	/**
	 * @param autori the autori to set
	 */
	public void setAutori(List<Autore> autori) {
		this.autori = autori;
	}

	/**
	 * @return the generi
	 */
	public List<Genere> getGeneri() {
		return generi;
	}

	/**
	 * @param generi the generi to set
	 */
	public void setGeneri(List<Genere> generi) {
		this.generi = generi;
	}
	
	

}
