package com.sleepy.RestServices.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue
	private long id;
	
	@NotEmpty(message="UserName cant be empty")
	@Column(name="USER_NAME", nullable= false, length=200)
	private String name;
	
	@Column(name="EMAIL_ID", unique=true ,nullable= false, length=200)
	private String email;
	@Column(name="ROLE", nullable= false, length=200)
	private String role;
	@Length(min=5,message="SSN should be of length more than 1")
	@Column(name="SSN", nullable= false, length=200, unique=true)
	private String ssn;
	
	public User() {
		//super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}
	
	
}
