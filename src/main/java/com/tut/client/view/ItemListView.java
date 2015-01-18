package com.tut.client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.NumberFormatter;

import com.tut.client.controller.Colors;
import com.tut.client.controller.GUIconstants;
import com.tut.client.controller.NewOrderController;
import com.tut.spring.dto.PizzaDTO;
import com.tut.spring.dto.PizzaOrderDTO;

public class ItemListView extends JPanel {
	
	private int standardHeight = 100;
	
	private String[] listOfFiles =  {"1.jpg", "2.jpg","4.jpg","7.jpg","8.jpg","9.png","12.jpg","13.jpg","23.jpg"};
	private LinkedList<Image> images;
	private int pointer = 0;
	
	private Locale locale = new Locale("de_CH");
//	private Currency currency = Currency.getInstance(locale);
	private NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
	
	private DecimalFormat df = new DecimalFormat("##.##");

	public ItemListView(NewOrderController controller) {
		this.controller = controller;

		this.setOpaque(true);
		this.setBackground(Colors.DESKNOTE_BACKGROUND.getColor());
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		repository = controller.getPizza();
		
		getImages();		
		updateList();
	}

	private void getImages() {
		images = new LinkedList<Image>();
		for(String f : listOfFiles){
			ImageIcon img = new ImageIcon(getClass().getResource("/images/pizza/"+f));
			images.add(img.getImage());
		}
	}

	public void updateList() {
		this.removeAll();
		height = 0;

		for (PizzaDTO pizza : repository) {
			this.add(new NoteItem(pizza));
		}

		this.revalidate();
		this.repaint();
	}

	class NoteItem extends JPanel {

		public NoteItem(PizzaDTO pizza) {
			this.pizza = pizza;

			this.setBorder(BorderFactory.createMatteBorder(1, 1, 0, 0,
					Colors.NOTE_BORDER.getColor()));
			this.setLayout(new FlowLayout(FlowLayout.LEADING,standardHeight+50, 10));
			
			setItemView();
			increasePanelHeight();
			this.addMouseListener(new ItemListener());
		}

		public PizzaDTO getPizza() {
			return this.pizza;
		}

		public void setItemView() {			
			this.setMaximumSize(new Dimension(GUIconstants.PIZZA_NOTE_WIDTH_MAX.getValue(), standardHeight));
			this.setBackground(Colors.NOTE_ITEM.getColor());					
						
			Box verBox = Box.createVerticalBox();
			
			JLabel titleDeskNote = new JLabel(pizza.getName());
			titleDeskNote.setFont(new Font("Aharoni", Font.BOLD, 18));
			
			JLabel name = new JLabel(pizza.getIncredients());
			name.setFont(new Font("Calibri", Font.ITALIC, 15));
			
			
			JLabel price = new JLabel("CHF "+ currencyFormatter.format(pizza.getPrice()));
			price.setFont(new Font("Calibri", Font.ITALIC, 15));
			price.setForeground(Color.red);
			JButton add = new JButton("add");
			add.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					controller.addPizzaOrder(getPizza());
				}
			});
			
			verBox.add(titleDeskNote);
			verBox.add(name);
			verBox.add(price);
			verBox.add(add);
			
			this.add(verBox);
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if(pointer>=9){
				pointer=0;
			}
			
			g.drawImage(images.get(pointer),0,0,standardHeight+25, standardHeight+25,null);

			pointer++;	
		}

		private static final long serialVersionUID = 1L;
		private PizzaDTO pizza;

	}

	class ItemListener extends MouseAdapter {
		 
	}

	private void increasePanelHeight() {
		height += standardHeight;
		this.setPreferredSize(new Dimension(GUIconstants.PIZZA_NOTE_WIDTH.getValue(), height));
	}

	private static final long serialVersionUID = 1L;

	private int height;
	private List<PizzaDTO> repository;
	private NewOrderController controller;
}
