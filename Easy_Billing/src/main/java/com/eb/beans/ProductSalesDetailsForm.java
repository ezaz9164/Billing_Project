package com.eb.beans;

import java.sql.Date;

import lombok.Data;
@Data
public class ProductSalesDetailsForm {


	private Integer quantity;
	private String productName;
	private Date date;
	
	
}
