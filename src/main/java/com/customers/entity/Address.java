package com.customers.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address implements Serializable {

	private static final long serialVersionUID = 6L;

	@Id
	@Column(name = "id_customer")
	private Long customerId;

	@Column(name = "address")
	private String address;

	public Address() {
		super();
	}

	public Address(Long customerId, String address) {
		super();
		this.customerId = customerId;
		this.address = address;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
