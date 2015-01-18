package com.tut.client.controller;

import java.awt.Color;

public enum Colors {

	MAIN_BACKGROUND(new Color(220, 220, 220)), // Start Screen

	ACCOUNT_BOX(new Color(241, 241, 241)), // Login, Register Box
	ACCOUNT_BORDER(new Color(229, 229, 229)),

	DESKNOTE_BACKGROUND(new Color(243, 249, 251)), // NoteList and Note
													// Background
	NOTE_BORDER(new Color(224,220,191)), NOTE_ITEM(new Color(255,248,220)), NOTE_ITEM_HOVER(new Color(220, 230, 242)),

	BLACK(Color.BLACK), WHITE(Color.WHITE), RED(Color.RED), LIGHT_GRAY(Color.LIGHT_GRAY), ORANGE(new Color(255, 144, 0)), PURPLE(
			new Color(128, 100, 162)), YELLOW(Color.YELLOW);

	// properties
	private Color color;

	// Constructor
	Colors(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}
}
