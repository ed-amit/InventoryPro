package com.lrd.inventory.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.lrd.inventory.database.ConnectionTester;
import com.lrd.inventory.ui.MasterHome;
import com.lrd.inventory.ui.SettingSingleUser;

public class Home {

	public Home() {
		InputStream inputStream;
		Properties db_properties = new Properties();
		File file = null;
		try {
			

			

			file = new File(System.getProperty("user.home")+"/DB_Variables.properties");
			if (file.exists()) {
				inputStream = new FileInputStream(System.getProperty("user.home")+"/DB_Variables.properties");
				db_properties.load(inputStream);
				inputStream.close();
			}else{
				file.createNewFile();
				inputStream = Home.class.getClassLoader().getResourceAsStream(
						"DB_Variables.properties");
				db_properties.load(inputStream);
				inputStream.close();
				
				FileOutputStream out = new FileOutputStream(
						System.getProperty("user.home")+"/DB_Variables.properties");

				db_properties.store(out, null);
				out.close();
			}

			
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (new ConnectionTester().testConnection(db_properties)) {
			new MasterHome("Dharm");
		} else {
			new SettingSingleUser();
		}

	}

	

	public static void main(String[] args) {
		new Home();

	}

}
