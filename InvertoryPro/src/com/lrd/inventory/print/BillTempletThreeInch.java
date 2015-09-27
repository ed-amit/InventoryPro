package com.lrd.inventory.print;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.util.ArrayList;

import com.lrd.inventory.model.BillDetailModel;
import com.lrd.inventory.model.ChallanModel;
import com.lrd.inventory.model.OtherChargesModel;
import com.lrd.inventory.model.PaymentModel;
import com.lrd.inventory.model.SaleOrderModel;
import com.lrd.inventory.model.SaleQuotationModel;
import com.lrd.inventory.model.SalesBillDetailModel;
import com.lrd.inventory.model.SalesBillModel;

public class BillTempletThreeInch implements Printable{
	
	private final static int POINTS_PER_INCH = 72;

	private String firmName;
	private String storeName;
	private String firmAddress;
	private String tinNo;

	
	private Font FONT_LG_BOLD;
	private Font FONT_LG_PLAIN;
	private Font FONT_SM_BOLD;
	private Font FONT_SM_PLAIN;
	
	double totalQty = 0;
	double totalRate = 0;
	double totalDiscount = 0;
	double totalAmount = 0;
	double grandTotal = 0;
	double totalOtherCharges = 0;
	String billType = "";

	boolean status = true;

	SalesBillModel saleBill;
	ChallanModel challan;
	SaleOrderModel saleOrder;
	SaleQuotationModel saleQuotation;
	ArrayList<BillDetailModel> saleDetailList;
	ArrayList<OtherChargesModel> OtherChargesList;
	PaymentModel payment;
	
	public BillTempletThreeInch(SalesBillModel saleBill,
			ArrayList<BillDetailModel> saleDetailList,
			ArrayList<OtherChargesModel> OtherChargesList,
			PaymentModel payment) {
		
		firmName = "LRD Technologies Pvt. Ltd.";
		storeName = "Pune Store";
		firmAddress = "G4, Rajyog Complex, Kothrud ,PUNE";
		tinNo = "123456789";

		
		FONT_LG_BOLD = new Font("helvetica", Font.BOLD, 10);
		FONT_LG_PLAIN = new Font("helvetica", Font.PLAIN, 10);
		FONT_SM_BOLD = new Font("helvetica", Font.BOLD, 8);
		FONT_SM_PLAIN = new Font("helvetica", Font.PLAIN, 8);
		
		this.saleBill = saleBill;
		billType = "Vat Invoice";
		this.saleDetailList = saleDetailList;
		//this.OtherChargesList = OtherChargesList;
		this.payment = payment;
		
		if (OtherChargesList.size() > 0) {
			for (OtherChargesModel otherCharge : OtherChargesList) {
				totalOtherCharges += otherCharge.getAmount();
			}
		}
		
	}
	
