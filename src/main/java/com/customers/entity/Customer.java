package com.customers.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 2L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_customer")
	private Long customerId;

	@Column(name = "name")
	private String name;

	@ManyToOne(targetEntity = Status.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_status")
	private Status status;

	/**
	 * ONE to ONE
	 */

	@OneToOne(targetEntity = Email.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_customer")
	private Email email;

	@OneToOne(targetEntity = Phone.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_customer")
	private Phone phone;

	@OneToOne(targetEntity = Address.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_customer")
	private Address address;

	/**
	 * ONE to MANY
	 */

	@OneToMany(targetEntity = Note.class, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "id_customer")
	private List<Note> notes;

	public Customer() {
		super();
	}

	// Minimum Constructor
	public Customer(Long customerId, String name, Status status) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.status = status;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
}
