package com.eb.bo;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name="comdetails")
@Data
public class CompanyDetailsBo {
	
	@Id
	@GenericGenerator(name="hiGen",strategy="increment")
	@GeneratedValue(generator="hiGen")
	private int cid;
	
	@Column(name="cname")
	private String companyName;

	@Column(name="gst")
	private float gst;

}
