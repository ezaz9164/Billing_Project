package com.eb.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
@Entity
@Table(name="custable")
@Data
public class CustomerDetailsBo {

	@Id
	@Column(name="cno")
	@GenericGenerator(name="Incr_Gen",strategy="increment" )
	@GeneratedValue(generator="Incr_Gen")
	private Long customerId;
	@Column(name="cname")
	private String customerName;
	@Column(name="ctno")
	private String customerGstNo;
	@Column(name="cpno")
	private String customerPhoneNo;
	@Column(name="cadd")
	private String customerAddress;

}
