package com.laptrinhjavaweb.enums;

public enum ProductColorEnum {
    PINK("Pink"),  //calls constructor with value 3
    YELLOW("Yellow"),  //calls constructor with value 2
    BLACK("Black"),   //calls constructor with value 1
    GREY("Grey"),  //calls constructor with value 3
    WHITE("White"),  //calls constructor with value 2
    GREEN("Green")   //calls constructor with value 1
    ; // semicolon needed when fields / methods follow


    private String value;

    private ProductColorEnum(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}
}
