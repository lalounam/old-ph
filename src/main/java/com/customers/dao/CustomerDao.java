package com.customers.dao;

import java.util.List;

import com.customers.entity.Customer;
import com.customers.entity.Status;

public interface CustomerDao {

	public Customer findCustomerById(Long customerId);

	public List<Customer> findAll(String criteria);

	public List<Status> findAll();

}
