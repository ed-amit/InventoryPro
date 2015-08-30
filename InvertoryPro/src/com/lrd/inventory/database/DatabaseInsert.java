package com.lrd.inventory.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lrd.inventory.model.BillDetailModel;
import com.lrd.inventory.model.BillModel;
import com.lrd.inventory.model.BillPaymentModel;
import com.lrd.inventory.model.BillReturnModel;
import com.lrd.inventory.model.BrandModel;
import com.lrd.inventory.model.CategoryModel;
import com.lrd.inventory.model.CreditorModel;
import com.lrd.inventory.model.DistributorModel;
import com.lrd.inventory.model.ProductModel;
import com.lrd.inventory.model.PurchaseBillDetailModel;
import com.lrd.inventory.model.PurchaseBillModel;
import com.lrd.inventory.model.PurchaseBillPaymentModel;
import com.lrd.inventory.model.PurchaseOrderDetailModel;
import com.lrd.inventory.model.PurchaseOrderModel;
import com.lrd.inventory.model.PurchaseReturnModel;
import com.lrd.inventory.model.RackModel;
import com.lrd.inventory.model.VatModel;


public class DatabaseInsert {

	Connection connection = null;
	Statement stmt = null;

	public DatabaseInsert(Connection connection) {
		this.connection = connection;
		try {
			this.stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param RackModel
	 *            Object
	 * 
	 *            insert rack model data into rack table of db
	 */
	public void insertRack(RackModel rack) {
		String query = "insert into rack values (null , '" + rack.getRackDesc()
				+ "' , '" + rack.getRackName() + "' ," + rack.getFirmId()
				+ " , " + rack.getStoreId() + ");";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param CategoryModal
	 * 
	 *            insert CategoryModal data into database
	 */
	public void insertCategory(CategoryModel category) {
		String query = "insert into categories values (null , '"
				+ category.getCategoryDesc() + "' , '"
				+ category.getCategoryName() + "' ," + category.getRackId()
				+ " , " + category.getFirmId() + " , " + category.getStoreId()
				+ ");";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param object
	 *            of BrandModel
	 * 
	 *            insert BrandModal data into database
	 */
	public void insertBrand(BrandModel brand) {
		String query = "insert into brand values (null , '"
				+ brand.getBrandDesc() + "' , '" + brand.getBrandName()
				+ "' , " + brand.getCategoryId() + " ," + brand.getRackId()
				+ " , " + brand.getFirmId() + " , " + brand.getStoreId() + ");";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param object
	 *            of VatModel
	 * 
	 *            insert VatModel data into db
	 */
	public void insertVat(VatModel vat) {
		String query = "insert into vats values (null , " + vat.getVatPercent()
				+ " , " + vat.getYearId() + " , " + vat.getFermId() + " ,"
				+ vat.getVatUpdated() + ");";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param product
	 * 
	 *            this function is used to insert ProductModel into db
	 */
	public void insertProduct(ProductModel product) {
		// System.out.println(product.getBrandId());
		String query = "insert into products values (null , '"
				+ product.getProductCode() + "', '" + product.getProductName()
				+ "', '" + product.getProductDesc() + "',"
				+ product.getRackId() + " ," + product.getCategoryId() + " ,"
				+ product.getBrandId() + " , '" + product.getUnit() + "',"
				+ product.getQuantity() + " ," + product.getPurchaseRate()
				+ " ," + product.getMRP() + " ," + product.getSaleRate() + " ,"
				+ product.getWholesaleRate() + " ," + product.getOnlineRate()
				+ " ," + product.getVatPercent() + " ,"
				+ product.getLowQuantity() + " ," + product.getFirmId() + " ,"
				+ product.getStoreId() + " ," + product.getYearId() + " );";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param distributor
	 * 
	 *            this function is used to insert DistributorModel into db
	 */
	public void insertDistributor(DistributorModel distributor) {
		String query = "insert into distributors values (null,"
				+ distributor.getStoreId() + " ,'" + distributor.getStatus()
				+ "','" + distributor.getName() + "','"
				+ distributor.getAgencyName() + "','" + distributor.getPanNo()
				+ "','" + distributor.getTinNo() + "','"
				+ distributor.getAddress() + "','" + distributor.getCity()
				+ "','" + distributor.getPincode() + "','"
				+ distributor.getOfficeNo() + "','" + distributor.getFaxNo()
				+ "','" + distributor.getMobileNo() + "','"
				+ distributor.getBuyingType() + "','"
				+ distributor.getLocationType() + "','"
				+ distributor.getPurchaseType() + "','"
				+ distributor.getDrugLicenceNo() + "','"
				+ distributor.getTerms() + "','" + distributor.getRemark()
				+ "');";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param bill
	 * @return id from database for newly inserted row
	 * 
	 *         this function is used to insert billDetailModel into db
	 */
	public int insertBill(BillModel bill) {
		int id = 0;
		String query = "insert into bill values (null , '" + bill.getBillDate()
				+ "' , '" + bill.getBillNo() + "' , '"
				+ bill.getCustomerAddress() + "' , '" + bill.getCustomerName()
				+ "' , '" + bill.getCustomerType() + "' , "
				+ bill.getDiscount() + " , " + bill.getTotalAmt() + " , "
				+ bill.getHomeDelivery() + " , '" + bill.getMobileNo()
				+ "' , '" + bill.getNarration() + "' , '" + bill.getUserName()
				+ "' , " + bill.getVatPercent() + " , " + bill.getVatAmt()
				+ " , " + bill.getChallanNo() + " , " + bill.getCounter()
				+ " , " + bill.getFirmId() + " , '" + bill.getPrefix() + "' , "
				+ bill.getStoreId() + " , " + bill.getYearId() + " );";
		try {
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet result = stmt
					.executeQuery("select max(bill_id) from bill");
			result.first();
			id = result.getInt(1);
			// System.out.println(id + "  id from db");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * @param billDetail
	 *            this function is used to insert billDetailModel into db
	 */
	public void insertBillDetail(BillDetailModel billDetail) {
		String query = "insert into bill_details values (null , "
				+ billDetail.getBillId() + " , '" + billDetail.getBatchNo()
				+ "' , '" + billDetail.getCategoryName() + "', '"
				+ billDetail.getProductCode() + "', '"
				+ billDetail.getProductName() + "', "
				+ billDetail.getProductQuantity() + " , "
				+ billDetail.getProductRate() + " , '"
				+ billDetail.getProductType() + "', '"
				+ billDetail.getProductUnit() + "', " + billDetail.getMrp()
				+ " , " + billDetail.getVatAmt() + " , "
				+ billDetail.getVatPercent() + " , '"
				+ billDetail.getWarrantyEndDate() + "', '"
				+ billDetail.getWarrantyStartDate() + "', "
				+ billDetail.getDiscountPercent() + " , "
				+ billDetail.getDiscountAmt() + ",'','','',0,0,'',0)";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertBillPayment(BillPaymentModel billPayment) {
		String query = "insert into bill_payment_details values(null, '"
				+ billPayment.getBankName() + "', '" + billPayment.getCode()
				+ "', '" + billPayment.getDescription() + "', "
				+ billPayment.getPaidAmt() + " , '"
				+ billPayment.getPaymentDate() + "', '"
				+ billPayment.getPaymentMode() + "', "
				+ billPayment.getBillId() + ");";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertCreditor(CreditorModel creditor) {
		String query = "insert into credit_customers values (null, '"
				+ creditor.getName() + "', '" + creditor.getAddress() + "', '"
				+ creditor.getContactNo() + "', " + creditor.getCreditLimit()
				+ " , " + creditor.getCreditAmt() + " , "
				+ creditor.getDebitAmt() + " , " + creditor.getFirmId() + " , "
				+ creditor.getStoreId() + " );";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param Product_id
	 * @param New_Quantity
	 */
	public void updateProduct(int id, double qty) {
		String query = "update products set QUANTITY=" + qty
				+ " where PRODUCT_ID=" + id;
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param productName
	 * @param productCode
	 * @param qty
	 */
	public void updateProduct(String productName, String productCode, double qty) {
		String query = "update products set QUANTITY=QUANTITY-" + qty
				+ " where PRODUCT_CODE='" + productCode
				+ "' and product_name='" + productName + "'";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param billReturn
	 */
	public void insertBillReturn(BillReturnModel billReturn) {
		String query = "insert into sale_return_details values (null, '"
				+ billReturn.getBillDate() + "', "
				+ billReturn.getBillDetailId() + " , '"
				+ billReturn.getBillNo() + "', " + billReturn.getBillId()
				+ " , '" + billReturn.getProductCode() + "', '"
				+ billReturn.getProductName() + "', "
				+ billReturn.getProductRate() + " , '"
				+ billReturn.getProductType() + "', "
				+ billReturn.getProductQuantity() + " , '"
				+ billReturn.getReason() + "', '" + billReturn.getReturnDate()
				+ "', '" + billReturn.getStatus() + "', "
				+ billReturn.getSubTotal() + " , '"
				+ billReturn.getProductUnit() + "', " + billReturn.getVatAmt()
				+ " , " + billReturn.getVatPercent() + " , "
				+ billReturn.getDiscountPercent() + " , "
				+ billReturn.getDiscountAmt() + " , " + billReturn.getFirmId()
				+ " , " + billReturn.getStoreId() + " , "
				+ billReturn.getYearId() + " );";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param purchaseBill
	 */
	public int insertPurchaseBill(PurchaseBillModel purchaseBill) {
		int id = 0;
		String query = "insert into purchase_bill values (null,'"
				+ purchaseBill.getAddress() + "','"
				+ purchaseBill.getAgencyName() + "','"
				+ purchaseBill.getBillNo() + "', " + purchaseBill.getCess()
				+ ",'" + purchaseBill.getContactNo() + "', "
				+ purchaseBill.getCstAmount() + ", "
				+ purchaseBill.getCstPercent() + ", "
				+ purchaseBill.getDiscount() + ", "
				+ purchaseBill.getEntaryTax() + ", "
				+ purchaseBill.getExciseAmount() + ", "
				+ purchaseBill.getExcisePercent() + ", "
				+ purchaseBill.getGrandTotal() + ", "
				+ purchaseBill.getHamali() + ", " + purchaseBill.getLbtAmount()
				+ ", " + purchaseBill.getLbtPercent() + ", "
				+ purchaseBill.getMiscellaneous() + ", "
				+ purchaseBill.getNoOfDays() + ", " + purchaseBill.getOctrai()
				+ ", " + purchaseBill.getPaidAmount() + ",'"
				+ purchaseBill.getPaymentMode() + "','"
				+ purchaseBill.getPurchaseDate() + "','"
				+ purchaseBill.getTinNo() + "', "
				+ purchaseBill.getTransportatin() + ", "
				+ purchaseBill.getVatAmount() + ", "
				+ purchaseBill.getVatPercent() + ", "
				+ purchaseBill.getDistributorId() + ", "
				+ purchaseBill.getStoreId() + ", " + purchaseBill.getYearId()
				+ ")";
		try {
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet result = stmt
					.executeQuery("select max(bill_id) from purchase_bill");
			result.first();
			id = result.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * 
	 * @param purchaseBillDetail
	 */
	public void insertPurchaseBillDetail(
			PurchaseBillDetailModel purchaseBillDetail) {
		String query = "insert into purchase_bill_details values (null, "
				+ purchaseBillDetail.getDiscount() + ", "
				+ purchaseBillDetail.getFreeProduct() + ", "
				+ purchaseBillDetail.getMRP() + ", "
				+ purchaseBillDetail.getOnlineSaleRate() + ",'"
				+ purchaseBillDetail.getProductCode() + "','"
				+ purchaseBillDetail.getProductImage() + "','"
				+ purchaseBillDetail.getProductName() + "', "
				+ purchaseBillDetail.getPurchasePrice() + ", "
				+ purchaseBillDetail.getQuantity() + ", "
				+ purchaseBillDetail.getSaleRate() + ", "
				+ purchaseBillDetail.getTotalCost() + ",'"
				+ purchaseBillDetail.getUnit() + "', "
				+ purchaseBillDetail.getVatAmount() + ", "
				+ purchaseBillDetail.getVatPercent() + ", "
				+ purchaseBillDetail.getWholeSalePrice() + ", "
				+ purchaseBillDetail.getPurchaseBillId() + ")";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param purchaseBillPayment
	 */
	public void insertPurchasePayment(
			PurchaseBillPaymentModel purchaseBillPayment) {
		String query = "";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param purchaseReturn
	 */
	public void insertPurchaseReturn(PurchaseReturnModel purchaseReturn) {
		String query = "insert into purchase_return_details values (null,'"
				+ purchaseReturn.getBillNumber() + "', "
				+ purchaseReturn.getBillDetailId() + ", "
				+ purchaseReturn.getBillId() + ",'"
				+ purchaseReturn.getProductName() + "','"
				+ purchaseReturn.getProductCode() + "', "
				+ purchaseReturn.getPurchasePrice() + ", "
				+ purchaseReturn.getQuantity() + ",'"
				+ purchaseReturn.getReturnDate() + "', "
				+ purchaseReturn.getTotalCost() + ",'"
				+ purchaseReturn.getUnit() + "', "
				+ purchaseReturn.getVatAmount() + ", "
				+ purchaseReturn.getVatPercent() + ", "
				+ purchaseReturn.getStoreId() + ", "
				+ purchaseReturn.getYearId() + ")";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param purchaseOrder
	 * @return new generated OrderId
	 */
	public int insertPurchaseOrder(PurchaseOrderModel purchaseOrder) {
		int id = 0;
		String query = "insert into purchase_order values (null, '"
				+ purchaseOrder.getExpectedDate() + "', '"
				+ purchaseOrder.getOrderDate() + "', '"
				+ purchaseOrder.getStatus() + "', '"
				+ purchaseOrder.getSupplierName() + "', "
				+ purchaseOrder.getTotalProduct() + ", "
				+ purchaseOrder.getReceiptId() + ", "
				+ purchaseOrder.getStoreId() + ", " + purchaseOrder.getYearId()
				+ ");";
		try {
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet result = stmt
					.executeQuery("select max(order_id) from purchase_order");
			result.first();
			id = result.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * 
	 * @param purchaseOrderDetail
	 */
	public void insertPurchaseOrderDetail(
			PurchaseOrderDetailModel purchaseOrderDetail) {
		String query = "insert into purchase_order_details values (null, '"
				+ purchaseOrderDetail.getProductCode() + "', '"
				+ purchaseOrderDetail.getProductName() + "', "
				+ purchaseOrderDetail.getQuantity() + ", '"
				+ purchaseOrderDetail.getUnit() + "', "
				+ purchaseOrderDetail.getOrderId() + ");";
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
