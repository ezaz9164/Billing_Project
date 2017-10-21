package com.eb.beans;

import lombok.Data;

@Data
public class TaxComponentsForm {

	
	private Integer billNo;
	private Integer productId;
	private Float taxableAmount;
	private Double hsnCode;
	private Float gst;
	
	

}
