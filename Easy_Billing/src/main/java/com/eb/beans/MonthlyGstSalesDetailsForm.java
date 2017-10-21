package com.eb.beans;

import java.sql.Date;

import lombok.Data;

@Data
public class MonthlyGstSalesDetailsForm {

	private Float gst;
	private Float amount;
	private Date date;
	
}
