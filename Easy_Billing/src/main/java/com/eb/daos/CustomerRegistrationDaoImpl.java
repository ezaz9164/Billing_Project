package com.eb.daos;

import org.springframework.stereotype.Repository;

import com.eb.bo.CustomerDetailsBo;
import com.eb.daoAPI.ICustomerRegistrationDao;
@Repository
public class CustomerRegistrationDaoImpl extends GenericDao implements ICustomerRegistrationDao {

	@Override
	public Long saveCustomerDetails(CustomerDetailsBo customerDetailsBo) {
		return Save(customerDetailsBo);
	}

}
