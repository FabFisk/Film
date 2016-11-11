package it.alfasoft.fabrizio.utility;
 
import it.alfasoft.fabrizio.bean.Film;
import it.alfasoft.fabrizio.controller.FilmController;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
 
@ManagedBean(name="dtEditView")
@SessionScoped
public class EditView implements Serializable {
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Film> list;
	      
    @ManagedProperty("#{filmControl}")
    private FilmController filmCon;
      
    @PostConstruct
    public void init() {
    	list = filmCon.getFilms();
    }
    
    public List<Film> getFilms() {
 		return list;
 	}

 	public void setFilms(List<Film> films) {
 		this.list = films;
 	}

 	public FilmController getFilmCon() {
 		return filmCon;
 	}

 	public void setFilmCon(FilmController filmCon) {
 		this.filmCon = filmCon;
 	}
 	
 	public static long getSerialversionuid() {
 		return serialVersionUID;
 	}    
    
    public List<String> getGeneri() {
        return filmCon.getGeneri();
    }
     
 	public void onRowEdit(RowEditEvent event) {
 		filmCon.updateFilm((Film) event.getObject());
        FacesMessage msg = new FacesMessage("Film Modificato", ((Film) event.getObject()).getTitolo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Modifica Annullata", ((Film) event.getObject()).getTitolo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
//    public void onCellEdit(CellEditEvent event) {
//        Object oldValue = event.getOldValue();
//        Object newValue = event.getNewValue();
//         
//        if(newValue != null && !newValue.equals(oldValue)) {
//            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
//            FacesContext.getCurrentInstance().addMessage(null, msg);
//        }
//    }
}