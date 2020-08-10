package com.cts.customer;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.easymock.EasyMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.cts.customer.dao.CustomerDaoImpl;
import com.cts.customer.request.CustomerRequest;
import com.cts.customer.resource.CustomerResource;
import com.cts.customer.response.CustomerResponse;
import com.cts.customer.service.CustomerServiceImpl;

@SpringBootTest
class CustomersApiApplicationTests {

	CustomerResource resource;
	CustomerServiceImpl customerService;
	
	CustomerDaoImpl customerDao;
	CustomerRequest customerRequest;
	
	@BeforeEach
	public void setup() {
		
		resource = new CustomerResource();
		customerDao = EasyMock.createNiceMock(CustomerDaoImpl.class);
		customerService = new CustomerServiceImpl();
		customerService.setCustomerDao(customerDao);
		resource.setCustomerService(customerService);
	}
	
	@Test
	public void testBadRequestCreateCustomerBadRequest() {
		
		 ResponseEntity<CustomerResponse> customerResponse = null;
		try {
				customerRequest = getCustomerRequest();
				customerResponse = resource.createCustomer(customerRequest);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		assertNotNull(customerResponse);
	}
	@Test
	public void testCreateCustomer() {
		
		 ResponseEntity<CustomerResponse> customerResponse = null;
		try {
				customerRequest = getCustomerRequest();
				customerRequest.setUserName("gautam");
				customerResponse = resource.createCustomer(customerRequest);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		assertNotNull(customerResponse);
	}
	
	
	

	private CustomerRequest getCustomerRequest() {
		customerRequest = new CustomerRequest();
		customerRequest.setCustomerName("Gautam");
		customerRequest.setCity("CHENNAI");
		customerRequest.setDob("08-15-1991");
		customerRequest.setPanNo("IND124323");
		customerRequest.setEmailId("togautam@gmail.com");
		customerRequest.setPassword("password123");
		return customerRequest;
	}
	
}