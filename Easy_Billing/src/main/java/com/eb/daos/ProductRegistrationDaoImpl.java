package com.eb.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.eb.bo.ProductBo;
import com.eb.daoAPI.IProductRegistrationDao;

@Repository
@PropertySource("classpath:/db.properties")
public class ProductRegistrationDaoImpl extends GenericDao implements IProductRegistrationDao {

	@Autowired
	private Environment env;

	public Long saveProduct(ProductBo productBo) {
		return Save(productBo);
	}

	public int countProductByName(String productName) {
		int noOfProducts = 0;
		System.out.println(productName);
		@SuppressWarnings("unchecked")
		List<Object> s = getEntity(env.getProperty("query.checkProductName"), new Object[] { productName });

		Object o = s.get(0);
		Long l = (Long) o;
		noOfProducts = l.intValue();
		
		System.out.println("int value  "+noOfProducts);
		return noOfProducts;
	}

}