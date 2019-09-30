package com.springboot.products.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.products.entity.Products;
import com.springboot.products.model.Product;
import com.springboot.products.repository.ProductsRepository;

@Service
public class ProductsServiceImpl implements ProductsService{
	
	private ModelMapper mapper;
	
	@Autowired
	private ProductsRepository productsRepository;

	@Override
	public Products addProduct(Product product) {
		Products products = null;
		
		products = mapper.map(product, Products.class);
		
		products = productsRepository.save(products);
		
		return products;
	}

}
