package com.eb.beans;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class ProductForm {

	private Long productId;

	@NotNull(message="RATE can not be empty")
	@PositiveOrZero(message="MRP can not be empty")
	private Float mrp;
	
	@PositiveOrZero(message="RATE cannot be empty")
	@NotNull(message="RATE can not be empty")
	private Float rate;
	
	@NotEmpty(message="PRODUCT NAME can not be empty")
	private String productName;
	
	@NotEmpty(message="select a COMPANY NAME")
	private String productCompany;

	@PositiveOrZero(message="GST cannot be empty")
	@NotNull(message="select a gst value")
	private Float gst;
	
	@NotEmpty(message="HSN CODE cannot be empty")
	private String hsnCode;
	
	@NotEmpty(message="enter the reference unit of your product")
	private String unitOfReference;
	
	@Positive(message=" enter total units needed")
	@NotNull(message="it cant be null")
	private Integer noOfUnits;
	
	
}
