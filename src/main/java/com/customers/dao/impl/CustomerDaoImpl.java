package com.customers.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customers.dao.CustomerDao;
import com.customers.entity.Customer;
import com.customers.entity.repository.CustomerRepository;

@Service
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private CustomerRepository cr;

	public Customer findCustomerById(Long customerId) {
		return cr.getOne(customerId);
	}

}
