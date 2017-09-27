package com.eb.beans;

import lombok.Data;

@Data
public class TaxComponents {

	
	private int billNo;
	private int productId;
	private float taxableAmount;
	private double hsnCode;
	private float gst;
	
	

}
