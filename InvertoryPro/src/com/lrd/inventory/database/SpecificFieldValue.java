package com.lrd.inventory.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SpecificFieldValue {

	Connection connection = null;
	Statement stmt=null;
	ResultSet result = null;

	public SpecificFieldValue(Connection connection) {
		this.connection=connection;
		try {	this.stmt=connection.createStatement();	} catch (SQLException e) {	e.printStackTrace();	}
	}



	/**
	 * 
	 * @return List of all store name
	 */
	public List<String> getAllStoreName(){
		List<String> list = new ArrayList<String>();
		try{
			result=stmt.executeQuery("select store_name from store_details");
			while(result.next()){
				list.add(result.getString("store_name"));
			}
		}catch(SQLException e){ e.printStackTrace(); }
		return list;
	}
	
	
	
	public String getStoreName(int id){
		String str="";
		try{
			result=stmt.executeQuery("select store_name from store_details where store_id="+id);
			result.first();
				str=result.getString("store_name");
			
		}catch(SQLException e){ e.printStackTrace(); }
		return str;
	}


	/**
	 * 
	 * @param storeId
	 * @return
	 */
	public List<String> getAllRackName(int storeId){
		List<String> list = new ArrayList<String>();
		try{
			result=stmt.executeQuery("select RACK_NAME from rack where STORE_ID ="+storeId);
			while(result.next()){
				list.add(result.getString("RACK_NAME"));
			}
		}catch(SQLException e){ /*e.printStackTrace();*/ }
		return list;
	}



	/**
	 * 
	 * @param storeId
	 * @return
	 */
	public List<String> getCategoryName(int rackId){
		List<String> list = new ArrayList<String>();
		try{
			result=stmt.executeQuery("select CATEGORY_NAME from categories where rack_id="+rackId);
			while(result.next()){
				list.add(result.getString("CATEGORY_NAME"));
			}
		}catch(SQLException e){ /*e.printStackTrace();*/ }
		return list;
	}


	/**
	 * 
	 * @param  category id
	 * @return all category within given rack id
	 */
	public String getCategoryNameByID(int id){
		try{
			result=stmt.executeQuery("select CATEGORY_NAME from categories where CATEGORY_ID ="+id);
			result.first();
			return result.getString("CATEGORY_NAME");

		}catch(SQLException e){ /*e.printStackTrace();*/ }
		return null ;
	}
	
	
	/**
	 * 
	 * @param productName
	 * @return category name for given product name
	 */
	public String getCategoryName(String productName){
		try{
			result=stmt.executeQuery("select CATEGORY_NAME from categories where CATEGORY_ID =(select CATEGORY_ID from products where PRODUCT_NAME='"+productName+"');");
			result.first();
			return result.getString("CATEGORY_NAME");

		}catch(SQLException e){ /*e.printStackTrace();*/ }
		return null ;
	}



	/**
	 * @param Rack id
	 * @return return rack name for that id
	 */
	public String getRackName(int rackId){
		try{
			result=stmt.executeQuery("select RACK_NAME from rack where RACK_ID ="+rackId);
			result.first();
			return result.getString("RACK_NAME");

		}catch(SQLException e){ /*e.printStackTrace();*/ }
		return null ;
	}
	
	
	




	public List<String> getBrandName(int categoryId){
		List<String> list = new ArrayList<String>();
		try{
			result=stmt.executeQuery("select BRAND_NAME from brand where category_id="+categoryId);
			while(result.next()){
				list.add(result.getString("BRAND_NAME"));
			}
		}catch(SQLException e){ /*e.printStackTrace();*/ }
		return list;
	}




	public String getBrandNameById(int id){
		try{
			result=stmt.executeQuery("select BRAND_NAME from brand where BRAND_ID ="+id);
			result.first();
			return result.getString("BRAND_NAME");

		}catch(SQLException e){ /*e.printStackTrace();*/ }
		return null ;
	}



	public List<String> getBrandNameByCategoryId(int id){
		List<String> list = new ArrayList<String>();
		try{
			result=stmt.executeQuery("select BRAND_NAME from brand where CATEGORY_ID ="+id);
			result.first();
			list.add(result.getString("BRAND_NAME"));

		}catch(SQLException e){ /*e.printStackTrace();*/ }
		return list ;
	}


	public List<String> getUnitName(){
		List<String> list = new ArrayList<String>();
		try{
			result=stmt.executeQuery("select * from unit");
			while(result.next()){	
					list.add(result.getString("UNIT_NAME"));
			}
		}catch(SQLException e){ /*e.printStackTrace();*/ }
		return list;
	}


	public List<Float> getVatByStartYear(int startYear){

		TableId tableid=new TableId(connection);
		ArrayList<Integer> yearIds = tableid.getYearId(startYear);
		List<Float> list = new ArrayList<>();
		for(int yearId : yearIds){
			try{ 
				
				result=stmt.executeQuery("select VAT_PERCENT from vats where YEAR_ID ="+yearId);
				while(result.next()){
					if(!list.contains(result.getFloat("VAT_PERCENT"))){ 
							list.add(result.getFloat("VAT_PERCENT"));
					}
				}
			}catch(SQLException e){ /*e.printStackTrace();*/ }
		}
		return list ;
	}
	
	
	
	public List<String> getAllCreditorsName(){
		List<String> list = new ArrayList<String>();
		try{
			result=stmt.executeQuery("select customer_name from credit_customers");
			while(result.next()){
				list.add(result.getString("customer_name"));
			}
		}catch(SQLException e){ /*e.printStackTrace();*/ }
		return list;
	}
	
	
	
	public List<String> getAllSupplierName(){
		List<String> list = new ArrayList<String>();
		try{
			result=stmt.executeQuery("select agency_name from distributors");
			while(result.next()){
				list.add(result.getString("agency_name"));
			}
		}catch(SQLException e){ /*e.printStackTrace();*/ }
		return list;
	}
	
	
	
	public String getBillPrefix(int storeId){
		String query="select bill_prefix from bill_challan_prefix where STORE_ID="+storeId;
		try{
			result=stmt.executeQuery(query);
			result.first();
			return result.getString("bill_prefix");

		}catch(SQLException e){ e.printStackTrace(); }
		return null ;
	}
	
	
	
	public String getChallanPrefix(int storeId){
		String query="select challan_prefix from bill_challan_prefix where STORE_ID="+storeId;
		try{
			result=stmt.executeQuery(query);
			result.first();
			return result.getString("challan_prefix");

		}catch(SQLException e){ e.printStackTrace(); }
		return null ;
	}
	
	
	
	public String getNewBillNo(int storeId){
		String query="select max(BILL_ID) from bill;";
		String prefix;
		try{
			prefix = getBillPrefix(storeId);
			result=stmt.executeQuery(query);
			result.first();
			return prefix+"-"+(result.getInt(1)+1);

		}catch(SQLException e){ e.printStackTrace(); }
		return null ;
	}
	
	
	
	public String getNewChallanNo(int storeId){
		String query="select max(CHALLAN_ID) from challan;";
		String prefix;
		try{
			prefix = getBillPrefix(storeId);
			result=stmt.executeQuery(query);
			result.first();
			return prefix+"-"+(result.getInt(1)+1);

		}catch(SQLException e){ e.printStackTrace(); }
		return null ;
	}
	
	
	
	public String getNewSaleOrderNo(int storeId) {
		// TODO Auto-generated method stub
		String query="select max(order_ID) from sale_order;";
		try{
			result=stmt.executeQuery(query);
			result.first();
			return (result.getInt(1)+1)+"";

		}catch(SQLException e){ e.printStackTrace(); }
		
		return null;
	}



	public String getNewSaleQuotationNo(int storeId) {
		// TODO Auto-generated method stub
		String query="select max(quotation_ID) from sale_quotation;";
		try{
			result=stmt.executeQuery(query);
			result.first();
			return (result.getInt(1)+1)+"";

		}catch(SQLException e){ e.printStackTrace(); }
		
		return null;
	}
	
	
	public double getPaidAmount(int billId){
		String query="SELECT SUM(PAID_AMOUNT) from bill_payment_details where bill_id="+billId+" GROUP BY BILL_ID";
		try {
			ResultSet result = stmt.executeQuery(query);
			result.first();
			double paidAmount = result.getDouble(1);
			return paidAmount;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}



	

}
