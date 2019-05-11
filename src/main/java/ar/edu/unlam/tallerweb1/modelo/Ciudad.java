package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ciudad {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idCiudad;
	
	private String nombre;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Ubicacion ubicacionGeografica;
	
	@ManyToOne(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private Pais pais;
	
	
	public Long getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Ubicacion getUbicacionGeografica() {
		return ubicacionGeografica;
	}
	public void setUbicacionGeografica(Ubicacion ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	
}
