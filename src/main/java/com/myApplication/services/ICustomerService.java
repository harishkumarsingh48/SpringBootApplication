package com.myApplication.services;

import java.util.List;

import com.myApplication.dto.Customer;

public interface ICustomerService {

	public Customer createCustomer(Customer customer);

	public Customer findByloginIdAndloginPassword(String loginId, String password);

	public List<Customer> getAllCustomer();

	public Customer getSingleCustomer(Long id);

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomerById(Long id);

}
