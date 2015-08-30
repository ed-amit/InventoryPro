package com.lrd.inventory.model;

public class ProductModel {
	
	
	private int product_id;
	private String product_code;
	private String product_name;
	private String product_desc;
	private int product_rack_id;
	private int product_category_id;
	private int product_brand_id;
	private String product_unit;
	private double product_quantity;
	private double product_purchase_rate;
	private double product_mrp;
	private double product_sale_rate;
	private double product_wholesale_rate;
	private double product_online_rate;
	private double product_vat_percent;
	private double product_low_quantity;
	private int product_firm_id;
	private int product_store_id;
	private int product_year_id;
	
	

	public ProductModel() {
		setDefault();
	}
	
	public void setDefault(){
		product_id = product_rack_id = product_category_id = product_brand_id = product_firm_id = product_store_id = product_year_id = 0;
		product_code = product_name = product_desc = product_unit = "";
		product_quantity = product_purchase_rate = product_mrp = product_sale_rate = product_wholesale_rate = product_online_rate = product_vat_percent =product_low_quantity = 0;
	}
	
	
	
	public void setProductId (int id){
		this.product_id=id;
	}
	
public void setProductCode (String productCode){
	this.product_code=productCode;	
	}
	
public void setProductName (String productName){
	this.product_name = productName;
}

public void setProductDesc (String productDesc){
	this.product_desc = productDesc;
}

public void setRackId (int rackId){
	this.product_rack_id = rackId;
}

public void setCategoryId (int categoryId){
	this.product_category_id=categoryId;
}

public void setBrandId (int brandId){
	this.product_brand_id = brandId;
}

public void setUnit (String unit){
	this.product_unit = unit;
}

public void setQuantity (double quantity){
	this.product_quantity = quantity;
}

public void setPurchaseRate (double rate){
	this.product_purchase_rate =rate;
}

public void setMRP (double rate){
	this.product_mrp = rate;
}

public void setSaleRate (double rate){
	this.product_sale_rate = rate;
}

public void setWholesaleRate (double rate){
	this.product_wholesale_rate =rate;
}

public void setOnlineRate (double rate){
	this.product_online_rate =rate;
}

public void setVatPercent (double vatPercent){
	this.product_vat_percent =vatPercent;
}

public void setLowQuantity (double quantity){
	this.product_low_quantity = quantity;
}

public void setFirmId (int id){
	this.product_firm_id = id;
}

public void setStoreId (int id){
	this.product_store_id =id;
}

public void setYearId (int id){
	this.product_year_id = id;
}






public int getProductId (){
	return this.product_id ;
}

public String getProductCode (){
	return this.product_code ;
}

public String getProductName (){
	return this.product_name ;
}

public String getProductDesc (){
	return this.product_desc ;
}

public int getRackId (){
	return this.product_rack_id ;
}

public int getCategoryId (){
	return this.product_category_id ;
}

public int getBrandId (){
	return this.product_brand_id ;
}

public String getUnit (){
	return this.product_unit ;
}

public double getQuantity (){
	return this.product_quantity ;
}

public double getPurchaseRate (){
	return this.product_purchase_rate ;
}

public double getMRP (){
	return this.product_mrp ;
}

public double getSaleRate (){
	return this.product_sale_rate ;
}

public double getWholesaleRate (){
	return this.product_wholesale_rate ;
}

public double getOnlineRate (){
	return this.product_online_rate ;
}

public double getVatPercent (){
	return this.product_vat_percent ;
}

public double getLowQuantity (){
	return this.product_low_quantity ;
}

public int getFirmId (){
	return this.product_firm_id ;
}

public int getStoreId (){
	return this.product_store_id ;
}

public int getYearId (){
	return this.product_year_id ;
}



}
