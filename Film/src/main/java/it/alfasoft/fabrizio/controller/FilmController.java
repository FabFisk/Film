package it.alfasoft.fabrizio.controller;

import it.alfasoft.fabrizio.bean.Film;
import it.alfasoft.fabrizio.service.Gestione;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name="filmControl", eager=true)
@SessionScoped
public class FilmController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Gestione g;
	private List<Film> films;
	
	public FilmController (){
		g = new Gestione();
	}
	
	public Gestione getG() {
		return g;
	}

	public void setG(Gestione g) {
		this.g = g;
	}
	
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String createFilm(Film f){
		if(g.createFilm(f)){
			return "form?faces-redirect=true";
		}
		return "form";
	}
		
	public void updateList(){
		this.setFilms(g.getAll());
	}
	
	public String editFilm(Film f){	
		Film f1 = g.redFilm(f.getId());
		ExternalContext exContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = exContext.getRequestMap();
		requestMap.put("film", f1);
		return "edit";
	}	
	public String deleteFilm(long id){
		g.deleteFilm(id);
		return "table.xhtml?faces-redirect=true";
		
	}
	public String updateFilm(Film f){
		g.updateFilm(f);		
		return "table?faces-redirect=true";		
	}

}
