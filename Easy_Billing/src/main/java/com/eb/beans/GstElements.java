package com.eb.beans;

import lombok.Data;

@Data
public class GstElements {
	
	private float cGstAmount;
	private float sGstAmount;
	private float taxableAmount;
	private float cGstRate;
	private float sGstRate;
	private String hsnCode;
	
	
}
