package com.customers.ui;

import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.customers.service.PersistenceVaadinService;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.UI;

@Scope("prototype")
@SpringUI
public abstract class Main extends UI {

	private static final long serialVersionUID = 6935000628898132351L;

	@Autowired
	protected PersistenceVaadinService vaadinService;

	@WebServlet(value = "/vaadin/*", asyncSupported = true)
	@VaadinServletConfiguration(ui = Main.class, productionMode = false)
	public static class DispatcherServlet extends SpringVaadinServlet {
		private static final long serialVersionUID = -2584775635128137932L;
	}
}
