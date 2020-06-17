package com.laptrinhjavaweb.controller;

import java.util.List;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.StoreDTO;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.service.IStoreSevice;
import com.laptrinhjavaweb.service.impl.ProductService;
import com.laptrinhjavaweb.service.impl.StoreService;

public class ProductController {
	
	public static void main(String[] args) {
		IProductService productService = new ProductService();
		List<ProductDTO> productDTOs = productService.findAll();
		for (ProductDTO item: productDTOs) {
			System.out.println("ID:" + item.getId());
			System.out.println("Ten dien thoai:" + item.getName());
			System.out.println("Gia dien thoai:" + item.getCost());
			System.out.println("Description 1:" + item.getDescription1());
		}

/*		ProductDTO productDTO = new ProductDTO();
		productDTO.setName("Iphone 21");
		productDTO.setCost(210000);
		productDTO.setCode("IPHONE_21");
		productService.insert(productDTO);
*/		
		
//		IStoreSevice storeSevice = new StoreService();
	//	StoreDTO storeDTO = new StoreDTO();
		//storeDTO.setName("TGDD Bình Thạnh");
		//storeDTO.setCode("BINH_THANH");
		//storeSevice.insert(storeDTO);
	}
}
