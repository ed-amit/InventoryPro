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
import com.lrd.inventory.model.SalesBillModel;

public class BillTempletFullA4 implements Printable {

	private final static int POINTS_PER_INCH = 72;

	private String firmName;
	private String storeName;
	private String firmAddress;
	private String tinNo;

	private Font FONT_XLG_BOLD;
	private Font FONT_LG_PLAIN;
	private Font FONT_MD_PLAIN;
	private Font FONT_SM_BOLD;
	private Font FONT_SM_PLAIN;

	double totalQty = 0;
	double totalRate = 0;
	double totalDiscount = 0;
	double totalAmount = 0;
	double grandTotal = 0;
	double totalOtherCharges = 0;
	String billType = "";

	boolean status = false;

	SalesBillModel saleBill;
	ChallanModel challan;
	SaleOrderModel saleOrder;
	SaleQuotationModel saleQuotation;
	ArrayList<BillDetailModel> billDetailList;
	ArrayList<OtherChargesModel> OtherChargesList;
	PaymentModel payment;

	public BillTempletFullA4(SalesBillModel saleBill,
			ArrayList<BillDetailModel> billDetailList,
			ArrayList<OtherChargesModel> OtherChargesList, PaymentModel payment) {

		firmName = "LRD Technologies Pvt. Ltd.";
		storeName = "Pune Store";
		firmAddress = "G4, Rajyog Complex, Kothrud ,PUNE";
		tinNo = "123456789";

		FONT_XLG_BOLD = new Font("helvetica", Font.BOLD, 20);
		FONT_LG_PLAIN = new Font("helvetica", Font.PLAIN, 16);
		FONT_MD_PLAIN = new Font("helvetica", Font.PLAIN, 12);
		FONT_SM_BOLD = new Font("helvetica", Font.BOLD, 10);
		FONT_SM_PLAIN = new Font("helvetica", Font.PLAIN, 10);

		this.saleBill = saleBill;
		billType = "Vat Invoice";
		this.billDetailList = billDetailList;
		// this.OtherChargesList = OtherChargesList;
		this.payment = payment;

		if (OtherChargesList.size() > 0) {
			for (OtherChargesModel otherCharge : OtherChargesList) {
				totalOtherCharges += otherCharge.getAmount();
			}
		}

	}

	public BillTempletFullA4(ChallanModel challan,
			ArrayList<BillDetailModel> billDetailList,
			ArrayList<OtherChargesModel> OtherChargesList, PaymentModel payment) {

		firmName = "LRD Technologies Pvt. Ltd.";
		storeName = "Pune Store";
		firmAddress = "G4, Rajyog Complex, Kothrud ,PUNE";
		tinNo = "123456789";

		FONT_XLG_BOLD = new Font("helvetica", Font.BOLD, 20);
		FONT_LG_PLAIN = new Font("helvetica", Font.PLAIN, 16);
		FONT_MD_PLAIN = new Font("helvetica", Font.PLAIN, 12);
		FONT_SM_BOLD = new Font("helvetica", Font.BOLD, 10);
		FONT_SM_PLAIN = new Font("helvetica", Font.PLAIN, 10);

		this.challan = challan;
		billType = "Sale Invoice";
		this.billDetailList = billDetailList;
		// this.OtherChargesList = OtherChargesList;
		this.payment = payment;

		if (OtherChargesList.size() > 0) {
			for (OtherChargesModel otherCharge : OtherChargesList) {
				totalOtherCharges += otherCharge.getAmount();
			}
		}

	}

	public BillTempletFullA4(SaleOrderModel saleOrder,
			ArrayList<BillDetailModel> billDetailList,
			ArrayList<OtherChargesModel> OtherChargesList, PaymentModel payment) {

		firmName = "LRD Technologies Pvt. Ltd.";
		storeName = "Pune Store";
		firmAddress = "G4, Rajyog Complex, Kothrud ,PUNE";
		tinNo = "123456789";

		FONT_XLG_BOLD = new Font("helvetica", Font.BOLD, 20);
		FONT_LG_PLAIN = new Font("helvetica", Font.PLAIN, 16);
		FONT_MD_PLAIN = new Font("helvetica", Font.PLAIN, 12);
		FONT_SM_BOLD = new Font("helvetica", Font.BOLD, 10);
		FONT_SM_PLAIN = new Font("helvetica", Font.PLAIN, 10);

		this.saleOrder = saleOrder;
		billType = "Sale Order";
		this.billDetailList = billDetailList;
		// this.OtherChargesList = OtherChargesList;
		this.payment = payment;

		if (OtherChargesList.size() > 0) {
			for (OtherChargesModel otherCharge : OtherChargesList) {
				totalOtherCharges += otherCharge.getAmount();
			}
		}

	}

