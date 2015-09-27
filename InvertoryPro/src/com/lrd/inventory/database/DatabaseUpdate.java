package com.lrd.inventory.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.lrd.inventory.model.SalesBillDetailModel;
import com.lrd.inventory.model.SalesBillModel;
import com.lrd.inventory.model.BrandModel;
import com.lrd.inventory.model.CategoryModel;
import com.lrd.inventory.model.CreditorModel;
import com.lrd.inventory.model.DistributorModel;
import com.lrd.inventory.model.ProductModel;
import com.lrd.inventory.model.RackModel;
import com.lrd.inventory.model.StoreModel;

public class DatabaseUpdate {

	Connection connection = null;
	Statement stmt = null;

	public DatabaseUpdate(Connection connection) {
		// TODO Auto-generated constructor stub
		this.connection = connection;
		try {
			this.stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateRack(RackModel rack) {

		try {
			stmt.executeUpdate("update rack set rack_name='"
					+ rack.getRackName() + "', RACK_DESCIRPTION='"
					+ rack.getRackDesc() + "' where rack_id="
					+ rack.getRackId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCategory(CategoryModel category) {

		try {
			stmt.executeUpdate("update categories set category_name='"
					+ category.getCategoryName() + "', category_DESCIRPTION='"
					+ category.getCategoryDesc() + "', rack_id="
					+ category.getRackId() + " where category_id="
					+ category.getCategoryId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateBrand(BrandModel brand) {

		try {
			stmt.executeUpdate("update brand set brand_name='"
					+ brand.getBrandName() + "', brand_DESCIRPTION='"
					+ brand.getBrandDesc() + "', rack_id=" + brand.getRackId()
					+ ", category_id=" + brand.getCategoryId()
					+ " where brand_id=" + brand.getBrandId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateProduct(ProductModel product) {
		try {
			stmt.executeUpdate("update products set product_code='"
					+ product.getProductCode() + "', product_name='"
					+ product.getProductName() + "', product_desc='"
					+ product.getProductDesc() + "', rack_id= "
					+ product.getRackId() + ", category_id= "
					+ product.getCategoryId() + ",brand_id= "
					+ product.getBrandId() + ",unit='" + product.getUnit()
					+ "', quantity= " + product.getQuantity()
					+ ",purchase_rate= " + product.getPurchaseRate() + ",mrp= "
					+ product.getMRP() + ",sale_rate= " + product.getSaleRate()
					+ ",wholesale_rate= " + product.getWholesaleRate()
					+ ",online_sale_rate= " + product.getOnlineRate()
					+ ",vat_per= " + product.getVatPercent()
					+ ",low_level_quantity= " + product.getLowQuantity()
					+ " where product_id=" + product.getProductId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCreditCustomer(CreditorModel creditor) {

		try {
			stmt.executeUpdate("update credit_customers set customer_name='"
					+ creditor.getName() + "', address='"
					+ creditor.getAddress() + "', contact_no='"
					+ creditor.getContactNo() + "', credit_limit="
					+ creditor.getCreditLimit() + ", credit_balance="
					+ creditor.getCreditAmt() + ", debit_balance="
					+ creditor.getDebitAmt() + " where customer_id="
					+ creditor.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateDistributor(DistributorModel distributor) {

		try {
			stmt.executeUpdate("update distributors set status='"
					+ distributor.getStatus() + "', name='"
					+ distributor.getName() + "', agency_name='"
					+ distributor.getAgencyName() + "', pan_no='"
					+ distributor.getPanNo() + "', tin_no='"
					+ distributor.getTinNo() + "', address='"
					+ distributor.getAddress() + "',city='"
					+ distributor.getCity() + "', pincode='"
					+ distributor.getPincode() + "', office_no='"
					+ distributor.getOfficeNo() + "', fax_no='"
					+ distributor.getFaxNo() + "',mobile_no='"
					+ distributor.getMobileNo() + "', drug_licence_no='"
					+ distributor.getDrugLicenceNo()
					+ "', term_and_condition='" + distributor.getTerms()
					+ "', remark='" + distributor.getRemark()
					+ "' where distributor_id="
					+ distributor.getDistributorId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateSalesBillAmount(SalesBillModel billModel) {

		try {
			stmt.executeUpdate("update bill set discount="
					+ billModel.getDiscount() + " , grand_total="
					+ billModel.getTotalAmt() + " where bill_id="
					+ billModel.getBillId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateSalesBillProduct(SalesBillDetailModel billDetail) {

		try {
			stmt.executeUpdate("update bill_details set product_quantity="
					+ billDetail.getProductQuantity() + " ,vat_amount="
					+ billDetail.getVatAmt() + " ,vat_percentage="
					+ billDetail.getVatPercent() + " ,discount_per="
					+ billDetail.getDiscountPercent() + " ,discount_rs="
					+ billDetail.getDiscountAmt() + " where bill_details_id="
					+ billDetail.getBillDetailId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePurchaseBillPayment(int PurchaseBillId,
			double paymentAmount) {

		try {
			stmt.executeUpdate("update purchase_bill set paid_amount=paid_amount+"
					+ paymentAmount + " where bill_id=" + PurchaseBillId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePurchaseOrderStatus(int orderId, String status) {
		// TODO Auto-generated method stub
		try {
			stmt.executeUpdate("update purchase_order set status='" + status
					+ "' where order_id=" + orderId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateStoreDetails(StoreModel store) {
		// TODO Auto-generated method stub
		try {
			stmt.executeUpdate("update store_details set store_name='"
					+ store.getStoreName() + "', address='"
					+ store.getAddress() + "',pin_no= " + store.getPinNo()
					+ ",city='" + store.getCityName() + "',state='"
					+ store.getStateName() + "',contact_no='"
					+ store.getContactNo() + "',email='" + store.getEmailId()
					+ "',manager_name='" + store.getManagerName()
					+ "',registration_no='" + store.getRegistrationNo()
					+ "',pan_no='" + store.getPanNo() + "' where store_id="
					+ store.getStoreId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
