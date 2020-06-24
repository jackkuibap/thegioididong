package com.laptrinhjavaweb.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.spi.ResolveResult;

import com.laptrinhjavaweb.builder.ProductSearchBuilder;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.StoreDTO;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.service.IStoreSevice;
import com.laptrinhjavaweb.service.impl.ProductService;
import com.laptrinhjavaweb.service.impl.StoreService;

public class ProductController {
	
	public static void main(String[] args) {
		/*IProductService productService = new ProductService();
		List<ProductDTO> productDTOs = productService.findAll();
				for (ProductDTO item: productDTOs) {
			System.out.println("ID:" + item.getId());
			System.out.println("Ten dien thoai:" + item.getName());
			System.out.println("Gia dien thoai:" + item.getCost());
			System.out.println("Description 1:" + item.getDescription1());
		}
*/

		ProductDTO dto = new ProductDTO();
		dto.setName("Iphone 212");
		dto.setCost(210000);
		dto.setCode("IPHONE_21");
		dto.setCreatedBy("abc");
		dto.setProductCategoryID(1L);
		dto.setCreateDate(new Date());
		IProductService productService = new ProductService();
		ProductDTO productDTO = productService.insert(dto);
		List<ProductDTO> dtos = new ArrayList<>();
		dtos.add(productDTO);
/*		//String name = "Xiaomi Redmi Note 9 Pro";
		String name = "Iphone 21";
		//String color = "Grey";
		//String code = "Xiaomi";
		//String costFrom = "4000000";
		//String costTo = "8000000";
		//String[] features = new String[] {"TYPICAL_1", "SPECIAL_4"};
		//String brand = "Xiaomi";
		//Long storeID = 1L;
		ProductSearchBuilder builder = new ProductSearchBuilder.Builder()
				.setName(name)
				//.setColor(color).setCode(code)
				//.setCostFrom(costFrom).setCostTo(costTo)
				//.setFeatures(features).setBrand(brand)
				//.setStoreID(storeID)
				.build();
		IProductService productService = new ProductService();
		List<ProductDTO> result = productService.findAll(builder);
		System.out.println(result);
*/		
		/*IStoreSevice storeSevice = new StoreService();
		StoreDTO storeDTO = new StoreDTO();
		storeDTO.setName("TGDD Bình Thạnh");
		storeDTO.setCode("BINH_THANH");
		storeSevice.insert(storeDTO);
		*/
	}
}
