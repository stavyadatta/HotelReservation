package com.company;

import com.company.Room.FacingView;
import com.company.Room.BedType;
import com.company.Room.RoomType;
import com.company.Room.RoomStatus;

import java.util.Date;
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

    /**
     * this function will find the suitable room for the guest and will check the dates as well, it will return the room
     * when the room is found
     * @param roomType
     * @param bedType
     * @param facingView
     * @param fromDate
     * @param toDate
     * @return
     */

    public static Room findingRoom(RoomType roomType, BedType bedType, FacingView facingView, Date fromDate, Date toDate){
        for(Room room: Hotel.getRooms()){
            if(room.getStatus() == RoomStatus.VACANT || room.getStatus() == RoomStatus.RESERVED){
                if(room.getRoomType() == roomType && room.getBedType() == bedType && room.getFacing() == facingView){
                    // checking clashes with the date
                    if(ReservationController.checkingNoRoomDateClash(room, fromDate, toDate)){
                        room.setStatus(RoomStatus.RESERVED);
                        return room;
                    }
                }
            }
        }
        return null;
    }
}
