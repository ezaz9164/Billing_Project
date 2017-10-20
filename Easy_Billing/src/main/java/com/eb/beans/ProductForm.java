package com.eb.beans;

import lombok.Data;

@Data
public class ProductForm {

	private Long productId;
	private Float mrp;
	private Float rate;
	private String productName;
	private String productCompany;

	private Float gst;
	private String hsnCode;
	private String unitOfReference;
	private Integer noOfUnits;
	
	
}
