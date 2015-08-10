package com.cai.contact.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "CONTACTS")
public class Contact{

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	private Integer id;

	@Column(name = "FIRSTNAME")
	@NotEmpty(message = "{NotEmpty.Contact.firstname}")
	private String firstname;

	@Column(name = "LASTNAME")
	@NotEmpty(message = "{NotEmpty.Contact.lastname}")
	private String lastname;

	@Column(name = "EMAIL")
	//@Email
	private String email;

	@Column(name = "TELEPHONE")
	@NumberFormat
	private String telephone;

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPk() {
		return this.id;
	}
	

}
