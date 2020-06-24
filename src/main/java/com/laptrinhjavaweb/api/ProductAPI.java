package com.laptrinhjavaweb.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.api.input.ProductInput;
import com.laptrinhjavaweb.api.output.ProductCategoryOutput;
import com.laptrinhjavaweb.api.output.ProductColorOutput;
import com.laptrinhjavaweb.builder.ProductSearchBuilder;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductCategoryService;
import com.laptrinhjavaweb.service.IProductService;
import com.laptrinhjavaweb.service.impl.ProductCategoryService;
import com.laptrinhjavaweb.service.impl.ProductService;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet("/product")
public class ProductAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductService productService = new ProductService();
	private IProductCategoryService productCategoryService = new ProductCategoryService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String action = request.getParameter("action");
		if (action != null && action.equals("SEARCH_PRODUCT")) {
			ProductInput productInput = FormUtil.toModel(ProductInput.class, request);
			ProductSearchBuilder builder = new ProductSearchBuilder.Builder()
					.setName(productInput.getName())
					.setColor(productInput.getColor())
					.setCode(productInput.getCode())
					.setCostFrom(productInput.getCostFrom())
					.setCostTo(productInput.getCostTo())
					.setFeatures(productInput.getFeatures())
					.setBrand(productInput.getBrand())
					.setStoreID(productInput.getStoreID())
					.build();
							
			List<ProductDTO> result = productService.findAll(builder);
			mapper.writeValue(response.getOutputStream(), result);
		} else if (action != null && action.equals("GET_PRODUCT_BRAND")) {
			List<ProductCategoryOutput> result = productCategoryService.findAll();
			mapper.writeValue(response.getOutputStream(), result);
			
		} else if (action != null && action.equals("GET_PRODUCT_COLOR")) {
			List<ProductColorOutput> result = productService.getProductColor(); 
			mapper.writeValue(response.getOutputStream(), result);
			//mapper.writeValue(response.getOutputStream(), productService.getMapProductColor());
		} else if (action != null && action.equals("GET_PRODUCT_FEATURE")) {
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		ProductDTO productdto = HttpUtil.of(request.getReader()).toModel(ProductDTO.class);
		productService.insert(productdto);
		mapper.writeValue(response.getOutputStream(), productdto);
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
