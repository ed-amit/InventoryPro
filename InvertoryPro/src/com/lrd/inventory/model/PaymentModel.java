package com.lrd.inventory.model;

public class PaymentModel {
	
	
	private int payment_id;
	private int ref_id;
	private int store_id;
	private double paid_amount;
	
	private String bank_name;
	private String code;
	private String Description;
	private String payment_date;
	private String payment_mode;
	
	

	public PaymentModel() {
		setDefault();
	}
	
	public void setDefault(){
		payment_id=ref_id=store_id=0;
		paid_amount=0;
		bank_name=code=Description=payment_date=payment_mode="";
	}
	
	
	
	
	public void setPaymentId (int paymentId){
		this.payment_id = paymentId;
	}
	
	public void setRefId (int refId){
		this.ref_id = refId;
	}
	
	public void setStoreId (int storeId){
		this.store_id = storeId;
	}
	
	public void setPaidAmt (double amt){
		this.paid_amount = amt;
	}
	
	public void setBankName (String bankName){
		this.bank_name = bankName;
	}
	
	public void setCode (String code){
		this.code = code;
	}
	
	public void setDescription (String description){
		this.Description = description ;
	}
	
	public void setPaymentDate (String date){
		this.payment_date = date;
	}
	
	public void setPaymentMode (String mode){
		this.payment_mode = mode;
	}
	
	
	
	
	public int getPaymentId (){
		return this.payment_id ;
	}
	
	public int getRefId (){
		return this.ref_id ;
	}
	
	public int getStoreId (){
		return this.store_id ;
	}
	
	public double getPaidAmt (){
		return this.paid_amount ;
	}
	
	public String getBankName (){
		return this.bank_name ;
	}
	
	public String getCode (){
		return this.code ;
	}
	
	public String getDescription (){
		return this.Description ;
	}
	
	public String getPaymentDate (){
		return this.payment_date ;
	}
	
	public String getPaymentMode (){
		return this.payment_mode ;
	}
	
	

}
