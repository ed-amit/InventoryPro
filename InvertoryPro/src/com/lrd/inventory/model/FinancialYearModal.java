package com.lrd.inventory.model;

public class FinancialYearModal {
	
	int year_id;
	int start_year;
	int end_year;
	int year_selected;

	public FinancialYearModal() {
		setDefault();
	}
	
	public void setDefault(){
		year_id=start_year=end_year=year_selected=0;
	}
	
	public void setYearId(int id){
		this.year_id=id;
	}
	
	public void setStartYear(int startYear){
		this.start_year = startYear;
	}
	
	public void setEndYear(int endYear){
		this.end_year = endYear;
	}
	
	public void setSelectedYear(int value){
		this.year_selected = value ;
	}
	
	
	
	
	public int getYearId(){
		return this.year_id;
	}
	
	public int getStartYear(){
		return this.start_year;
	}
	
	public int getEndYear(){
		return this.end_year;
	}
	
	public int getSelectedYear(){
		return this.year_selected;
	}
}
