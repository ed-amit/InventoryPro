package com.lrd.inventory.model;

public class ChallanModel {
	
	
	private int challan_id;
	private int counter;
	private int firm_id;
	private int store_id;
	private int year_id;
	private int home_delivery;
	
	private double discount;
	private double total_amt;
	private double challan_vat_percent;
	private double challan_vat_amt;
	
	private String challan_no;
	private String challan_date;
	private String customer_name;
	private String customer_address;
	private String customer_type;
	private String mobile_no;
	private String narration;
	private String username;
	private String prefix;
	
	
	

	public ChallanModel() {
		setDefault();
	}
	
	
	public void setDefault(){
		challan_id=counter=firm_id=store_id=year_id=home_delivery=0;
		discount=total_amt=challan_vat_percent=challan_vat_amt=0;
		challan_no=challan_date=customer_name=customer_address="";
		customer_type=mobile_no=narration=username=prefix="";
	}
	
	
	
	public void setChallanId (int challanId){
		this.challan_id = challanId;
	}

	public void setCounter (int counter){
		this.counter=counter;
	}

	public void setFirmId (int firmId){
		this.firm_id = firmId;
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

	public void setChallanVatPercent (double challanVatPercent){
		this.challan_vat_percent = challanVatPercent;
	}

	public void setChallanVatAmt (double vatAmt){
		this.challan_vat_amt = vatAmt;
	}

	public void setChallanNo (String challanNo){
		this.challan_no = challanNo;
	}

	public void setChallanDate (String challanDate){
		this.challan_date = challanDate;
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

	
	
	
	
	public int getChallanId (){
		return this.challan_id ;
	}
	
	public int getCounter (){
		return this.counter ;
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
		return this.challan_vat_percent ;
	}
	
	public double getVatAmt (){
		return this.challan_vat_amt ;
	}
	
	public String getchallanNo (){
		return this.challan_no ;
	}
	
	public String getChallanDate (){
		return this.challan_date ;
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
