package com.eb.beans;


import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class CustomerDetailsForm {
	
	
    
	private Long customerId;
	@NotEmpty(message="Please Enter the Customer Name")
	private String customerName;
	private String customerGstNo;
	private String customerPhoneNo;
	@NotEmpty(message="Please Enter the Customer Address")
	private String customerAddress;

	
	
	
	}
