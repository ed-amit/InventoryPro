package com.lrd.inventory.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lrd.inventory.model.SalesBillDetailModel;
import com.lrd.inventory.model.SalesBillModel;
import com.lrd.inventory.model.BrandModel;
import com.lrd.inventory.model.CategoryModel;
import com.lrd.inventory.model.ChallanDetailModel;
import com.lrd.inventory.model.ChallanModel;
import com.lrd.inventory.model.CreditorModel;
import com.lrd.inventory.model.DistributorModel;
import com.lrd.inventory.model.FinancialYearModal;
import com.lrd.inventory.model.MarginModel;
import com.lrd.inventory.model.ProductModel;
import com.lrd.inventory.model.PurchaseBillDetailModel;
import com.lrd.inventory.model.PurchaseBillModel;
import com.lrd.inventory.model.PurchaseOrderModel;
import com.lrd.inventory.model.RackModel;
import com.lrd.inventory.model.SaleOrderModel;
import com.lrd.inventory.model.VatModel;

public class GetDBValue {

	Connection connection = null;
	Statement stmt = null;

	public GetDBValue(Connection connection) {
		this.connection = connection;
		try {
			this.stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<RackModel> getRackDetail(int storeId) {
		try {
			ArrayList<RackModel> list = new ArrayList<>();
			ResultSet result = stmt
					.executeQuery("select * from rack where store_id="
							+ storeId);
			RackModel rack;
			while (result.next()) {
				rack = new RackModel();
				rack.setRackId(result.getInt("RACK_ID"));
				rack.setRackDesc(result.getString("RACK_DESCIRPTION"));
				rack.setRackName(result.getString("RACK_NAME"));
				rack.setFirmId(result.getInt("FIRM_ID"));
				rack.setStoreId(result.getInt("store_id"));
				list.add(rack);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<CategoryModel> getCategoryDetail(int storeId) {
		try {
			ArrayList<CategoryModel> list = new ArrayList<>();
			ResultSet result = stmt
					.executeQuery("select * from categories where store_id="
							+ storeId);
			CategoryModel category;
			while (result.next()) {
				category = new CategoryModel();
				category.setCategoryId(result.getInt("CATEGORY_ID"));
				category.setCategoryDesc(result
						.getString("CATEGORY_DESCIRPTION"));
				category.setCategoryName(result.getString("CATEGORY_NAME"));
				category.setRackId(result.getInt("RACK_ID"));
				category.setFirmId(result.getInt("FIRM_ID"));
				category.setStoreId(result.getInt("store_id"));
				list.add(category);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<BrandModel> getBrandDetail(int storeId) {
		try {
			ArrayList<BrandModel> list = new ArrayList<>();
			ResultSet result = stmt
					.executeQuery("select * from brand where store_id="
							+ storeId);
			BrandModel brand;
			while (result.next()) {
				brand = new BrandModel();
				brand.setBrandId(result.getInt("BRAND_ID"));
				brand.setBrandDesc(result.getString("BRAND_DESCIRPTION"));
				brand.setBrandName(result.getString("BRAND_NAME"));
				brand.setCategoryId(result.getInt("CATEGORY_ID"));
				brand.setRackId(result.getInt("RACK_ID"));
				brand.setFirmId(result.getInt("FIRM_ID"));
				brand.setStoreId(result.getInt("store_id"));
				list.add(brand);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<VatModel> getVatDetail() {
		try {
			ArrayList<VatModel> list = new ArrayList<>();
			ResultSet result = stmt.executeQuery("select * from vats");
			VatModel vat;
			while (result.next()) {
				vat = new VatModel();
				vat.setVatId(result.getInt("VAT_ID"));
				vat.setVatPercent(result.getFloat("VAT_PERCENT"));
				vat.setYearId(result.getInt("YEAR_ID"));
				vat.setFirmId(result.getInt("FIRM_ID"));
				vat.setVatUpdated(result.getInt("VAT_UPDATED"));
				list.add(vat);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<FinancialYearModal> getFinancialYearDetail() {
		try {
			ArrayList<FinancialYearModal> list = new ArrayList<>();
			ResultSet result = stmt
					.executeQuery("select * from financial_year");
			FinancialYearModal year;
			while (result.next()) {
				year = new FinancialYearModal();
				year.setYearId(result.getInt("YEAR_ID"));
				year.setStartYear(result.getInt("YEAR_FROM"));
				year.setEndYear(result.getInt("YEAR_TO"));
				year.setSelectedYear(result.getInt("YEAR_SELECTED"));
				list.add(year);
			}

			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ProductModel> getProductDetail(int storeId) {
		try {
			ArrayList<ProductModel> list = new ArrayList<>();
			ResultSet result = stmt
					.executeQuery("select * from products where STORE_ID="
							+ storeId);

			while (result.next()) {
				ProductModel product = new ProductModel();
				product.setProductId(result.getInt("PRODUCT_ID"));
				product.setProductCode(result.getString("PRODUCT_CODE"));
				product.setProductName(result.getString("PRODUCT_NAME"));
				product.setProductDesc(result.getString("PRODUCT_DESC"));
				product.setRackId(result.getInt("RACK_ID"));
				product.setCategoryId(result.getInt("CATEGORY_ID"));
				product.setBrandId(result.getInt("BRAND_ID"));
				product.setUnit(result.getString("UNIT"));
				product.setQuantity(result.getDouble("QUANTITY"));
				product.setPurchaseRate(result.getDouble("PURCHASE_RATE"));
				product.setMRP(result.getDouble("MRP"));
				product.setSaleRate(result.getDouble("SALE_RATE"));
				product.setWholesaleRate(result.getDouble("WHOLESALE_RATE"));
				product.setOnlineRate(result.getDouble("ONLINE_SALE_RATE"));
				product.setVatPercent(result.getDouble("VAT_PER"));
				product.setLowQuantity(result.getDouble("LOW_LEVEL_QUANTITY"));
				product.setFirmId(result.getInt("FIRM_ID"));
				product.setStoreId(result.getInt("STORE_ID"));
				product.setYearId(result.getInt("YEAR_ID"));

				list.add(product);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ProductModel getProductDetailById(int productId) {
		// TODO Auto-generated method stub
		try {

			ResultSet result = stmt
					.executeQuery("select * from products where product_ID="
							+ productId);
			result.first();

			ProductModel product = new ProductModel();

			product.setProductId(result.getInt("PRODUCT_ID"));
			product.setProductCode(result.getString("PRODUCT_CODE"));
			product.setProductName(result.getString("PRODUCT_NAME"));
			product.setProductDesc(result.getString("PRODUCT_DESC"));
			product.setRackId(result.getInt("RACK_ID"));
			product.setCategoryId(result.getInt("CATEGORY_ID"));
			product.setBrandId(result.getInt("BRAND_ID"));
			product.setUnit(result.getString("UNIT"));
			product.setQuantity(result.getDouble("QUANTITY"));
			product.setPurchaseRate(result.getDouble("PURCHASE_RATE"));
			product.setMRP(result.getDouble("MRP"));
			product.setSaleRate(result.getDouble("SALE_RATE"));
			product.setWholesaleRate(result.getDouble("WHOLESALE_RATE"));
			product.setOnlineRate(result.getDouble("ONLINE_SALE_RATE"));
			product.setVatPercent(result.getDouble("VAT_PER"));
			product.setLowQuantity(result.getDouble("LOW_LEVEL_QUANTITY"));
			product.setFirmId(result.getInt("FIRM_ID"));
			product.setStoreId(result.getInt("STORE_ID"));
			product.setYearId(result.getInt("YEAR_ID"));

			return product;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<DistributorModel> getDistributorDetail(int storeId) {
		try {
			ArrayList<DistributorModel> list = new ArrayList<>();
			ResultSet result = stmt
					.executeQuery("select * from distributors where store_id="
							+ storeId);
			DistributorModel distributor;
			while (result.next()) {
				distributor = new DistributorModel();

				distributor.setDistributorId(result.getInt("distributor_id"));
				distributor.setStoreId(result.getInt("store_id"));
				distributor.setStatus(result.getString("status"));
				distributor.setName(result.getString("name"));
				distributor.setAgencyName(result.getString("agency_name"));
				distributor.setPanNo(result.getString("pan_no"));
				distributor.setTinNo(result.getString("tin_no"));
				distributor.setAddress(result.getString("address"));
				distributor.setCity(result.getString("city"));
				distributor.setPinCode(result.getString("pincode"));
				distributor.setOfficeNo(result.getString("office_no"));
				distributor.setFaxNo(result.getString("fax_no"));
				distributor.setMobileNo(result.getString("mobile_no"));
				distributor.setBuyingType(result.getString("buying_type"));
				distributor.setLocationType(result.getString("location_type"));
				distributor.setPurchaseType(result.getString("purchase_type"));
				distributor.setDrugLicenceNo(result
						.getString("drug_licence_no"));
				distributor.setTerms(result.getString("term_and_condition"));
				distributor.setRemark(result.getString("remark"));

				list.add(distributor);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<CreditorModel> getCreditorDetail(int storeId) {
		try {

			ArrayList<CreditorModel> list = new ArrayList<>();
			ResultSet result = stmt
					.executeQuery("select * from credit_customers where store_id="
							+ storeId);
			CreditorModel creditor;
			while (result.next()) {

				creditor = new CreditorModel();
				creditor.setId(result.getInt("customer_id"));
				creditor.setName(result.getString("customer_name"));
				creditor.setAddress(result.getString("address"));
				creditor.setContactNo(result.getString("contact_no"));
				creditor.setCreditLimit(result.getDouble("CREDIT_LIMIT"));
				creditor.setCreditAmt(result.getDouble("credit_balance"));
				creditor.setDebitAmt(result.getDouble("debit_balance"));
				creditor.setStoreId(result.getInt("store_id"));
				list.add(creditor);
			}

			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<SalesBillModel> getDueBillDetail(int storeId) {
		try {
			ArrayList<SalesBillModel> billList = new ArrayList<>();
			stmt.executeUpdate("CREATE OR REPLACE VIEW DUE_PAYMENT AS SELECT BILL_ID , SUM(PAID_AMOUNT) from bill_payment_details GROUP BY BILL_ID");
			ResultSet result = stmt
					.executeQuery("SELECT * FROM bill,`due_payment` WHERE GRAND_TOTAL>`sum(paid_amount)` AND bill.bill_id=due_payment.bill_id");

			SalesBillModel bill;
			while (result.next()) {
				bill = new SalesBillModel();

				bill.setBillId(result.getInt("bill_id"));
				bill.setCounter(result.getInt("counter"));
				bill.setFirmId(result.getInt("firm_id"));
				bill.setChallanNo(result.getInt("challan_no"));
				bill.setStoreId(result.getInt("store_id"));
				bill.setYearId(result.getInt("year_id"));
				bill.setHomeDelivery(result.getInt("home_delivery"));
				bill.setDiscount(result.getDouble("discount"));
				bill.setTotalAmt(result.getDouble("grand_total"));
				bill.setBillVatPercent(result.getDouble("whole_bill_vat"));
				bill.setBillVatAmt(result.getDouble("whole_bill_vat_amount"));
				bill.setBillNo(result.getString("bill_no"));
				bill.setBillDate(result.getString("bill_date"));
				bill.setCustomerName(result.getString("customer_name"));
				bill.setCustomerAddress(result.getString("customer_address"));
				bill.setCustomerType(result.getString("customer_type"));
				bill.setMobileNo(result.getString("mobile_number"));
				bill.setNarration(result.getString("narration"));
				bill.setUserName(result.getString("username"));
				bill.setPrefix(result.getString("prefix"));

				billList.add(bill);
			}
			return billList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<SalesBillDetailModel> getBillProductDetail(int billId) {
		ArrayList<SalesBillDetailModel> billDetailList = new ArrayList<>();
		String query = "select * from bill_details where bill_id=" + billId;
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				SalesBillDetailModel billDetailModel = new SalesBillDetailModel();
				billDetailModel.setBillDetailId(result
						.getInt("bill_details_id"));
				billDetailModel.setBillId(result.getInt("bill_id"));
				billDetailModel.setProductQuantity(result
						.getDouble("product_quantity"));
				billDetailModel
						.setProductRate(result.getDouble("Product_rate"));
				billDetailModel.setMrp(result.getDouble("mrp"));
				billDetailModel.setVatPercent(result
						.getDouble("vat_percentage"));
				billDetailModel.setVatAmt(result.getDouble("vat_amount"));
				billDetailModel.setDiscountPercent(result
						.getDouble("discount_per"));
				billDetailModel.setDiscountAmt(result.getDouble("discount_rs"));
				billDetailModel.setBatchNo(result.getString("batch_no"));
				billDetailModel.setCategoryName(result
						.getString("category_name"));
				billDetailModel
						.setProductCode(result.getString("product_code"));
				billDetailModel
						.setProductName(result.getString("product_name"));
				billDetailModel
						.setProductType(result.getString("product_type"));
				billDetailModel
						.setProductUnit(result.getString("product_unit"));
				billDetailModel.setWarrantyStartDate(result
						.getString("warranty_start_date"));
				billDetailModel.setWarrantyEndDate(result
						.getString("warranty_end_date"));

				billDetailList.add(billDetailModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return billDetailList;
	}

	public ArrayList<SalesBillModel> getAllBill(int storeId) {
		ArrayList<SalesBillModel> billList = new ArrayList<>();
		String query = "select * from bill where store_id=" + storeId;
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				SalesBillModel bill = new SalesBillModel();

				bill.setBillId(result.getInt("bill_id"));
				bill.setCounter(result.getInt("counter"));
				bill.setFirmId(result.getInt("firm_id"));
				bill.setChallanNo(result.getInt("challan_no"));
				bill.setStoreId(result.getInt("store_id"));
				bill.setYearId(result.getInt("year_id"));
				bill.setHomeDelivery(result.getInt("home_delivery"));
				bill.setDiscount(result.getDouble("discount"));
				bill.setTotalAmt(result.getDouble("grand_total"));
				bill.setBillVatPercent(result.getDouble("whole_bill_vat"));
				bill.setBillVatAmt(result.getDouble("whole_bill_vat_amount"));
				bill.setBillNo(result.getString("bill_no"));
				bill.setBillDate(result.getString("bill_date"));
				bill.setCustomerName(result.getString("customer_name"));
				bill.setCustomerAddress(result.getString("customer_address"));
				bill.setCustomerType(result.getString("customer_type"));
				bill.setMobileNo(result.getString("mobile_number"));
				bill.setNarration(result.getString("narration"));
				bill.setUserName(result.getString("username"));
				bill.setPrefix(result.getString("prefix"));

				billList.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return billList;
	}

	public ArrayList<SalesBillModel> getAllBill(String arg0, String argType,
			int storeId) {
		ArrayList<SalesBillModel> billList = new ArrayList<>();
		String query = "";
		if (argType.equals("billId"))
			query = "select * from bill where store_id=" + storeId
					+ " and bill_no LIKE '" + arg0 + "%'";
		else if (argType.equals("customerName"))
			query = "select * from bill where store_id=" + storeId
					+ " and customer_name LIKE '" + arg0 + "%'";
		else
			query = "select * from bill where store_id=" + storeId;
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				SalesBillModel bill = new SalesBillModel();

				bill.setBillId(result.getInt("bill_id"));
				bill.setCounter(result.getInt("counter"));
				bill.setFirmId(result.getInt("firm_id"));
				bill.setChallanNo(result.getInt("challan_no"));
				bill.setStoreId(result.getInt("store_id"));
				bill.setYearId(result.getInt("year_id"));
				bill.setHomeDelivery(result.getInt("home_delivery"));
				bill.setDiscount(result.getDouble("discount"));
				bill.setTotalAmt(result.getDouble("grand_total"));
				bill.setBillVatPercent(result.getDouble("whole_bill_vat"));
				bill.setBillVatAmt(result.getDouble("whole_bill_vat_amount"));
				bill.setBillNo(result.getString("bill_no"));
				bill.setBillDate(result.getString("bill_date"));
				bill.setCustomerName(result.getString("customer_name"));
				bill.setCustomerAddress(result.getString("customer_address"));
				bill.setCustomerType(result.getString("customer_type"));
				bill.setMobileNo(result.getString("mobile_number"));
				bill.setNarration(result.getString("narration"));
				bill.setUserName(result.getString("username"));
				bill.setPrefix(result.getString("prefix"));

				billList.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return billList;
	}

	public ArrayList<SalesBillModel> getAllBill(int storeId, String fromDate,
			String toDate) {
		ArrayList<SalesBillModel> billList = new ArrayList<>();
		String query = "select * from bill where store_id=" + storeId
				+ " AND bill_date BETWEEN '" + fromDate + "' AND '" + toDate
				+ "';";
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				SalesBillModel bill = new SalesBillModel();

				bill.setBillId(result.getInt("bill_id"));
				bill.setCounter(result.getInt("counter"));
				bill.setFirmId(result.getInt("firm_id"));
				bill.setChallanNo(result.getInt("challan_no"));
				bill.setStoreId(result.getInt("store_id"));
				bill.setYearId(result.getInt("year_id"));
				bill.setHomeDelivery(result.getInt("home_delivery"));
				bill.setDiscount(result.getDouble("discount"));
				bill.setTotalAmt(result.getDouble("grand_total"));
				bill.setBillVatPercent(result.getDouble("whole_bill_vat"));
				bill.setBillVatAmt(result.getDouble("whole_bill_vat_amount"));
				bill.setBillNo(result.getString("bill_no"));
				bill.setBillDate(result.getString("bill_date"));
				bill.setCustomerName(result.getString("customer_name"));
				bill.setCustomerAddress(result.getString("customer_address"));
				bill.setCustomerType(result.getString("customer_type"));
				bill.setMobileNo(result.getString("mobile_number"));
				bill.setNarration(result.getString("narration"));
				bill.setUserName(result.getString("username"));
				bill.setPrefix(result.getString("prefix"));

				billList.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return billList;
	}

	public ArrayList<SalesBillModel> getGeneralCustomerBill(int storeId) {
		ArrayList<SalesBillModel> billList = new ArrayList<>();
		String query = "select * from bill where store_id=" + storeId
				+ " AND customer_type='General Customer'";
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				SalesBillModel bill = new SalesBillModel();

				bill.setBillId(result.getInt("bill_id"));
				bill.setCounter(result.getInt("counter"));
				bill.setFirmId(result.getInt("firm_id"));
				bill.setChallanNo(result.getInt("challan_no"));
				bill.setStoreId(result.getInt("store_id"));
				bill.setYearId(result.getInt("year_id"));
				bill.setHomeDelivery(result.getInt("home_delivery"));
				bill.setDiscount(result.getDouble("discount"));
				bill.setTotalAmt(result.getDouble("grand_total"));
				bill.setBillVatPercent(result.getDouble("whole_bill_vat"));
				bill.setBillVatAmt(result.getDouble("whole_bill_vat_amount"));
				bill.setBillNo(result.getString("bill_no"));
				bill.setBillDate(result.getString("bill_date"));
				bill.setCustomerName(result.getString("customer_name"));
				bill.setCustomerAddress(result.getString("customer_address"));
				bill.setCustomerType(result.getString("customer_type"));
				bill.setMobileNo(result.getString("mobile_number"));
				bill.setNarration(result.getString("narration"));
				bill.setUserName(result.getString("username"));
				bill.setPrefix(result.getString("prefix"));

				billList.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return billList;
	}

	public ArrayList<SalesBillModel> getCreditorBill(String creditorName,
			String contact, int storeId) {
		ArrayList<SalesBillModel> billList = new ArrayList<>();
		String query = "select * from bill where store_id=" + storeId
				+ " AND customer_type='Credit Customer' AND customer_name='"
				+ creditorName + "' AND mobile_number='" + contact + "'";
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				SalesBillModel bill = new SalesBillModel();

				bill.setBillId(result.getInt("bill_id"));
				bill.setCounter(result.getInt("counter"));
				bill.setFirmId(result.getInt("firm_id"));
				bill.setChallanNo(result.getInt("challan_no"));
				bill.setStoreId(result.getInt("store_id"));
				bill.setYearId(result.getInt("year_id"));
				bill.setHomeDelivery(result.getInt("home_delivery"));
				bill.setDiscount(result.getDouble("discount"));
				bill.setTotalAmt(result.getDouble("grand_total"));
				bill.setBillVatPercent(result.getDouble("whole_bill_vat"));
				bill.setBillVatAmt(result.getDouble("whole_bill_vat_amount"));
				bill.setBillNo(result.getString("bill_no"));
				bill.setBillDate(result.getString("bill_date"));
				bill.setCustomerName(result.getString("customer_name"));
				bill.setCustomerAddress(result.getString("customer_address"));
				bill.setCustomerType(result.getString("customer_type"));
				bill.setMobileNo(result.getString("mobile_number"));
				bill.setNarration(result.getString("narration"));
				bill.setUserName(result.getString("username"));
				bill.setPrefix(result.getString("prefix"));

				billList.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return billList;
	}

	public ArrayList<ChallanModel> getChallanDetail(int storeId) {
		ArrayList<ChallanModel> challanList = new ArrayList<>();
		String query = "select * from challan where store_id=" + storeId;
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				ChallanModel challan = new ChallanModel();

				challan.setChallanId(result.getInt("challan_id"));
				challan.setCounter(result.getInt("counter"));
				challan.setFirmId(result.getInt("firm_id"));
				challan.setStoreId(result.getInt("store_id"));
				challan.setYearId(result.getInt("year_id"));
				challan.setHomeDelivery(result.getInt("home_delivery"));
				challan.setDiscount(result.getDouble("discount"));
				challan.setTotalAmt(result.getDouble("grand_total"));
				challan.setChallanVatPercent(result.getDouble("whole_bill_vat"));
				challan.setChallanVatAmt(result
						.getDouble("whole_bill_vat_amount"));
				challan.setChallanNo(result.getString("challan_no"));
				challan.setChallanDate(result.getString("challan_date"));
				challan.setCustomerName(result.getString("customer_name"));
				challan.setCustomerAddress(result.getString("customer_address"));
				challan.setCustomerType(result.getString("customer_type"));
				challan.setMobileNo(result.getString("mobile_number"));
				challan.setNarration(result.getString("narration"));
				challan.setUserName(result.getString("username"));
				challan.setPrefix(result.getString("prefix"));

				challanList.add(challan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return challanList;
	}

	public ArrayList<ChallanDetailModel> getChallanProductDetail(int challanId) {
		ArrayList<ChallanDetailModel> challanDetailList = new ArrayList<>();
		String query = "select * from challan_details where challan_id="
				+ challanId;
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				ChallanDetailModel challanDetailModel = new ChallanDetailModel();
				challanDetailModel.setChallanDetailId(result
						.getInt("challan_details_id"));
				challanDetailModel.setChallanId(result.getInt("challan_id"));
				challanDetailModel.setProductQuantity(result
						.getDouble("product_quantity"));
				challanDetailModel.setProductRate(result
						.getDouble("Product_rate"));
				challanDetailModel.setMrp(result.getDouble("mrp"));
				challanDetailModel.setVatPercent(result
						.getDouble("vat_percentage"));
				challanDetailModel.setVatAmt(result.getDouble("vat_amount"));
				challanDetailModel.setDiscountPercent(result
						.getDouble("discount_per"));
				challanDetailModel.setDiscountAmt(result
						.getDouble("discount_rs"));
				challanDetailModel.setBatchNo(result.getString("batch_no"));
				challanDetailModel.setCategoryName(result
						.getString("category_name"));
				challanDetailModel.setProductCode(result
						.getString("product_code"));
				challanDetailModel.setProductName(result
						.getString("product_name"));
				challanDetailModel.setProductType(result
						.getString("product_type"));
				challanDetailModel.setProductUnit(result
						.getString("product_unit"));
				challanDetailModel.setWarrantyStartDate(result
						.getString("warranty_start_date"));
				challanDetailModel.setWarrantyEndDate(result
						.getString("warranty_end_date"));

				challanDetailList.add(challanDetailModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return challanDetailList;
	}

	public ArrayList<PurchaseOrderModel> getPurchaseOrder(int orderId) {
		ArrayList<PurchaseOrderModel> purchaseOrderList = new ArrayList<>();
		String query = "select * from purchase_order where order_id LIKE '%"
				+ orderId + "%';";
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				PurchaseOrderModel purchaseOrder = new PurchaseOrderModel();

				purchaseOrder.setOrderId(result.getInt("order_id"));
				purchaseOrder
						.setExceptedDate(result.getString("expected_date"));
				purchaseOrder.setOrderDate(result.getString("order_date"));
				purchaseOrder.setStatus(result.getString("status"));
				purchaseOrder
						.setSupplierName(result.getString("supplier_name"));
				purchaseOrder.setTotalProduct(result.getInt("total_products"));
				purchaseOrder.setReceiptId(result.getInt("recepiteid"));
				purchaseOrder.setStoreId(result.getInt("store_id"));
				purchaseOrder.setYearId(result.getInt("year_id"));

				purchaseOrderList.add(purchaseOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseOrderList;
	}

	public ArrayList<PurchaseOrderModel> getAllPendingPurchaseOrder(int storeId) {
		ArrayList<PurchaseOrderModel> purchaseOrderList = new ArrayList<>();
		String query = "select * from purchase_order where status ='pending' AND store_id="
				+ storeId + ";";
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				PurchaseOrderModel purchaseOrder = new PurchaseOrderModel();

				purchaseOrder.setOrderId(result.getInt("order_id"));
				purchaseOrder
						.setExceptedDate(result.getString("expected_date"));
				purchaseOrder.setOrderDate(result.getString("order_date"));
				purchaseOrder.setStatus(result.getString("status"));
				purchaseOrder
						.setSupplierName(result.getString("supplier_name"));
				purchaseOrder.setTotalProduct(result.getInt("total_products"));
				purchaseOrder.setReceiptId(result.getInt("recepiteid"));
				purchaseOrder.setStoreId(result.getInt("store_id"));
				purchaseOrder.setYearId(result.getInt("year_id"));

				purchaseOrderList.add(purchaseOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseOrderList;
	}

	public ArrayList<PurchaseOrderModel> getPurchaseOrder(String supplierName) {
		ArrayList<PurchaseOrderModel> purchaseOrderList = new ArrayList<>();
		String query = "select * from purchase_order where supplier_name LIKE '%"
				+ supplierName + "%';";
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				PurchaseOrderModel purchaseOrder = new PurchaseOrderModel();

				purchaseOrder.setOrderId(result.getInt("order_id"));
				purchaseOrder
						.setExceptedDate(result.getString("expected_date"));
				purchaseOrder.setOrderDate(result.getString("order_date"));
				purchaseOrder.setStatus(result.getString("status"));
				purchaseOrder
						.setSupplierName(result.getString("supplier_name"));
				purchaseOrder.setTotalProduct(result.getInt("total_products"));
				purchaseOrder.setReceiptId(result.getInt("recepiteid"));
				purchaseOrder.setStoreId(result.getInt("store_id"));
				purchaseOrder.setYearId(result.getInt("year_id"));

				purchaseOrderList.add(purchaseOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseOrderList;
	}
	public ArrayList<PurchaseOrderModel> getPurchaseOrder(String startDate,
			String endDate) {
		ArrayList<PurchaseOrderModel> purchaseOrderList = new ArrayList<>();
		String query = "select * from purchase_order where order_date between '"
				+ startDate + "' and '" + endDate + "'";
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				PurchaseOrderModel purchaseOrder = new PurchaseOrderModel();

				purchaseOrder.setOrderId(result.getInt("order_id"));
				purchaseOrder
						.setExceptedDate(result.getString("expected_date"));
				purchaseOrder.setOrderDate(result.getString("order_date"));
				purchaseOrder.setStatus(result.getString("status"));
				purchaseOrder
						.setSupplierName(result.getString("supplier_name"));
				purchaseOrder.setTotalProduct(result.getInt("total_products"));
				purchaseOrder.setReceiptId(result.getInt("recepiteid"));
				purchaseOrder.setStoreId(result.getInt("store_id"));
				purchaseOrder.setYearId(result.getInt("year_id"));

				purchaseOrderList.add(purchaseOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseOrderList;
	}

	public ArrayList<PurchaseBillModel> getPurchaseBill(String fieldName,
			int storeId) {
		ArrayList<PurchaseBillModel> purchaseBillList = new ArrayList<>();
		String query = "select * from purchase_bill where " + fieldName + "="
				+ storeId;
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				PurchaseBillModel purchaseBill = new PurchaseBillModel();

				purchaseBill.setBillId(result.getInt("bill_id"));
				purchaseBill.setAddress(result.getString("address"));
				purchaseBill.setAgencyName(result.getString("Agency_name"));
				purchaseBill.setBillNo(result.getString("bill_number"));
				purchaseBill.setCess(result.getDouble("cess"));
				purchaseBill.setContactNo(result.getString("contact_no"));
				purchaseBill.setCstAmount(result.getDouble("cst_amount"));
				purchaseBill.setCstPercent(result.getDouble("cst"));
				purchaseBill.setDiscount(result.getDouble("discount"));
				purchaseBill.setEntryTax(result.getDouble("entry_tax"));
				purchaseBill.setExciseAmount(result.getDouble("excise_amount"));
				purchaseBill.setExcisePercent(result.getDouble("excise"));
				purchaseBill.setGrandTotal(result.getDouble("grand_total"));
				purchaseBill.setHamali(result.getDouble("hamali"));
				purchaseBill.setLbtAmount(result.getDouble("lbt_amount"));
				purchaseBill.setLbtPercent(result.getDouble("lbt"));
				purchaseBill
						.setMiscellaneous(result.getDouble("miscellaneous"));
				purchaseBill.setNoOfDays(result.getInt("no_of_days"));
				purchaseBill.setOctraiAmt(result.getDouble("octrai"));
				purchaseBill.setPaidAmount(result.getDouble("Paid_amount"));
				purchaseBill.setPaymentMode(result.getString("payment_mode"));
				purchaseBill.setPurchaseDate(result.getString("purchase_date"));
				purchaseBill.setTinNo(result.getString("tin_number"));
				purchaseBill.setTransportationAmt(result
						.getDouble("transportation"));
				purchaseBill.setVatAmount(result.getDouble("vat_amount"));
				purchaseBill.setVatPercent(result.getDouble("vat"));
				purchaseBill.setDistributorId(result.getInt("distributor_id"));
				purchaseBill.setStoreId(result.getInt("store_id"));
				purchaseBill.setYearId(result.getInt("year_id"));

				purchaseBillList.add(purchaseBill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseBillList;
	}

	public ArrayList<PurchaseBillDetailModel> getPurchaseBillDetail(
			int purchaseBillId) {
		ArrayList<PurchaseBillDetailModel> purchaseBillDetailList = new ArrayList<>();
		String query = "select * from purchase_bill_details where bill_Details_id="
				+ purchaseBillId;
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				PurchaseBillDetailModel purchaseBillDetail = new PurchaseBillDetailModel();

				purchaseBillDetail.setPurchaseDetailId(result
						.getInt("bill_details_id"));
				purchaseBillDetail.setDiscount(result.getDouble("discount"));
				purchaseBillDetail.setFreeProduct(result.getDouble("free"));
				purchaseBillDetail.setMRP(result.getDouble("mrp"));
				purchaseBillDetail.setOnlineSaleRate(result
						.getDouble("online_sale_price"));
				purchaseBillDetail.setProductCode(result
						.getString("product_code"));
				purchaseBillDetail.setProductImange(result
						.getString("product_image"));
				purchaseBillDetail.setProductName(result
						.getString("product_name"));
				purchaseBillDetail.setPurchasePrice(result
						.getDouble("purchase_price"));
				purchaseBillDetail.setQuantity(result.getDouble("quantity"));
				purchaseBillDetail.setSaleRate(result.getDouble("rate"));
				purchaseBillDetail.setTotalCost(result.getDouble("total_cost"));
				purchaseBillDetail.setUnit(result.getString("unit"));
				purchaseBillDetail.setVatAmount(result.getDouble("vat_amount"));
				purchaseBillDetail.setVatPercent(result
						.getDouble("vat_percentage"));
				purchaseBillDetail.setWholeSalePrice(result
						.getDouble("whole_sale_price"));
				purchaseBillDetail.setPurchaseBillId(result.getInt("bill_id"));

				purchaseBillDetailList.add(purchaseBillDetail);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseBillDetailList;
	}

	public ArrayList<SaleOrderModel> getAllPendingSaleOrder(int storeId) {
		ArrayList<SaleOrderModel> saleOrderList = new ArrayList<>();
		// String
		// query="SELECT * FROM `sale_order` WHERE DATE_SUB(NOW(), INTERVAL `number_of_days` DAY) < `order_date` AND store_id="+storeId;
		String query = "SELECT * FROM `sale_order` WHERE status='pending' AND store_id="
				+ storeId;
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				SaleOrderModel saleOrder = new SaleOrderModel();

				saleOrder.setOrderId(result.getInt("ORDER_ID"));
				saleOrder.setOrderDate(result.getString("ORDER_DATE"));
				saleOrder.setOrderNo(result.getString("ORDER_NO"));
				saleOrder.setCustomerAddress(result
						.getString("CUSTOMER_ADDRESS"));
				saleOrder.setCustomerName(result.getString("CUSTOMER_NAME"));
				saleOrder.setCustomerType(result.getString("CUSTOMER_TYPE"));
				saleOrder.setDiscount(result.getDouble("DISCOUNT"));
				saleOrder.setTotalAmt(result.getDouble("GRAND_TOTAL"));
				saleOrder.setHomeDelivery(result.getInt("HOME_DELIVERY"));
				saleOrder.setMobileNo(result.getString("MOBILE_NUMBER"));
				saleOrder.setNarration(result.getString("NARRATION"));
				saleOrder.setUserName(result.getString("USERNAME"));
				saleOrder
						.setOrderVatPercent(result.getDouble("WHOLE_BILL_VAT"));
				saleOrder.setOrderVatAmt(result
						.getDouble("WHOLE_BILL_VAT_AMOUNT"));
				saleOrder.setCounter(result.getInt("COUNTER"));
				saleOrder.setFirmId(result.getInt("FIRM_ID"));
				saleOrder.setPrefix(result.getString("PREFIX"));
				saleOrder.setStoreId(result.getInt("STORE_ID"));
				saleOrder.setYearId(result.getInt("YEAR_ID"));
				saleOrder.setNumberOfDays(result.getInt("NUMBER_OF_DAYS"));
				saleOrder.setStatus(result.getString("STATUS"));

				saleOrderList.add(saleOrder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saleOrderList;
	}

	public ArrayList<MarginModel> getAllBillMargin(int storeId,
			String fromDate, String toDate) {
		ArrayList<MarginModel> billList = new ArrayList<>();
		String query = "SELECT bill.bill_id, bill.bill_no, bill.bill_date, bill.customer_name,"
				+ " sum(bill_details.product_rate*bill_details.product_quantity) AS product_total_rate,"
				+ " sum(bill_details.product_rate*bill_details.product_quantity)-"
				+ "sum(bill_details.purchase_rate*bill_details.product_quantity) as margin "
				+ "FROM `bill_details` LEFT JOIN `bill` on bill_details.bill_id=bill.bill_id "
				+ "where bill.store_id="
				+ storeId
				+ " AND bill.bill_date BETWEEN '"
				+ fromDate
				+ "' AND '"
				+ toDate + "' group by bill_details.bill_id;";
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				MarginModel bill = new MarginModel();

				bill.setBillId(result.getInt("bill_id"));
				bill.setBillNo(result.getString("bill_no"));
				bill.setBillDate(result.getString("bill_date"));
				bill.setCustomerName(result.getString("customer_name"));
				bill.setMargin(result.getDouble("margin"));
				bill.setProductTotalRate(result.getDouble("product_total_rate"));

				billList.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return billList;
	}

	public ArrayList<MarginModel> getAllBillMargin(String arg0, String argType,
			int storeId) {
		ArrayList<MarginModel> billList = new ArrayList<>();
		String query = "";
		if (argType.equals("billId"))
			query = "SELECT bill.bill_id, bill.bill_no, bill.bill_date, bill.customer_name,"
					+ " sum(bill_details.product_rate*bill_details.product_quantity) AS product_total_rate"
					+ ", sum(bill_details.product_rate*bill_details.product_quantity)-"
					+ "sum(bill_details.purchase_rate*bill_details.product_quantity) as margin "
					+ "FROM `bill_details` LEFT JOIN `bill` on bill_details.bill_id=bill.bill_id "
					+ "where bill.store_id="
					+ storeId
					+ " and bill_no LIKE '"
					+ arg0 + "%' group by bill_details.bill_id;";
		else if (argType.equals("customerName"))
			query = "SELECT bill.bill_id, bill.bill_no, bill.bill_date, bill.customer_name,"
					+ " sum(bill_details.product_rate*bill_details.product_quantity) AS product_total_rate,"
					+ " sum(bill_details.product_rate*bill_details.product_quantity)-"
					+ "sum(bill_details.purchase_rate*bill_details.product_quantity) as margin "
					+ "FROM `bill_details` LEFT JOIN `bill` on bill_details.bill_id=bill.bill_id "
					+ "where bill.store_id="
					+ storeId
					+ " and customer_name LIKE '"
					+ arg0
					+ "%' group by bill_details.bill_id;";
		else
			query = "SELECT bill.bill_id, bill.bill_no, bill.bill_date, bill.customer_name,"
					+ " sum(bill_details.product_rate*bill_details.product_quantity) AS product_total_rate,"
					+ " sum(bill_details.product_rate*bill_details.product_quantity)-"
					+ "sum(bill_details.purchase_rate*bill_details.product_quantity) as margin "
					+ "FROM `bill_details` LEFT JOIN `bill` on bill_details.bill_id=bill.bill_id "
					+ "where bill.store_id="
					+ storeId
					+ " group by bill_details.bill_id;";
		try {
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				MarginModel bill = new MarginModel();

				bill.setBillId(result.getInt("bill_id"));
				bill.setBillNo(result.getString("bill_no"));
				bill.setBillDate(result.getString("bill_date"));
				bill.setCustomerName(result.getString("customer_name"));
				bill.setMargin(result.getDouble("margin"));
				bill.setProductTotalRate(result.getDouble("product_total_rate"));

				billList.add(bill);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return billList;
	}

}
