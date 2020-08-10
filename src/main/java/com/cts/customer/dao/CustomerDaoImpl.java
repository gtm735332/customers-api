package com.cts.customer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cts.customer.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);
	
	@PersistenceContext
	EntityManager em;
	
	
	@Transactional
	public void persist(Customer customer) {
		em.persist(customer);
		logger.info("\n Customer Details persisted");
		
	}
	
}
