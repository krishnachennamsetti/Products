package com.springboot.products.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.products.model.Product;
import com.springboot.products.service.ProductsService;

@Component
public class ProductReceiver {
	
	@Autowired
	private ProductsService productsService;
	
	private ObjectMapper mapper = new ObjectMapper();

	@JmsListener(destination = "productaddition", containerFactory = "jmsListenerContainerFactory")
    public void receive(String message) {
		
		try {
			Product product = mapper.readValue(message, Product.class);
			productsService.addProduct(product);
			
		} catch (IOException exception) {
			exception.printStackTrace();
		}
		
	}

}
