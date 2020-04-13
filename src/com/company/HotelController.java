package com.company;

import com.company.Room.FacingView;
import com.company.Room.BedType;
import com.company.Room.RoomType;
import com.company.Room.RoomStatus;

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

    public static Room findingRoom(RoomType roomType, BedType bedType, FacingView facingView){
        for(Room room: Hotel.getRooms()){
            if(room.getStatus() == RoomStatus.VACANT){
                if(room.getRoomType() == roomType && room.getBedType() == bedType && room.getFacing() == facingView){
                    room.setStatus(RoomStatus.OCCUPIED);
                    return room;
                }
            }
        }
        return null;
    }
}
