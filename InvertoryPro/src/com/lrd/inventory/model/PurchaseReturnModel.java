/**
 * 
 */
package com.lrd.inventory.model;

/**
 * @author Dharm
 *
 */
public class PurchaseReturnModel {

	private int		returnId;
	private int		billDetailId;
	private int		billId;
	private int		storeId;
	private int		YearId;

	private double	purchasePrice;
	private double	Quantity;
	private double	totalCost;
	private double	vatAmount;
	private double	vatPercent;

	private String	billNumber;
	private String	productName;
	private String	productCode;
	private String	returnDate;
	private String	unit;

	public PurchaseReturnModel() {
		// TODO Auto-generated constructor stub
		setDefault();
	}

	public void setDefault() {
		returnId = billDetailId = billId = storeId = YearId = 0;
		purchasePrice = Quantity = totalCost = vatAmount = vatPercent = 0;
		billNumber = productName = productCode = returnDate = unit = "";
	}

	public void setReturnId(int id) {
		this.returnId = id;
	}

	public void setBillDetailId(int id) {
		this.billDetailId = id;
	}

	public void setBillId(int id) {
		this.billId = id;
	}

	public void setStoreId(int id) {
		this.storeId = id;
	}

	public void setYearId(int id) {
		this.YearId = id;
	}

	public void setPurchasePrice(double amount) {
		this.purchasePrice = amount;
	}

	public void setQuantity(double qty) {
		this.Quantity = qty;
	}

	public void setTotalCost(double amount) {
		this.totalCost = amount;
	}

	public void setVatAmount(double amount) {
		this.vatAmount = amount;
	}

	public void setVatPercent(double percent) {
		this.vatPercent = percent;
	}

	public void setBillNumber(String billNo) {
		this.billNumber = billNo;
	}

	public void setProductName(String name) {
		this.productName = name;
	}

	public void setProductCode(String code) {
		this.productCode = code;
	}

	public void setReturnDate(String date) {
		this.returnDate = date;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getReturnId() {
		return this.returnId;
	}

	public int getBillDetailId() {
		return this.billDetailId;
	}

	public int getBillId() {
		return this.billId;
	}

	public int getStoreId() {
		return this.storeId;
	}

	public int getYearId() {
		return this.YearId;
	}

	public double getPurchasePrice() {
		return this.purchasePrice;
	}

	public double getQuantity() {
		return this.Quantity;
	}

	public double getTotalCost() {
		return this.totalCost;
	}

	public double getVatAmount() {
		return this.vatAmount;
	}

	public double getVatPercent() {
		return this.vatPercent;
	}

	public String getBillNumber() {
		return this.billNumber;
	}

	public String getProductName() {
		return this.productName;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public String getReturnDate() {
		return this.returnDate;
	}

	public String getUnit() {
		return this.unit;
	}

}
