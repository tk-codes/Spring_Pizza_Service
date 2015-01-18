package com.tut.client.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tut.client.controller.Colors;
import com.tut.client.controller.GUIconstants;
import com.tut.client.controller.MainController;

public class MainInfoView extends JPanel implements ActionListener {
	
	private MainController controller;

	public MainInfoView(MainController controller) {
		this.controller = controller;

		this.setOpaque(false);
		this.setPreferredSize(new Dimension(GUIconstants.INFO_WITH.getValue(), GUIconstants.HEIGHT.getValue()));
		this.setLayout(new FlowLayout(FlowLayout.CENTER));

		this.setBackground(Colors.MAIN_BACKGROUND.getColor());
		createComponents();
	}

	private void createComponents() {
		Box infoBox = Box.createVerticalBox();
		infoBox.add(Box.createVerticalStrut(25));

		// Title Box
		JLabel titleDeskNote = new JLabel("Pizza Service");
		titleDeskNote.setFont(new Font("Aharoni", Font.BOLD, 35));
		titleDeskNote.setForeground(Colors.BLACK.getColor());
		titleDeskNote.setBackground(Colors.NOTE_BORDER.getColor());
		Box titleBox = Box.createHorizontalBox();
		titleBox.add(Box.createHorizontalStrut(15));
		titleBox.add(titleDeskNote);

		// Slogan Box
		JLabel slogan = new JLabel("A Spring Application");
		slogan.setFont(new Font("Calibri", Font.ITALIC, 20));
		Box sloganBox = Box.createHorizontalBox();
		sloganBox.add(Box.createHorizontalStrut(15));
		sloganBox.add(slogan);

		// Logo Box
		ImageIcon logo = new ImageIcon(getClass().getResource("/images/main.png"));
		JLabel logoHolder = new JLabel(logo);
		Box logoBox = Box.createHorizontalBox();
		logoBox.add(logoHolder);

		JPanel messagePanel = createMessagePanel();

		infoBox.add(titleBox);
		infoBox.add(Box.createVerticalStrut(5));
		infoBox.add(sloganBox);
		infoBox.add(logoBox);
		infoBox.add(Box.createVerticalStrut(15));
		infoBox.add(messagePanel);

		this.add(infoBox);
	}

	private JPanel createMessagePanel() {
		JPanel messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		messagePanel.setOpaque(false);

		newOrder = new JButton("New Order");
		viewOrders = new JButton("View Orders");
		
		newOrder.addActionListener(this);
		viewOrders.addActionListener(this);
		
		messagePanel.add(newOrder);
		messagePanel.add(viewOrders);
		return messagePanel;
	}

	private static final long serialVersionUID = 1L;
	private JButton newOrder;
	private JButton viewOrders;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("New Order")){
			controller.init_NewOrder();
			newOrder.setEnabled(false);
		}
	}

	public void enableNewOrder() {
		newOrder.setEnabled(true);
	}
}
