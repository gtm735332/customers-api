package com.cts.customer.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

	private String customerName;
	private String userName;
	private String password;
	private String address;
	private String city;
	private String state;
	private String country;
	private String emailId;
	private String panNo;
	private String contactNo;
	private String dob;
	private String accountType;
	
}
