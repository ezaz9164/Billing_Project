package com.eb.beans;

import java.sql.Date;

import lombok.Data;

@Data
public class BillingItem {

	private int quantity;
	private String productDescription;
	private float mrp;
	private float rate;
	private String offerItem;
	private float gst;
	private float price;
	private Date date;
	private String hsnCode;
	private int billNo;
	private int customerId;
	private String unitOfReference;
	private String productCompany;
	
	
}