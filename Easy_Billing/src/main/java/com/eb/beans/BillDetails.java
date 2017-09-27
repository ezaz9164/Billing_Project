package com.eb.beans;

import java.sql.Date;

import lombok.Data;

@Data
public class BillDetails {

	private int billNo;
	private int customerId;
	private float amount;
	private Date date;

		

}
