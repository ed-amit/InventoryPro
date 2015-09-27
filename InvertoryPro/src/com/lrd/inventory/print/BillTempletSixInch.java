package com.lrd.inventory.print;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.ArrayList;

import com.lrd.inventory.model.BillDetailModel;
import com.lrd.inventory.model.OtherChargesModel;
import com.lrd.inventory.model.PaymentModel;
import com.lrd.inventory.model.SalesBillDetailModel;
import com.lrd.inventory.model.SalesBillModel;

public class BillTempletSixInch implements Printable{

	SalesBillModel saleBill;
	ArrayList<BillDetailModel> saleDetailList;
	ArrayList<OtherChargesModel> OtherChargesList;
	PaymentModel payment;
	
	public BillTempletSixInch(SalesBillModel saleBill,
			ArrayList<BillDetailModel> saleDetailList,
			ArrayList<OtherChargesModel> OtherChargesList,
			PaymentModel payment) {
		
		
		this.saleBill = saleBill;
		this.saleDetailList = saleDetailList;
		//this.OtherChargesList = OtherChargesList;
		this.payment = payment;
		
		
	}
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		// TODO Auto-generated method stub
		return 0;
	}

}
