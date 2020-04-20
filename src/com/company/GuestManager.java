package com.company;
import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;



public class GuestManager {
	
	public static ArrayList<Guest> guestDetails = new ArrayList<Guest>();
	
	// Create Guest method
	private static int guestIdNumber =1; 
	public static Guest CreateGuest() throws ParseException {
	
		String name = null;
		String address = null;
		String country = null;
		String gender = null;
		String nationality = null;
		long phoneNumber = 0;
		String drivingLicense = null;
		String passportNumber = null;
		int GuestIdNum=guestIdNumber;
		Guest g = new Guest(GuestIdNum,name,address,country, gender,nationality,
				phoneNumber,drivingLicense,passportNumber);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter guest name:");
		name = sc.nextLine();
		g.setName(name);
		
		System.out.println("Enter guest Id: \n 1 Passport Number \n 2 Driving License");
		int decision = Integer.parseInt(sc.nextLine());
		if(decision<=2&&decision>0) {
			switch(decision) {
			case 1:
				System.out.println("Enter guest passport number:");
				passportNumber = sc.nextLine();
				g.setpassportNumber(passportNumber);
		     	break;
			case 2:
				System.out.println("Enter guest driving license:");
				drivingLicense = sc.nextLine();
				g.setdrivingLicense(drivingLicense);
				break;
			default:
				System.out.println("Please enter a valid number.");
		}	
		}
		
		System.out.println("Enter guest phone number:");
		phoneNumber = Long.parseLong(sc.nextLine());
		g.setphoneNumber(phoneNumber);
		sc.nextLine();
		
		System.out.println("Enter guest gender:");
		gender = sc.nextLine();
		g.setGender(gender);
		
		System.out.println("Enter guest nationality:");
		nationality = sc.nextLine();
		g.setNationality(nationality);
		
		System.out.println("Enter guest country:");
		country = sc.nextLine();
		g.setCountry(country);
		
		System.out.println("Enter guest address:");
		address = sc.nextLine();
		g.setAddress(address);
		
		g.setGuestIdNum(GuestIdNum);
		int method = -1;
		do{
			System.out.print("Payment method 1 for card and 2 for cash: ");
			method = Integer.parseInt(sc.nextLine());
			switch (method){
				case 1:
					System.out.println("Payment via card");
					CreditCard creditCard = CreditCardBoundary.enterCreditCardDetails();
					g.setPaymentMethod(creditCard);
					break;
				case 2:
					System.out.println("Payment via cash");
					Cash cash = new Cash();
					g.setPaymentMethod(cash);
					break;
				default:
					System.out.println("Please select a number between 1 and 2");
			}
		}while(method < 1 || method > 2);
		
		guestDetails.add(g);
		
		System.out.println("GuestIdNumber "+GuestIdNum+ ": Name "+ g.getName()+ " details.");
		System.out.println("Passport Number: " + g.getpassportNumber()+ "\n Driving License: " +
		g.getdrivingLicense() + "\n Phone Number: " + g.getphoneNumber() + "\n Gender: " +g.getGender()
		+ "\n Nationality: "+g.getNationality()+ "\n Country: "+g.getCountry()+ "\n Address: "+
		g.getAddress());
		guestIdNumber++;
		return g;
	}
	
	// Update Guest method
	
	public static void UpdateGuest() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Guest Name");
		String guestName = sc.nextLine();
		System.out.println("Enter the Guest passport");
		String guestPassport = sc.nextLine();
		int GuestIdNumber = Integer.parseInt(sc.nextLine());
		sc.nextLine();
				 
