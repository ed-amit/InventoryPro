package com.lrd.inventory.model;

public class StoreModel {

	private int store_id;
	private int pin_no;

	private String store_name;
	private String address;
	private String city;
	private String state;
	private String contact_no;
	private String email;
	private String manager_name;
	private String registration_no;
	private String pan_no;

	public StoreModel() {
		// TODO Auto-generated constructor stub
		setDefault();
	}

	public void setDefault() {
		store_id = pin_no = 0;
		store_name = address = city = state = contact_no = "";
		email = manager_name = registration_no = pan_no = "";
	}

	public void setStoreId(int storeId) {
		this.store_id = storeId;
	}

	public void setPinNo(int pinNo) {
		this.pin_no = pinNo;
	}

	public void setStoreName(String storeName) {
		this.store_name = storeName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setContactNo(String contactNo) {
		this.contact_no = contactNo;
	}

	public void setEmailId(String emailId) {
		this.email = emailId;
	}

	public void setManagerName(String name) {
		this.manager_name = name;
	}

	public void setRegistrationNo(String regNo) {
		this.registration_no = regNo;
	}

	public void setPanNo(String panNo) {
		this.pan_no = panNo;
	}

	public int getStoreId() {
		return this.store_id;
	}

	public int getPinNo() {
		return this.pin_no;
	}

	public String getStoreName() {
		return this.store_name;
	}

	public String getAddress() {
		return this.address;
	}

	public String getCityName() {
		return this.city;
	}

	public String getStateName() {
		return this.state;
	}

	public String getContactNo() {
		return this.contact_no;
	}

	public String getEmailId() {
		return this.email;
	}

	public String getManagerName() {
		return this.manager_name;
	}

	public String getRegistrationNo() {
		return this.registration_no;
	}

	public String getPanNo() {
		return this.pan_no;
	}

}
