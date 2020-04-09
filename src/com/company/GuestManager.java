package com.company;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;


public class GuestManager {
	
	static LinkedHashMap<Integer, List<String>> NoOfGuest = new LinkedHashMap<Integer, List<String>>();
	static List<String> guestDetails = new ArrayList<String>();
	
	static int key=1;
	
	// Create Guest method
	
	public static void CreateGuest() {
	
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
		Guest g = new Guest(name,creditCardNum,address,country, gender,nationality,
				phoneNumber,drivingLicense,passportNumber,expiryDate);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter guest name:");
		name = sc.nextLine();
		g.setName(name);
		guestDetails.add(name);
		
		System.out.println("Enter guest Id: \n 1 Passport Number \n 2 Driving License");
		int decision = sc.nextInt();
		if(decision<=2&&decision>0) {
			switch(decision) {
			case 1:
				System.out.println("Enter guest passport number:");
				passportNumber = sc.nextLine();
				g.setpassportNumber(passportNumber);
				guestDetails.add(passportNumber);
				break;
			case 2:
				System.out.println("Enter guest driving license:");
				drivingLicense = sc.nextLine();
				g.setdrivingLicense(drivingLicense);
				guestDetails.add(drivingLicense);
				break;
			default:
				System.out.println("Please enter a valid number.");
		}	
		}
		
		System.out.println("Enter guest phone number:");
		phoneNumber = sc.nextLine();
		g.setphoneNumber(phoneNumber);
		guestDetails.add(phoneNumber);
		
		System.out.println("Enter guest gender:");
		gender = sc.nextLine();
		g.setGender(gender);
		guestDetails.add(gender);
		
		System.out.println("Enter guest nationality:");
		nationality = sc.nextLine();
		g.setNationality(nationality);
		guestDetails.add(nationality);
		
		System.out.println("Enter guest country:");
		country = sc.nextLine();
		g.setCountry(country);
		guestDetails.add(country);
		
		System.out.println("Enter guest address:");
		address = sc.nextLine();
		g.setAddress(address);
		guestDetails.add(address);
		
		System.out.println("Enter guest creditCardNum:");
		creditCardNum = sc.nextLine();
		g.setcreditCardNum(creditCardNum);
		guestDetails.add(creditCardNum);
		
		System.out.println("Enter guest expiryDate:");
		expiryDate = sc.nextLine();
		g.setExpiryDate(expiryDate);
		guestDetails.add(expiryDate);
		
		NoOfGuest.put(key, guestDetails);
		
		key++;	
	}
	
	// Update Guest method
	
