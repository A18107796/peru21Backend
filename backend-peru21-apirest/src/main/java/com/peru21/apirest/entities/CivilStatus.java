package com.peru21.apirest.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "civil_status")
public class CivilStatus implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "El campo esta vacio")
	@Size(min = 5, message = "El campo minimo es 5")
	@Column(nullable = false, unique = true)
	private String nameCivilStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameCivilStatus() {
		return nameCivilStatus;
	}

	public void setNameCivilStatus(String nameCivilStatus) {
		this.nameCivilStatus = nameCivilStatus;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
