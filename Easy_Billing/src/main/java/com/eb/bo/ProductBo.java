package com.eb.bo;

import javax.persistence.Column;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name="product")
@Data
public class ProductBo {
	
	@Id
	@Column(name="PRODUCT_ID")
	@GenericGenerator(name="Incr_Gen",strategy="increment" )
	@GeneratedValue(generator="Incr_Gen")
	private int productId;
	
	@Column(name="MRP")
	private float mrp;
	
	@Column(name="RATE")
	private float rate;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_COMPANY")
	private String productCompany;
	

	@Column(name="GST")
	private float gst;
	
	@Column(name="HSN_CODE")
	private String hsnCode;
	
	@Column(name="UNIT_OF_REFERENCE")
	private String unitOfReference;
	
	@Column(name="NO_OF_UNITS")
	private int noOfUnits;

}