	public BillTempletFullA4(SaleQuotationModel saleQuotation,
			ArrayList<BillDetailModel> billDetailList,
			ArrayList<OtherChargesModel> OtherChargesList) {

		firmName = "LRD Technologies Pvt. Ltd.";
		storeName = "Pune Store";
		firmAddress = "G4, Rajyog Complex, Kothrud ,PUNE";
		tinNo = "123456789";

		FONT_XLG_BOLD = new Font("helvetica", Font.BOLD, 20);
		FONT_LG_PLAIN = new Font("helvetica", Font.PLAIN, 16);
		FONT_MD_PLAIN = new Font("helvetica", Font.PLAIN, 12);
		FONT_SM_BOLD = new Font("helvetica", Font.BOLD, 10);
		FONT_SM_PLAIN = new Font("helvetica", Font.PLAIN, 10);

		this.saleQuotation = saleQuotation;
		billType = "Sale Quotation";
		this.billDetailList = billDetailList;
		// this.OtherChargesList = OtherChargesList;
		

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
		if (status) {
		setBillBorder(g2d, pageFormat);
		setBillPreDefine(g2d, pageFormat);
		setBillLabel(g2d, pageFormat);
		setBillDetails(g2d, pageFormat);

		if (billType.equals("Vat Invoice")) {
			setSaleBillInfo(g2d, pageFormat);
			setSaleBillTotals(g2d, pageFormat);
		} else if (billType.equals("Sale Invoice")) {
			setChallanInfo(g2d, pageFormat);
			setChallanTotals(g2d, pageFormat);
		} else if (billType.equals("Sale Order")) {
			setSaleOrderInfo(g2d, pageFormat);
			setSaleOrderTotals(g2d, pageFormat);
		} else if (billType.equals("Sale Quotation")) {
			setSaleQuotationInfo(g2d, pageFormat);
			setSaleQuotationTotals(g2d, pageFormat);
		}

		setBillType(g2d, pageFormat);
		
		}
		status=true;
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
		Rectangle2D.Double border1 = new Rectangle2D.Double(0, 0,
				pageFormat.getImageableWidth(), pageFormat.getImageableHeight());

		g2d.setStroke(new BasicStroke((float) 0.5));
		Rectangle2D.Double border2 = new Rectangle2D.Double(0, 0,
				pageFormat.getImageableWidth(), 2 * POINTS_PER_INCH);

		Rectangle2D.Double border3 = new Rectangle2D.Double(0,
				2 * POINTS_PER_INCH, pageFormat.getImageableWidth(), 20);

		Rectangle2D.Double border4 = new Rectangle2D.Double(0,
				2 * POINTS_PER_INCH, 45, 6 * POINTS_PER_INCH - 20);
		Rectangle2D.Double border5 = new Rectangle2D.Double(
				pageFormat.getImageableWidth() - 230, 2 * POINTS_PER_INCH, 45,
				6 * POINTS_PER_INCH);
		Rectangle2D.Double border6 = new Rectangle2D.Double(
				pageFormat.getImageableWidth() - 140, 2 * POINTS_PER_INCH, 45,
				6 * POINTS_PER_INCH);
		Rectangle2D.Double border7 = new Rectangle2D.Double(
				pageFormat.getImageableWidth() - 50, 2 * POINTS_PER_INCH, 50,
				6 * POINTS_PER_INCH);
		Rectangle2D.Double border8 = new Rectangle2D.Double(0,
				8 * POINTS_PER_INCH - 20, pageFormat.getImageableWidth(), 20);

		Rectangle2D.Double border9 = new Rectangle2D.Double(
				pageFormat.getImageableWidth() - 140, 8 * POINTS_PER_INCH, 90,
				pageFormat.getImageableHeight() - 8 * POINTS_PER_INCH - 30);
		Rectangle2D.Double border10 = new Rectangle2D.Double(
				pageFormat.getImageableWidth() - 50, 8 * POINTS_PER_INCH, 50,
				pageFormat.getImageableHeight() - (8 * POINTS_PER_INCH) - 30);
		Rectangle2D.Double border11 = new Rectangle2D.Double(
				pageFormat.getImageableWidth() - 140,
				pageFormat.getImageableHeight() - 30, 70, 30);
		Rectangle2D.Double border12 = new Rectangle2D.Double(
				pageFormat.getImageableWidth() - 70,
				pageFormat.getImageableHeight() - 30, 70, 30);

		g2d.draw(border1);
		g2d.draw(border2);
		g2d.draw(border3);
		g2d.draw(border4);
		g2d.draw(border5);
		g2d.draw(border6);
		g2d.draw(border7);
		g2d.draw(border8);
		g2d.draw(border9);
		g2d.draw(border10);
		g2d.draw(border11);
		g2d.draw(border12);
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
		g2d.drawString("Discount",
				(int) (pageFormat.getImageableWidth() - 135),
				8 * POINTS_PER_INCH + 39);

	}

