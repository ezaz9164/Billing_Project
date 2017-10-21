package com.eb.daoAPI;


import com.eb.bo.ProductBo;

public interface IProductRegistrationDao {

	Long saveProduct(ProductBo productBo);
	int countProductByName(String productName);
	
	
	
}
