package com.peru21.apirest.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "persons")
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "El campo esta vacio")
	@Size(min = 5, message = "El campo minimo es 5")
	@Column(nullable = false)
	private String firstName;

	@NotEmpty(message = "El campo esta vacio")
	@Size(min = 5, message = "El campo minimo es 5")
	@Column(nullable = false)
	private String lastName;

	@NotEmpty(message = "El campo esta vacio")
	@Size(min = 8, max = 8, message = "El DNI requiere 8 digitos")
	@Column(nullable = false, length = 8)
	private String dni;

	@NotNull(message = "Seleccione su fecha de nacimiento")
	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String address;

	@NotEmpty(message = "El campo esta vacio")
	@Email(message = "El email no tiene un formato correcto.")
	@Size(min = 5, message = "El campo minimo es 5")
	@Column(nullable = false, unique = true)
	private String email;

	private String phone;

	@NotNull(message = "Usted debe seleccionar un distrito")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDistrict")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private District district;

	@NotNull(message = "Usted debe seleccionar un Sexo")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idSex")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Sex sex;

	@NotNull(message = "Usted debe seleccionar un Estado Civil")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCivilStatus")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private CivilStatus civilStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "person", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	private Student student;

	@OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = { "person", "hibernateLazyInitializer", "handler" }, allowSetters = true)
	private Users user;


	@PrePersist
	public void prePersist() {
		createDate = new Date();
		user = new Users(this.getDni().toString(), this.getDni(), true);
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public CivilStatus getCivilStatus() {
		return civilStatus;
	}

	public void setCivilStatus(CivilStatus civilStatus) {
		this.civilStatus = civilStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	private static final long serialVersionUID = 1L;

}
