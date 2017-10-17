package com.eb.controllers;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eb.beans.Product;
import com.eb.dto.CompanyDetailsDto;
import com.eb.service.ProductRegistrationService;
import com.eb.urls.UrlRefs;

@Controller
@RequestMapping(path = UrlRefs.productRegistrationRequest)
public class ProductRegistrationController implements UrlRefs {

	@Autowired
	private ProductRegistrationService productRegService;

	@RequestMapping(method = RequestMethod.GET, path = UrlRefs.productRegistrationInitial)
	public String getProductRegistrationPage(Model model) {
		Product product = new Product();

		List<CompanyDetailsDto> companyDetailsList = productRegService.getallCompanyDetails();

		model.addAttribute("product", product);
		model.addAttribute("companyDetailsList", companyDetailsList);
		System.out.println("came to controller");
		
		
		
		
		return "product_Registration";

		
		
		
		
	}

	@RequestMapping(method = RequestMethod.POST, path = UrlRefs.productRegistrationInitial)
	public String submitProductRegistrationpage(Model model, @ModelAttribute Product product, BindingResult be) {

		int pId = productRegService.saveProduct(product);
		model.addAttribute("pId", pId);

		return "pRegSuccess";
	}

	@RequestMapping(path = UrlRefs.isProductExist, method = RequestMethod.GET)
	public @ResponseBody String isProductExists(HttpServletRequest request) {
			
		System.out.println("cchek controller entered");
		String productName = request.getParameter("pName");
		boolean isExists = false;
		String checkedStatus = "allowed";
		isExists = productRegService.isProductExists(productName);

		if (isExists == true) {

			checkedStatus = "notAllowed";

		}

		
		System.out.println(checkedStatus);
		return checkedStatus;

	}

}