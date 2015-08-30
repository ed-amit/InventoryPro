package com.lrd.inventory.model;

public class PurchaseBillModel {

	private int billId;
	private int no_of_days;
	private int distributor_id;
	private int store_id;
	private int year_id;
	
	private String address;
	private String agency_name;
	private String bill_no;
	private String contact_no;
	private String payment_mode;
	private String purchase_date;
	private String tin_no;
	
	private double cess;
	private double cst_amount;
	private double cst_percent;
	private double discount;
	private double entry_tax;
	private double excise_amount;
	private double excise_percent;
	private double grandTotal;
	private double hamali;
	private double lbt_amount;
	private double lbt_percent;
	private double miscellaneous;
	private double octrai;
	private double paid_amount;
	private double transportation;
	private double vat_amount;
	private double vat_percent;
	
	
	public PurchaseBillModel() {
		setDefault();
	}
	
	public void setDefault(){
		billId = no_of_days = distributor_id = store_id = year_id = 0 ;
		
		address = agency_name = bill_no = contact_no = "";
		payment_mode = purchase_date = tin_no = "";
		
		cess = cst_amount = cst_percent = discount = entry_tax = 0 ;
		excise_amount = excise_percent = grandTotal = hamali = 0 ;
		lbt_amount = lbt_percent = miscellaneous = octrai = 0 ;
		paid_amount = transportation = vat_amount = vat_percent = 0;
	}
	
	
	public void setBillId (int billId){
		this.billId = billId ;
	}
	
	public void setNoOfDays (int noOfDays){
		this.no_of_days = noOfDays ;
	}
	
	public void setDistributorId (int distributorId){
		this.distributor_id = distributorId ;
	}
	
	public void setStoreId (int storeId){
		this.store_id = storeId ;
	}
	
	public void setYearId (int yearId){
		this.year_id = yearId ;
	}
	
	public void setAddress (String address){
		this.address = address ;
	}
	
	public void setAgencyName (String agencyName){
		this.agency_name = agencyName ;
	}
	
	public void setBillNo (String billNo){
		this.bill_no = billNo ;
	}
	
	public void setContactNo (String contactNo){
		this.contact_no = contactNo ;
	}
	
	public void setPaymentMode (String mode){
		this.payment_mode = mode ;
	}
	
	public void setPurchaseDate (String date){
		this.purchase_date = date ;
	}
	
	public void setTinNo (String tinNo){
		this.tin_no = tinNo ;
	}
	
	public void setCess (double cess){
		this.cess = cess ;
	}
	
	public void setCstAmount (double amount){
		this.cst_amount = amount ;
	}
	
	public void setCstPercent (double percent){
		this.cst_percent = percent ;
	}
	
	public void setDiscount (double amount){
		this.discount = amount ;
	}
	
	public void setEntryTax (double percent){
		this.entry_tax = percent ;
	}
	
	public void setExciseAmount (double amount){
		this.excise_amount = amount ;
	}
	
	public void setExcisePercent (double percent){
		this.excise_percent = percent ;
	}
	
	public void setGrandTotal (double amount){
		this.grandTotal = amount ;
	}
	
	public void setHamali (double amount){
		this.hamali = amount ;
	}
	
	public void setLbtAmount (double amount){
		this.lbt_amount = amount ;
	}
	
	public void setLbtPercent (double percent){
		this.lbt_percent = percent ;
	}
	
	public void setMiscellaneous (double amount){
		this.miscellaneous = amount ;
	}
	
	public void setOctraiAmt (double amount){
		this.octrai = amount ;
	}
	
	public void setPaidAmount (double amount){
		this.paid_amount = amount ;
	}
	
	public void setTransportationAmt (double amount){
		this.transportation = amount ;
	}
	
	public void setVatAmount (double amount){
		this.vat_amount = amount ;
	}
	
	public void setVatPercent (double percent){
		this.vat_percent = percent ;
	}
	
	
	
	
	public int getBillId (){
		return this.billId ;
	}
	
	public int getNoOfDays (){
		return this.no_of_days ;
	}
	
	public int getDistributorId (){
		return this.distributor_id ;
	}
	
	public int getStoreId (){
		return this.store_id ;
	}
	
	public int getYearId (){
		return this.year_id ;
	}
	
	public String getAddress (){
		return this.address ;
	}
	
	public String getAgencyName (){
		return this.agency_name ;
	}
	
	public String getBillNo (){
		return this.bill_no ;
	}
	
	public String getContactNo (){
		return this.contact_no ;
	}
	
	public String getPaymentMode (){
		return this.payment_mode ;
	}
	
	public String getPurchaseDate (){
		return this.purchase_date ;
	}
	
	public String getTinNo (){
		return this.tin_no ;
	}
	
	public double getCess (){
		return this.cess ;
	}
	
	public double getCstAmount (){
		return this.cst_amount ;
	}
	
	public double getCstPercent (){
		return this.cst_percent ;
	}
	
	public double getDiscount (){
		return this.discount ;
	}
	
	public double getEntaryTax (){
		return this.entry_tax ;
	}
	
	public double getExciseAmount (){
		return this.excise_amount ;
	}
	
	public double getExcisePercent (){
		return this.excise_percent ;
	}
	
	public double getGrandTotal (){
		return this.grandTotal ;
	}
	
	public double getHamali (){
		return this.hamali ;
	}
	
	public double getLbtAmount (){
		return this.lbt_amount ;
	}
	
	public double getLbtPercent (){
		return this.lbt_percent ;
	}
	
	public double getMiscellaneous (){
		return this.miscellaneous ;
	}
	
	public double getOctrai (){
		return this.octrai ;
	}
	
	public double getPaidAmount (){
		return this.paid_amount ;
	}
	
	public double getTransportatin (){
		return this.transportation ;
	}
	
	public double getVatAmount (){
		return this.vat_amount ;
	}
	
	public double getVatPercent (){
		return this.vat_percent ;
	}
	
	

}
