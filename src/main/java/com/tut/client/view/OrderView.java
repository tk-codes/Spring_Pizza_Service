package com.tut.client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tut.client.controller.Colors;
import com.tut.client.controller.GUIconstants;
import com.tut.client.controller.NewOrderController;
import com.tut.spring.dto.PizzaDTO;
import com.tut.spring.dto.PizzaOrderDTO;

public class OrderView extends JPanel {

	private List<PizzaOrderDTO> pizzaOrder;
	private Box orderHolder;
	private JLabel totalPrice;

	private Locale locale = new Locale("de_CH");
	private NumberFormat currencyFormatter = NumberFormat
			.getCurrencyInstance(locale);

	private Box mainContent;

	// Constructor
	public OrderView(NewOrderController controller) {
		this.controller = controller;

		this.pizzaOrder = new ArrayList<PizzaOrderDTO>();

		this.setBackground(Colors.DESKNOTE_BACKGROUND.getColor());
		this.setPreferredSize(new Dimension(GUIconstants.NOTELIST_WIDTH
				.getValue(), GUIconstants.HEIGHT.getValue()));
		this.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0,
				Colors.NOTE_BORDER.getColor()));
		this.setLayout(new FlowLayout(FlowLayout.LEFT));

		createComponents();
	}

	public void addPizzaOrder(PizzaDTO pizza) {

		PizzaOrderDTO o = getOrder(pizza);

		if (o != null) {
			o.setCount(o.getCount() + 1);
		} else {
			PizzaOrderDTO order = new PizzaOrderDTO();
			order.setPizza(pizza);
			order.setCount(1);
			this.pizzaOrder.add(order);
		}

		createContent();
	}

	public String getTotalPrice() {
		double price = 0;
		for (PizzaOrderDTO o : pizzaOrder) {
			price += o.getCount() * o.getPizza().getPrice();
		}
		return currencyFormatter.format(price);
	}

	private PizzaOrderDTO getOrder(PizzaDTO pizza) {
		for (PizzaOrderDTO o : pizzaOrder) {
			if (o.getPizza() == pizza)
				return o;
		}
		return null;
	}

	private void createComponents() {
		Box noteLayout = Box.createVerticalBox();

		// Box
		Box headerBox = createHeader();
		orderHolder = createContent();

		noteLayout.add(headerBox);
		noteLayout.add(Box.createVerticalStrut(10));
		noteLayout.add(orderHolder);
		this.add(noteLayout);
	}

	// HeaderBox
	private Box createHeader() {
		FlowLayout header = new FlowLayout(FlowLayout.LEFT);
		JPanel hPanel = new JPanel(header);
		hPanel.setOpaque(false);

		JLabel title = new JLabel("Shopping Cart");
		title.setFont(new Font("Calibri", Font.BOLD, 25));
		hPanel.add(title);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.add(hPanel);

		JPanel headerBox = new JPanel(header);
		headerBox.setOpaque(true);
		JButton button1 = new JButton("Clear All");
		button1.setBackground(Colors.LIGHT_GRAY.getColor());
		button1.setFocusable(false);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pizzaOrder.clear();
				createContent();
			}
		});

		JButton button2 = new JButton("Order");
		button2.setBackground(Colors.LIGHT_GRAY.getColor());
		button2.setFocusable(false);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				controller.createPopup(pizzaOrder);
			}
		});

		headerBox.add(button1);
		headerBox.add(button2);
		verticalBox.add(headerBox);

		FlowLayout priceBoxlayout = new FlowLayout(FlowLayout.LEFT);
		JPanel priceBox = new JPanel(priceBoxlayout);
		priceBox.setOpaque(false);

		Font adjustedFont = new Font("Calibri", Font.PLAIN, 20);
		JLabel lblTotal = new JLabel("Total Price:");
		lblTotal.setFont(adjustedFont);

		totalPrice = new JLabel("0.00");
		totalPrice.setFont(adjustedFont);
		priceBox.add(lblTotal);
		priceBox.add(totalPrice);

		verticalBox.add(priceBox);
		return verticalBox;
	}

	// content
	private Box createContent() {
		this.totalPrice.setText(getTotalPrice());
		if (mainContent == null)
			mainContent = Box.createVerticalBox();
		else
			mainContent.removeAll();

		FlowLayout leftLayout = new FlowLayout(FlowLayout.LEFT);

		for (PizzaOrderDTO o : pizzaOrder) {
			JPanel hPanel = new JPanel(new BorderLayout());
			hPanel.setPreferredSize(new Dimension(GUIconstants.NOTELIST_WIDTH
					.getValue() - 15, 25));
			hPanel.add(new JLabel(o.getPizza().getName()));
			hPanel.setOpaque(true);

			String value = o.getCount()
					+ currencyFormatter.format(o.getPizza().getPrice());
			hPanel.add(new JLabel(value), BorderLayout.EAST);

			mainContent.add(hPanel);
		}

		return mainContent;
	}

	private static final long serialVersionUID = 1L;
	private NewOrderController controller;

	public void reset() {
		// pizzaOrder.clear();
		// createContent();
	}

}
