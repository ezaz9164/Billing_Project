package com.eb.serviceAPI;

import com.eb.beans.CustomerDetailsForm;

public interface ICustomerRegistrationService {
 Long saveCustomerDetails(CustomerDetailsForm customerDetailsForm);
}
