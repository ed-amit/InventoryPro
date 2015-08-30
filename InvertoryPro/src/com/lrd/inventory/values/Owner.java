package com.lrd.inventory.values;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Owner {
	
	private String name;
	private String address;
	private String district;
	private String state;
	private String pin;
	private String contact;
	
	
	
	public Owner() {
		Properties ownerprop = new Properties();
		InputStream inputStream = Owner.class.getClassLoader().getResourceAsStream("owner.properties");
		try { ownerprop.load(inputStream); } catch (IOException e) { e.printStackTrace(); }
		this.name=ownerprop.getProperty("owner_name");
		this.address=ownerprop.getProperty("address");
		this.district=ownerprop.getProperty("district");
		this.state=ownerprop.getProperty("state");
		this.pin=ownerprop.getProperty("pin");
		this.contact=ownerprop.getProperty("contact");
	}
	
	public String getOwnerName(){
		return this.name;
	}
	
	public String getOwnerAddress(){
		return this.address;
	}

	public String getOwnerDistrict(){
		return this.district;
	}
	
	public String getOwnerState(){
		return this.state;
	}
	
	public String getOwnerPin(){
		return this.pin;
	}
	
	public String getOwnerContact(){
		return this.contact;
	}
	
	public static void main (String[] args){
		Owner ow=new Owner();
		System.out.println(ow.getOwnerName()+" "+ow.getOwnerAddress());
	}
}
