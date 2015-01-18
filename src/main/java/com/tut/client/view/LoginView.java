package com.tut.client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.tut.client.controller.Colors;
import com.tut.client.controller.GUIconstants;
import com.tut.client.controller.MainController;

public class LoginView extends JPanel {

	// Constructor
	public LoginView(MainController controller) {
		this.mainController = controller;

		this.setBackground(Colors.MAIN_BACKGROUND.getColor());

		FlowLayout layout = new FlowLayout();
		layout.setVgap(0);
		this.setLayout(layout);

		setupLoginView();
	}

	private void setupLoginView() {
		mainLayout = Box.createHorizontalBox();
		mainLayout.setPreferredSize(new Dimension(GUIconstants.WIDTH.getValue(), GUIconstants.HEIGHT.getValue()));

		createDeskNoteInfo();
		createLoginPanel();

		this.add(mainLayout);
	}

	private void createDeskNoteInfo() {
		register = new JButton("Register");
		register.addActionListener(new ButtonListener());

	}

	private void createLoginPanel() {
		tfUsername = new JTextField(); // LoginFields
		tfPassword = new JPasswordField();
		login = new JButton("Sign in");

		// Login Button
		login.setFocusable(false);
		login.addActionListener(new ButtonListener());

		// Main LoginPanel
		JPanel loginPanel = new JPanel(new BorderLayout());
		loginPanel.setBackground(Colors.ACCOUNT_BOX.getColor());
		loginPanel.setBorder(BorderFactory.createLineBorder(Colors.ACCOUNT_BORDER.getColor(), 1));

		// Panel for TextFields
		Box loginFields = Box.createVerticalBox();
		JLabel signIn = new JLabel("Sign in");
		signIn.setFont(new Font("Calibri", Font.BOLD, 25));
		signIn.setForeground(Colors.PURPLE.getColor());

		loginFields.add(Box.createVerticalStrut(60));
		loginFields.add(signIn);
		loginFields.add(Box.createVerticalStrut(30));

		loginFields.add(new JLabel("Username"));
		loginFields.add(tfUsername);
		loginFields.add(new JLabel("Password"));
		loginFields.add(tfPassword);
		loginFields.add(Box.createVerticalStrut(30));
		loginFields.add(login);
		loginPanel.add(loginFields, BorderLayout.NORTH);

		mainLayout.add(loginPanel);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == register) {
//				mainController.switchToRegister();
			} else if (e.getSource() == login) {
//				mainController.login(tfUsername.getText(), new String(tfPassword.getPassword()));
			}
		}
	}

	private static final long serialVersionUID = 1L;
	private MainController mainController;

	private Box mainLayout;

	private JButton register;
	private JButton login;

	private JTextField tfUsername;
	private JPasswordField tfPassword;
}
