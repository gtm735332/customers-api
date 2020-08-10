package com.cts.customer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ADDRESS")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Address implements Serializable{
	

	private static final long serialVersionUID = 4000842677640345022L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ADDRESS_ID")
	private long id;
	
	@Column(name="ADDRESS_LINE")
	private String address_line;
	
	private String city;
	private String state;
	private String country;
}
