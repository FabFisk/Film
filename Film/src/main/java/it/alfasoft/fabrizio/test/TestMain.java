package it.alfasoft.fabrizio.test;

import it.alfasoft.fabrizio.bean.Film;
import it.alfasoft.fabrizio.service.Gestione;

public class TestMain {

	public static void main(String[] args) {
		
		Gestione g = new Gestione();
		Film f = new Film();
		f.setTitolo("Pulp Fiction");
		f.setRegista("Quentin Tarantino");
		f.setAnno("1994");
		f.setGenere("Pulp");
		f.setCodFilm("Prova1");
		
		g.createFilm(f);
	
	}

}
