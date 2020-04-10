package com.company;

import java.util.Scanner;

public class ReservationBoundary {

    public void checkIn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Names of the guest u wanna add \n-1 when all the guests have been added");
        int decision = 0;
        while(decision != -1){
            GuestManager.CreateGuest();
            System.out.print("More guest? press -1 for no and any other number for yes: ");
            decision = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Payment method 1 for card and 2 for cash: ");
        int method = Integer.parseInt(sc.nextLine());

        switch (method){
            case 1:
                System.out.println("Payment via card");

        }

    }



    public static void checkout(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Floor: ");
        int floor = Integer.parseInt(sc.nextLine());
        System.out.print("Room number: ");
        int room_num = Integer.parseInt(sc.nextLine());
        Room room = Hotel.getRooms().get(floor * Hotel.ROOMS_ON_EACH_FLOOR + room_num);
        System.out.println("Check out process \nYour total bill is: ");
    }
}