	public BillTempletThreeInch(ChallanModel challan,
			ArrayList<BillDetailModel> saleDetailList,
			ArrayList<OtherChargesModel> OtherChargesList,
			PaymentModel payment) {
		
		firmName = "LRD Technologies Pvt. Ltd.";
		storeName = "Pune Store";
		firmAddress = "G4, Rajyog Complex, Kothrud ,PUNE";
		tinNo = "123456789";

		
		FONT_LG_BOLD = new Font("helvetica", Font.BOLD, 10);
		FONT_LG_PLAIN = new Font("helvetica", Font.PLAIN, 10);
		FONT_SM_BOLD = new Font("helvetica", Font.BOLD, 8);
		FONT_SM_PLAIN = new Font("helvetica", Font.PLAIN, 8);
		
		this.challan = challan;
		billType = "Sale Invoice";
		this.saleDetailList = saleDetailList;
		//this.OtherChargesList = OtherChargesList;
		this.payment = payment;
		
		if (OtherChargesList.size() > 0) {
			for (OtherChargesModel otherCharge : OtherChargesList) {
				totalOtherCharges += otherCharge.getAmount();
			}
		}
		
	}
	
	
	public BillTempletThreeInch(SaleOrderModel saleOrder,
			ArrayList<BillDetailModel> saleDetailList,
			ArrayList<OtherChargesModel> OtherChargesList,
			PaymentModel payment) {
		
		firmName = "LRD Technologies Pvt. Ltd.";
		storeName = "Pune Store";
		firmAddress = "G4, Rajyog Complex, Kothrud ,PUNE";
		tinNo = "123456789";

		
		FONT_LG_BOLD = new Font("helvetica", Font.BOLD, 10);
		FONT_LG_PLAIN = new Font("helvetica", Font.PLAIN, 10);
		FONT_SM_BOLD = new Font("helvetica", Font.BOLD, 8);
		FONT_SM_PLAIN = new Font("helvetica", Font.PLAIN, 8);
		
		this.saleOrder = saleOrder;
		billType = "Sale Order";
		this.saleDetailList = saleDetailList;
		//this.OtherChargesList = OtherChargesList;
		this.payment = payment;
		
		if (OtherChargesList.size() > 0) {
			for (OtherChargesModel otherCharge : OtherChargesList) {
				totalOtherCharges += otherCharge.getAmount();
			}
		}
		
	}
	
	
	public BillTempletThreeInch(SaleQuotationModel saleQuotation,
			ArrayList<BillDetailModel> saleDetailList,
			ArrayList<OtherChargesModel> OtherChargesList) {
		
		firmName = "LRD Technologies Pvt. Ltd.";
		storeName = "Pune Store";
		firmAddress = "G4, Rajyog Complex, Kothrud ,PUNE";
		tinNo = "123456789";

		
		FONT_LG_BOLD = new Font("helvetica", Font.BOLD, 10);
		FONT_LG_PLAIN = new Font("helvetica", Font.PLAIN, 10);
		FONT_SM_BOLD = new Font("helvetica", Font.BOLD, 8);
		FONT_SM_PLAIN = new Font("helvetica", Font.PLAIN, 8);
		
		this.saleQuotation = saleQuotation;
		billType = "Sale Quotation";
		this.saleDetailList = saleDetailList;
		//this.OtherChargesList = OtherChargesList;
		
		if (OtherChargesList.size() > 0) {
			for (OtherChargesModel otherCharge : OtherChargesList) {
				totalOtherCharges += otherCharge.getAmount();
			}
		}
		
	}
	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
			throws PrinterException {
		
		Graphics2D g2d = (Graphics2D) graphics;
		setPaper(pageFormat);

		// --- Translate the origin to 0,0 for the top left corner
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

		g2d.setPaint(Color.black);

		//setBillBorder(g2d, pageFormat);
		//setBillPreDefine(g2d, pageFormat);
		//setBillLabel(g2d, pageFormat);
		//setBillTotals(g2d, pageFormat);
		
		return 0;
	}
	
	private void setPaper(PageFormat pageFormat) {
		Paper paper = pageFormat.getPaper();
		paper.setSize(8.5 * POINTS_PER_INCH, 11 * POINTS_PER_INCH);
		paper.setImageableArea(pageFormat.getImageableX(),
				pageFormat.getImageableY(), paper.getImageableWidth(),
				paper.getImageableHeight());
		pageFormat.setPaper(paper);
	}

	private void setBillBorder(Graphics2D g2d, PageFormat pageFormat) {

		g2d.setStroke(new BasicStroke(5));
		

		
	}

