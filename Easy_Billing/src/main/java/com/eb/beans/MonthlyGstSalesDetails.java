package com.eb.beans;

import java.sql.Date;

import lombok.Data;

@Data
public class MonthlyGstSalesDetails {

	private float gst;
	private float amount;
	private Date date;
	
}
