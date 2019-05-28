package com.myApplication;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myApplication.dto.Customer;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		/*Customer customer=new Customer();
		customer.setCreatedBy(new Long(1));
		customer.setCreatedOn(new Timestamp( new Date().getTime()));
		customer.setCurrentFlag("A");
		customer.setDateOfBirth(new Timestamp( new Date().getTime()));
		customer.setEmailAddress("harish.singh@gmail.com");
		customer.setFirstName("Harish");
		customer.setLastName("Singh");
		customer.setLoginId("harish");
		customer.setLoginPassword("harish");
		customer.setMiddleName("Kumar");
		customer.setModifiedBy(new Long(0));
		customer.setModifiedOn(new Timestamp( new Date().getTime()));
		customer.setRole("ADMIN");
		customer.setStatus("A");
		ObjectMapper mapperObj = new ObjectMapper();
		try {
            // get Employee object as a json string
            String jsonStr = mapperObj.writeValueAsString(customer);
            System.out.println(jsonStr);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
	}
}
