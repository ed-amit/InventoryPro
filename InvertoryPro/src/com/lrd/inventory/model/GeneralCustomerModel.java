package com.lrd.inventory.model;

public class GeneralCustomerModel {

	
	int id;
	int firm_id;
	int store_id;
	
	String name;
	String address;
	String contact_no;
	
	
	
	public GeneralCustomerModel() {
		setDefault();
	}
	
	public void setDefault(){
		id=firm_id=store_id=0;
		name = address = contact_no = "";
	}
	
	
	
	
	public void setId(int id){
		this.id = id;
	}
	
	public void setFirmId(int firmId){
		this.firm_id = firmId;
	}
	
	public void setStoreId(int id){
		this.store_id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setContactNo(String contactNo){
		this.contact_no = contactNo;
	}
	
	
	
	public int getId(){
		return this.id;
	}
	
	public int getFirmId(){
		return this.firm_id;
	}
	
	public int getStoreId(){
		return this.store_id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getContactNo(){
		return this.contact_no;
	}

}
