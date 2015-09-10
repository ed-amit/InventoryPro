package com.lrd.inventory.model;

public class BillModel {
	
	
	protected int bill_id;
	protected int counter;
	protected int firm_id;
	protected int challan_no;
	protected int store_id;
	protected int year_id;
	protected int home_delivery;
	
	protected double discount;
	protected double total_amt;
	protected double bill_vat_percent;
	protected double bill_vat_amt;
	
	protected String bill_no;
	protected String bill_date;
	protected String customer_name;
	protected String customer_address;
	protected String customer_type;
	protected String mobile_no;
	protected String narration;
	protected String username;
	protected String prefix;
	
	
	

	public BillModel() {
		setDefault();
	}
	
	
	public void setDefault(){
		bill_id=counter=firm_id=challan_no=store_id=year_id=home_delivery=0;
		discount=total_amt=bill_vat_percent=bill_vat_amt=0;
		bill_no=bill_date=customer_name=customer_address="";
		customer_type=mobile_no=narration=username=prefix="";
	}
	
	
	
	public void setBillId (int billId){
		this.bill_id = billId;
	}

	public void setCounter (int counter){
		this.counter=counter;
	}

	public void setFirmId (int firmId){
		this.firm_id = firmId;
	}

	public void setChallanNo (int challanNo){
		this.challan_no = challanNo;
	}

	public void setStoreId (int storeId){
		this.store_id = storeId;
	}

	public void setYearId (int yearId){
		this.year_id = yearId;
	}

	public void setHomeDelivery (int homeDelivery){
		this.home_delivery = homeDelivery;
	}

	public void setDiscount (double discount){
		this.discount = discount;
	}

	public void setTotalAmt (double totalAmt){
		this.total_amt = totalAmt;
	}

	public void setBillVatPercent (double billVatPercent){
		this.bill_vat_percent = billVatPercent;
	}

	public void setBillVatAmt (double vatAmt){
		this.bill_vat_amt = vatAmt;
	}

	public void setBillNo (String billNo){
		this.bill_no = billNo;
	}

	public void setBillDate (String billDate){
		this.bill_date = billDate;
	}

	public void setCustomerName (String customerName){
		this.customer_name = customerName;
	}

	public void setCustomerAddress (String customerAddress){
		this.customer_address = customerAddress;
	}

	public void setCustomerType (String customerType){
		this.customer_type = customerType;
	}

	public void setMobileNo (String mobileNo){
		this.mobile_no = mobileNo;
	}

	public void setNarration (String narration){
		this.narration = narration;
	}

	public void setUserName (String userName){
		this.username = userName;
	}

	public void setPrefix (String prefix){
		this.prefix = prefix;
	}

	
	
	
	
	public int getBillId (){
		return this.bill_id ;
	}
	
	public int getCounter (){
		return this.counter ;
	}
	
	public int getFirmId (){
		return this.firm_id ;
	}
	
	public int getChallanNo (){
		return this.challan_no ;
	}
	
	public int getStoreId (){
		return this.store_id ;
	}
	
	public int getYearId (){
		return this.year_id ;
	}
	
	public int getHomeDelivery (){
		return this.home_delivery ;
	}
	
	public double getDiscount (){
		return this.discount ;
	}
	
	public double getTotalAmt (){
		return this.total_amt ;
	}
	
	public double getVatPercent (){
		return this.bill_vat_percent ;
	}
	
	public double getVatAmt (){
		return this.bill_vat_amt ;
	}
	
	public String getBillNo (){
		return this.bill_no ;
	}
	
	public String getBillDate (){
		return this.bill_date ;
	}
	
	public String getCustomerName (){
		return this.customer_name ;
	}
	
	public String getCustomerAddress (){
		return this.customer_address ;
	}
	
	public String getCustomerType (){
		return this.customer_type ;
	}
	
	public String getMobileNo (){
		return this.mobile_no ;
	}
	
	public String getNarration (){
		return this.narration ;
	}
	
	public String getUserName (){
		return this.username ;
	}
	
	public String getPrefix (){
		return this.prefix ;
	}
	
	

	

}
