package com.DemoMVC.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.DemoMVC.dao.CustomerDao;
import com.DemoMVC.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;
	
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	@Transactional
	public void addCustomer(Customer customer) {
		this.customerDao.addCustomer(customer);
	}

	@Transactional	
	public void updateCustomer(Customer customer) {
		this.customerDao.updateCustomer(customer);		
	}
	
	@Transactional
	public List<Customer> listCustomers() {
		return this.customerDao.listCustomers();
	}

	@Transactional
	public Customer getCustomerById(int id) {
		return this.customerDao.getCustomerById(id);
	}

	@Transactional
	public void removeCustomer(int id) {
		this.customerDao.removeCustomer(id);
	}

}
