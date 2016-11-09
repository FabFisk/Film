package it.alfasoft.fabrizio.service;

import it.alfasoft.fabrizio.DAO.FilmDAO;
import it.alfasoft.fabrizio.bean.Film;

import java.util.List;

public class Gestione {

	private FilmDAO fDAO;
	
	public Gestione(){
		fDAO = new FilmDAO();
	}
	
	public List<Film> getAll() {
		return fDAO.getAll();
	}
	
	public boolean createFilm(Film f) {
		return fDAO.create(f);
	}

	public void editFilm(long id) {
		Film f = fDAO.read(id);
		fDAO.update(f);		
	}

	public void deleteFilm(long id) {
		Film f = fDAO.read(id);
		fDAO.delete(f);
	}
}
