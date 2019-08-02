package com.myApplication.controllers;


import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myApplication.constants.ApplicationConstant;
import com.myApplication.dto.Customer;
import com.myApplication.exception.UserNotFoundException;
import com.myApplication.services.CustomerServiceImpl;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(ApplicationConstant.CONTEXT_API)
// netstat -a -n -o | find "8080"
// taskkill /F /PID 15776
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@GetMapping(ApplicationConstant.GET_ALL_CUSTOMER_API)
	public List<Customer> getAllcustomer() {
		List<Customer> customerList = customerServiceImpl.getAllCustomer();
		return customerList;
	}
	
	@PostMapping(ApplicationConstant.CUSTOMER_REGISTATION_API)
	public Customer registercustomer(@RequestBody Customer customer) {
		return  customerServiceImpl.createCustomer(customer);
	}

	@PostMapping(ApplicationConstant.CUSTOMER_LOGIN_API)
	public Customer logincustomer(@RequestBody Customer reqCustomer) {
		System.out.println("login id==="+reqCustomer.getLoginId() +"  login Password==="+reqCustomer.getLoginPassword());
		Customer resCustomer=customerServiceImpl.findByloginIdAndloginPassword(reqCustomer.getLoginId(), reqCustomer.getLoginPassword());
		if(resCustomer==null)
			throw new UserNotFoundException("login id==="+reqCustomer.getLoginId());
		return resCustomer;
	}

	@GetMapping(ApplicationConstant.GET_SINGLE_CUSTOMER_API)
	public Resource<Customer> getSinglecustomer(@PathVariable("customerId") long customerId) {
		Customer resCustomer= customerServiceImpl.getSingleCustomer(customerId);
		Resource<Customer> resource= new Resource<Customer>(resCustomer);
		Link allCustomerLink = ControllerLinkBuilder
		                .linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllcustomer())
		                .withRel("All-users");
		resource.add(allCustomerLink);
		if(resCustomer==null)
			throw new UserNotFoundException("customer Id==="+customerId+ "not found");
		return resource;
	}

	

	@PutMapping(ApplicationConstant.UPDAT_CUSTOMER_API)
	public Customer updatecustomer(@RequestBody Customer currentcustomer) {
		return customerServiceImpl.updateCustomer(currentcustomer);
	}

	@DeleteMapping(ApplicationConstant.DELETE_CUSTOMER_API)
	public Customer deletecustomer(@PathVariable("customerId") long customerId) {
		Customer resCustomer= customerServiceImpl.getSingleCustomer(customerId);
		if(resCustomer==null)
			throw new UserNotFoundException("customer Id==="+customerId+ "not found");
		return resCustomer;

	}

	

    private String getAccessToken(HttpServletRequest request) {
    	String accessToken=request.getRequestedSessionId();
    	System.out.println(accessToken);
        return accessToken;
        
    }

    
}
