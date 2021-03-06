package it.alfasoft.fabrizio.controller;

import it.alfasoft.fabrizio.bean.Film;
import it.alfasoft.fabrizio.service.Gestione;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;

@ManagedBean(name="filmControl", eager=true)
@ViewScoped
public class FilmController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Gestione g;
	private List<Film> films;
	private List<String> generi;
	
	public FilmController (){
		g = new Gestione();
		generi = new ArrayList<String>();
		generi.add("");
		generi.add("Horror");
		generi.add("Fantascienza");
		generi.add("Thriller");
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

	public List<String> getGeneri() {
		return generi;
	}

	public void setGeneri(List<String> generi) {
		this.generi = generi;
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
		return "Table2.xhtml?faces-redirect=true";
		
	}
	public String updateFilm(Film f){
		g.updateFilm(f);		
		return "table?faces-redirect=true";		
	}
	
    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
 	public void onRowEdit(RowEditEvent event) {
 		this.updateFilm((Film) event.getObject());
        FacesMessage msg = new FacesMessage("Film Modificato", ((Film) event.getObject()).getTitolo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modifica Annullata", ((Film) event.getObject()).getTitolo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

}
