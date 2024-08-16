package com.construction.enums;

public enum ConstructionType {

	WAREHOUSE(6), HOUSE(4), APARTMENT(12), MALL(24);

	int value;

	private ConstructionType(int month) {
		this.value = month;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	

}
