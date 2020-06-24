package com.laptrinhjavaweb.enums;

public enum ProductFeatureEnum {
    FEATURE_1("FEATURE_1"),  //calls constructor with value 3
    FEATURE_2("FEATURE_2"),  //calls constructor with value 2
    FEATURE_3("FEATURE_3"),   //calls constructor with value 1
    FEATURE_4("FEATURE_4"),  //calls constructor with value 3
    FEATURE_5("FEATURE_5"),  //calls constructor with value 2
    FEATURE_6("FEATURE_6")   //calls constructor with value 1
    ; // semicolon needed when fields / methods follow


    private String value;

    private ProductFeatureEnum(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}
}
