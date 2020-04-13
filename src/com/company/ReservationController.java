package com.company;

import java.util.ArrayList;
import java.util.Date;

public class ReservationController {
    private static ArrayList<Reservation> reservations;

    static {
        reservations = new ArrayList<Reservation>();
    }

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }

    /**
     * finds reservation using String and then passes to findingreservation o find the reservation if found this method
     * passes true otherwise it passes false and thats how this works
     * @param guestName
     * @return boolean
     */

    public static boolean reservationFindings(String guestName){
        Reservation reservation;
        // finding the reservations by name
        reservation = findingReservationGuest(guestName);
        if(reservation == null){
            return false;
        } else {
            reservation.setReservationStatus(Reservation.ReservationStatus.CHECKEDIN);
            reservationInfo(reservation);
            return true;
        }
    }

    /**
     * @param reservation
     * getting the information of the reservation and printing using a boundary class functions
     */
    private static void reservationInfo(Reservation reservation){
        ArrayList<String> completeRoomNums = new ArrayList<String>();
        for(Room room: reservation.getRooms()){
            completeRoomNums.add(room.getCompleteRoomNumber());
        }
        ReservationBoundary.printingReservationDetails(completeRoomNums);
    }

    /**
     * finds the reservation
     * @param guestName
     * @return Reservation
     */

    private static Reservation findingReservationGuest(String guestName){
        for(Reservation reservation: reservations){
            if(guestName.equals(reservation.getGuest().getName())){
                return reservation;
            }
        }
        return null;
    }

    /**
     * Used to set up the reservation object and change the status also adds the reservation to the reservation
     * array list
     * @param numberofGuests
     * @param guest
     * @param room
     * @param reservationId
     */

    public static void settingUpReservationObject(int numberofGuests, Guest guest, Room room, int reservationId, Date toDate,
                                                  Date fromDate){
        Reservation reservation = new Reservation();
        reservation.setNumberOfGuestStaying(numberofGuests);
        reservation.getRooms().add(room);
        reservation.setReservationNumber(reservationId);
        reservation.setGuest(guest);
        reservation.setReservationStatus(Reservation.ReservationStatus.CONFIRMED);
        reservation.setToDate(toDate);
        reservation.setFromDate(fromDate);
        getReservations().add(reservation);
    }

    public static void setReservations(ArrayList<Reservation> reservations) {
        ReservationController.reservations = reservations;
    }

    public static Reservation findReservation(String completeRoomNum){
        for(Reservation reservation: reservations){
            for(Room room: reservation.getRooms()){
                if(completeRoomNum.equals(room.getCompleteRoomNumber())){
                    System.out.println("Reservation found");
                    return reservation;
                }
            }
        }
        System.out.println("Room not checked in, please enter correct room number");
        return null;
    }




}
