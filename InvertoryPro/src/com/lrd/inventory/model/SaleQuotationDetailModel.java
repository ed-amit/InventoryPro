package com.lrd.inventory.model;

public class SaleQuotationDetailModel extends BillDetailModel {

	private int quotation_detail_id;
	private int quotation_id;

	public SaleQuotationDetailModel() {
		// TODO Auto-generated constructor stub
		super.setDefault();
		setDefault();
	}
	
	public SaleQuotationDetailModel(BillDetailModel billDetail) {
		super(billDetail);
		setDefault();
	}

	public void setDefault() {
		quotation_detail_id = quotation_id = 0;

	}

	public void setQuotationDetailId(int quotationDetailId) {
		this.quotation_detail_id = quotationDetailId;
	}

	public void setQuotationId(int quotationId) {
		this.quotation_id = quotationId;
	}

	public int getQuotationDetailId() {
		return this.quotation_detail_id;
	}

	public int getQuotationId() {
		return this.quotation_id;
	}

}
