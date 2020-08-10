package com.cts.customer.response;

import java.util.HashMap;
import java.util.Map;

import com.cts.customer.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerResponse {

	private String statusCode;
	private String statusMessage;
	private Customer customer;
	private Map<String, String> errorsMap;
	
	public Map<String, String> getErrorsMap() {
		if(errorsMap == null) {
			errorsMap = new HashMap<>();
		}
		return errorsMap;
	}
	public void setErrorsMap(Map<String, String> errorMap) {
		this.errorsMap = errorMap;
	}
	
	
}
