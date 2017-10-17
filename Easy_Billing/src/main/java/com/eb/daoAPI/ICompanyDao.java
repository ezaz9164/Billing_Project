package com.eb.daoAPI;

import java.util.List;

import com.eb.bo.CompanyDetailsBo;

public interface ICompanyDao {
	
	//to get all companies and their gst
	List<CompanyDetailsBo> getCompanyDetails();
	
	
	
}
