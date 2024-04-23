package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ciudad")
public class Ciudad {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idCiudad")
	private int idCiudad;
	
	@Column(name = "nomCiudad")
	private String nomCiudad;
	
	@Column(name = "habitantes")
	private int habitantes;

	public Ciudad() {
		super();
	}

	public Ciudad(String nomCiudad, int habitantes) {
		super();
		this.nomCiudad = nomCiudad;
		this.habitantes = habitantes;
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNomCiudad() {
		return nomCiudad;
	}

	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}

	public int getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(int habitantes) {
		this.habitantes = habitantes;
	}
}
