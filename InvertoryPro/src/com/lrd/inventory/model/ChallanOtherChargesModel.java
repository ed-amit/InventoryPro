package com.lrd.inventory.model;

public class ChallanOtherChargesModel {

	int id;
	int challan_id;
	int firm_id;
	int store_id;
	int year_id;
	double amount;
	String charge_name;
	
	
	public ChallanOtherChargesModel() {
		setDefault();
	}
	
	
	public void setDefault(){
		id=challan_id=firm_id=store_id=year_id=0;
		amount=0;
		charge_name="";
	}
	
	
	
	
	public void setId (int id){
		this.id=id;
	}
	
	public void setChallanId (int challanId){
		this.challan_id = challanId;
	}
	
	public void setFirmId (int firmId){
		this.firm_id = firmId;
	}
	
	public void setStoreId (int storeId){
		this.store_id = storeId;
	}
	
	public void setYearId (int yearId){
		this.year_id = yearId;
	}
	
	public void setAmount (double amount){
		this.amount = amount;
	}
	
	public void setChargeName (String chargeName){
		this.charge_name = chargeName;
	}
	
	
	
	public int getId(){
		return this.id;
	}
	
	public int getChallanId(){
		return this.challan_id;
	}
	
	public int getFirmId(){
		return this.firm_id;
	}
	
	public int getStoreId(){
		return this.store_id;
	}
	
	public int getYearId(){
		return this.year_id;
	}
	
	public double getAmount(){
		return this.amount;
	}
	
	public String getChargeName(){
		return this.charge_name;
	}

}

