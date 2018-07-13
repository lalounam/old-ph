package com.customers.ui;

import java.util.List;

import com.customers.entity.Customer;
import com.customers.entity.Note;
import com.customers.entity.Status;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "/customer/*")
public class CustomerIU extends Main {

	private static final long serialVersionUID = -5060347607483525472L;

	private final VerticalLayout main = new VerticalLayout();
	private Grid<Customer> customerGrid;

	@Override
	protected void init(VaadinRequest request) {
		this.initGrid();
		main.addComponent(customerGrid);
		setContent(main);
	}

	private void initGrid() {
		this.customerGrid = new Grid<>("Customers", this.vaadinService.getCustomerDao().findAll(""));
		this.customerGrid.setWidth("90%");

		this.customerGrid.addColumn(Customer::getName).setCaption("Name");
		this.customerGrid.addColumn(Customer -> Customer.getStatus().getStatus()).setCaption("Status");

		this.customerGrid.setDetailsGenerator(row -> {
			HorizontalLayout layoutInternal = new HorizontalLayout();
			VerticalLayout layoutData = new VerticalLayout();
			VerticalLayout layoutNotes = new VerticalLayout();
			VerticalLayout notes = new VerticalLayout();
			Panel panelNotes = new Panel("Notes");

			layoutData.addComponent(new Label("Email: " + (row.getEmail() != null ? row.getEmail().getEmail() : "")));
			layoutData.addComponent(
					new Label("Phone number: " + (row.getPhone() != null ? row.getPhone().getPhone() : "")));
			layoutData.addComponent(
					new Label("Address: " + (row.getAddress() != null ? row.getAddress().getAddress() : "")));

			ComboBox<Status> sel = new ComboBox<>("Select Status", this.vaadinService.getCustomerDao().findAll());
			sel.setItemCaptionGenerator(Status::getStatus);
			sel.setSelectedItem(row.getStatus());
			sel.setEmptySelectionAllowed(false);
			sel.addSelectionListener(selection -> {
				row.setStatus(selection.getValue());
			});

			for (Note note : row.getNotes()) {
				HorizontalLayout r = new HorizontalLayout();
				TextArea ta = new TextArea();
				Button x = new Button("x");

				ta.setRows(2);
				ta.setValue(note.getNote());

				x.addClickListener(event -> {
					r.removeComponent(x);
					r.removeComponent(ta);
					List<Note> origin = row.getNotes();
					origin.remove(note);
					row.setNotes(origin);
				});

				r.addComponent(ta);
				r.addComponent(x);

				notes.addComponent(r);
			}
			
			Button add = new Button("+ add note");
			add.addClickListener(event -> {
				
			});
			
			notes.addComponent(add);

			panelNotes.setContent(notes);

			layoutNotes.addComponent(sel);
			layoutNotes.addComponent(panelNotes);

			// Wrap up all the parts into a vertical layout
			layoutInternal.addComponent(layoutData);
			layoutInternal.addComponent(layoutNotes);
			return layoutInternal;
		});

		this.customerGrid.addItemClickListener(event -> {
			final Customer item = event.getItem();
			this.customerGrid.setDetailsVisible(item, !this.customerGrid.isDetailsVisible(item));
		});
	}

}
