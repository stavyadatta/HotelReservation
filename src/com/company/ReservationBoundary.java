package com.company;

import java.util.Scanner;

public class ReservationBoundary {
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
