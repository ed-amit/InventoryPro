package com.lrd.inventory.model;

public class SalesBillDetailModel {

	int bill_detail_id;
	int bill_id;

	double product_quantity;
	double product_rate;
	double mrp;
	double vat_percent;
	double vat_amt;
	double discount_percent;
	double discount_amt;

	String batch_no;
	String category_name;
	String product_code;
	String product_name;
	String product_type;
	String product_unit;
	String warranty_end_date;
	String warranty_start_date;

	public SalesBillDetailModel() {
		setDefault();
	}

	public void setDefault() {
		bill_detail_id = bill_id = 0;
		product_quantity = product_rate = mrp = vat_percent = 0;
		vat_amt = discount_percent = discount_amt = 0;

		batch_no = category_name = product_code = product_name = "";
		product_type = product_unit = "";
		warranty_start_date = warranty_end_date = "";
	}

	public void setBillDetailId(int billDetailId) {
		this.bill_detail_id = billDetailId;
	}

	public void setBillId(int billId) {
		this.bill_id = billId;
	}

	public void setProductQuantity(double Quantity) {
		this.product_quantity = Quantity;
	}

	public void setProductRate(double rate) {
		this.product_rate = rate;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public void setVatPercent(double vatPercent) {
		this.vat_percent = vatPercent;
	}

	public void setVatAmt(double vatAmt) {
		this.vat_amt = vatAmt;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discount_percent = discountPercent;
	}

	public void setDiscountAmt(double discountAmt) {
		this.discount_amt = discountAmt;
	}

	public void setBatchNo(String batchNo) {
		this.batch_no = batchNo;
	}

	public void setCategoryName(String name) {
		this.category_name = name;
	}

	public void setProductCode(String code) {
		this.product_code = code;
	}

	public void setProductName(String name) {
		this.product_name = name;
	}

	public void setProductType(String type) {
		this.product_type = type;
	}

	public void setProductUnit(String unit) {
		this.product_unit = unit;
	}

	public void setWarrantyEndDate(String endDate) {
		this.warranty_end_date = endDate;
	}

	public void setWarrantyStartDate(String startDate) {
		this.warranty_start_date = startDate;
	}

	public int getBillDetailId() {
		return this.bill_detail_id;
	}

	public int getBillId() {
		return this.bill_id;
	}

	public double getProductQuantity() {
		return this.product_quantity;
	}

	public double getProductRate() {
		return this.product_rate;
	}

	public double getMrp() {
		return this.mrp;
	}

	public double getVatPercent() {
		return this.vat_percent;
	}

	public double getVatAmt() {
		return this.vat_amt;
	}

	public double getDiscountPercent() {
		return this.discount_percent;
	}

	public double getDiscountAmt() {
		return this.discount_amt;
	}

	public String getBatchNo() {
		return this.batch_no;
	}

	public String getCategoryName() {
		return this.category_name;
	}

	public String getProductCode() {
		return this.product_code;
	}

	public String getProductName() {
		return this.product_name;
	}

	public String getProductType() {
		return this.product_type;
	}

	public String getProductUnit() {
		return this.product_unit;
	}

	public String getWarrantyEndDate() {
		return this.warranty_end_date;
	}

	public String getWarrantyStartDate() {
		return this.warranty_start_date;
	}

}
