package com.eb.beans;

import lombok.Data;

@Data
public class GstElementsForm {
	
	private Float cGstAmount;
	private Float sGstAmount;
	private Float taxableAmount;
	private Float cGstRate;
	private Float sGstRate;
	private String hsnCode;
	
	
}
