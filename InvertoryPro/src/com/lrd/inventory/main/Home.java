package com.lrd.inventory.main;



import java.sql.Connection;

import com.lrd.inventory.database.DatabaseConnection;
import com.lrd.inventory.ui.MasterHome;
import com.lrd.inventory.values.Owner;
import com.lrd.inventory.values.ScreenElementDimention;

public class Home {
	
	ScreenElementDimention screen;
	Owner owner;
	DatabaseConnection db_connect;
	Connection connection=null;

	public Home() {
		screen=new ScreenElementDimention();
		owner=new Owner();
		db_connect=new DatabaseConnection();
		connection=db_connect.getConnection();
		new MasterHome(owner,connection);
	}

	public static void main(String[] args) {
		
		new Home();
	}

}
