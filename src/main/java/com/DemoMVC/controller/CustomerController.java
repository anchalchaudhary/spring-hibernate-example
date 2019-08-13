package com.DemoMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.DemoMVC.model.Customer;
import com.DemoMVC.service.CustomerService;

@Controller
public class CustomerController {
	
private CustomerService customerService;
	
	@Autowired(required=true)
	@Qualifier(value="customerService")
	public void setCustomerService(CustomerService customerService){
		this.customerService = customerService;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin(Model model) {
		
		return "login";
	}
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHome(Model model) {
		
		model.addAttribute("customer",new Customer());
		return "home";
	}
	
	@RequestMapping(value = "/addCustomerForm", method = RequestMethod.GET)
	public String showAddCustomerForm(Model model) {
		
		model.addAttribute("customer",new Customer());
		return "addNewCustomer";
	}
	
	@RequestMapping(value = "/listcustomer", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("listCustomers", this.customerService.listCustomers());
		return "listCustomer";
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@ModelAttribute("customer") Customer customer) {

		System.out.println(customer.getCustomerId());
		System.out.println(customer.getName());
		this.customerService.addCustomer(customer);

		return "redirect:/listcustomer";
	} 
	@RequestMapping("/remove/{customerId}")
    public String removeCustomer(@PathVariable("customerId") int customerId){
		
        this.customerService.removeCustomer(customerId);
        return "redirect:/listcustomer";
    }
 
    @RequestMapping("/edit/{customerId}")
    public String editCustomer(@PathVariable("customerId") int customerId, Model model){
        model.addAttribute("customer", this.customerService.getCustomerById(customerId));
        return "editCustomer";
    }
    
    @RequestMapping(value="edit/editCustomerDetails", method = RequestMethod.POST)
    public String editCustomerDetails(@ModelAttribute("customer") Customer customer){

		this.customerService.updateCustomer(customer);
        return "redirect:/listcustomer";
    }
} 
