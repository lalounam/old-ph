package com.customers.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.customers.dao.CustomerDao;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;

@UIScope
@SpringComponent
public class PersistenceVaadinService {

	@Autowired
	private CustomerDao customerDao;

	public CustomerDao getCustomerDao() {
		return customerDao;
	}
}
