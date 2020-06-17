package com.laptrinhjavaweb.enums;

public enum DistricEnum {
    QUAN_1("Quận 1"),  //calls constructor with value 3
    QUAN_2("Quận 2"),  //calls constructor with value 2
    QUAN_3("Quận 3")   //calls constructor with value 1
    ; // semicolon needed when fields / methods follow


    private String value;

    private DistricEnum(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}
}
