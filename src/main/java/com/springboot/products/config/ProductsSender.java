package com.springboot.products.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductsSender {
	
	@Autowired
	private JmsTemplate jmsTemplate;

	public void send(String message) {
		
		jmsTemplate.convertAndSend("productaddition", message);
		
	}

}
