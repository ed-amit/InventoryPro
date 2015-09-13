package com.lrd.inventory.model;

public class MarginModel extends SalesBillModel {

	private double productTotalRate;
	private double margin;

	public MarginModel() {
		super.setDefault();
		productTotalRate = margin = 0;

	}
	
	
	public double getProductTotalRate(){
		return this.productTotalRate;
	}
	
	public double getMargin(){
		return this.margin;
	}

	public void setProductTotalRate(double amount){
		this.productTotalRate=amount;
	}
	
	public void setMargin(double amount){
		this.margin=amount;
	}
}
