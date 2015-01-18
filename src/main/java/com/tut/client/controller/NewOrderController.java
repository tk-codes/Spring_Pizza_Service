package com.tut.client.controller;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.web.client.RestTemplate;

import com.tut.client.view.PizzaOrderView;
import com.tut.spring.dto.PizzaDTO;

public class NewOrderController {

	// View
	private JFrame pizzaFrame;
	private Box mainLayout;
	
	private MainController controller;
	
	private RestTemplate restTemplate;
	
	private List<PizzaDTO> pizzas;
	
	public NewOrderController(MainController controller) {
		this.controller = controller;
		this.restTemplate = new RestTemplate();
	}
	
	public void run(){
		init_pizzas();		
		init_PizzaFrame();
	}
	
	private void init_pizzas() {
		PizzaDTO[] pizzaArray = restTemplate.getForObject("http://localhost:14140/pizza_service/", PizzaDTO[].class);
		pizzas = new ArrayList<PizzaDTO>();
		for(PizzaDTO p : pizzaArray)
			pizzas.add(p);
	}

	private void initView() {
		mainLayout = Box.createHorizontalBox();
		mainLayout.setPreferredSize(new Dimension(GUIconstants.WIDTH.getValue(), GUIconstants.HEIGHT.getValue()));

		createPizzaOrderView();

		pizzaFrame.add(mainLayout);
	}

	private void createPizzaOrderView() {
		JPanel infoPanel = new PizzaOrderView(this);
		mainLayout.add(infoPanel);		
	}

	private void init_PizzaFrame() {
		pizzaFrame = new JFrame("New Order");
		pizzaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pizzaFrame.setLocation(new Point(300, 200));
		pizzaFrame.setResizable(false);
		pizzaFrame.setSize(GUIconstants.FRAME_WIDTH.getValue(),
				GUIconstants.FRAME_HEIGHT.getValue());
		pizzaFrame.setVisible(true);

		// Main Screen
		initView();
		
		pizzaFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				controller.enableNewOrder();
			}
		});
	}
	
	public List<PizzaDTO> getPizza(){
		return pizzas;
	}
}
