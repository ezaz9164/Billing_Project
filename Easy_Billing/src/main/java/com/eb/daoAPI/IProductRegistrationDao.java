package com.eb.daoAPI;


import com.eb.bo.ProductBo;

public interface IProductRegistrationDao {

	int saveProduct(ProductBo productBo);
	int countProductByName(String productName);
	
	
	
}
