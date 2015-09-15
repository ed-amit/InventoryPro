package com.lrd.inventory.model;

public class SaleQuotationModel {

	private int quotation_id;
	private int counter;
	private int firm_id;
	//private int number_of_days;
	private int store_id;
	private int year_id;
	private int home_delivery;

	private double discount;
	private double total_amt;
	private double quotation_vat_percent;
	private double quotation_vat_amt;

	//private String quotation_no;
	private String quotation_date;
	private String customer_name;
	private String customer_address;
	private String customer_type;
	private String mobile_no;
	private String narration;
	private String username;
	private String prefix;
	//private String status;
	
	public SaleQuotationModel() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setDefault() {
		quotation_id = counter = firm_id = store_id = year_id = home_delivery = 0;
		discount = total_amt = quotation_vat_percent = quotation_vat_amt = 0;
		quotation_date = customer_name = customer_address = "";
		customer_type = mobile_no = narration = username = prefix = "";
	}

	public void setQuotationId(int quotationId) {
		this.quotation_id = quotationId;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public void setFirmId(int firmId) {
		this.firm_id = firmId;
	}

	public void setStoreId(int storeId) {
		this.store_id = storeId;
	}

	public void setYearId(int yearId) {
		this.year_id = yearId;
	}

	public void setHomeDelivery(int homeDelivery) {
		this.home_delivery = homeDelivery;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public void setTotalAmt(double totalAmt) {
		this.total_amt = totalAmt;
	}

	public void setQuotationVatPercent(double quotationVatPercent) {
		this.quotation_vat_percent = quotationVatPercent;
	}

	public void setQuotationVatAmt(double vatAmt) {
		this.quotation_vat_amt = vatAmt;
	}

	public void setQuotationDate(String quotationDate) {
		this.quotation_date = quotationDate;
	}

	public void setCustomerName(String customerName) {
		this.customer_name = customerName;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customer_address = customerAddress;
	}

	public void setCustomerType(String customerType) {
		this.customer_type = customerType;
	}

	public void setMobileNo(String mobileNo) {
		this.mobile_no = mobileNo;
	}

	public void setNarration(String narration) {
		this.narration = narration;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public int getQuotationId() {
		return this.quotation_id;
	}

	public int getCounter() {
		return this.counter;
	}

	public int getFirmId() {
		return this.firm_id;
	}

	public int getStoreId() {
		return this.store_id;
	}

	public int getYearId() {
		return this.year_id;
	}

	public int getHomeDelivery() {
		return this.home_delivery;
	}

	public double getDiscount() {
		return this.discount;
	}

	public double getTotalAmt() {
		return this.total_amt;
	}

	public double getVatPercent() {
		return this.quotation_vat_percent;
	}

	public double getVatAmt() {
		return this.quotation_vat_amt;
	}

	public String getQuotationDate() {
		return this.quotation_date;
	}

	public String getCustomerName() {
		return this.customer_name;
	}

	public String getCustomerAddress() {
		return this.customer_address;
	}

	public String getCustomerType() {
		return this.customer_type;
	}

	public String getMobileNo() {
		return this.mobile_no;
	}

	public String getNarration() {
		return this.narration;
	}

	public String getUserName() {
		return this.username;
	}

	public String getPrefix() {
		return this.prefix;
	}

}
