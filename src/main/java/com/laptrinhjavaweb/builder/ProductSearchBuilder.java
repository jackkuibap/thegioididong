package com.laptrinhjavaweb.builder;

public class ProductSearchBuilder {
	private String name;
	private String color;
	private String code;
	private Integer cost;
	private String feature;

	private ProductSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.color = builder.color;
		this.code = builder.code;
		this.cost = builder.cost;
		this.feature = builder.feature;
		
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

	public Integer getCost() {
		return cost;
	}

	public String getFeature() {
		return feature;
	}

	public static class Builder{
		private String name;
		private String color;
		private String code;
		private Integer cost;
		private String feature;
		
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
		public Builder setCost(Integer cost) {
			this.cost = cost;
			return this;
		}
		public Builder setFeature(String feature) {
			this.feature = feature;
			return this;
		}
		
		public ProductSearchBuilder build() {
			return new ProductSearchBuilder(this);
		}
	}
}
