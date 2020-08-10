package com.cts.customer.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.customer.request.CustomerRequest;
import com.cts.customer.response.CustomerResponse;
import com.cts.customer.service.CustomerService;
import com.cts.customer.util.CustomerValidator;
import com.cts.customer.util.ValidatorConstants;

import lombok.Getter;
import lombok.Setter;

@RestController
@RequestMapping("/customer")
@Getter@Setter
public class CustomerResource {

	@Autowired
	CustomerService customerService;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest){
		
		CustomerResponse customerResp = new CustomerResponse();
		CustomerValidator.validateCustomerRequest(customerRequest, customerResp.getErrorsMap());
		if(customerResp.getErrorsMap().isEmpty()) {
			return	customerService.createCustomer(customerRequest, customerResp);
		}else {
			customerResp.setStatusCode(ValidatorConstants.BAD_REQUEST_CODE);
			customerResp.setStatusMessage(ValidatorConstants.BAD_REQUEST_MSG);
			return new ResponseEntity<CustomerResponse>(customerResp, HttpStatus.BAD_REQUEST);
		}
	
	}
	
}
