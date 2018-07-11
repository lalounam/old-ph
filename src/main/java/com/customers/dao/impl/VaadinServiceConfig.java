package com.customers.dao.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vaadin.spring.annotation.EnableVaadin;

@Configuration
@EnableVaadin
public class VaadinServiceConfig {

	@Bean
	public VaadinService vaadinService() {
		return new VaadinService();
	}
}
