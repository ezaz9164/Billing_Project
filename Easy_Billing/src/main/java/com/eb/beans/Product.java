package com.eb.beans;

import lombok.Data;

@Data
public class Product {

	private int productId;
	private float mrp;
	private float rate;
	private String productName;
	private String productCompany;

	private float gst;
	private String hsnCode;
	private String unitOfReference;
	private int noOfUnits;
	
}