	private void setBillPreDefine(Graphics2D g2d, PageFormat pageFormat) {
		g2d.setFont(FONT_XLG_BOLD);
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

			g2d.setFont(FONT_MD_PLAIN);
			// --- Compute the horizontal center of the page
			fontMetrics = g2d.getFontMetrics();
			titleX = (pageFormat.getImageableWidth() / 2)
					- (fontMetrics.stringWidth(firmAddress) / 2);
			g2d.drawString(firmAddress, (int) titleX, 65);
		}

		// Address of Store
		{
			g2d.setFont(FONT_SM_PLAIN);
			g2d.drawString(tinNo, 50, 2 * POINTS_PER_INCH - 25);
		}
	}

	private void setBillType(Graphics2D g2d, PageFormat pageFormat) {

		g2d.setFont(FONT_SM_PLAIN);

		FontMetrics fontMetrics = g2d.getFontMetrics();
		double titleX = (pageFormat.getImageableWidth() / 2)
				- (fontMetrics.stringWidth(billType) / 2);
		g2d.drawString(billType, (int) titleX, 75);

	}

	private void setSaleBillInfo(Graphics2D g2d, PageFormat pageFormat) {
		g2d.setFont(FONT_SM_PLAIN);

		g2d.drawString(saleBill.getBillNo(), 50, 2 * POINTS_PER_INCH - 40);
		g2d.drawString(saleBill.getCustomerName(), 50, 2 * POINTS_PER_INCH - 10);
		g2d.drawString(
				saleBill.getBillDate(),
				(int) (pageFormat.getImageableWidth() + 50 - 2 * POINTS_PER_INCH),
				2 * POINTS_PER_INCH - 25);
		g2d.drawString(
				saleBill.getMobileNo(),
				(int) (pageFormat.getImageableWidth() + 50 - 2 * POINTS_PER_INCH),
				2 * POINTS_PER_INCH - 10);

	}

	private void setBillDetails(Graphics2D g2d, PageFormat pageFormat) {

		g2d.setFont(FONT_SM_PLAIN);
		int i = 1;
		int positionY = 2 * POINTS_PER_INCH + 35;
		for (BillDetailModel saleDetail : billDetailList) {
			g2d.drawString(i + "", 10, positionY);
			g2d.drawString(saleDetail.getProductName(), 55, positionY);
			g2d.drawString(saleDetail.getProductQuantity() + "",
					(int) (pageFormat.getImageableWidth() - 220), positionY);
			g2d.drawString(saleDetail.getVatPercent() + "",
					(int) (pageFormat.getImageableWidth() - 175), positionY);
			g2d.drawString(saleDetail.getProductRate() + "",
					(int) (pageFormat.getImageableWidth() - 130), positionY);
			g2d.drawString(saleDetail.getDiscountAmt() + "",
					(int) (pageFormat.getImageableWidth() - 85), positionY);
			g2d.drawString(saleDetail.getSubTotal() + "",
					(int) (pageFormat.getImageableWidth() - 40), positionY);
			
			totalQty += saleDetail.getProductQuantity();
			totalRate += saleDetail.getProductRate()
					* saleDetail.getProductQuantity();
			totalDiscount += saleDetail.getDiscountAmt()
					* saleDetail.getProductQuantity();
			totalAmount += saleDetail.getSubTotal();
			
			
			positionY += 12;
			i++;
		}
		
	}

	private void setSaleBillTotals(Graphics2D g2d, PageFormat pageFormat) {
		g2d.setFont(FONT_SM_PLAIN);

		g2d.drawString(totalQty + "",
				(int) (pageFormat.getImageableWidth() - 220),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString(totalRate + "",
				(int) (pageFormat.getImageableWidth() - 130),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString(totalDiscount + "",
				(int) (pageFormat.getImageableWidth() - 85),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString(totalAmount + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH - 4);

		g2d.drawString(saleBill.getVatAmt() + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 13);
		g2d.drawString(totalOtherCharges + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 26);
		g2d.drawString(saleBill.getDiscount() + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 39);

		g2d.drawString(totalAmount + saleBill.getVatAmt() + totalOtherCharges
				+ "", (int) (pageFormat.getImageableWidth() - 60),
				(int) (pageFormat.getImageableHeight() - 10));
	}

	private void setChallanInfo(Graphics2D g2d, PageFormat pageFormat) {
		g2d.setFont(FONT_SM_PLAIN);

		g2d.drawString(challan.getchallanNo(), 50, 2 * POINTS_PER_INCH - 40);
		g2d.drawString(challan.getCustomerName(), 50, 2 * POINTS_PER_INCH - 10);
		g2d.drawString(
				challan.getChallanDate(),
				(int) (pageFormat.getImageableWidth() + 50 - 2 * POINTS_PER_INCH),
				2 * POINTS_PER_INCH - 25);
		g2d.drawString(
				challan.getMobileNo(),
				(int) (pageFormat.getImageableWidth() + 50 - 2 * POINTS_PER_INCH),
				2 * POINTS_PER_INCH - 10);

	}

	private void setChallanTotals(Graphics2D g2d, PageFormat pageFormat) {
		g2d.setFont(FONT_SM_PLAIN);

		g2d.drawString(totalQty + "",
				(int) (pageFormat.getImageableWidth() - 220),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString(totalRate + "",
				(int) (pageFormat.getImageableWidth() - 130),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString(totalDiscount + "",
				(int) (pageFormat.getImageableWidth() - 85),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString(totalAmount + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH - 4);

		g2d.drawString(saleBill.getVatAmt() + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 13);
		g2d.drawString(totalOtherCharges + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 26);
		g2d.drawString(challan.getDiscount() + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 39);

		g2d.drawString(totalAmount + challan.getVatAmt() + totalOtherCharges
				+ "", (int) (pageFormat.getImageableWidth() - 60),
				(int) (pageFormat.getImageableHeight() - 10));
	}

	private void setSaleOrderInfo(Graphics2D g2d, PageFormat pageFormat) {
		g2d.setFont(FONT_SM_PLAIN);

		g2d.drawString(saleOrder.getOrderNo(), 50, 2 * POINTS_PER_INCH - 40);
		g2d.drawString(saleOrder.getCustomerName(), 50,
				2 * POINTS_PER_INCH - 10);
		g2d.drawString(
				saleOrder.getOrderDate(),
				(int) (pageFormat.getImageableWidth() + 50 - 2 * POINTS_PER_INCH),
				2 * POINTS_PER_INCH - 25);
		g2d.drawString(
				saleOrder.getMobileNo(),
				(int) (pageFormat.getImageableWidth() + 50 - 2 * POINTS_PER_INCH),
				2 * POINTS_PER_INCH - 10);

	}

	private void setSaleOrderTotals(Graphics2D g2d, PageFormat pageFormat) {
		g2d.setFont(FONT_SM_PLAIN);

		g2d.drawString(totalQty + "",
				(int) (pageFormat.getImageableWidth() - 220),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString(totalRate + "",
				(int) (pageFormat.getImageableWidth() - 130),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString(totalDiscount + "",
				(int) (pageFormat.getImageableWidth() - 85),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString(totalAmount + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH - 4);

		g2d.drawString(saleBill.getVatAmt() + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 13);
		g2d.drawString(totalOtherCharges + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 26);
		g2d.drawString(saleOrder.getDiscount() + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 39);

		g2d.drawString(totalAmount + saleOrder.getVatAmt() + totalOtherCharges
				+ "", (int) (pageFormat.getImageableWidth() - 60),
				(int) (pageFormat.getImageableHeight() - 10));
	}

	private void setSaleQuotationInfo(Graphics2D g2d, PageFormat pageFormat) {
		g2d.setFont(FONT_SM_PLAIN);

		g2d.drawString(saleQuotation.getQuotationId() + "", 50,
				2 * POINTS_PER_INCH - 40);
		g2d.drawString(saleQuotation.getCustomerName(), 50,
				2 * POINTS_PER_INCH - 10);
		g2d.drawString(
				saleQuotation.getQuotationDate(),
				(int) (pageFormat.getImageableWidth() + 50 - 2 * POINTS_PER_INCH),
				2 * POINTS_PER_INCH - 25);
		g2d.drawString(
				saleQuotation.getMobileNo(),
				(int) (pageFormat.getImageableWidth() + 50 - 2 * POINTS_PER_INCH),
				2 * POINTS_PER_INCH - 10);

	}

	private void setSaleQuotationTotals(Graphics2D g2d, PageFormat pageFormat) {
		g2d.setFont(FONT_SM_PLAIN);

		g2d.drawString(totalQty + "",
				(int) (pageFormat.getImageableWidth() - 220),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString(totalRate + "",
				(int) (pageFormat.getImageableWidth() - 130),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString(totalDiscount + "",
				(int) (pageFormat.getImageableWidth() - 85),
				8 * POINTS_PER_INCH - 4);
		g2d.drawString(totalAmount + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH - 4);

		g2d.drawString(saleBill.getVatAmt() + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 13);
		g2d.drawString(totalOtherCharges + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 26);
		g2d.drawString(saleQuotation.getDiscount() + "",
				(int) (pageFormat.getImageableWidth() - 40),
				8 * POINTS_PER_INCH + 39);

		g2d.drawString(totalAmount + saleQuotation.getVatAmt()
				+ totalOtherCharges + "",
				(int) (pageFormat.getImageableWidth() - 60),
				(int) (pageFormat.getImageableHeight() - 10));
	}

}
