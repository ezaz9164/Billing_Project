package com.eb.daos;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.eb.bo.CompanyDetailsBo;
import com.eb.daoAPI.ICompanyDao;

@Repository
@PropertySource("classpath:/query.properties")
public class GetAllCompanyDetailsDaoImpl extends GenericDao implements ICompanyDao{

	@Autowired
	private Environment env;
	
	@Override
	public List<CompanyDetailsBo> getCompanyDetails() {
		List<CompanyDetailsBo> companyDetailsBoList=new ArrayList<CompanyDetailsBo>();
		
		@SuppressWarnings("unchecked")
		List<Object[]> CompanyObjectList =(List<Object[]>) getEntity(env.getProperty("query.getCompleteCompanyDetails"));
	 
		for (Object[] objects : CompanyObjectList) {
				String companyName=(String) objects[0];
				Float gst=(Float)objects[1];
			CompanyDetailsBo companyDetailsBo=new CompanyDetailsBo();
			companyDetailsBo.setCompanyName(companyName);
			companyDetailsBo.setGst(gst);
			companyDetailsBoList.add(companyDetailsBo);
		}
		
		
		return companyDetailsBoList;
	}

	
	
}
