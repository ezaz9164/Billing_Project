package com.eb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eb.beans.Product;
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
	public int saveProduct(Product product) {

		ProductBo productBo = new ProductBo();

		productBo.setGst(product.getGst());
		productBo.setHsnCode(product.getHsnCode());
		productBo.setMrp(product.getMrp());
		productBo.setNoOfUnits(product.getNoOfUnits());
		productBo.setProductCompany(product.getProductCompany());
		productBo.setProductName(product.getProductName());
		productBo.setRate(product.getRate());
		productBo.setUnitOfReference(product.getUnitOfReference());

		int pId = productRegistrationDao.saveProduct(productBo);

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
	public List<CompanyDetailsDto> getallCompanyDetails() {

		List<CompanyDetailsDto> dto = new ArrayList<>();
		List<CompanyDetailsBo> companyDetails = companyDao.getCompanyDetails();

		for (CompanyDetailsBo bo : companyDetails) {
			CompanyDetailsDto cDto = new CompanyDetailsDto();
			cDto.setCompanyName(bo.getCompanyName());
			cDto.setGst(bo.getGst());
			dto.add(cDto);
		}
		return dto;
	}

}