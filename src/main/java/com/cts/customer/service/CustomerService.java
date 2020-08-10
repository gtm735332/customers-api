package com.cts.customer.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cts.customer.request.CustomerRequest;
import com.cts.customer.response.CustomerResponse;

@Service
public interface CustomerService {

	public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest customerRequest, CustomerResponse customerResponse);
}
