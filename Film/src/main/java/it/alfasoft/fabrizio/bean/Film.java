package it.alfasoft.fabrizio.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ManagedBean(name="film", eager=true)
public class Film implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String titolo;
	private String anno;
	private String regista;
	private String genere;
	private String codFilm;
	private List<String> generi;
	
	public Film (){
		generi = new ArrayList<String>();
		generi.add("Horror");
		generi.add("Fantascienza");
		generi.add("Thriller");
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAnno() {
		return anno;
	}

	public void setAnno(String anno) {
		this.anno = anno;
	}

	public String getRegistra() {
		return regista;
	}

	public void setRegistra(String registra) {
		this.regista = registra;
	}

	public String getCodFilm() {
		return codFilm;
	}

	public void setCodFilm(String codFilm) {
		this.codFilm = codFilm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
