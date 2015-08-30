package com.lrd.inventory.model;

public class CategoryModel {
	
	int category_id ;
	String category_name ;
	String category_desc;
	int rack_id;
	int firm_id;
	int store_id;

	public CategoryModel() {
		setDefault();
	}
	
	public void setDefault(){
		category_id = rack_id = firm_id = store_id =0;
		category_name=category_desc=null;
	}
	
	
	
	
	/**
	 * 
	 * @param id
	 */
	public void setCategoryId(int id){
		this.category_id = id;
	}
	
	
	/**
	 * 
	 * @param name
	 */
	public void setCategoryName(String name){
		this.category_name = name;
	}
	
	public void setCategoryDesc(String desc){
		this.category_desc=desc;
	}
	
	public void setRackId(int id){
		this.rack_id = id;
	}
	
	public void setFirmId(int id){
		this.firm_id=id;
	}
	
	public void setStoreId(int id){
		this.store_id=id;
	}
	
	
	
	
	
	public int getCategoryId(){
		return this.category_id;
	}
	
	public String getCategoryName(){
		return this.category_name;
	}
	
	public String getCategoryDesc(){
		return this.category_desc;
	}
	
	public int getRackId(){
		return this.rack_id;
	}
	
	public int getFirmId(){
		return this.firm_id;
	}
	
	public int getStoreId(){
		return this.store_id;
	}

}
