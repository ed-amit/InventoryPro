package com.lrd.inventory.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TableId {
	
	Connection connection = null;
	Statement stmt=null;
	ResultSet result = null;

	public TableId(Connection connection) {
		this.connection=connection;
		try {	this.stmt=connection.createStatement();	} catch (SQLException e) {	e.printStackTrace();	}
	}
	
	
	
	
	
	/**
	 * @param storeName
	 * @return store_id from store table
	 */
	public int getStoreId(String storeName){
		int storeId = 0;
		try{
			result=stmt.executeQuery("select store_id from store_details where store_name ='"+storeName+"';");
			result.first();
			storeId=result.getInt("store_id");
			
		}catch(SQLException e){ e.printStackTrace(); }
		return storeId;
	}
	
	
	
	/**
	 * @param rackName
	 * @return rack_id from rack table
	 */
	public int getRackId(String rackName){
		int rackId = 0;
		try{
			result=stmt.executeQuery("select RACK_ID from rack where RACK_NAME ='"+rackName+"';");
			result.first();
			rackId=result.getInt("RACK_ID");
			
		}catch(SQLException e){ e.printStackTrace(); }
		return rackId;
	}
	
	
	
	/**
	 * @param categoryName
	 * @return category_id from categories table
	 */
	public int getCategoryId(String categoryName){
		int categoryId = 0;
		try{
			result=stmt.executeQuery("select CATEGORY_ID from categories where CATEGORY_NAME ='"+categoryName+"';");
			result.first();
			categoryId=result.getInt("CATEGORY_ID");
			
		}catch(SQLException e){ e.printStackTrace(); }
		return categoryId;
	}
	
	
	
	public int getBrandId(String brandName){
		int brandId = 0;
		try{
			result=stmt.executeQuery("select BRAND_ID from brand where BRAND_NAME ='"+brandName+"';");
			result.first();
			brandId=result.getInt("BRAND_ID");
			
		}catch(SQLException e){ e.printStackTrace(); }
		return brandId;
	}
	
	// need to be change later
	public int getUnitId(String unitName){
		int unitId = 0;
		try{
			result=stmt.executeQuery("select UNIT_ID from unit where UNIT_NAME ='"+unitName+"';");
			result.first();
			unitId=result.getInt("UNIT_ID");
			
		}catch(SQLException e){ e.printStackTrace(); }
		return unitId;
	}
	
	
	public int getYearId(int startYear , int endYear){
		int yearId = 0;
		try{
			result=stmt.executeQuery("select YEAR_ID from financial_year where YEAR_FROM ="+startYear+" AND YEAR_TO = "+endYear+";");
			result.first();
			yearId=result.getInt("YEAR_ID");
			
		}catch(SQLException e){ 
			
			try {
				yearId=stmt.executeUpdate("insert into financial_year values (null,"+startYear+", 0 ,"+endYear+");",Statement.RETURN_GENERATED_KEYS);
			} catch (SQLException e1){ e1.printStackTrace(); }
			
		}
		return yearId;
	}
	
	
	
	public ArrayList<Integer> getYearId(int startYear ){
		ArrayList<Integer> yearIds = new ArrayList<>();
		try{
			result=stmt.executeQuery("select YEAR_ID from financial_year where YEAR_FROM ="+startYear+";");
			result.first();
			yearIds.add(result.getInt("YEAR_ID"));
			
			
		}catch(SQLException e){ 
			
		}
		return yearIds;
	}
	
	
	public int getNewPurchaseOrderId(){
		int orderId = 0;
		try{
			result=stmt.executeQuery("select max(order_id) from purchase_order ;");
			result.first();
			orderId=result.getInt(1);
			
		}catch(SQLException e){ e.printStackTrace(); }
		return orderId+1;
	}
	
	
	
	public int getNewPurchaseBillId(){
		int billId = 0;
		try{
			result=stmt.executeQuery("select max(bill_id) from purchase_bill ;");
			result.first();
			billId=result.getInt(1);
			
		}catch(SQLException e){ e.printStackTrace(); }
		return billId+1;
	}
	
	
	

}
