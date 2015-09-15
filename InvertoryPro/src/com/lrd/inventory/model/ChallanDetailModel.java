package com.lrd.inventory.model;

public class ChallanDetailModel extends BillDetailModel{

	private int challan_detail_id;
	private int challan_id;

	public ChallanDetailModel() {
		super.setDefault();
		setDefault();
	}
	
	public ChallanDetailModel(BillDetailModel billDetail) {
		super(billDetail);
		setDefault();
	}

	public void setDefault() {
		challan_detail_id = challan_id = 0;
	}

	public void setChallanDetailId(int challanDetailId) {
		this.challan_detail_id = challanDetailId;
	}

	public void setChallanId(int challanId) {
		this.challan_id = challanId;
	}

	public int getChallanDetailId() {
		return this.challan_detail_id;
	}

	public int getChallanId() {
		return this.challan_id;
	}
}
