package com.company;
import java.text.ParseException;
import java.util.Scanner;

public class GuestBoundary {
	
	public static void enterGuest() throws ParseException {
		
	    System.out.println("Choose to: \n 1 Add guest \n 2 Update guest \n 3 Search Guest "
	    		+ "\n 4 Remove guest \n 5 Exit");
	    Scanner sc = new Scanner(System.in);
	
	        int decision = Integer.parseInt(sc.nextLine());
	         switch (decision){
	             case 1:
	            	 GuestManager.CreateGuest();
	                 break;
	
	             case 2:
	                 GuestManager.UpdateGuest();
	                 break;
	
	             case 3:
	            	 GuestManager.SearchGuest();
	            	 break;
	
	             case 4:
	            	 GuestManager.RemoveGuest();
	            	 break;
	             case 5:
	            	 break;
	            default:
	            	System.out.println("Enter a valid number");
	         }
         }
}

