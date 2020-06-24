package com.laptrinhjavaweb.builder;

public class ProductSearchBuilder {
	private String name;
	private String color;
	private String code;
	private String costFrom;
	private String costTo;
	private String[] features = new String[] {};
	private String brand;
	private Long storeID;
	
	private ProductSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.color = builder.color;
		this.code = builder.code;
		this.costFrom = builder.costFrom;
		this.costTo = builder.costTo;
		this.features = builder.features;
		this.brand = builder.brand;
		this.storeID = builder.storeID;
	}
	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public String getCode() {
		return code;
	}

	public String getCostFrom() {
		return costFrom;
	}
	public String getCostTo() {
		return costTo;
	}
	
	public String[] getFeatures() {
		return features;
	}
	public String getBrand() {
		return brand;
	}
	public Long getStoreID() {
		return storeID;
	}

	public static class Builder{
		private String name;
		private String color;
		private String code;
		private String costFrom;
		private String costTo;
		private String[] features = new String[] {};		
		private String brand;
		private Long storeID;
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setColor(String color) {
			this.color = color;
			return this;
		}
		public Builder setCode(String code) {
			this.code = code;
			return this;
		}
		public Builder setCostFrom(String costFrom) {
			this.costFrom = costFrom;
			return this;
		}
		public Builder setCostTo(String costTo) {
			this.costTo = costTo;
			return this;
		}
		public Builder setFeatures(String[] features) {
			this.features = features;
			return this;
		}

		public Builder setBrand(String brand) {
			this.brand = brand;
			return this;
		}
		public Builder setStoreID(Long storeID) {
			this.storeID = storeID;
			return this;
		}
		public ProductSearchBuilder build() {
			return new ProductSearchBuilder(this);
		}
	}
}
