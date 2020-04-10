package com.company;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;


public class GuestManager {
	
	public static LinkedHashMap<Integer, Guest> NoOfGuest = new LinkedHashMap<Integer, Guest>();
	public static ArrayList<Guest> guestDetails = new ArrayList<Guest>();
	
	static int key=1;
	
	// Create Guest method
	
	public static Guest CreateGuest() {
	
		String name = null;
		String creditCardNum = null;
		String address = null;
		String country = null;
		String gender = null;
		String nationality = null;
		String phoneNumber = null;
		String drivingLicense = null;
		String passportNumber = null;
		String expiryDate = null;
		Guest g = new Guest(name,address,country, gender,nationality,
				phoneNumber,drivingLicense,passportNumber);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter guest name:");
		name = sc.nextLine();
		g.setName(name);
		//guestDetails.add(name);
		
		System.out.println("Enter guest Id: \n 1 Passport Number \n 2 Driving License");
		int decision = Integer.parseInt(sc.nextLine());
		if(decision<=2&&decision>0) {
			switch(decision) {
			case 1:
				System.out.println("Enter guest passport number:");
				passportNumber = sc.nextLine();
				g.setpassportNumber(passportNumber);
				//guestDetails.add(passportNumber);
				break;
			case 2:
				System.out.println("Enter guest driving license:");
				drivingLicense = sc.nextLine();
				g.setdrivingLicense(drivingLicense);
				//guestDetails.add(drivingLicense);
				break;
			default:
				System.out.println("Please enter a valid number.");
		}	
		}
		
		System.out.println("Enter guest phone number:");
		phoneNumber = sc.nextLine();
		g.setphoneNumber(phoneNumber);
		//guestDetails.add(phoneNumber);
		
		System.out.println("Enter guest gender:");
		gender = sc.nextLine();
		g.setGender(gender);
		//guestDetails.add(gender);
		
		System.out.println("Enter guest nationality:");
		nationality = sc.nextLine();
		g.setNationality(nationality);
		//guestDetails.add(nationality);
		
		System.out.println("Enter guest country:");
		country = sc.nextLine();
		g.setCountry(country);
		//guestDetails.add(country);
		
		System.out.println("Enter guest address:");
		address = sc.nextLine();
		g.setAddress(address);
		//guestDetails.add(address);
		

		guestDetails.add(g);
		//NoOfGuest.put(key, guestDetails);
		key++;

		return g;
		

	}
	
