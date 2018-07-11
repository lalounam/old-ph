package com.customers.ui;

import javax.annotation.PostConstruct;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.customers.dao.impl.VaadinService;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;

@SpringUI(path = "/boton/*")
@Scope("prototype")
public class Main extends UI {

	private static final long serialVersionUID = 87L;

	@Autowired
	private VaadinService vaadinService;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(ui = Main.class, productionMode = false)
	public static class DispatcherServlet extends SpringVaadinServlet {
		private static final long serialVersionUID = -2584775635128137932L;
	}

	@Override
	protected void init(VaadinRequest request) {

	}

	@PostConstruct
	public void myMethod() {
		System.out.println(vaadinService);
		Button button = new Button(vaadinService.getCustomerDao().findCustomerById(1L).getName());
		setContent(button);
	}

}
