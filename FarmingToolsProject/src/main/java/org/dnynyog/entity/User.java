package org.dnynyog.entity;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
@Component
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(updatable = true,insertable = true,nullable = false)
	private String firstName;
	@Column(updatable = true,insertable = true,nullable = false)
	private String lastName;
	@Column(updatable = true,insertable = true,nullable = false)
	private String email;
	@Column(updatable = true,insertable = true,nullable = false)
	private String password;
	@Column(insertable = true,nullable = false)
	private int pincode;
	@Column(insertable = true,nullable = false)
	private long mobileno;

	public static  User getInstance()
	{
		return new User();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;

	}

	public int getPincode() {
		return pincode;
	}

	public User setPincode(int pincode) {
		this.pincode = pincode;
		return this;
	}

	public long getMobileno() {
		return mobileno;
	}

	public User setMobileno(long mobileno) {
		this.mobileno = mobileno;
		return this;
	}

	
	
}
