package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject the customer dao
	// here we just have the CustomerDAO which is an interface but why not the Implementation?
	// the answer for that is that we added the @Repository in the CusotmerDAOImpl so that spring will 
	// scan and look for the CustomerDAO implementation and autowire the implementation in here
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@GetMapping("/list ")
	public String listCustomer(Model theModel) {
		
		// get customers from the dao
		
		List<Customer> theCustomers = customerDAO.getCustomers();
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		
		return "list-customers";
	}
		
	

}
