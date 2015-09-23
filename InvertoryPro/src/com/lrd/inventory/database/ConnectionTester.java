package com.lrd.inventory.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTester {

	public ConnectionTester() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean testConnection(Properties properties) {
		try {
			String url = properties.getProperty("url1") + properties.getProperty("server") + ":" + properties.getProperty("port") + "/" + properties.getProperty("database_name");
			Class.forName(properties.getProperty("driver"));
			DriverManager.getConnection(url, properties.getProperty("user"), properties.getProperty("password"));
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			//e.printStackTrace();
		}
		return false;
	}

}
