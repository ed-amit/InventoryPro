package com.lrd.inventory.model;

public class OtherChargesModel {

	int id;
	int ref_id;
	int firm_id;
	int store_id;
	int year_id;
	double amount;
	String charge_name;

	public OtherChargesModel() {
		// TODO Auto-generated constructor stub
		setDefault();
	}

	public void setDefault() {
		id = ref_id = firm_id = store_id = year_id = 0;
		amount = 0;
		charge_name = "";
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRefId(int refId) {
		this.ref_id = refId;
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

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setChargeName(String chargeName) {
		this.charge_name = chargeName;
	}

	public int getId() {
		return this.id;
	}

	public int getRefId() {
		return this.ref_id;
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

	public double getAmount() {
		return this.amount;
	}

	public String getChargeName() {
		return this.charge_name;
	}

}
