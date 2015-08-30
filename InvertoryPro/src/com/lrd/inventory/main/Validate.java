package com.lrd.inventory.main;

public class Validate {

	public Validate() {
		
	}

	/**
	 * @param str
	 * @return true if str is empty or null
	 */
	public boolean isEmpty(String str){
		if(str==null || str.equals("") || str.equals(" "))
			return true;
		else
			return false;
	}
	
	
	
	public double setRound(double value){
		return (Math.round(value*100))/100;
	}
	
	
	public double setRound(String value){
		return (Math.round(Double.parseDouble(value)*100))/100;
	}
	
}
