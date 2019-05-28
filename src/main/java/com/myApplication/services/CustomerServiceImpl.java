package com.myApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myApplication.dao.CustomerDaoImpl;
import com.myApplication.dto.Customer;


@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerDaoImpl customerDao;

	public Customer createCustomer(Customer customer) 
	{
		return customerDao.createCustomer(customer);
	}

	public Customer findByloginIdAndloginPassword(String loginId, String password)
	{
		return customerDao.findByloginIdAndloginPassword(loginId, password);
	}

	public List<Customer> getAllCustomer()
	{
		return customerDao.getAllCustomer();
	}

	public Customer getSingleCustomer(Long customerId)
	{
		return customerDao.getSingleCustomer(customerId);
	}

	public Customer updateCustomer(Customer customer)
	{
		return customerDao.updateCustomer(customer);
	}

	public Customer deleteCustomerById(Long customerId)
	{
		return customerDao.deleteCustomerById(customerId);
	}
	/*@Transactional
	public Customer createCustomer(Customer Customer) {
		customerDao.save(Customer);
		return Customer;
	}

	@Transactional
	public Customer findByloginIdAndloginPassword(String loginId, String password) {
		return customerDao.findByloginIdAndloginPassword(loginId, password);
	}

	@Transactional
	public List<Customer> getAllCustomer() {
		return customerDao.findAll();
	}

	@Transactional
	public Customer getSingleCustomer(Long id) {
		Optional<Customer> Customer = customerDao.findById(id);
		return Customer.get();
	}

	@Transactional
	public Customer updateCustomer(Customer Customer) {
		customerDao.save(Customer);
		return Customer;
	}
	
	@Transactional
	public Customer deleteCustomerById(Long id) {
		Optional<Customer> Customer = customerDao.findById(id);
		customerDao.deleteById(id);
		return Customer.get();
	}
*/
	
}
