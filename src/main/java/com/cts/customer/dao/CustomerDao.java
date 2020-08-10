package com.cts.customer.dao;

import org.springframework.stereotype.Repository;

import com.cts.customer.model.Customer;

@Repository
public interface CustomerDao {

	public void persist(Customer customer);

}
