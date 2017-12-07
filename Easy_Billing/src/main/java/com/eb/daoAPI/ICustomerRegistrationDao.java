package com.eb.daoAPI;

import com.eb.bo.CustomerDetailsBo;

public interface ICustomerRegistrationDao {
   Long saveCustomerDetails(CustomerDetailsBo customerDetailsBo);
}
