package com.lrd.inventory.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDelete {

	Connection connection = null;
	Statement stmt = null;

	public DatabaseDelete(Connection connection) {
		// TODO Auto-generated constructor stub
		this.connection = connection;
		try {
			this.stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public boolean deleteRack(int rackId){
		try {
			stmt.executeUpdate("delete from rack where rack_id="+rackId);
			return true;		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}




	public boolean deleteCategory(int categoryId){

		try {
			stmt.executeUpdate("delete from categories where category_id="+categoryId);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



	public boolean deleteBrand(int brandId){

		try {
			stmt.executeUpdate("delete from brand where brand_id="+brandId);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public boolean deleteVat(int vatId){

		try {
			stmt.executeUpdate("delete from vats where vat_id="+vatId);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public boolean deleteProduct(int productId){

		try {
			stmt.executeUpdate("delete from products where product_id="+productId);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public boolean deleteProductVat(int productId){

		try {
			stmt.executeUpdate("delete from product_vat where product_id="+productId);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public boolean deleteCreditCustomer(int customerId){

		try {
			stmt.executeUpdate("delete from credit_customers where customer_id="+customerId);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public boolean deleteDistributor(int distributorId){

		try {
			stmt.executeUpdate("delete from distributors where distributor_id="+distributorId);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public boolean deleteProductFromSaleBill(int billDetailId){

		try {
			stmt.executeUpdate("delete from bill_details where bill_details_id="+billDetailId);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



	public boolean deletePurchaseOrder(int orderId) {
		// TODO Auto-generated method stub
		try {
			stmt.executeUpdate("delete from purchase_order where order_id="+orderId);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}



	public boolean deletePurchaseBill(int purchaseBillId) {
		// TODO Auto-generated method stub
		try {
			stmt.executeUpdate("delete from purchase_bill where bill_id="+purchaseBillId);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



	public boolean deletePurchaseBillDetails(int purchaseBillId) {
		// TODO Auto-generated method stub
		try {
			stmt.executeUpdate("delete from purchase_bill_details where bill_id="+purchaseBillId);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}



	public boolean deletePurchasePaymentDetails(int purchaseBillId) {
		// TODO Auto-generated method stub
		try {
			stmt.executeUpdate("delete from purchase_bill_payment where bill_id="+purchaseBillId);
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
