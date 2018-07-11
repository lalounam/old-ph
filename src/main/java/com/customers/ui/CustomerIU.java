package com.customers.ui;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;

@SpringUI(path = "/customer/*")
public class CustomerIU extends Main {

	private static final long serialVersionUID = -5060347607483525472L;

	@Override
	protected void init(VaadinRequest request) {
		Button button = new Button(vaadinService.getCustomerDao().findCustomerById(1L).getName());
		setContent(button);
	}

}
