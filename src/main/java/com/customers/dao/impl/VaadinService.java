package com.customers.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.customers.dao.CustomerDao;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@UIScope
@SpringComponent
public class VaadinService {

	@Autowired
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}
}
