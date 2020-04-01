package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Playlist {
	
	@Id
	private int id;
	private String nome;
	
	// mappedBy indica quale sia il nome della proprietà che è l'altro capo di questa associazione molti-molti
	@ManyToMany(mappedBy = "playlist")
	private List<Brano> brani;
	
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
	 * @return the brani
	 */
	public List<Brano> getBrani() {
		return brani;
	}
	/**
	 * @param brani the brani to set
	 */
	public void setBrani(List<Brano> brani) {
		this.brani = brani;
	}
	
	

}
