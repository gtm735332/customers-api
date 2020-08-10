package com.cts.customer.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.cts.customer.request.CustomerRequest;



public class CustomerValidator {

	public static Map<String, String> validateCustomerRequest(CustomerRequest customerRequest, Map<String, String> errorMap) {
		
		if(StringUtils.isEmpty(customerRequest.getCustomerName())) {
			errorMap.put(ValidatorConstants.CUSTOMER_NAME, ValidatorConstants.MANDATORY_FIELD);
		}
		
		if(StringUtils.isEmpty(customerRequest.getUserName())) {
			errorMap.put(ValidatorConstants.USER_NAME, ValidatorConstants.MANDATORY_FIELD);
		}
		
		if(StringUtils.isEmpty(customerRequest.getEmailId())) {
			errorMap.put(ValidatorConstants.EMAIL_ID, ValidatorConstants.MANDATORY_FIELD);
		}
		
		if(StringUtils.isEmpty(customerRequest.getPassword())) {
			errorMap.put(ValidatorConstants.PASSWORD_FIELD, ValidatorConstants.MANDATORY_FIELD);
		}
		
		if(StringUtils.isNotEmpty(customerRequest.getDob())) {
			try {
				convertStrToDateObj(customerRequest.getDob());
			}catch (ParseException e) {
				errorMap.put(ValidatorConstants.DATE_OF_BIRTH, ValidatorConstants.INVALID_DATE_OF_BIRTH_FORMAT_MSG);
			}
		}
		return errorMap;
	}
	
	public static Date convertStrToDateObj(String dateStr) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat(ValidatorConstants.DATE_FORMAT);
		sdf.setLenient(false);
		Date dateObj = sdf.parse(dateStr);
		return sdf.parse(sdf.format(dateObj));
	}
}
