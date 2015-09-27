package com.lrd.inventory.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.lrd.inventory.model.ProductModel;
import com.lrd.inventory.model.RackModel;

public class DatabaseReport {

	Connection connection = null;
	Statement stmt = null;

	public DatabaseReport(Connection connection) {
		this.connection = connection;
		try {
			this.stmt = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ProductModel> getPurchaseReport(String startDate,
			String endDate, int storeId) {
		try {
			ArrayList<ProductModel> productlist = new ArrayList<>();
			ResultSet result = stmt
					.executeQuery("SELECT product_code,product_name,unit,mrp,"
							+ "sum(`FREE`+`QUANTITY`) as total FROM "
							+ "(select purchase_bill_details.product_code, purchase_bill_details.product_name,"
							+ "  purchase_bill_details.unit, purchase_bill_details.mrp,"
							+ " purchase_bill_details.free,purchase_bill_details.quantity from purchase_bill,"
							+ " purchase_bill_details where purchase_bill.bill_id=purchase_bill_details.bill_id"
							+ " and purchase_date between '"+startDate+"'"
							+ " and '"+endDate+"'"
							+ " and store_id="+storeId+")as t group by (product_name)");

			while (result.next()) {
				ProductModel product = new ProductModel();
				
				product.setProductCode(result.getString("product_code"));
				product.setProductName(result.getString("product_name"));
				product.setUnit(result.getString("unit"));
				product.setMRP(result.getDouble("mrp"));
				product.setQuantity(result.getDouble("total"));
				
				productlist.add(product);

			}
			return productlist;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
