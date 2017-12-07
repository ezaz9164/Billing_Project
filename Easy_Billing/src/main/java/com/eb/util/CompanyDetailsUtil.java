package com.eb.util;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.eb.service.ProductRegistrationService;

@Component
@DependsOn(value= {"productRegistrationService"})
public class CompanyDetailsUtil {

	@Autowired
	private ProductRegistrationService productRegistrationService;
	
	private Map<String,List<Float>> companyMap=null;
	
	
	@PostConstruct
	public void init() {
		
		companyMap=productRegistrationService.getallCompanyDetails();
	}
	
		
	public Set<String> getCompanyName(){
		
		
		return companyMap.keySet();
		
		
		
	}
	
	

	public List<Float> getGstByCompanyName(String Name){
		

		return companyMap.get(Name);
		
		
	}
	
	
}
