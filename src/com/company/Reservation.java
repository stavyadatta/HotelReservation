package com.company;

import java.util.ArrayList;

public class Reservation {
    private long reservationCode;
    private long reservationNumber;
    private ArrayList<Guest> guests;
    private  ArrayList<Room> rooms;
   // private enum reservationStatus;

    public Reservation(){
        guests = new ArrayList<Guest>();
        rooms = new ArrayList<Room>();
    }
    public long getReservationCode() {
        return reservationCode;
    }

    public long getReservationNumber() {

        return reservationNumber;
    }

    public void setReservationCode(long reservationCode) {

        this.reservationCode = reservationCode;
    }

    public void setReservationNumber(long reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public double totalRoom_RoomService_Cost(){
        // finding the total room cost of the guest
        double total_room_cost = 0.0;
        double total_roomService_cost = 0.0;
        for(Room room: rooms){
            total_room_cost = total_room_cost + room.getRoomRate();
            for(RoomService roomService: room.getRoomServices()){
                total_roomService_cost = total_roomService_cost + roomService.getCost();
            }
        }

        return total_room_cost + total_roomService_cost;

    }
}

