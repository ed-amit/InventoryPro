package com.lrd.inventory.model;

public class SaleOrderDetailModel {

	
	int order_detail_id;
	int order_id;
	
	double product_quantity;
	double product_rate;
	double purchseRate;
	double mrp;
	double vat_percent;
	double vat_amt;
	double discount_percent;
	double discount_amt;
	double subTotal;
	
	String product_code;
	String product_name;
	String product_type;
	String product_unit;
	
	
	public SaleOrderDetailModel() {
		// TODO Auto-generated constructor stub
		setDefault();
	}
	
	
	public void setDefault(){
		order_detail_id = order_id = 0;
		product_quantity =product_rate=mrp=vat_percent=0;
		vat_amt=discount_percent=discount_amt = purchseRate=0;
		
		product_code=product_name="";
		product_type=product_unit="";
		
	}
	
	
	
	
	
	public void setOrderDetailId (int orderDetailId){
		this.order_detail_id = orderDetailId;
	}
	
	public void setOrderId (int orderId){
		this.order_id = orderId;
	}
	
	public void setProductQuantity (double Quantity){
		this.product_quantity = Quantity;
	}
	
	public void setProductRate (double rate){
		this.product_rate = rate;
	}
	
	public void setMrp (double mrp){
		this.mrp = mrp;
	}
	
	public void setVatPercent (double vatPercent){
		this.vat_percent = vatPercent;
	}
	
	public void setVatAmt (double vatAmt){
		this.vat_amt = vatAmt;
	}
	
	public void setDiscountPercent (double discountPercent){
		this.discount_percent = discountPercent;
	}
	
	public void setDiscountAmt (double discountAmt){
		this.discount_amt = discountAmt;
	}
	
	public void setPurchaseRate (double amount){
		this.purchseRate = amount;
	}
	
	public void setSubTotal (double amount){
		this.subTotal = amount;
	}
	
	public void setProductCode (String code){
		this.product_code = code;
	}
	
	public void setProductName (String name){
		this.product_name = name;
	}
	
	public void setProductType (String type){
		this.product_type = type;
	}
	
	public void setProductUnit (String unit){
		this.product_unit = unit;
	}
	
	
	
	
	
	
	
	public int getOrderDetailId (){
		return this.order_detail_id ;
	}
	
	public int getOrderId (){
		return this.order_id ;
	}
	
	public double getProductQuantity (){
		return this.product_quantity ;
	}
	
	public double getProductRate (){
		return this.product_rate ;
	}
	
	public double getMrp (){
		return this.mrp ;
	}
	
	public double getVatPercent (){
		return this.vat_percent ;
	}
	
	public double getVatAmt (){
		return this.vat_amt ;
	}
	
	public double getDiscountPercent (){
		return this.discount_percent ;
	}
	
	public double getDiscountAmt (){
		return this.discount_amt ;
	}
	
	public double getPurchaseRate (){
		return this.purchseRate ;
	}
	
	public double getSubTotal (){
		return this.purchseRate ;
	}
	
	public String getProductCode (){
		return this.product_code ;
	}
	
	public String getProductName (){
		return this.product_name ;
	}
	
	public String getProductType (){
		return this.product_type ;
	}
	
	public String getProductUnit (){
		return this.product_unit ;
	}
	
	

}
