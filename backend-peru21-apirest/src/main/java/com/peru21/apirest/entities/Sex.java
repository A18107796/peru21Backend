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
@Table(name = "sexs")
public class Sex implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "El campo esta vacio")
	@Size(min = 5, message = "El campo minimo es 5")
	@Column(nullable = false, unique = true)
	private String nameSex;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameSex() {
		return nameSex;
	}

	public void setNameSex(String nameSex) {
		this.nameSex = nameSex;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
