package com.eb.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eb.beans.ProductForm;
import com.eb.service.ProductRegistrationService;
import com.eb.urls.UrlRefs;
import com.eb.util.CompanyDetailsUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(path = UrlRefs.productRegistrationRequest)
public class ProductRegistrationController implements UrlRefs {

	@Autowired
	private ProductRegistrationService productRegService;

	@Autowired
	private CompanyDetailsUtil companyDetailsUtil;

	@RequestMapping(method = RequestMethod.GET, path = UrlRefs.productRegistrationInitial)
	public String getProductRegistrationPage(ModelMap model) {
		ProductForm product = new ProductForm();

	

		model.put("product", product);

		Set<String> companyList = companyDetailsUtil.getCompanyName();

		model.put("companyList", companyList);
		System.out.println("came to controller");
		return "product_Registration";

	}

	@RequestMapping(method = RequestMethod.POST, path = UrlRefs.productRegistrationInitial)
	public String submitProductRegistrationpage(Model model, @Valid @ModelAttribute(name="product") ProductForm product,
			BindingResult be) {

		if (be.hasErrors()) {
			System.out.println("product model-->"+product);
			Set<String> companyList = companyDetailsUtil.getCompanyName();
			model.addAttribute("product", product);
			model.addAttribute("companyList", companyList);
			return "product_Registration";
		} else {
			Long pId = productRegService.saveProduct(product);
			model.addAttribute("pId", pId);

			return "pRegSuccess";

		}
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

	@GetMapping(path = GET_GSTS_BY_COMPANY)
	public @ResponseBody String getCompanyGst(HttpServletRequest request) {

		System.out.println("enterd to ajzx");
		String name = request.getParameter("cName");
		System.out.println(name);
		List<Float> gstList = companyDetailsUtil.getGstByCompanyName(name);
		System.out.println(gstList);
		ObjectMapper mapper = new ObjectMapper();
		String mapperValue = null;
		try {
			mapperValue = mapper.writeValueAsString(gstList);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapperValue;

	}

}