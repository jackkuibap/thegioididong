package com.laptrinhjavaweb.enums;

public enum ProductBrandEnum {
    IPHONE("Iphone"),  
    SAMSUNG("Samsung"), 
    OPPO("Oppo"),   
    XIAOMI("Xiaomi"),  
    VIVO("Vivo"),  
    REALME("Realme"), 
    VSMART("Vsmart"), 
    ; // semicolon needed when fields / methods follow


    private String value;

    private ProductBrandEnum(String value) {
        this.value = value;
    }

	public String getValue() {
		return value;
	}
}
