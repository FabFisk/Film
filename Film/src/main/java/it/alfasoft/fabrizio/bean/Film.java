package it.alfasoft.fabrizio.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

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
	@Transient
	private List<String> generi;
	
	public Film (){
		generi = new ArrayList<String>();
		generi.add("");
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

	public String getCodFilm() {
		return codFilm;
	}

	public void setCodFilm(String codFilm) {
		this.codFilm = codFilm;
	}
	
	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
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
	
	public void validaCodice(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if (value == null) {
			return;
		}
		String dato = value.toString();
		if (!dato.startsWith("mov")) {
			FacesMessage msg = new FacesMessage("Codice errato!");
			throw new ValidatorException(msg);

		}
	}
}
