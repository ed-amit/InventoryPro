package com.lrd.inventory.model;

public class DistributorModel {

	int distributor_id;
	int store_id;
	String status;
	String name;
	String agency_name;
	String pan_no;
	String tin_no;
	String address;
	String city;
	String pincode;
	String office_no;
	String fax_no;
	String mobile_no;
	String buying_type;
	String location_type;
	String purchase_type;
	String drug_licence_no;
	String terms;
	String remark;

	public DistributorModel() {
		setDefault();
	}

	public void setDefault(){
		distributor_id=store_id=0;
		status=name=agency_name=pan_no=tin_no=address=city=pincode=office_no="";
		fax_no=mobile_no=buying_type=location_type=purchase_type="";
		drug_licence_no=terms=remark="";
	}


	public void setDistributorId(int id){
		this.distributor_id=id;
	}

	public void setStoreId(int id){
		this.store_id = id;
	}
	public void setStatus(String status){
		this.status = status;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setAgencyName(String agencyName){
		this.agency_name = agencyName;
	}
	public void setPanNo(String panNo){
		this.pan_no = panNo;
	}
	public void setTinNo(String tinNo){
		this.tin_no = tinNo;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public void setCity(String city){
		this.city = city;
	}
	public void setPinCode(String pinCode){
		this.pincode = pinCode;
	}
	public void setOfficeNo(String officeNo){
		this.office_no = officeNo;
	}
	public void setFaxNo(String faxNo){
		this.fax_no=faxNo;
	}
	public void setMobileNo(String mobileNo){
		this.mobile_no=mobileNo;
	}
	public void setBuyingType(String buyingType){
		this.buying_type=buyingType;
	}
	public void setLocationType(String locationType){
		this.location_type=locationType;
	}
	public void setPurchaseType(String purchaseType){
		this.purchase_type=purchaseType;
	}
	public void setDrugLicenceNo(String licenceNo){
		this.drug_licence_no=licenceNo;
	}
	public void setTerms(String terms){
		this.terms=terms;
	}
	public void setRemark(String remark){
		this.remark=remark;
	}
	
	
	
	
	public int getDistributorId (){
		return this.distributor_id ;
	}
	
	public int getStoreId (){
		return this.store_id ;
	}
	
	public String getStatus (){
		return this.status ;
	}
	
	public String getName (){
		return this.name ;
	}
	
	public String getAgencyName (){
		return this.agency_name ;
	}
	
	public String getPanNo (){
		return this.pan_no ;
	}
	
	public String getTinNo (){
		return this.tin_no ;
	}
	
	public String getAddress (){
		return this.address ;
	}
	
	public String getCity (){
		return this.city ;
	}
	
	public String getPincode (){
		return this.pincode ;
	}
	
	public String getOfficeNo (){
		return this.office_no ;
	}
	
	public String getFaxNo (){
		return this.fax_no ;
	}
	
	public String getMobileNo (){
		return this.mobile_no ;
	}
	
	public String getBuyingType (){
		return this.buying_type ;
	}
	
	public String getLocationType (){
		return this.location_type ;
	}
	
	public String getPurchaseType (){
		return this.purchase_type ;
	}
	
	public String getDrugLicenceNo (){
		return this.drug_licence_no ;
	}
	
	public String getTerms (){
		return this.terms ;
	}
	
	public String getRemark (){
		return this.remark ;
	}
	
	

}
