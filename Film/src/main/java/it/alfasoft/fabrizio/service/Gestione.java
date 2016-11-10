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

	public Film redFilm(long id) {
		return fDAO.read(id);
	}

	public boolean deleteFilm(long id) {
		Film f = fDAO.read(id);
		return fDAO.delete(f);
	}

	public void updateFilm(Film f) {
		fDAO.update(f);
	}


}
