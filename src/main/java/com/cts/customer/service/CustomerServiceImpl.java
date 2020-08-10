package com.cts.customer.service;

import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.customer.dao.CustomerDao;
import com.cts.customer.model.Address;
import com.cts.customer.model.Customer;
import com.cts.customer.model.User;
import com.cts.customer.request.CustomerRequest;
import com.cts.customer.response.CustomerResponse;
import com.cts.customer.util.CustomerValidator;
import com.cts.customer.util.ValidatorConstants;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter@Setter
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest customerRequest, CustomerResponse customerResponse){
		Customer customer = new Customer();
		constructCustomer(customer, customerRequest);
		customerDao.persist(customer);
		customerResponse.setCustomer(customer);
		customerResponse.setStatusCode(ValidatorConstants.SUCCESS_CODE);
		customerResponse.setStatusMessage(ValidatorConstants.SUCCESS_MSG);
		
		return new ResponseEntity<>(customerResponse, HttpStatus.OK);
	}

	
	private void constructCustomer(Customer customer, CustomerRequest customerRequest) {
		
		
		customer.setCustomerName(customerRequest.getCustomerName());
		customer.setAccountType(customerRequest.getAccountType());
		customer.setContactNo(customerRequest.getContactNo());
		customer.setPanNo(customerRequest.getPanNo());
		Address address = new Address();
		address.setAddress_line(customerRequest.getAddress());
		address.setCity(customerRequest.getCity());
		address.setState(customerRequest.getState());
		address.setCountry(customerRequest.getCountry());
		
		User user = new User();
		user.setUserId(customer.getCustomerId());
		user.setEmailId(customerRequest.getEmailId());
		user.setPassword(customerRequest.getPassword());
		user.setUserName(customerRequest.getUserName());
		if(StringUtils.isNotEmpty(customerRequest.getDob())) {
			try {
				customer.setDob(CustomerValidator.convertStrToDateObj(customerRequest.getDob()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		customer.setAddress(address);
		customer.setUser(user);
	}
}
