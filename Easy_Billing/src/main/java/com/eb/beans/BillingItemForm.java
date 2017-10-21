package com.eb.beans;

import java.sql.Date;

import lombok.Data;

@Data
public class BillingItemForm {

	private Long quantity;
	private String productDescription;
	private Float mrp;
	private Float rate;
	private String offerItem;
	private Float gst;
	private Float price;
	private Date date;
	private String hsnCode;
	private Long billNo;
	private Long customerId;
	private String unitOfReference;
	private String productCompany;
	
	 
}
