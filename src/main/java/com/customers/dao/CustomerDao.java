package com.customers.dao;

import com.customers.entity.Customer;

public interface CustomerDao {

	public Customer findCustomerById(Long customerId);

}
