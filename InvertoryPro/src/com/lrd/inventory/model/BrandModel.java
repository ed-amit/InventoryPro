package com.lrd.inventory.model;

public class BrandModel {

	int brand_id;
	String brand_name;
	String brand_desc;
	int category_id;
	int rack_id;
	int firm_id;
	int store_id;

	public BrandModel() {
		setDefault();
	}

	public void setDefault() {
		brand_id = category_id = rack_id = firm_id = store_id = 0;
		brand_name = brand_desc = null;
	}

	public void setBrandId(int id) {
		this.brand_id = id;
	}

	public void setBrandName(String name) {
		this.brand_name = name;
	}

	public void setBrandDesc(String desc) {
		this.brand_desc = desc;
	}

	public void setCategoryId(int id) {
		this.category_id = id;
	}

	public void setRackId(int id) {
		this.rack_id = id;
	}

	public void setFirmId(int id) {
		this.firm_id = id;
	}

	public void setStoreId(int id) {
		this.store_id = id;
	}

	public int getBrandId() {
		return this.brand_id;
	}

	public String getBrandName() {
		return this.brand_name;
	}

	public String getBrandDesc() {
		return this.brand_desc;
	}

	public int getCategoryId() {
		return this.category_id;
	}

	public int getRackId() {
		return this.rack_id;
	}

	public int getFirmId() {
		return this.firm_id;
	}

	public int getStoreId() {
		return this.store_id;
	}

}
