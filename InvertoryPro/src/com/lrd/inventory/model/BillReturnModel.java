package com.lrd.inventory.model;

public class BillReturnModel extends BillDetailModel {
	
	private int return_id;
	private String bill_date;
	private String bill_no;
	private String reason;
	private String return_date;
	private String status;
	private int firm_id;
	private int store_id;
	private int year_id;
	private double subTotal;
	public static final String RETURN = "RETURN";
	public static final String REPLACE = "REPLACE";
	

	public BillReturnModel() {
		setDefault();
	}
	
	
	
	@Override
	public void setDefault() {
		super.setDefault();
		return_id = 0;
		bill_date = bill_no = reason= return_date = status = "";
	}

	
	public void setReturnId (int returnId){
		this.return_id =returnId ;
	}
	
	public void setBillDate (String billDate){
		this.bill_date =billDate ;
	}
	
	public void setBillNo (String billNo){
		this.bill_no =billNo ;
	}
	
	public void setReason (String reason){
		this.reason = reason;
	}
	
	public void setReturnDate (String returnDate){
		this.return_date = returnDate;
	}
	
	public void setStatus(String status){
		this.status = status ;
	}
	
	public void setFirmId (int id){
		this.firm_id = id;
	}
	
	public void setStoreId (int id){
		this.store_id = id;
	}
	
	public void setYearId (int id){
		this.year_id = id;
	}
	
	public void setSubTotal(double total){
		this.subTotal = total;
	}
	
	public int getReturnId(){
		return this.return_id;
	}
	
	public String getBillDate (){
		return this.bill_date ;
	}
	
	public String getBillNo (){
		return this.bill_no ;
	}
	
	public String getReason (){
		return this.reason ;
	}
	
	public String getReturnDate (){
		return this.return_date ;
	}
	
	public String getStatus(){
		return this.status;
	}
	
	public int getFirmId (){
		return this.firm_id ;
	}
	
	public int getStoreId (){
		return this.store_id ;
	}
	
	public int getYearId (){
		return this.year_id ;
	}
	
	public double getSubTotal(){
		return this.subTotal;
	}
}
