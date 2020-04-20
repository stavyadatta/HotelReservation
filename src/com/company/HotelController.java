package com.company;

import com.company.Room.FacingView;
import com.company.Room.BedType;
import com.company.Room.RoomType;
import com.company.Room.RoomStatus;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    /**
     * Checks the room occupancy and passes the number of vacant, occupied, reserved, under maintenance and null
     * and passing the values to find the percentage respectively
     */
    public static void roomOccupancy(){
        final int numOfRooms = Hotel.NUMBER_OF_ROOMS;
        // list of all room types
        ArrayList<Room> vacantRooms = new ArrayList<Room>();
        ArrayList<Room> occupiedRooms = new ArrayList<Room>();
        ArrayList<Room> reservedRooms = new ArrayList<Room>();
        ArrayList<Room> underMaintenanceRooms = new ArrayList<Room>();
        ArrayList<Room> nullRooms = new ArrayList<Room>();
        int numOfVacant = 0;
        int numOfOccupied = 0;
        int numOfReserved = 0;
        int numOfUnderMaintenance = 0;
        int numOfNull =0;
        for(Room room: Hotel.getRooms()){
            switch (room.getStatus()){
                case VACANT:
                    numOfVacant++;
                    vacantRooms.add(room);
                    break;
                case OCCUPIED:
                    numOfOccupied++;
                    occupiedRooms.add(room);
                    break;
                case RESERVED:
                    numOfReserved++;
                    reservedRooms.add(room);
                    break;
                case UNDER_MAINTENANCE:
                    numOfUnderMaintenance++;
                    underMaintenanceRooms.add(room);
                    break;
                default:
                    numOfNull++;
                    nullRooms.add(room);
                    break;
            }
        }
        // HashMap to store values of the keys
        HashMap<Room.RoomStatus, ArrayList<Room>> roomStatusArrayListHashMap = new HashMap<Room.RoomStatus, ArrayList<Room>>();
        roomStatusArrayListHashMap.put(RoomStatus.VACANT, vacantRooms);
        roomStatusArrayListHashMap.put(RoomStatus.OCCUPIED, occupiedRooms);
        roomStatusArrayListHashMap.put(RoomStatus.RESERVED, reservedRooms);
        roomStatusArrayListHashMap.put(RoomStatus.UNDER_MAINTENANCE, underMaintenanceRooms);

        HotelBoundary.printingRoomStatusOccupancy(numOfVacant, numOfOccupied, numOfReserved, numOfUnderMaintenance);

        detailsPerRoomType(roomStatusArrayListHashMap);

    }

    private static void detailsPerRoomType(HashMap<Room.RoomStatus, ArrayList<Room>> roomStatusArrayListHashMap){
        // getting info about vacant rooms
        for(Room.RoomStatus roomStatus: roomStatusArrayListHashMap.keySet()){
            accessingEachRoomType(roomStatus, roomStatusArrayListHashMap.get(roomStatus));
        }
    }

    private static void accessingEachRoomType(Room.RoomStatus roomStatus, ArrayList<Room> rooms){
            int numOfSingleRoom = 0;
            int numOfDoubleRoom = 0;
            int numOfDeluxeRoom = 0;
            int numOfVIPRooms = 0;

            for(Room room: rooms){
                Room.RoomType roomType = room.getRoomType();
                switch (roomType){
                    case SINGLE:
                        numOfSingleRoom++;
                        break;
                    case DELUXE:
                        numOfDeluxeRoom++;
                        break;
                    case DOUBLE:
                        numOfDoubleRoom++;
                        break;
                    case VIP:
                        numOfVIPRooms++;
                        break;
                }
            }
            HotelBoundary.printingRoomTypeOccupancy(roomStatus, numOfSingleRoom, numOfDoubleRoom, numOfDeluxeRoom
                    , numOfVIPRooms, rooms.size());
    }

}
