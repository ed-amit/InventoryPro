package com.lrd.inventory.model;

public class PurchaseBillPaymentModel {

	private int payment_id;
	private int distributor_id;
	private int purchase_bill_id;

	private String bank_name;
	private String cheque_no;
	private String description;
	private String payment_date;
	private String payment_mode;

	private double paid_amount;
	private double remaining_amount;
	private double total_amount;

	public PurchaseBillPaymentModel() {
		setDefault();
	}

	public void setDefault() {
		payment_id = distributor_id = purchase_bill_id = 0;
		paid_amount = remaining_amount = total_amount = 0;
		bank_name = cheque_no = description = payment_date = payment_mode = "";
	}

	public void setPaymentId(int id) {
		this.payment_id = id;
	}

	public void setDistributorId(int id) {
		this.distributor_id = id;
	}

	public void setPurchaseBillId(int id) {
		this.purchase_bill_id = id;
	}

	public void setBankName(String name) {
		this.bank_name = name;
	}

	public void setChequeNo(String chequeNo) {
		this.cheque_no = chequeNo;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPaymentDate(String date) {
		this.payment_date = date;
	}

	public void setPaymentMode(String mode) {
		this.payment_mode = mode;
	}

	public void setPaidAmount(double amount) {
		this.paid_amount = amount;
	}

	public void setRemaningAmount(double amount) {
		this.remaining_amount = amount;
	}

	public void setTotalAmount(double amount) {
		this.total_amount = amount;
	}

	public int getPaymentId() {
		return this.payment_id;
	}

	public int getDistributorId() {
		return this.distributor_id;
	}

	public int getPurchaseBillId() {
		return this.purchase_bill_id;
	}

	public String getBankName() {
		return this.bank_name;
	}

	public String getChequeNo() {
		return this.cheque_no;
	}

	public String getDescription() {
		return this.description;
	}

	public String getPaymentDate() {
		return this.payment_date;
	}

	public String getPaymentMode() {
		return this.payment_mode;
	}

	public double getPaidAmount() {
		return this.paid_amount;
	}

	public double getRemaningAmount() {
		return this.remaining_amount;
	}

	public double getTotalAmount() {
		return this.total_amount;
	}

}
