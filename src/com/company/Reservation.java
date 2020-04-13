package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Reservation {
    private int reservationNumber;
    private Guest guest;
    private  ArrayList<Room> rooms;
    private PaymentMethod paymentMethod;
   // private enum reservationStatus;
    private int numberOfGuestStaying;

//    private enum reservationStatus {
//        confirmed,
//        inWaitlist,
//        checkedIn,
//        expired;
//
//        public String currentStatus;
//
//        // getter method
//        public String getCurrentStatus()
//        {
//            return this.currentStatus;
//        }
//
//        // enum constructor - cannot be public or protected
//        private reservationStatus(String currentStatus)
//        {
//            this.currentStatus = currentStatus;
//        }
//
//    }

//    private enum reservationStatus {
//        confirmed,
//        inWaitlist,
//        checkedIn,
//        expired;
//
//        public String currentStatus;
//
//        // getter method
//        public String getCurrentStatus()
//        {
//            return this.currentStatus;
//        }
//
//        // enum constructor - cannot be public or protected
//        private reservationStatus(String currentStatus)
//        {
//            this.currentStatus = currentStatus;
//        }
//
//        }

    public Reservation(){
        rooms = new ArrayList<Room>();
    }

    public int getReservationNumber() {

        return reservationNumber;
    }



    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public double totalReservationCost() {
        // finding the total room cost of the guest
        double price = 0;
        for(Room room: rooms){
            price = price + room.roomCost();
        }
        return price;
    }

    public int getNumberOfGuestStaying() {
        return numberOfGuestStaying;
    }

    public void setNumberOfGuestStaying(int numberOfGuestStaying) {
        this.numberOfGuestStaying = numberOfGuestStaying;
    }



    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

