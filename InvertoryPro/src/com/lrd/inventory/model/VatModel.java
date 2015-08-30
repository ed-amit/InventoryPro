package com.lrd.inventory.model;

public class VatModel {
	
	int vat_id;
	float vat_percent;
	int year_id;
	int firm_id;
	int vat_updateValue;

	public VatModel() {
		setDefault();
	}
	
	public void setDefault(){
		vat_id=year_id=firm_id=vat_updateValue = 0 ;
		vat_percent=(float) 0.0;
	}
	
	
	
	public void setVatId(int vatId){
		this.vat_id=vatId;
	}
	
	public void setVatPercent(float vatPercent){
		this.vat_percent = vatPercent;
	}
	
	public void setYearId(int yearId){
		this.year_id=yearId;
	}
	
	public void setFirmId(int firmId){
		this.firm_id=firmId;
	}
	
	public void setVatUpdated(int value){
		this.vat_updateValue=value;
	}
	

	
	
	public int getVatId(){
		return this.vat_id;
	}
	
	public float getVatPercent(){
		return this.vat_percent;
	}
	
	public int getYearId(){
		return this.year_id;
	}
	
	public int getFermId(){
		return this.firm_id;
	}
	
	public int getVatUpdated(){
		return this.vat_updateValue;
	}
	
}
