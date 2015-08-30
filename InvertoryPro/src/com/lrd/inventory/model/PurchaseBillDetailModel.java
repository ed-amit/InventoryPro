package com.lrd.inventory.model;

public class PurchaseBillDetailModel {

	private int purchase_detail_id;
	private int purchase_bill_id;
	
	private String product_code;
	private String product_image;
	private String product_name;
	private String unit;
	
	private double discount;
	private double free;
	private double mrp;
	private double online_sale_price;
	private double purchase_price;
	private double quantity;
	private double sale_rate;
	private double total_cost;
	private double vat_amount;
	private double vat_percent;
	private double whole_sale_price;
	
	public PurchaseBillDetailModel() {
		
	}

	
	public void setDefault(){
		purchase_detail_id = purchase_bill_id = 0;
		
		product_code = product_image = product_name = unit = "";
		
		discount = free = mrp = online_sale_price = purchase_price = 0;
		quantity = sale_rate = total_cost = vat_amount = 0;
		vat_percent = whole_sale_price = 0;
	}
	
	
	public void setPurchaseDetailId (int id){
		this.purchase_detail_id = id;
	}
	
	public void setPurchaseBillId (int id){
		this.purchase_bill_id = id;
	}
	
	public void setProductCode (String code){
		this.product_code=code ;
	}
	
	public void setProductImange (String image){
		this.product_image= image;
	}
	
	public void setProductName (String name){
		this.product_name = name;
	}
	
	public void setUnit (String unit){
		this.unit= unit;
	}
	
	public void setDiscount (double amount){
		this.discount =amount;
	}
	
	public void setFreeProduct (double quantity){
		this.free =quantity;
	}
	
	public void setMRP (double amount){
		this.mrp =  amount;
	}
	
	public void setOnlineSaleRate (double amount){
		this.online_sale_price = amount;
	}
	
	public void setPurchasePrice (double amount){
		this.purchase_price = amount;
	}
	
	public void setQuantity (double quantity){
		this.quantity = quantity;
	}
	
	public void setSaleRate (double amount){
		this.sale_rate = amount;
	}
	
	public void setTotalCost (double amount){
		this.total_cost =amount;
	}
	
	public void setVatAmount (double amount){
		this.vat_amount = amount ;
	}
	
	public void setVatPercent (double percent){
		this.vat_percent = percent;
	}
	
	public void setWholeSalePrice (double amount){
		this.whole_sale_price = amount;
	}
	
	
	
	
	public int getPurchaseDetailId (){
		return this.purchase_detail_id ;
	}
	
	public int getPurchaseBillId (){
		return this.purchase_bill_id ;
	}
	
	public String getProductCode (){
		return this.product_code ;
	}
	
	public String getProductImage (){
		return this.product_image ;
	}
	
	public String getProductName (){
		return this.product_name ;
	}
	
	public String getUnit (){
		return this.unit ;
	}
	
	public double getDiscount (){
		return this.discount ;
	}
	
	public double getFreeProduct (){
		return this.free ;
	}
	
	public double getMRP (){
		return this.mrp ;
	}
	
	public double getOnlineSaleRate (){
		return this.online_sale_price ;
	}
	
	public double getPurchasePrice (){
		return this.purchase_price ;
	}
	
	public double getQuantity (){
		return this.quantity ;
	}
	
	public double getSaleRate (){
		return this.sale_rate ;
	}
	
	public double getTotalCost (){
		return this.total_cost ;
	}
	
	public double getVatAmount (){
		return this.vat_amount ;
	}
	
	public double getVatPercent (){
		return this.vat_percent ;
	}
	
	public double getWholeSalePrice (){
		return this.whole_sale_price ;
	}
	
	
}
