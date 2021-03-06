package com.DemoMVC.service;

import java.util.List;

import com.DemoMVC.model.Customer;

public interface CustomerService {

	public void addCustomer(Customer p);
	public void updateCustomer(Customer p);
	public List<Customer> listCustomers();
	public Customer getCustomerById(int id);
	public void removeCustomer(int id);
}
