package com.tut.client.view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JPanel;

import com.tut.client.controller.Colors;
import com.tut.client.controller.GUIconstants;
import com.tut.client.controller.NewOrderController;
import com.tut.spring.dto.PizzaDTO;

public class PizzaOrderView extends JPanel {

	public PizzaOrderView(NewOrderController orderController) {
		this.controller = orderController;
		this.setBackground(Colors.DESKNOTE_BACKGROUND.getColor());

		FlowLayout layout = new FlowLayout();
		layout.setVgap(0);
		this.setLayout(layout);

		setupDeskNoteView(orderController);
	}

	private void setupDeskNoteView(NewOrderController orderController) {
		Box mainLayout = Box.createHorizontalBox();
		mainLayout.setPreferredSize(new Dimension(GUIconstants.WIDTH.getValue(), GUIconstants.HEIGHT.getValue()));

		pizzaListView = new PizzaListView(controller);
		orderView = new OrderView(controller);
		
		mainLayout.add(pizzaListView);
		mainLayout.add(orderView);
		
		this.add(mainLayout);
	}

	public PizzaListView getNoteListView() {
		return this.pizzaListView;
	}

	public OrderView getNoteView() {
		return this.orderView;
	}

	private static final long serialVersionUID = 1L;
	private OrderView orderView;
	private PizzaListView pizzaListView;
	
	private NewOrderController controller;
	
	public void addPizzaOrder(PizzaDTO pizzaOrder) {
		this.orderView.addPizzaOrder(pizzaOrder);	
	}
	
	public void clearOrder(){
		orderView.reset();
	}
}
