package com.eb.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eb.beans.CustomerDetailsForm;
import com.eb.service.CustomerRegistrationServiceImpl;
import com.eb.serviceAPI.ICustomerRegistrationService;
import com.eb.urls.UrlRefs;

@Controller
@RequestMapping(path=UrlRefs.customerRegistrationRequest)
public class CustomerRegistrationController implements UrlRefs {
	@Autowired
  private ICustomerRegistrationService customerRegistrationService;
  @RequestMapping(method=RequestMethod.GET)
  public String getCustomerRegistrationPage(Model model) {
	  CustomerDetailsForm customerDetailsForm= new CustomerDetailsForm();
	  customerDetailsForm.setCustomerGstNo("Not Avaliable");
	  customerDetailsForm.setCustomerPhoneNo("Not Avaliable");
	  model.addAttribute("customerDetailsForm", customerDetailsForm);
	  
	  
	  
	  return customerRegistrationPage;
  }
  @RequestMapping(method=RequestMethod.POST)
  public String getSuccessPage( Model model, @Valid CustomerDetailsForm customerDetailsForm,BindingResult be) {
	      if(be.hasErrors()) {
	    	  return customerRegistrationPage;
	      }
	  Long cid=customerRegistrationService.saveCustomerDetails(customerDetailsForm);
	  model.addAttribute("name", customerDetailsForm.getCustomerName());
	  String subject="Customer";
	  model.addAttribute("subject",subject);
	  model.addAttribute("operation", "Registration");
	  model.addAttribute("repeat",customerRegistrationRequest);
	  return customerRegistrationSuccess;
  }



}
