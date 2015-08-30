package com.lrd.inventory.model;

public class ChallanPaymentModel {
	
	
	int payment_id;
	int challan_id;
	double paid_amount;
	
	String bank_name;
	String code;
	String Description;
	String payment_date;
	String payment_mode;
	
	

	public ChallanPaymentModel() {
		setDefault();
	}
	
	public void setDefault(){
		payment_id=challan_id=0;
		paid_amount=0;
		bank_name=code=Description=payment_date=payment_mode="";
	}
	
	
	
	
	public void setPaymentId (int paymentId){
		this.payment_id = paymentId;
	}
	
	public void setChallanId (int challanId){
		this.challan_id = challanId;
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
	
	public int getChallanId (){
		return this.challan_id ;
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
