package com.laptrinhjavaweb.controller;

import com.laptrinhjavaweb.enums.DistricEnum;

public class test {
	public static void main(String[] args) {
		for (DistricEnum item: DistricEnum.values()) {
			System.out.println("code: "+item);
			System.out.println("code: "+item.getValue());
		}
	}
}
