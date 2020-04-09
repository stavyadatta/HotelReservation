package com.company;

import java.time.LocalDateTime;
import java.util.Scanner;

public class RoomServiceController {

    public static void roomServiceModifier(RoomService roomService, double price){
        Scanner sc = new Scanner(System.in);
        roomService.setCost(price);
        LocalDateTime now = LocalDateTime.now();
        roomService.setDate(now);

        System.out.println("Your Room number Please");
        System.out.print("Floor: ");
        int floor = Integer.parseInt(sc.nextLine());
        System.out.print("Room number: ");
        int room_num = Integer.parseInt(sc.nextLine());

        Hotel.getRoom(floor*Hotel.ROOMS_ON_EACH_FLOOR + room_num).addRoomService(roomService);
        System.out.printf("The room service has been ordered in the room %.2f ", Hotel.getRoom(floor*Hotel.ROOMS_ON_EACH_FLOOR + room_num));
    }
}