	public static void UpdateGuest() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter which guest details you wish to update: \n 1 Name"
				+ "\n 2 Passport number \n 3 Driving license \n 4 Phone number"
				+ "\n 5 Gender \n 6 Nationality \n 7 Country \n 8 Address"
				+ "\n 9 Credit card number \n 10 Credit card expiry date \n Enter 0 to exit");
		int decision = sc.nextInt();
		while(decision!=11&&decision>0&&decision<11) {
			switch(decision) {
			case 0:
				break;
			case 1: 
				System.out.println("Enter guest name:");
				String name = sc.nextLine();
					 
				ListIterator<String> iterator = guestDetails.listIterator();
				while (iterator.hasNext()) {
				      String next = iterator.next();
				      if (next.equals(((Guest) guestDetails).getName())) {
				          iterator.set(name);
				      }
				 }
			case 2:
				System.out.println("Enter guest passport number:");
				String passportNumber = sc.nextLine();
					 
				iterator = guestDetails.listIterator();
				while (iterator.hasNext()) {
				      String next = iterator.next();
				      if (next.equals(((Guest) guestDetails).getpassportNumber())) {
				          iterator.set(passportNumber);
				      }
				 }
			case 3:
				System.out.println("Enter guest driving license:");
				String drivingLicense = sc.nextLine();
					 
				iterator = guestDetails.listIterator();
				while (iterator.hasNext()) {
				      String next = iterator.next();
				      if (next.equals(((Guest) guestDetails).getdrivingLicense())) {
				          iterator.set(drivingLicense);
				      }
				 }
			case 4: 
				System.out.println("Enter guest phone number:");
				String phoneNumber = sc.nextLine();
					 
				iterator = guestDetails.listIterator();
				while (iterator.hasNext()) {
				      String next = iterator.next();
				      if (next.equals(((Guest) guestDetails).getphoneNumber())) {
				          iterator.set(phoneNumber);
				      }
				 }
			case 5:
				System.out.println("Enter guest gender:");
				String gender = sc.nextLine();
					 
				iterator = guestDetails.listIterator();
				while (iterator.hasNext()) {
				      String next = iterator.next();
				      if (next.equals(((Guest) guestDetails).getGender())) {
				          iterator.set(gender);
				      }
				 }
			case 6:
				System.out.println("Enter guest nationality:");
				String nationality = sc.nextLine();
					 
				iterator = guestDetails.listIterator();
				while (iterator.hasNext()) {
				      String next = iterator.next();
				      if (next.equals(((Guest) guestDetails).getNationality())) {
				          iterator.set(nationality);
				      }
				 }
			case 7: 
				System.out.println("Enter guest country:");
				String country = sc.nextLine();
					 
				iterator = guestDetails.listIterator();
				while (iterator.hasNext()) {
				      String next = iterator.next();
				      if (next.equals(((Guest) guestDetails).getCountry())) {
				          iterator.set(country);
				      }
				 }
			case 8:
				System.out.println("Enter guest address:");
				String address = sc.nextLine();
					 
				iterator = guestDetails.listIterator();
				while (iterator.hasNext()) {
				      String next = iterator.next();
				      if (next.equals(((Guest) guestDetails).getAddress())) {
				          iterator.set(address);
				      }
				 }
			case 9:
				System.out.println("Enter guest creditCardNum:");
				String creditCardNum = sc.nextLine();
					 
				iterator = guestDetails.listIterator();
				while (iterator.hasNext()) {
				      String next = iterator.next();
				      if (next.equals(((Guest) guestDetails).getcreditCardNum())) {
				          iterator.set(creditCardNum);
				      }
				 }
			case 10: 
				System.out.println("Enter guest expiryDate:");
				String expiryDate = sc.nextLine();
					 
				iterator = guestDetails.listIterator();
				while (iterator.hasNext()) {
				      String next = iterator.next();
				      if (next.equals(((Guest) guestDetails).getExpiryDate())) {
				          iterator.set(expiryDate);
				      }
				 }
			default:
				System.out.println("Please enter a valid number.");
				
			decision = sc.nextInt();
		}
		}
		sc.close();
	}
	
	// Search Guest method
	
	public static void SearchGuest() {
		System.out.println("To search guest details please enter guest's passport number:");
		Scanner sc = new Scanner(System.in);
		String passportNumber = sc.nextLine();
		

		Set<Integer> searchGuestDetails = NoOfGuest.keySet();
		
//		for (List<Integer> value : a.values()) {
//		    if (value.contains(1)) { // change the 1 to whatever value you're searching
//		        System.out.println("Found!");
//		    }
//		}
		
		for(Integer key : searchGuestDetails) {
 
            for(String gDetails : NoOfGuest.get(key)) {
                if(gDetails.contains(passportNumber)) {
                	System.out.println("The guest details of"+passportNumber+ "are as follows:");
                	System.out.println("\\t\\t\\t\\t\\t\\t\\t\\t\\t"+gDetails);
                }
            }
		}
		sc.close();
	}
	
	// Remove Guest method
	
	public static void RemoveGuest() {
		
		System.out.println("To remove guest please enter guest's passport number:");
		Scanner sc = new Scanner(System.in);
		String passportNumber = sc.nextLine();
		

		Set<Integer> removeguest = NoOfGuest.keySet();
		
		for(Integer key : removeguest) {
            for(String gDetails : NoOfGuest.get(key)) {
                if(gDetails.contains(passportNumber)) {
                	NoOfGuest.remove(key);
                }
            }
		}
		sc.close();
	}

}
