package com.DemoMVC.dao;

import java.util.List;

import com.DemoMVC.model.Customer;

public interface CustomerDao {
	
	public void addCustomer(Customer p);
	public void updateCustomer(Customer p);
	public List<Customer> listCustomers();
	public Customer getCustomerById(int id);
	public void removeCustomer(int id);
}
