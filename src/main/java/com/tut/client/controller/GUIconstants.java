package com.tut.client.controller;

public enum GUIconstants {
	
	MAIN_WIDTH(400), MAIN_HEIGHT(380), WIDTH_1(395), HEIGHT_1(350),
	
	FRAME_WIDTH(760), FRAME_HEIGHT(415), WIDTH(755), HEIGHT(387),

	INFO_WITH(525),

	NOTE_WIDTH(450), NOTE_PADDING_LEFT(5),

	NOTELIST_WIDTH(305),
	
	PIZZA_NOTE_WIDTH_MAX(450),
	
	PIZZA_NOTE_WIDTH(420),

	POPUP_WIDTH(300), POPUP_HEIGHT(300);

	private int value;

	// Constructor
	private GUIconstants(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
