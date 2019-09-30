package com.springboot.products.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.products.config.ProductsSender;
import com.springboot.products.model.Product;

@RestController
public class ProductsController {

	@Autowired
	private ProductsSender sender;

	@Autowired
	private ObjectMapper objectMapper;

	@RequestMapping("/productSender")
	public void doMakeSenderCall() {

		Product product = new Product();
		product.setId("1");
		product.setName("JBL headset");
		product.setPrice(new BigDecimal(1000));
		product.setDescription("famous JBL headset");

		String jsonMessage = null;
		try {
			jsonMessage = objectMapper.writeValueAsString(product);
			sender.send(jsonMessage);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

}
