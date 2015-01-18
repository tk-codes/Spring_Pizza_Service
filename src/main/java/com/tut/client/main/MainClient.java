package com.tut.client.main;

import javax.swing.SwingUtilities;

import com.tut.client.controller.MainController;

public class MainClient {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {

				MainController main = new MainController();
				main.run();

			}

		});

	}

}
