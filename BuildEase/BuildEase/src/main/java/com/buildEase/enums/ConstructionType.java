package com.buildEase.enums;

public enum ConstructionType {

	WAREHOUSE(6), HOUSE(4), APARTMENT(12), MALL(24);

	int value;

	private ConstructionType(int month) {
		this.value = month;
	}

}