		for(int i = 0; i < guestDetails.size(); i++){
		   	if(GuestIdNumber == guestDetails.get(i).getGuestIdNum()){
		   		System.out.println(" GuestIdNumber found! \n Enter which guest details you wish to update: \n 1 Name"
						+ "\n 2 Passport number \n 3 Driving license \n 4 Phone number"
						+ "\n 5 Gender \n 6 Nationality \n 7 Country \n 8 Address"
						+ "\n 0 Exit");
		   	int decision = Integer.parseInt(sc.nextLine());
			switch(decision) {
			case 0:
				break;
				
			case 1: 
				System.out.println("The old name was " + guestDetails.get(i).getName());
				System.out.print("\nNew name: ");
				String newName = sc.nextLine();
				guestDetails.get(i).setName(newName);
				break;
				
			case 2:
				System.out.println("The old passport number was:" + guestDetails.get(i).getpassportNumber());
				System.out.print("\nNew passport number: ");
				String passportNumber = sc.nextLine();
				guestDetails.get(i).setpassportNumber(passportNumber);
				break;
				
			case 3:
				System.out.println("The old driving license was: " + guestDetails.get(i).getdrivingLicense());
				System.out.print("\nNew driving license: ");
				String drivingLicense = sc.nextLine();
				guestDetails.get(i).setdrivingLicense(drivingLicense);
				break;
				
			case 4: 
				System.out.println("The old phone number was: " + guestDetails.get(i).getphoneNumber());
				System.out.print("\nNew phone number: ");
				int phoneNumber = sc.nextInt();
				guestDetails.get(i).setphoneNumber(phoneNumber);
				break;
				
			case 5:
				System.out.println("The old gender was: " + guestDetails.get(i).getGender());
				System.out.print("\nNew gender: ");
				String gender = sc.nextLine();
				guestDetails.get(i).setGender(gender);
				break;
				
			case 6:
				System.out.println("The old nationality was: " + guestDetails.get(i).getNationality());
				System.out.print("\nNew nationality: ");
				String nationality = sc.nextLine();
				guestDetails.get(i).setNationality(nationality);
				break;
				
			case 7: 
				System.out.println("The old country was: " + guestDetails.get(i).getCountry());
				System.out.print("\nNew country: ");
				String country = sc.nextLine();
				guestDetails.get(i).setCountry(country);
				break;
				
			case 8:
				System.out.println("The old address was: " + guestDetails.get(i).getAddress());
				System.out.print("\nNew address: ");
				String address = sc.nextLine();
				guestDetails.get(i).setAddress(address);
				break;	
			
			default:
				System.out.println("Please enter a valid number.");
				
		}
		}
	}
	}
	
	// Search Guest method
	
	public static void SearchGuest() {

		System.out.println("To search guest please enter GuestIdNumber:");
		Scanner sc = new Scanner(System.in);
		int guestId = sc.nextInt();
		
		for(int i = 0; i<guestDetails.size(); i++){
	   		if(guestId == guestDetails.get(i).getGuestIdNum()){
	   			System.out.println("The guest details of "+guestDetails.get(i).getName()+ " are as follows:");
            	System.out.println(" Name: "+ guestDetails.get(i).getName()+"\n Phone Number: "+ guestDetails.get(i).getphoneNumber()
            			+"\n Driving License: "+guestDetails.get(i).getdrivingLicense()+"\n Passport Number :"+
            			guestDetails.get(i).getpassportNumber()+"\n Gender: "+guestDetails.get(i).getGender()+"\n Nationality: "+guestDetails.get(i).getNationality()+
            			"\n Country: "+ guestDetails.get(i).getCountry()+"\n Address: "+guestDetails.get(i).getAddress());
			}
	}
	}
	
	// Remove Guest method
	
	public static void RemoveGuest() {
		
		System.out.println("To remove guest please enter GuestIdNumber:");
		Scanner sc = new Scanner(System.in);
		int guestId = sc.nextInt();
		
		for(int i = 0; i<guestDetails.size(); i++){
	   		if(guestId == guestDetails.get(i).getGuestIdNum()){
	   			guestDetails.remove(i);
			}
		}
		System.out.println("Guest "+guestId+ " removed.");
	}

	public static ArrayList<Guest> getGuestDetails() {
		return guestDetails;
	}

	public static void setGuestDetails(ArrayList<Guest> guestDetails) {
		GuestManager.guestDetails = guestDetails;
	}
}
