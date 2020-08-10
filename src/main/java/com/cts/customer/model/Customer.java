package com.cts.customer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CUSTOMER")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Customer implements Serializable{

	
	private static final long serialVersionUID = -929269490799081861L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CUSTOMER_ID")
	private long customerId;
	
	@Column(name="CUSTOMER_NAME")
	private String customerName;
	
	@Column(name="PAN_NO")
	private String panNo;
	
	@Column(name="CONTACT_NO")
	private String contactNo;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date dob;

	@Column(name="ACCOUNT_TYPE")
	private String accountType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn()
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private User user;
	
}
