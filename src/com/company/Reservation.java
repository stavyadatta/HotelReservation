package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
    private int reservationNumber;
    private ArrayList<Guest> guests;
    private  ArrayList<Room> rooms;
    private PaymentMethod paymentMethod;

    private enum reservationStatus {
        confirmed,
        inWaitlist,
        checkedIn,
        expired;

        public String currentStatus;

        // getter method
        public String getCurrentStatus()
        {
            return this.currentStatus;
        }

        // enum constructor - cannot be public or protected
        private reservationStatus(String currentStatus)
        {
            this.currentStatus = currentStatus;
        }

        }



    public Reservation(){
        guests = new ArrayList<Guest>();
        rooms = new ArrayList<Room>();
    }

    public int getReservationNumber() {

        return reservationNumber;
    }



    public void setReservationNumber(int reservationNumber) {
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
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

