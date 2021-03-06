package com.company;

import java.text.ParseException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        int choice=-1;



        while(choice!=100){
            System.out.println("1. Enter a new guest's details: ");
            System.out.println("2. Update a guest's details: ");
            System.out.println("3. Create/Update rooms details (include setting status like ‘Under Maintenance");
            System.out.println("4. Create an order for a room service");
            System.out.println("5. Create/Update/Remove room service menu items. ");
            System.out.println("7. For Reservations");
            System.out.println("8. Check out");
            System.out.println("9. Room Status report");
            System.out.println("10. Checking in");
            System.out.println("11. For updating reservation");
            System.out.println("12. Reservation Removal");
            System.out.println("13. Reservation Printing");


            System.out.print("Please enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());


            if(choice==100) {
                break;
            }
            switch(choice) {
                case 1:
                    System.out.println("Create/Update/Search guests detail (Search by name using keyword/s) ");
                    GuestBoundary.enterGuest();
                    break;
                case 2:
                    System.out.println("Create/Update/Remove/Print Reservation");
                    break;
                case 3:
                    System.out.println("Create/Update rooms details (include setting status like ‘Under Maintenance");
                    HotelBoundary.enterHotel();
                    break;
                case 4:
                    System.out.println("Entering room service orders - list menu items for selection \n");
                    RoomServiceBoundary.initiateRoomService();
                    break;
                case 5:
                    System.out.println("Create/Update/Remove room service menu items.");
                    MenuBoundary.enterMenu();
                    break;
                case 6:
                    System.out.println("Room availability");
                    break;
                case 7:
                    System.out.println("Room reserving (for walk-in or reservation)");
                    ReservationBoundary.reserving();
                    break;
                case 8:
                    System.out.println("Room Check-out and print bill invoice (with breakdowns on days of stay, " +
                            "room service order items\n" +
                            "and its total, tax and total amount) ");
                    ReservationBoundary.checkout();
                    break;
                case 9:
                    System.out.println("Print Room Status statistic report by ");
                    HotelBoundary.roomStats();
                    break;
                case 10:
                    System.out.println("for check in");
                    ReservationBoundary.checkIn();
                    break;
                case 11:
                    System.out.println("For updating the reservation");
                    ReservationBoundary.updatingReservation();
                    break;
                case 12:
                    System.out.println("Reservation removal");
                    ReservationBoundary.reservationRemoval();
                    break;
                case 13:
                    System.out.println("Print Reservation");
                    ReservationBoundary.printReservation();
                    break;

                default:
                    System.out.println("only choose between ");

            }
        }


        sc.close();
    }
}
