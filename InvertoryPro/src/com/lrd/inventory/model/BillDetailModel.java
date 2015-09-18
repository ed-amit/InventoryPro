package com.lrd.inventory.model;

public class BillDetailModel {

	protected double product_quantity;
	protected double product_rate;
	protected double purchseRate;
	protected double mrp;
	protected double vat_percent;
	protected double vat_amt;
	protected double discount_percent;
	protected double discount_amt;
	protected double subTotal;

	protected String batch_no;
	protected String category_name;
	protected String product_code;
	protected String product_name;
	protected String product_type;
	protected String product_unit;
	protected String warranty_end_date;
	protected String warranty_start_date;

	public BillDetailModel() {
		// TODO Auto-generated constructor stub
	}

	public BillDetailModel(BillDetailModel billDetail) {
		// TODO Auto-generated constructor stub
		this.product_quantity = billDetail.getProductQuantity();
		this.product_rate = billDetail.getProductRate();
		this.purchseRate = billDetail.getPurchaseRate();
		this.mrp = billDetail.getMrp();
		this.vat_percent = billDetail.getVatPercent();
		this.vat_amt = billDetail.getVatAmt();
		this.discount_percent = billDetail.getDiscountPercent();
		this.discount_amt = billDetail.getDiscountAmt();
		this.subTotal = billDetail.getSubTotal();
		
		this.batch_no = billDetail.getBatchNo();
		this.category_name = billDetail.getCategoryName();
		this.product_code = billDetail.getProductCode();
		this.product_name = billDetail.getProductName();
		this.product_type = billDetail.getProductType();
		this.product_unit = billDetail.getProductUnit();
		this.warranty_end_date = billDetail.getWarrantyEndDate();
		this.warranty_start_date = billDetail.getWarrantyStartDate();

	}

	public void setDefault() {

		product_quantity = product_rate = purchseRate = mrp = vat_percent = 0;
		vat_amt = discount_percent = discount_amt = subTotal = 0;

		batch_no = category_name = product_code = product_name = "";
		product_type = product_unit = "";
		warranty_start_date = warranty_end_date = "";
	}

	public void setProductQuantity(double Quantity) {
		this.product_quantity = Quantity;
	}

	public void setProductRate(double rate) {
		this.product_rate = rate;
	}

	public void setPurchaseRate(double amount) {
		this.purchseRate = amount;
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

	public void setSubTotal(double amount) {
		this.subTotal = amount;
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

	public double getProductQuantity() {
		return this.product_quantity;
	}

	public double getProductRate() {
		return this.product_rate;
	}

	public double getPurchaseRate() {
		return this.purchseRate;
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

	public double getSubTotal() {
		return this.subTotal;
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
