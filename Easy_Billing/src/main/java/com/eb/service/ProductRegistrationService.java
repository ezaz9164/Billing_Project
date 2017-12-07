package com.eb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eb.beans.ProductForm;
import com.eb.bo.CompanyDetailsBo;
import com.eb.bo.ProductBo;
import com.eb.daoAPI.ICompanyDao;
import com.eb.daoAPI.IProductRegistrationDao;
import com.eb.dto.CompanyDetailsDto;

@Service
public class ProductRegistrationService {


	@Autowired
	private IProductRegistrationDao productRegistrationDao;

	@Autowired
	private ICompanyDao companyDao;

	
	
	@Transactional

	public Long saveProduct(ProductForm product) {


		ProductBo productBo = new ProductBo();

		productBo.setGst(product.getGst());
		productBo.setHsnCode(product.getHsnCode());
		productBo.setMrp(product.getMrp());
		productBo.setNoOfUnits(product.getNoOfUnits());
		productBo.setProductCompany(product.getProductCompany());
		productBo.setProductName(product.getProductName());
		productBo.setRate(product.getRate());
		productBo.setUnitOfReference(product.getUnitOfReference());

		Long pId = productRegistrationDao.saveProduct(productBo);

		return pId;

	}

	@Transactional
	public boolean isProductExists(String productName) {
		boolean isExists = false;
		int productCount = productRegistrationDao.countProductByName(productName);

		if (productCount != 0) {
			isExists = true;
		}
		return isExists;
	}

	@Transactional
	public Map<String, List<Float>> getallCompanyDetails() {
		List<CompanyDetailsBo> companyDetails = companyDao.getCompanyDetails();

		Map<String, List<Float>> companyDetailsDto = new HashMap<String, List<Float>>();

		for (CompanyDetailsBo bo : companyDetails) {

			String companyName = bo.getCompanyName();
			Float gstValue=bo.getGst();
			if (companyDetailsDto.containsKey(companyName)) {
				List<Float> gstSet = companyDetailsDto.get(companyName);
			
						gstSet.add(gstValue);

			} else {
				List<Float> gstSet = new ArrayList<Float>();
				gstSet.add(gstValue);
				companyDetailsDto.put(companyName, gstSet);
			}

		}

		return companyDetailsDto;
	}

	/*
	 * @Transactional public List<CompanyDetailsDto> getallCompanyDetails() {
	 * 
	 * List<CompanyDetailsDto> dto = new ArrayList<>(); List<CompanyDetailsBo>
	 * companyDetails = companyDao.getCompanyDetails();
	 * 
	 * 
	 * 
	 * for (CompanyDetailsBo bo : companyDetails) { CompanyDetailsDto cDto = new
	 * CompanyDetailsDto(); cDto.setCompanyName(bo.getCompanyName());
	 * cDto.setGst(bo.getGst()); dto.add(cDto); }
	 * 
	 * 
	 * return dto; }
	 */

}