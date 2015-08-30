package com.lrd.inventory.model;

public class RackModel {
	
	int rack_id ;
	String rack_name ;
	String rack_desc;
	int firm_id;
	int store_id;

	public RackModel() {
		setDefault();
	}
	
	public void setRackId(int id){
		this.rack_id = id;
	}
	
	public void setRackName(String name){
		this.rack_name = name;
	}
	
	public void setRackDesc(String desc){
		this.rack_desc=desc;
	}
	
	public void setFirmId(int id){
		this.firm_id=id;
	}
	
	public void setStoreId(int id){
		this.store_id=id;
	}
	
	
	
	
	public int getRackId(){
		return this.rack_id;
	}
	
	public String getRackName(){
		return this.rack_name;
	}
	
	public String getRackDesc(){
		return this.rack_desc;
	}
	
	public int getFirmId(){
		return this.firm_id;
	}
	
	public int getStoreId(){
		return this.store_id;
	}
	
	public void setDefault(){
		rack_id = firm_id = store_id =0;
		rack_name=rack_desc=null;
	}

}
