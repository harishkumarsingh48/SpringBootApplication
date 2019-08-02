package com.myApplication.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myApplication.dto.Customer;

//@Repository
//public interface   CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> { 
//@Query("select employee from Employee where employee.loginId = :loginId and employee.loginPassword=:loginPassword")	Customer findByloginIdAndloginPassword(@Param("loginId") String loginId,@Param("loginPassword") String loginPassword);
@Service
public class CustomerDaoImpl implements ICustomerDao{
	
	private static LinkedHashMap<Long, Customer> cutomerLinkedHashMap=new LinkedHashMap<Long, Customer>();
	
	
	
	public Customer createCustomer(Customer customer)
	{
		Long sequennce=generateSequence();
		customer.setCustomerId(sequennce);
		customer.setModifiedBy(sequennce);
		customer.setCreatedBy(sequennce);
		cutomerLinkedHashMap.put(sequennce, customer);
		return customer;
	}

	public Customer findByloginIdAndloginPassword(String loginId, String password)
	{
		System.out.println("login id==="+loginId +"  login Password==="+password);
		Customer customer=null;
		for (Map.Entry<Long,Customer> entry : cutomerLinkedHashMap.entrySet())  
		{
			Customer cust=entry.getValue();
			if(cust.getLoginId().equals(loginId) && cust.getLoginPassword().equals(password) )
				customer=cust;
		} 
		return customer;
	}

	public List<Customer> getAllCustomer()
	{
		return new ArrayList<Customer>(cutomerLinkedHashMap.values());
		
	}

	public Customer getSingleCustomer(Long customerId)
	{
		Customer customer=null;
		customer= cutomerLinkedHashMap.get(customerId);
		return customer;
	}

	public Customer updateCustomer(Customer customer)
	{
		cutomerLinkedHashMap.replace(customer.getCustomerId(), customer);
		return customer;
	}

	public Customer deleteCustomerById(Long customerId)
	{
		Customer customer=null;
		customer=cutomerLinkedHashMap.get(customerId);
		cutomerLinkedHashMap.remove(customerId);
		return customer;
	}
	private static Long generateSequence()
	{
		Long newSequence=new Long(1);
		if(cutomerLinkedHashMap.size()>0)
		{
			Map<Long, Customer> sortedMap = new LinkedHashMap<Long, Customer>();
			cutomerLinkedHashMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
	                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
			newSequence=new Long(cutomerLinkedHashMap.size()+1);
		}
		
		return newSequence;
	}
	
	
	
	static {
		try {

			Long customerId=generateSequence();
			Customer customer1=new Customer();
			customer1.setCustomerId(customerId);
			customer1.setFullName("Harish Kumar Singh");
			customer1.setVillage("Dariyapur");
			customer1.setPostOffice("Ara");
			customer1.setPoliceStation("Udwant Nagar");
			customer1.setCountryName("India");
			customer1.setStateName("Bihar");
			customer1.setDistrictName("Bhojpur");
			customer1.setEmail("harish@gmail.com");
			customer1.setMobileNo("9868006903");
			customer1.setLoginId("harish");
			customer1.setLoginPassword("harish");
			customer1.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1980"));
			customer1.setGender("Male");
			ArrayList<String> hobies=new ArrayList<String>();
			hobies.add("Reading books");
			hobies.add("Watching movies");
			customer1.setHobies(hobies);
			customer1.setEducation("Post Graduate");
			customer1.setComment("I am a good boy.");
			customer1.setRole("A");
			customer1.setStatus("A");
			customer1.setCreatedBy(customerId);
			customer1.setCreatedOn(new Date());
			customer1.setModifiedBy(customerId);
			customer1.setModifiedOn(new Date());
			cutomerLinkedHashMap.put(customer1.getCustomerId(), customer1);
			
			
			customerId=generateSequence();
			Customer customer2=new Customer();
			customer2.setCustomerId(customerId);
			customer2.setFullName("Priyanka Kumari");
			customer2.setVillage("Dariyapur");
			customer2.setPostOffice("Ara");
			customer2.setPoliceStation("Udwant Nagar");
			customer2.setCountryName("India");
			customer2.setStateName("Bihar");
			customer2.setDistrictName("Bhojpur");
			customer2.setEmail("harish@gmail.com");
			customer2.setMobileNo("9868006903");
			customer2.setLoginId("priyanka");
			customer2.setLoginPassword("priyanka");
			customer2.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1982"));
			customer2.setGender("Female");
			hobies=new ArrayList<String>();
			hobies.add("Reading books");
			hobies.add("Watching movies");
			customer2.setHobies(hobies);
			customer2.setEducation("Post Graduate");
			customer2.setComment("I am a good boy.");
			customer2.setRole("E");
			customer2.setStatus("A");
			customer2.setCreatedBy(customerId);
			customer2.setCreatedOn(new Date());
			customer2.setModifiedBy(customerId);
			customer2.setModifiedOn(new Date());
			cutomerLinkedHashMap.put(customer2.getCustomerId(), customer2);
			
			customerId=generateSequence();
			Customer customer3=new Customer();
			customer3.setCustomerId(customerId);
			customer3.setFullName("Samyak Singh Sidhartha");
			customer3.setVillage("Dariyapur");
			customer3.setPostOffice("Ara");
			customer3.setPoliceStation("Udwant Nagar");
			customer3.setCountryName("India");
			customer3.setStateName("Bihar");
			customer3.setDistrictName("Bhojpur");
			customer3.setEmail("harish@gmail.com");
			customer3.setMobileNo("9868006903");
			customer3.setLoginId("samyak");
			customer3.setLoginPassword("samyak");
			customer3.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2014"));
			customer3.setGender("Male");
			hobies=new ArrayList<String>();
			hobies.add("Reading books");
			hobies.add("Watching movies");
			customer3.setHobies(hobies);
			customer3.setEducation("Post Graduate");
			customer3.setComment("I am a good boy.");
			customer3.setRole("E");
			customer3.setStatus("A");
			customer3.setCreatedBy(customerId);
			customer3.setCreatedOn(new Date());
			customer3.setModifiedBy(customerId);
			customer3.setModifiedOn(new Date());
			cutomerLinkedHashMap.put(customer3.getCustomerId(), customer3);
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
