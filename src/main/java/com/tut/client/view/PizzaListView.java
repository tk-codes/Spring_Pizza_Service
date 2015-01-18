package com.tut.client.view;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.tut.client.controller.Colors;
import com.tut.client.controller.GUIconstants;
import com.tut.client.controller.NewOrderController;

public class PizzaListView extends JPanel {
	
	// Constructor
	public PizzaListView(NewOrderController controller) {
		this.controller = controller;

		this.setBackground(Colors.DESKNOTE_BACKGROUND.getColor());
		this.setPreferredSize(new Dimension(GUIconstants.NOTE_WIDTH.getValue(), GUIconstants.HEIGHT.getValue()));
		createComponents();
	}

	private void createComponents() {
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setPreferredSize(new Dimension(GUIconstants.NOTE_WIDTH.getValue(), GUIconstants.HEIGHT.getValue()));
		verticalBox.setOpaque(true);
		
		JLabel title = new JLabel("Pizza");
		title.setFont(new Font("Calibri", Font.BOLD, 25));
		title.setAlignmentX(Component.LEFT_ALIGNMENT);
		verticalBox.add(title);
		
		Box horizontalBox = Box.createHorizontalBox();
		JTextField tfSearch = new JTextField();
		horizontalBox.add(tfSearch);

		JButton button1 = new JButton("Search");
		button1.setBackground(Colors.LIGHT_GRAY.getColor());
		button1.setFocusable(false);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//controller.addPizzaOrder();
			}
		});
		horizontalBox.add(button1);

		listItems = new ItemListView(controller);
		JScrollPane scroller = new JScrollPane(listItems);
		scroller.setPreferredSize(new Dimension(GUIconstants.NOTE_WIDTH.getValue(), 326));
		scroller.setBorder(BorderFactory.createEmptyBorder());
		scroller.setOpaque(true);

		verticalBox.add(Box.createVerticalStrut(5));
		verticalBox.add(horizontalBox);
		verticalBox.add(Box.createVerticalStrut(15));
		verticalBox.add(scroller);
		this.add(verticalBox);
	}
	private static final long serialVersionUID = 1L;

	private NewOrderController controller;
//	private NoteList repository;
//
	private ItemListView listItems;
}
