package com.customers.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Email implements Serializable {

	private static final long serialVersionUID = 4L;

	@Id
	@Column(name = "id_customer")
	private Long customerId;

	@Column(name = "email")
	private String email;

	public Email() {
		super();
	}

	public Email(Long customerId, String email) {
		super();
		this.customerId = customerId;
		this.email = email;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
