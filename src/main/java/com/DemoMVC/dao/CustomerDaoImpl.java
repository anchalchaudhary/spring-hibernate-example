package com.DemoMVC.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.DemoMVC.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(customer);
		logger.info("Customer saved successfully, Customer Details="+customer);
	}

	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(customer);
		logger.info("Customer updated successfully, Customer Details="+customer);
	}

	@SuppressWarnings("unchecked")
	public List<Customer> listCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customersList = session.createQuery("from Customer").list();
		for(Customer customer : customersList){
			logger.info("Customer List::"+customer);
		}
		return customersList;
	}

	public Customer getCustomerById(int customerId) {
		Session session = this.sessionFactory.getCurrentSession();		
		Customer customer = (Customer) session.load(Customer.class, new Integer(customerId));
		logger.info("Customer details: "+customer);
		return customer;
	}

	public void removeCustomer(int customerId) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.load(Customer.class, new Integer(customerId));
		if(null != customer){
			session.delete(customer);
		}
		logger.info("Customer Deleted: "+customer);		
	}

}