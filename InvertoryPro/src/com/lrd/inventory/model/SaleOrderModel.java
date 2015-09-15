package com.lrd.inventory.model;

public class SaleOrderModel {

	private int order_id;
	private int counter;
	private int firm_id;
	private int number_of_days;
	private int store_id;
	private int year_id;
	private int home_delivery;

	private double discount;
	private double total_amt;
	private double order_vat_percent;
	private double order_vat_amt;

	private String order_no;
	private String order_date;
	private String customer_name;
	private String customer_address;
	private String customer_type;
	private String mobile_no;
	private String narration;
	private String username;
	private String prefix;
	private String status;

	public SaleOrderModel() {
		// TODO Auto-generated constructor stub
		setDefault();
	}

	public void setDefault() {
		order_id = counter = firm_id = number_of_days = store_id = year_id = home_delivery = 0;
		discount = total_amt = order_vat_percent = order_vat_amt = 0;
		order_no = order_date = customer_name = customer_address = "";
		customer_type = mobile_no = narration = username = prefix = status = "";
	}

	public void setOrderId(int orderId) {
		this.order_id = orderId;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public void setFirmId(int firmId) {
		this.firm_id = firmId;
	}

	public void setNumberOfDays(int days) {
		this.number_of_days = days;
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

	public void setOrderVatPercent(double orderVatPercent) {
		this.order_vat_percent = orderVatPercent;
	}

	public void setOrderVatAmt(double vatAmt) {
		this.order_vat_amt = vatAmt;
	}

	public void setOrderNo(String orderNo) {
		this.order_no = orderNo;
	}

	public void setOrderDate(String orderDate) {
		this.order_date = orderDate;
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

	public void setStatus(String status) {
		this.status = status;
	}

	public int getOrderId() {
		return this.order_id;
	}

	public int getCounter() {
		return this.counter;
	}

	public int getFirmId() {
		return this.firm_id;
	}

	public int getNumberOfDays() {
		return this.number_of_days;
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
		return this.order_vat_percent;
	}

	public double getVatAmt() {
		return this.order_vat_amt;
	}

	public String getOrderNo() {
		return this.order_no;
	}

	public String getOrderDate() {
		return this.order_date;
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

	public String getStatus() {
		return this.status;
	}

}
