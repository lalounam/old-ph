package com.customers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.customers.config.PersistenceJPAConfig;
import com.customers.dao.CustomerDao;
import com.customers.entity.Customer;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { PersistenceJPAConfig.class }, loader = AnnotationConfigContextLoader.class)
public class CustomerTest extends TestCase {

	@Autowired
	private CustomerDao customerDao;

	@Test
	public void exists() {
		final Customer customer = this.customerDao.findCustomerById(1L);
		assertNotNull(customer);
	}

	@Test
	public void relationship() {
		final Customer customer = this.customerDao.findCustomerById(1L);
		assertNotNull(customer.getStatus());
		assertNotNull(customer.getEmail());
		assertNotNull(customer.getPhone());
		assertNotNull(customer.getAddress());
		assertNotNull(customer.getNotes());
	}

	@Test
	public void notes() {
		final Customer customer = this.customerDao.findCustomerById(1L);
		assertEquals(0, customer.getNotes().size());
	}
}
