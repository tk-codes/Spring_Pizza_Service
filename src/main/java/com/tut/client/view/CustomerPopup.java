package com.tut.client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tut.client.controller.Colors;
import com.tut.client.controller.GUIconstants;
import com.tut.client.controller.NewOrderController;
import com.tut.spring.dto.CustomerDTO;
import com.tut.spring.dto.PizzaOrderDTO;

public class CustomerPopup extends JDialog {
	
	private List<PizzaOrderDTO> pizzaOrder;

	public CustomerPopup(NewOrderController controller, List<PizzaOrderDTO> pizzaOrder) {
		this.controller = controller;
		this.pizzaOrder = pizzaOrder;

		this.setBackground(Colors.DESKNOTE_BACKGROUND.getColor());
		this.setPreferredSize(new Dimension(GUIconstants.POPUP_WIDTH.getValue(),
				180));

		FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
		layout.setVgap(0);
		this.setLayout(layout);
		createComponents();
		
		this.setTitle("Customer");
	}

	private void createComponents() {
		name = new JTextField("Keerthikan");
		street = new JTextField("Büelhof 5");
		plz = new JTextField("8852");
		place = new JTextField("Altendorf");

		// Main LoginPanel
		JPanel editPanel = new JPanel(new BorderLayout());
		editPanel.setOpaque(false);

		// Label
		JLabel lbEdit = new JLabel("Customer");
		lbEdit.setFont(new Font("Calibri", Font.BOLD, 25));
		lbEdit.setForeground(Colors.PURPLE.getColor());

		// Login Button
		save = new JButton("Send");
		save.setBackground(Colors.LIGHT_GRAY.getColor());
		save.setFocusable(false);
		save.addActionListener(new ButtonListener());

		JPanel editTopPanel = new JPanel(new GridLayout(4, 2));
		editTopPanel.setPreferredSize(new Dimension(GUIconstants.POPUP_WIDTH.getValue(),80));

		editTopPanel.add(new JLabel("Name"));
		editTopPanel.add(name);
		editTopPanel.add(new JLabel("Street"));
		editTopPanel.add(street);
		editTopPanel.add(new JLabel("zip code"));
		editTopPanel.add(plz);
		editTopPanel.add(new JLabel("Place"));
		editTopPanel.add(place);

		editPanel.add(lbEdit, BorderLayout.NORTH);
		editPanel.add(editTopPanel, BorderLayout.WEST);
		editPanel.add(save, BorderLayout.SOUTH);

		this.add(editPanel);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!name.getText().isEmpty()) {
				CustomerDTO c = new CustomerDTO();
				c.setName(name.getText());
				c.setStreet(street.getText());
				c.setPlace(place.getText());
				c.setPlz(Integer.parseInt(plz.getText()));
				controller.sendOrder(c, pizzaOrder);
			} else {
				JOptionPane.showMessageDialog(null, "You can't leave the title empty", "Error",
						JOptionPane.ERROR_MESSAGE, null);
			}
		}
	}

	private static final long serialVersionUID = 1L;
	private NewOrderController controller;
	private JTextField name;
	private JTextField street;
	private JTextField plz;
	private JTextField place;
	private JButton save;
}
