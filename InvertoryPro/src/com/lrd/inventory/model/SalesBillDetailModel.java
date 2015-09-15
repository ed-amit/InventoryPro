package com.lrd.inventory.model;

public class SalesBillDetailModel extends BillDetailModel {

	private int bill_detail_id;
	private int bill_id;

	public SalesBillDetailModel() {
		super.setDefault();
		setDefault();
	}
	
	public SalesBillDetailModel(BillDetailModel billDetail) {
		super(billDetail);
		setDefault();
	}

	public void setDefault() {
		bill_detail_id = bill_id = 0;
	}

	public void setBillDetailId(int billDetailId) {
		this.bill_detail_id = billDetailId;
	}

	public void setBillId(int billId) {
		this.bill_id = billId;
	}

	public int getBillDetailId() {
		return this.bill_detail_id;
	}

	public int getBillId() {
		return this.bill_id;
	}

}
