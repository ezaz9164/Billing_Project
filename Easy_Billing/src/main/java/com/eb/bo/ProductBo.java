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
	@Column(name="pid" )
	@GenericGenerator(name="Incr_Gen",strategy="increment" )
	@GeneratedValue(generator="Incr_Gen")
	private Long productId;
	
	@Column(name="mrp")
	private Float mrp;
	
	@Column(name="rate")
	private Float rate;
	
	@Column(name="pname")
	private String productName;
	
	@Column(name="pcom")
	private String productCompany;
	

	@Column(name="vatp")
	private Float gst;
	
	@Column(name="Hsn_code")
	private String hsnCode;
	
	@Column(name="unites_per")
	private String unitOfReference;
	
	@Column(name="no_of_unites")
	private Integer noOfUnits;

}