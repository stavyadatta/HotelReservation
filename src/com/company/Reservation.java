package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Reservation {
    private int reservationNumber;
    private Guest guest;
    private  ArrayList<Room> rooms;
   // private enum reservationStatus;
    private int numberOfGuestStaying;
    private Date fromDate;
    private Date toDate;


    public enum ReservationStatus {
        CONFIRMED,
        WAITLIST,
        CHECKEDIN,
        EXPIRED

    }

    private ReservationStatus reservationStatus;


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

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public double totalReservationCost() {
        // finding the total room cost of the guest
        double price = 0;
        for(Room room: rooms){
            price = price + room.roomCost(this.getFromDate(), this.getToDate());
        }
        return price;
    }

    public int getNumberOfGuestStaying() {
        return numberOfGuestStaying;
    }

    public void setNumberOfGuestStaying(int numberOfGuestStaying) {
        this.numberOfGuestStaying = numberOfGuestStaying;
    }


    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}