	// Update Guest method
	
//	public static void UpdateGuest() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter which guest details you wish to update: \n 1 Name"
//				+ "\n 2 Passport number \n 3 Driving license \n 4 Phone number"
//				+ "\n 5 Gender \n 6 Nationality \n 7 Country \n 8 Address"
//				+ "\n 9 Credit card number \n 10 Credit card expiry date \n Enter 0 to exit");
//
//		ListIterator<String> iterator = guestDetails.listIterator();
//		int decision = Integer.parseInt(sc.nextLine());
//		while(decision!=11&&decision>0&&decision<11) {
//			switch(decision) {
//			case 0:
//				break;
//
//			case 1:
//				System.out.println("Enter new guest name:");
//				String name = sc.nextLine();
//
//				String oldName = iterator.getName();
//				System.out.println("Old guest name:" + oldName);
//
//				while (iterator.hasNext()) {
//				      String next = iterator.next();
//				      if (next.equals(oldName)) {
//				          iterator.set(name);
//				      }
//				 }
//				System.out.println("New guest name:" +name);
//				break;
//
//			case 2:
//				System.out.println("Enter new guest passport number:");
//				String passportNumber = sc.nextLine();
//
//				String OldPassportNumber = ((Guest) guestDetails).getName();
//				System.out.println("Old guest passport number:" + OldPassportNumber);
//
//				while (iterator.hasNext()) {
//				      String next = iterator.next();
//				      if (next.equals(OldPassportNumber)) {
//				          iterator.set(passportNumber);
//				      }
//				 }
//				System.out.println("New guest passport number:" +passportNumber);
//				break;
//
//			case 3:
//				System.out.println("Enter new guest driving license:");
//				String drivingLicense = sc.nextLine();
//
//				String OlddrivingLicense = ((Guest) guestDetails).getName();
//				System.out.println("Old guest driving license:" + OlddrivingLicense);
//
//				while (iterator.hasNext()) {
//				      String next = iterator.next();
//				      if (next.equals(OlddrivingLicense)) {
//				          iterator.set(drivingLicense);
//				      }
//				 }
//				System.out.println("New guest driving license:" +drivingLicense);
//				break;
//
//			case 4:
//				System.out.println("Enter new guest phone number:");
//				String phoneNumber = sc.nextLine();
//
//				String OldPhoneNumber = ((Guest) guestDetails).getName();
//				System.out.println("Old guest phone number:" + OldPhoneNumber);
//
//				while (iterator.hasNext()) {
//				      String next = iterator.next();
//				      if (next.equals(OldPhoneNumber)) {
//				          iterator.set(phoneNumber);
//				      }
//				 }
//				System.out.println("New guest phone number:" + phoneNumber);
//				break;
//
//			case 5:
//				System.out.println("Enter new guest gender:");
//				String gender = sc.nextLine();
//
//				String OldGender = ((Guest) guestDetails).getName();
//				System.out.println("Old guest gender:" + OldGender);
//
//				while (iterator.hasNext()) {
//				      String next = iterator.next();
//				      if (next.equals(OldGender)) {
//				          iterator.set(gender);
//				      }
//				 }
//				System.out.println("New guest gender:" +gender);
//				break;
//
//			case 6:
//				System.out.println("Enter new guest nationality:");
//				String nationality = sc.nextLine();
//
//				String OldNationality = ((Guest) guestDetails).getName();
//				System.out.println("Old guest nationality:" + OldNationality);
//
//				while (iterator.hasNext()) {
//				      String next = iterator.next();
//				      if (next.equals(OldNationality)) {
//				          iterator.set(nationality);
//				      }
//				 }
//				System.out.println("New guest nationality:" +nationality);
//				break;
//
//			case 7:
//				System.out.println("Enter new guest country:");
//				String country = sc.nextLine();
//
//				String OldCountry = ((Guest) guestDetails).getName();
//				System.out.println("Old guest country:" + OldCountry);
//
//				while (iterator.hasNext()) {
//				      String next = iterator.next();
//				      if (next.equals(OldCountry)) {
//				          iterator.set(country);
//				      }
//				 }
//				System.out.println("New guest country:" +country);
//				break;
//
//			case 8:
//				System.out.println("Enter new guest address:");
//				String address = sc.nextLine();
//
//				String OldAddress = ((Guest) guestDetails).getName();
//				System.out.println("Old guest address:" + OldAddress);
//
//				while (iterator.hasNext()) {
//				      String next = iterator.next();
//				      if (next.equals(OldAddress)) {
//				          iterator.set(address);
//				      }
//				 }
//				System.out.println("New guest address:" +address);
//				break;
//
//			case 9:
//				System.out.println("Enter new guest creditCardNum:");
//				String creditCardNum = sc.nextLine();
//
//				String OldCreditCardNum = ((Guest) guestDetails).getName();
//				System.out.println("Old guest credit card number:" + OldCreditCardNum);
//
//				while (iterator.hasNext()) {
//				      String next = iterator.next();
//				      if (next.equals(OldCreditCardNum)) {
//				          iterator.set(creditCardNum);
//				      }
//				 }
//				System.out.println("New guest credit card number:" +creditCardNum);
//				break;
//
//			case 10:
//				System.out.println("Enter new guest expiryDate:");
//				String expiryDate = sc.nextLine();
//
//				String OldExpiryDate = ((Guest) guestDetails).getName();
//				System.out.println("Old guest credit card expiry date:" + OldExpiryDate);
//
//				while (iterator.hasNext()) {
//				      String next = iterator.next();
//				      if (next.equals(OldExpiryDate)) {
//				          iterator.set(expiryDate);
//				      }
//				 }
//				System.out.println("New guest credit card expiry date:" +expiryDate);
//				break;
//
//			default:
//				System.out.println("Please enter a valid number.");
//
//			decision = sc.nextInt();
//		}
//		}
//		sc.close();
//	}
//
//	// Search Guest method
//
//	public static void SearchGuest() {
//		System.out.println("To search guest details please enter guest's passport number:");
//		Scanner sc = new Scanner(System.in);
//		String passportNumber = sc.nextLine();
//
//
//		Set<Integer> searchGuestDetails = NoOfGuest.keySet();
//
////		for (List<Integer> value : a.values()) {
////		    if (value.contains(1)) { // change the 1 to whatever value you're searching
////		        System.out.println("Found!");
////		    }
////		}
//
//		for(Integer key : searchGuestDetails) {
//
//            for(String gDetails : NoOfGuest.get(key)) {
//                if(gDetails.contains(passportNumber)) {
//                	System.out.println("The guest details of"+passportNumber+ "are as follows:");
//                	System.out.println("\\t\\t\\t\\t\\t\\t\\t\\t\\t"+gDetails);
//                }
//            }
//		}
//		sc.close();
//	}
//
//	// Remove Guest method
//
//	public static void RemoveGuest() {
//
//		System.out.println("To remove guest please enter guest's passport number:");
//		Scanner sc = new Scanner(System.in);
//		String passportNumber = sc.nextLine();
//
//
//		Set<Integer> removeguest = NoOfGuest.keySet();
//
//		for(Integer key : removeguest) {
//            for(String gDetails : NoOfGuest.get(key)) {
//                if(gDetails.contains(passportNumber)) {
//                	NoOfGuest.remove(key);
//                }
//            }
//		}
//		sc.close();
//	}
//
//	public static ArrayList<Guest> getGuestDetails() {
//		return guestDetails;
//	}
//
//	public static void setGuestDetails(ArrayList<Guest> guestDetails) {
//		GuestManager.guestDetails = guestDetails;
//	}
}
