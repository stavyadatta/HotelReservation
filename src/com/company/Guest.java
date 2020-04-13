package com.company;

public class Guest {

	private String name;
	private String address;
	private String country;
	private String gender;
	private String nationality;
	private int phoneNumber;
	private String drivingLicense;
	private String passportNumber;
	private int GuestIdNum;

	public Guest(int GuestIdNum,String name, String address, String country, String gender, String nationality, int phoneNumber, String drivingLicense, String passportNumber) {
		this.name = name;
		this.address = address;
		this.country = country;
		this.gender = gender;
		this.nationality = nationality;
		this.phoneNumber = phoneNumber;
		this.drivingLicense = drivingLicense;
		this.passportNumber = passportNumber;
		this.setGuestIdNum(GuestIdNum);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
//	public String getcreditCardNum() {
//		return creditCardNum;
//	}
	
//	public void setcreditCardNum(String creditCardNum ) {
//		this.creditCardNum=creditCardNum;
//	}
//
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country=country;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality=nationality;
	}
	
	public int getphoneNumber() {
		return phoneNumber;
	}
	
	public void setphoneNumber(int phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	
	public String getdrivingLicense() {
		return drivingLicense;
	}
	
	public void setdrivingLicense(String drivingLicense) {
		this.drivingLicense=drivingLicense;
	}	
	
	public String getpassportNumber() {
		return passportNumber;
	}
	
	public void setpassportNumber(String passportNumber) {
		this.passportNumber=passportNumber;
	}

	public int getGuestIdNum() {
		return GuestIdNum;
	}

	public void setGuestIdNum(int guestIdNum) {
		GuestIdNum = guestIdNum;
	}
		
//	public void setExpiryDate(String expiryDate) {
//		this.expiryDate=expiryDate;
//	}
//
//	public String getExpiryDate() {
//		return expiryDate;
//	}


}
