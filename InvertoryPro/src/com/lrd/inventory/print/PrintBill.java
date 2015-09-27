package com.lrd.inventory.print;

import java.awt.print.Book;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import com.lrd.inventory.model.BillDetailModel;
import com.lrd.inventory.model.ChallanModel;
import com.lrd.inventory.model.OtherChargesModel;
import com.lrd.inventory.model.PaymentModel;
import com.lrd.inventory.model.SaleOrderModel;
import com.lrd.inventory.model.SaleQuotationModel;
import com.lrd.inventory.model.SalesBillDetailModel;
import com.lrd.inventory.model.SalesBillModel;

public class PrintBill {

	public static final int THREE_INCH = 1;
	public static final int SIX_INCH = 2;
	public static final int HALF_A4 = 3;
	public static final int FULL_A4 = 4;

	private int defaultPrintSize;

	private PrinterJob printJob;
	private Book book;

	public PrintBill() {

		defaultPrintSize = 4;

		printJob = PrinterJob.getPrinterJob();

		PrintService printService = printJob.getPrintService();
		try {
			printJob.setPrintService(setprinter(printService));
		} catch (PrinterException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		book = new Book();
	}

	public void printSaleBill(SalesBillModel saleBill,
			ArrayList<BillDetailModel> billDetailList,
			ArrayList<OtherChargesModel> OtherChargesList, PaymentModel payment) {

		// check for default bill format
		if (defaultPrintSize == PrintBill.FULL_A4) {
			book.append(new BillTempletFullA4(saleBill, billDetailList,
					OtherChargesList, payment), printJob.defaultPage());

		} else if (defaultPrintSize == PrintBill.HALF_A4) {
			book.append(new BillTempletHalfA4(saleBill, billDetailList,
					OtherChargesList, payment), printJob.defaultPage());

		} else if (defaultPrintSize == PrintBill.SIX_INCH) {
			book.append(new BillTempletSixInch(saleBill, billDetailList,
					OtherChargesList, payment), printJob.defaultPage());

		} else if (defaultPrintSize == PrintBill.THREE_INCH) {
			book.append(new BillTempletThreeInch(saleBill, billDetailList,
					OtherChargesList, payment), printJob.defaultPage());
		}

		printJob.setPageable(book);

		//if (printJob.printDialog()) {
			try {
				printJob.print();
			} catch (Exception PrintException) {
				PrintException.printStackTrace();
			}
		//}

	}

	public void printChallan(ChallanModel challan,
			ArrayList<BillDetailModel> billDetailList,
			ArrayList<OtherChargesModel> OtherChargesList, PaymentModel payment) {

		// check for default bill format
		if (defaultPrintSize == PrintBill.FULL_A4) {
			book.append(new BillTempletFullA4(challan, billDetailList,
					OtherChargesList, payment), printJob.defaultPage());

		} else if (defaultPrintSize == PrintBill.HALF_A4) {
			book.append(new BillTempletHalfA4(challan, billDetailList,
					OtherChargesList, payment), printJob.defaultPage());

		} else if (defaultPrintSize == PrintBill.SIX_INCH) {
			/*
			 * book.append(new BillTempletSixInch(challan, billDetailList,
			 * OtherChargesList, payment), printJob.defaultPage());
			 */

		} else if (defaultPrintSize == PrintBill.THREE_INCH) {
			book.append(new BillTempletThreeInch(challan, billDetailList,
					OtherChargesList, payment), printJob.defaultPage());
		}

		printJob.setPageable(book);

		// if (printJob.printDialog()) {
		try {
			printJob.print();
		} catch (Exception PrintException) {
			PrintException.printStackTrace();
		}
		// }

	}

	public void printSaleOrder(SaleOrderModel saleOrder,
			ArrayList<BillDetailModel> billDetailList,
			ArrayList<OtherChargesModel> OtherChargesList, PaymentModel payment) {

		// check for default bill format
		if (defaultPrintSize == PrintBill.FULL_A4) {
			book.append(new BillTempletFullA4(saleOrder, billDetailList,
					OtherChargesList, payment), printJob.defaultPage());

		} else if (defaultPrintSize == PrintBill.HALF_A4) {
			book.append(new BillTempletHalfA4(saleOrder, billDetailList,
					OtherChargesList, payment), printJob.defaultPage());

		} else if (defaultPrintSize == PrintBill.SIX_INCH) {
			/*
			 * book.append(new BillTempletSixInch(saleOrder, billDetailList,
			 * OtherChargesList, payment), printJob.defaultPage());
			 */

		} else if (defaultPrintSize == PrintBill.THREE_INCH) {
			book.append(new BillTempletThreeInch(saleOrder, billDetailList,
					OtherChargesList, payment), printJob.defaultPage());
		}

		printJob.setPageable(book);

		// if (printJob.printDialog()) {
		try {
			printJob.print();
		} catch (Exception PrintException) {
			PrintException.printStackTrace();
		}
		// }

	}

	public void printSaleQuotation(SaleQuotationModel saleQuotation,
			ArrayList<BillDetailModel> billDetailList,
			ArrayList<OtherChargesModel> OtherChargesList) {

		// check for default bill format
		if (defaultPrintSize == PrintBill.FULL_A4) {
			book.append(new BillTempletFullA4(saleQuotation, billDetailList,
					OtherChargesList), printJob.defaultPage());

		} else if (defaultPrintSize == PrintBill.HALF_A4) {
			book.append(new BillTempletHalfA4(saleQuotation, billDetailList,
					OtherChargesList), printJob.defaultPage());

		} else if (defaultPrintSize == PrintBill.SIX_INCH) {
			/*
			 * book.append(new BillTempletSixInch(saleQuotation, billDetailList,
			 * OtherChargesList, payment), printJob.defaultPage());
			 */

		} else if (defaultPrintSize == PrintBill.THREE_INCH) {
			book.append(new BillTempletThreeInch(saleQuotation, billDetailList,
					OtherChargesList), printJob.defaultPage());
		}

		printJob.setPageable(book);

		// if (printJob.printDialog()) {
		try {
			printJob.print();
		} catch (Exception PrintException) {
			PrintException.printStackTrace();
		}
		// }

	}

	public static void main(String[] args) {
		SalesBillModel saleBill = new SalesBillModel();
		saleBill.setCustomerName("Dharm");
		saleBill.setMobileNo("9785323426");
		BillDetailModel saleDetail = new SalesBillDetailModel();
		saleDetail.setProductName("Item Name");
		OtherChargesModel otherCharge = new OtherChargesModel();
		ArrayList<BillDetailModel> billDetailList = new ArrayList<>();
		billDetailList.add(saleDetail);
		billDetailList.add(saleDetail);
		billDetailList.add(saleDetail);
		billDetailList.add(saleDetail);
		ArrayList<OtherChargesModel> OtherChargesList = new ArrayList<>();
		OtherChargesList.add(otherCharge);
		OtherChargesList.add(otherCharge);
		PaymentModel payment = new PaymentModel();

		new PrintBill().printSaleBill(saleBill, billDetailList,
				OtherChargesList, payment);

	}

	public PrintService setprinter(PrintService pps) {

		PrintService[] printServices = PrintServiceLookup.lookupPrintServices(
				null, null);

		for (PrintService printer : printServices) {
			if ((printer.getName().toLowerCase()).contains("pdf")) {
				pps = printer;

			}
		}
		return pps;
	}

}
