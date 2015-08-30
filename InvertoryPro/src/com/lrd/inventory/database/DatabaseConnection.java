package com.lrd.inventory.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

	static Connection connection = null;

	public DatabaseConnection() {

	}

	public Connection getConnection() {
		if (connection == null) {
			try {

				Properties db_properties = new Properties();
				InputStream inputStream = DatabaseConnection.class
						.getClassLoader().getResourceAsStream(
								"DB_Variables.properties");
				db_properties.load(inputStream);
				String driver = db_properties.getProperty("driver");

				String url = db_properties.getProperty("url1")
						+ db_properties.getProperty("server") + ":"
						+ db_properties.getProperty("port") + "/"
						+ db_properties.getProperty("database_name")
						+ db_properties.getProperty("url2");

				String user = db_properties.getProperty("user");
				String password = db_properties.getProperty("password");
				Class.forName(driver);
				//System.out.println(url);
				connection = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} // ////end of else

		return connection;
	}

}
