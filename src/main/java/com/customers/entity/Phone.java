package com.customers.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Phone implements Serializable {

	private static final long serialVersionUID = 5L;

	@Id
	@Column(name = "id_customer")
	private Long customerId;

	@Column(name = "phone")
	private String phone;

	public Phone() {
		super();
	}

	public Phone(Long customerId, String phone) {
		super();
		this.customerId = customerId;
		this.phone = phone;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
