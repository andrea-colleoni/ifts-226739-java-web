package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Brano {
	
	@Id
	private int id;
	private String titolo;
	private String autore;
	private String genere;
	private float durataInMinuti;
	
	@ManyToMany
	private List<Playlist> playlist;
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the autore
	 */
	public String getAutore() {
		return autore;
	}
	/**
	 * @param autore the autore to set
	 */
	public void setAutore(String autore) {
		this.autore = autore;
	}
	/**
	 * @return the genere
	 */
	public String getGenere() {
		return genere;
	}
	/**
	 * @param genere the genere to set
	 */
	public void setGenere(String genere) {
		this.genere = genere;
	}
	/**
	 * @return the durataInMinuti
	 */
	public float getDurataInMinuti() {
		return durataInMinuti;
	}
	/**
	 * @param durataInMinuti the durataInMinuti to set
	 */
	public void setDurataInMinuti(float durataInMinuti) {
		this.durataInMinuti = durataInMinuti;
	}
	/**
	 * @return the playlist
	 */
	public List<Playlist> getPlaylist() {
		return playlist;
	}
	/**
	 * @param playlist the playlist to set
	 */
	public void setPlaylist(List<Playlist> playlist) {
		this.playlist = playlist;
	}

	
}
