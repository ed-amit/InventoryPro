package com.lrd.inventory.model;

public class PurchaseOrderDetailModel {

	private int order_detail_id;
	private int order_id;
	
	private String product_code;
	private String product_name;
	private String unit;
	
	private double quantity;
	
	public PurchaseOrderDetailModel() {
		setDefault();
	}
	
	
	public void setDefault(){
		quantity = order_detail_id = order_id = 0 ;
		product_code = product_name = unit = "" ;
	}
	
	
	public void setOrederDeatilId(int id){
		this.order_detail_id = id;
	}
	
	public void setOrderId(int id){
		this.order_id = id;
	}
	
	public void setQuantity(double quantity){
		this.quantity = quantity;
	}
	
	public void setProductCode(String code){
		this.product_code = code;
	}
	
	public void setProductName(String name){
		this.product_name = name;
	}
	
	public void setUnit(String unit){
		this.unit = unit;
	}
	
	
	public int getOrderDetailId(){
		return this.order_detail_id;
	}
	
	public int getOrderId(){
		return this.order_id;
	}
	
	public double getQuantity(){
		return this.quantity;
	}
	
	public String getProductCode(){
		return this.product_code;
	}
	
	public String getProductName(){
		return this.product_name;
	}
	
	public String getUnit(){
		return this.unit;
	}
	
}
