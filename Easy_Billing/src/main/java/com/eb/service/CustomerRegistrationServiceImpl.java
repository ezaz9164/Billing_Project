package com.eb.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eb.beans.CustomerDetailsForm;
import com.eb.bo.CustomerDetailsBo;
import com.eb.daoAPI.ICustomerRegistrationDao;
import com.eb.serviceAPI.ICustomerRegistrationService;
@Service
public class CustomerRegistrationServiceImpl implements ICustomerRegistrationService {
    @Autowired
	private ICustomerRegistrationDao customerRegistrationDaoImpl;
	@Override
	@Transactional
	public Long saveCustomerDetails(CustomerDetailsForm customerDetailsForm) {
		CustomerDetailsBo customerDetailsBo= new CustomerDetailsBo();
		BeanUtils.copyProperties(customerDetailsForm, customerDetailsBo);
		
		return customerRegistrationDaoImpl.saveCustomerDetails(customerDetailsBo) ;
	}
         
}
