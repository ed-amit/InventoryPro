package com.lrd.inventory.model;

public class CreditorModel {

	
	int id;
	int firm_id;
	int store_id;
	
	double creditAmt;
	double credit_limit;
	double debitAmt;
	
	String name;
	String address;
	String contact_no;
	
	
	
	public CreditorModel() {
		setDefault();
	}
	
	public void setDefault(){
		id=firm_id=store_id=0;
		creditAmt=credit_limit=debitAmt=0;
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
	
	public void setCreditAmt(double amount){
		this.creditAmt = amount;
	}
	
	public void setCreditLimit(double amount){
		this.credit_limit = amount;
	}
	
	public void setDebitAmt(double amount){
		this.debitAmt = amount;
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
	
	public double getCreditAmt(){
		return this.creditAmt;
	}
	
	public double getCreditLimit(){
		return this.credit_limit;
	}
	
	public double getDebitAmt(){
		return this.debitAmt;
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
