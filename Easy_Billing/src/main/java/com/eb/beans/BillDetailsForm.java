package com.eb.beans;

import java.sql.Date;

import lombok.Data;


@Data
public class BillDetailsForm {

	private Long billNo;
	private Long customerId;
	private Float amount;
	private Date date;

		

}
