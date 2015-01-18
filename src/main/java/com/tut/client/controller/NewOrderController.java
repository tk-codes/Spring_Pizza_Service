package com.tut.client.controller;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.springframework.web.client.RestTemplate;

import com.tut.client.view.CustomerPopup;
import com.tut.client.view.PizzaOrderView;
import com.tut.spring.dto.CustomerDTO;
import com.tut.spring.dto.OrderDTO;
import com.tut.spring.dto.PizzaDTO;
import com.tut.spring.dto.PizzaOrderDTO;
import com.tut.spring.service.OrderService;
import com.tut.spring.service.impl.OrderServiceImpl;

public class NewOrderController {

	// View
	private JFrame pizzaFrame;
	private Box mainLayout;
	
	private MainController controller;
	
	private RestTemplate restTemplate;
	
	private List<PizzaDTO> pizzas;
	private PizzaOrderView mainPanel;
	
	private CustomerPopup popup;
	
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
		mainPanel = new PizzaOrderView(this);
		mainLayout.add(mainPanel);		
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

	public void addPizzaOrder(PizzaDTO pizza) {
		mainPanel.addPizzaOrder(pizza);	
	}
	
	public CustomerPopup createPopup(List<PizzaOrderDTO> pizzaOrder) {
		popup = new CustomerPopup(this, pizzaOrder);
		popup.setLocation(new Point(600, 250));
		popup.setResizable(true);
		popup.pack();
		popup.setVisible(true);
		popup.toFront();
		popup.addWindowListener(new PopupListener());
		popup.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		return popup;
	}
	
	/** Window Events */
	class PopupListener extends WindowAdapter {

		// Disable Main Frame
		public void windowOpened(WindowEvent e) {
			super.windowOpened(e);
//			pizzaFrame.setEnabled(false);
		}

		// Enable Window again
		public void windowClosed(WindowEvent w) {
			super.windowClosed(w);
//			pizzaFrame.setEnabled(true);
		}
	}

	public void sendOrder(CustomerDTO c, List<PizzaOrderDTO> pizzaOrder) {
		OrderDTO o = new OrderDTO();
		o.setCustomer(c);
		
		for(PizzaOrderDTO pz : pizzaOrder){
			o.addPizza(pz);
		}
		
		if(pizzaOrder.isEmpty()){
			
		}else{
			
			restTemplate.postForObject("http://localhost:14140/order_service/order/", o, OrderDTO.class);
			popup.dispose();		
			mainPanel.clearOrder();
		}		
	}
}
