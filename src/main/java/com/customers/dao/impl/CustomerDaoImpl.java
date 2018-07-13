package com.customers.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customers.dao.CustomerDao;
import com.customers.entity.Customer;
import com.customers.entity.Status;
import com.customers.entity.repository.CustomerRepository;
import com.customers.entity.repository.StatusRepository;

@Service
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private CustomerRepository cr;
	@Autowired
	private StatusRepository sr;

	public Customer findCustomerById(Long customerId) {
		return cr.getOne(customerId);
	}

	public List<Customer> findAll(String criteria) {
		return cr.findAll();
	}

	public List<Status> findAll() {
		return sr.findAll();
	}
}