	private void setBillLabel(Graphics2D g2d, PageFormat pageFormat) {

		// Label for tin, name, date, Contact

		g2d.setFont(FONT_SM_BOLD);
		g2d.drawString("bill No   :", 5, 2 * POINTS_PER_INCH - 40);
		g2d.drawString("Tin        :", 5, 2 * POINTS_PER_INCH - 25);
		g2d.drawString("Name    :", 5, 2 * POINTS_PER_INCH - 10);
		g2d.drawString("Date      :",
				(int) (pageFormat.getImageableWidth() - 2 * POINTS_PER_INCH),
				2 * POINTS_PER_INCH - 25);
		g2d.drawString("Contact :",
				(int) (pageFormat.getImageableWidth() - 2 * POINTS_PER_INCH),
				2 * POINTS_PER_INCH - 10);

		//
		// Table titles

		g2d.setFont(FONT_SM_BOLD);
		g2d.drawString("Sr", 10, 2 * POINTS_PER_INCH + 16);
		g2d.drawString("Item Name", 55, 2 * POINTS_PER_INCH + 16);
		g2d.drawString("Qty", (int) (pageFormat.getImageableWidth() - 220),
				2 * POINTS_PER_INCH + 16);
		g2d.drawString("vat %", (int) (pageFormat.getImageableWidth() - 175),
				2 * POINTS_PER_INCH + 16);
		g2d.drawString("Rate", (int) (pageFormat.getImageableWidth() - 130),
				2 * POINTS_PER_INCH + 16);
		g2d.drawString("Less", (int) (pageFormat.getImageableWidth() - 85),
				2 * POINTS_PER_INCH + 16);
		g2d.drawString("Total", (int) (pageFormat.getImageableWidth() - 40),
				2 * POINTS_PER_INCH + 16);

		g2d.drawString("Total", (int) (pageFormat.getImageableWidth() - 280),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString("Net Total",
				(int) (pageFormat.getImageableWidth() - 130),
				(int) (pageFormat.getImageableHeight() - 10));

		g2d.drawString("vat %", (int) (pageFormat.getImageableWidth() - 135),
				8 * POINTS_PER_INCH + 13);
		g2d.drawString("Other Charges",
				(int) (pageFormat.getImageableWidth() - 135),
				8 * POINTS_PER_INCH + 26);

	}

	private void setBillTotals(Graphics2D g2d, PageFormat pageFormat) {
		g2d.setFont(FONT_SM_PLAIN);

		g2d.drawString("Qty", (int) (pageFormat.getImageableWidth() - 220),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString("Rate", (int) (pageFormat.getImageableWidth() - 130),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString("less", (int) (pageFormat.getImageableWidth() - 85),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString("gtotal", (int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH - 4);

		g2d.drawString("vatamt", (int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 13);
		g2d.drawString("Ot amt", (int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 26);

		g2d.drawString("nt", (int) (pageFormat.getImageableWidth() - 60),
				(int) (pageFormat.getImageableHeight() - 10));
	}

	private void setBillPreDefine(Graphics2D g2d, PageFormat pageFormat) {
		g2d.setFont(FONT_LG_BOLD);
		// --- Compute the horizontal center of the page
		FontMetrics fontMetrics = g2d.getFontMetrics();
		double titleX = (pageFormat.getImageableWidth() / 2)
				- (fontMetrics.stringWidth(firmName) / 2);
		g2d.drawString(firmName, (int) titleX, 30);

		// Store name for bill
		{

			g2d.setFont(FONT_LG_PLAIN);
			// --- Compute the horizontal center of the page
			fontMetrics = g2d.getFontMetrics();
			titleX = (pageFormat.getImageableWidth() / 2)
					- (fontMetrics.stringWidth(storeName) / 2);
			g2d.drawString(storeName, (int) titleX, 50);
		}

		// Address of Store
		{

			g2d.setFont(FONT_LG_PLAIN);
			// --- Compute the horizontal center of the page
			fontMetrics = g2d.getFontMetrics();
			titleX = (pageFormat.getImageableWidth() / 2)
					- (fontMetrics.stringWidth(firmAddress) / 2);
			g2d.drawString(firmAddress, (int) titleX, 65);
		}

		// Address of Store
		{
			g2d.setFont(FONT_SM_PLAIN);
			g2d.drawString(tinNo, 55, 2 * POINTS_PER_INCH - 25);
		}
	}
	
	private void setBillType(Graphics2D g2d, PageFormat pageFormat) {

		g2d.setFont(FONT_SM_PLAIN);

		FontMetrics fontMetrics = g2d.getFontMetrics();
		double titleX = (pageFormat.getImageableWidth() / 2)
				- (fontMetrics.stringWidth(firmAddress) / 2);
		g2d.drawString(billType, (int) titleX, 75);

	}

}
