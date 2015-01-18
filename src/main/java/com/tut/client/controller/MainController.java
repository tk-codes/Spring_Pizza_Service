package com.tut.client.controller;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tut.client.view.MainInfoView;

public class MainController {

	// Main
	private JFrame mainFrame;
	private MainInfoView infoPanel;
	private Box mainLayout;
	
	public void run() {
		init_MainFrame();
	}

	private void initView() {
		mainLayout = Box.createHorizontalBox();
		mainLayout.setPreferredSize(new Dimension(GUIconstants.WIDTH_1.getValue(), GUIconstants.HEIGHT_1.getValue()));

		createMainView();

		mainFrame.add(mainLayout);
	}

	private void createMainView() {
		infoPanel = new MainInfoView(this);
		mainLayout.add(infoPanel);		
	}

	private void init_MainFrame() {
		mainFrame = new JFrame("Pizza Service: A Spring Application");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocation(new Point(300, 200));
		mainFrame.setResizable(false);
		mainFrame.setSize(GUIconstants.MAIN_WIDTH.getValue(),
				GUIconstants.MAIN_HEIGHT.getValue());
		mainFrame.setVisible(true);

		// Main Screen
		initView();
		init_NewOrder();
	}
	
	public void init_NewOrder(){
		NewOrderController pizzaOrder = new NewOrderController(this);
		pizzaOrder.run();
	}
	
	public void enableNewOrder(){
		infoPanel.enableNewOrder();
	}
}
