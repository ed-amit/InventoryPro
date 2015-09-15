package com.lrd.inventory.model;

public class SaleOrderDetailModel  extends BillDetailModel{

	private int order_detail_id;
	private int order_id;

	public SaleOrderDetailModel() {
		// TODO Auto-generated constructor stub
		super.setDefault();
		setDefault();
	}
	
	public SaleOrderDetailModel(BillDetailModel billDetail) {
		super(billDetail);
		setDefault();
	}

	public void setDefault() {
		order_detail_id = order_id = 0;

	}

	public void setOrderDetailId(int orderDetailId) {
		this.order_detail_id = orderDetailId;
	}

	public void setOrderId(int orderId) {
		this.order_id = orderId;
	}

	public int getOrderDetailId() {
		return this.order_detail_id;
	}

	public int getOrderId() {
		return this.order_id;
	}

}
