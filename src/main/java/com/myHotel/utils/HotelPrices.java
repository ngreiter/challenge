package com.myHotel.utils;

public enum HotelPrices {

	DIARIASEMANAL(120), DIARIAESPECIAL(150),

	VAGASEMANAL(15), VAGAESPECIAL(20);

	private int value;

	HotelPrices(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}

}
