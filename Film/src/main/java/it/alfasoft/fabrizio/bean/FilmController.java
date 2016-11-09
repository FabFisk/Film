package it.alfasoft.fabrizio.bean;

import it.alfasoft.fabrizio.service.Gestione;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ManagedBean(name="filmControl", eager=true)
public class FilmController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Gestione g;
	private List<Film> film;
	
	public FilmController (){
		g = new Gestione();
	}
	
	public Gestione getG() {
		return g;
	}

	public void setG(Gestione g) {
		this.g = g;
	}
	
	public List<Film> getFilm() {
		return film;
	}

	public void setFilm(List<Film> film) {
		this.film = film;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Film> updateList(){
		this.setFilm(g.getAll());
		return film;
	}
	
	

}
