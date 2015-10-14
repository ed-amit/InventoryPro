package com.lrd.inventory.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;

import com.lrd.inventory.database.ConnectionTester;
import com.lrd.inventory.ui.MasterHome;
import com.lrd.inventory.ui.SettingSingleUser;

public class Home extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Home() {
		if (checkUserRegistration()) {
			
			setDatabase();
		}
		
		

	}

	public static void main(String[] args) {
		new Home();

	}

	private boolean checkUserRegistration() {
		InputStream inputStream;
		Properties regProperties = new Properties();
		File file = null;
		try {

			file = new File(System.getProperty("user.home")
					+ "/owner.properties");
			if (file.exists()) {
				inputStream = new FileInputStream(
						System.getProperty("user.home")
								+ "/owner.properties");
				regProperties.load(inputStream);
				inputStream.close();
			} else {
				file.createNewFile();
				inputStream = Home.class.getClassLoader().getResourceAsStream(
						"owner.properties");
				regProperties.load(inputStream);
				inputStream.close();

				FileOutputStream out = new FileOutputStream(
						System.getProperty("user.home")
								+ "/owner.properties");

				regProperties.store(out, null);
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		Date currentDate,expDate;
		currentDate = new Date();
		expDate = new Date();
		String tempstr = regProperties.getProperty("date_code2");
		int day = Integer.parseInt(tempstr.substring(6));
		int month = Integer.parseInt(tempstr.substring(4,6));
		int year = Integer.parseInt(tempstr.substring(0,4));
		try {
			currentDate = sdf.parse(new DatePicker().getCurrentDate());
			java.util.Calendar cal = java.util.Calendar.getInstance();
	        cal.set(year, month-1, day);
	        expDate = cal.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(!regProperties.getProperty("status").equals("1111") || currentDate.after(expDate)){
			
			return new LicenseKeyRegistration(this).getStatus();
		}
		return true;
	}

	private void setDatabase() {
		InputStream inputStream;
		Properties db_properties = new Properties();
		File file = null;
		try {

			file = new File(System.getProperty("user.home")
					+ "/DB_Variables.properties");
			if (file.exists()) {
				inputStream = new FileInputStream(
						System.getProperty("user.home")
								+ "/DB_Variables.properties");
				db_properties.load(inputStream);
				inputStream.close();
			} else {
				file.createNewFile();
				inputStream = Home.class.getClassLoader().getResourceAsStream(
						"DB_Variables.properties");
				db_properties.load(inputStream);
				inputStream.close();

				FileOutputStream out = new FileOutputStream(
						System.getProperty("user.home")
								+ "/DB_Variables.properties");

				db_properties.store(out, null);
				out.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		if (new ConnectionTester().testConnection(db_properties)) {
			// new DatePicker(new JFrame()).setPickedDate();
			new MasterHome("Dharm");
		} else {
			if (new SettingSingleUser().getdbstatus())
				new MasterHome("Dharm");
		}
	}

}
