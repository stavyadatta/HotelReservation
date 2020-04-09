package com.company;

import java.util.Scanner;

public class HotelController {

    public static void changeStatus(int roomNumber){
        Scanner sc = new Scanner(System.in);
        System.out.println("Change the status to: \n");
        for(int i = 0; i< Room.RoomStatus.values().length; i++){
            System.out.println(i + " for " + Room.RoomStatus.values()[i] + "\n");
        }
        int decision = Integer.parseInt(sc.nextLine());
        Hotel.getRoom(roomNumber).setStatus(Room.RoomStatus.values()[decision]);


    }

    public static void printRooms(){
        Hotel.hotelRooms();
    }

    public static void changing_room_cost(double cost, int room_num){
        Hotel.change_room_price(cost, room_num);

    }
    public static void printRoomServiceOrders(int floor, int room_num){
        Room room = Hotel.getRooms().get(floor * Hotel.ROOMS_ON_EACH_FLOOR + room_num);

    }
}
