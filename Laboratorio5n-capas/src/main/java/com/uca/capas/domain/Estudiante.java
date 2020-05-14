package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(schema="public",name="estudiante")
public class Estudiante {
	
	@Id
	@Column(name="c_usuario")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer codigoEstudiante;
	
	@Size(message="El nombre no debe tener mas de 50 caracteres", max=50)
	@NotEmpty(message="No puede estar vacio")
	@Column(name="nombre")
	private String nombre;
	
	@Size(message="El apellido no debe tener mas de 50 caracteres", max=50)
	@NotEmpty(message="No puede estar vacio")
	@Column(name="apellido")
	private String apellido;
	
	@Size(message="El nombre no debe tener mas de 10 caracteres", max=10)
	@NotEmpty(message="No puede estar vacio")
	@Column(name="carne")
	private	String carne;
	
	@Size(message="El nombre no debe tener mas de 100 caracteres", max=100)
	@NotEmpty(message="No puede estar vacio")
	@Column(name="carrera")
	private String carrera;
	
	
	public Estudiante() {
		
	}

	public Integer getCodigoEstudiante() {
		return codigoEstudiante;
	}

	public void setCodigoEstudiante(Integer codigoEstudiante) {
		this.codigoEstudiante = codigoEstudiante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCarne() {
		return carne;
	}

	public void setCarne(String carne) {
		this.carne = carne;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	
	

}
