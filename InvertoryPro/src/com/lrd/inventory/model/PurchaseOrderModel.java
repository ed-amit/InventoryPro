package com.lrd.inventory.model;

public class PurchaseOrderModel {

	private int order_id;
	private int total_product;
	private int receipt_id;
	private int store_id;
	private int year_id;
	
	private String expected_date;
	private String order_date;
	private String status;
	private String supplier_name;
	
	public PurchaseOrderModel() {
		setDefault();
	}
	
	public void setDefault(){
		order_id = total_product = receipt_id = store_id = year_id = 0;
		expected_date = order_date = status = supplier_name = "";
	}
	
	
	public void setOrderId (int id){
		this.order_id = id ;
	}
	
	public void setTotalProduct (int count){
		this.total_product = count ;
	}
	
	public void setReceiptId (int id){
		this.receipt_id = id ;
	}
	
	public void setStoreId(int id){
		this.store_id = id ;
	}
	
	public void setYearId (int id){
		this.year_id = id ;
	}
	
	public void setExceptedDate (String date){
		this.expected_date = date ;
	}
	
	public void setOrderDate (String date){
		this.order_date = date ;
	}
	
	public void setStatus (String status){
		this.status = status ;
	}
	
	public void setSupplierName (String name){
		this.supplier_name = name ;
	}
	
	public int getOrderId (){
		return this.order_id ;
	}
	
	public int getTotalProduct (){
		return this.total_product ;
	}
	
	public int getReceiptId (){
		return this.receipt_id ;
	}
	
	public int getStoreId (){
		return this.store_id ;
	}
	
	public int getYearId (){
		return this.year_id ;
	}
	
	public String getExpectedDate (){
		return this.expected_date ;
	}
	
	public String getOrderDate (){
		return this.order_date ;
	}
	
	public String getStatus (){
		return this.status ;
	}
	
	public String getSupplierName (){
		return this.supplier_name ;
	}
	
	

}
