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
     * finds reservation using String and then passes to finding reservation o find the reservation if found this method
     * passes true otherwise it passes false and thats how this works, also changes the status to checked in
     * @param guestName
     * @return boolean
     */

    public static boolean reservationFindings(String guestName, String passportNum){
        Reservation reservation;
        // finding the reservations by name
        reservation = findingReservationGuest(guestName, passportNum);
        if(reservation == null){
            return false;
        } else {
            reservation.setReservationStatus(Reservation.ReservationStatus.CHECKEDIN);
            // printing the reservation and room numbers that are allocated
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
     * finds the reservation using guest name
     * @param guestName
     * @return Reservation
     */

    private static Reservation findingReservationGuest(String guestName, String passportNum){
        for(Reservation reservation: reservations){
            if(guestName.equals(reservation.getGuest().getName()) && passportNum.equals(reservation.getGuest().getpassportNumber())){
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
     * @param foundRooms
     * @param reservationId
     */

    public static void settingUpReservationObject(int numberofGuests, Guest guest, ArrayList<Room> foundRooms, int reservationId, Date toDate,
                                                  Date fromDate){
        Reservation reservation = new Reservation();
        reservation.setNumberOfGuestStaying(numberofGuests);
        reservation.getRooms().addAll(foundRooms);
        reservation.setReservationNumber(reservationId);
        reservation.setGuest(guest);
        reservation.setReservationStatus(Reservation.ReservationStatus.CONFIRMED);
        reservation.setToDate(toDate);
        reservation.setFromDate(fromDate);
        getReservations().add(reservation);
    }

    /**
     * Checking the clashing of the date with that particular room, being used in the hotel controller class
     * @param room
     * @param fromDate
     * @param toDate
     */

    public static boolean checkingNoRoomDateClash(Room room, Date fromDate, Date toDate){
        for(Reservation reservation: getReservations()){
            if(reservation.getRooms().contains(room)){
                if(!isNotWithinRange(reservation, fromDate, toDate)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isNotWithinRange(Reservation reservation, Date fromDate, Date toDate){
        if(fromDate.before(reservation.getFromDate()) && toDate.after(reservation.getFromDate())){
            return false;
        } else if(fromDate.after(reservation.getFromDate()) && fromDate.before(reservation.getToDate())){
            return false;
        } else{
            return true;
        }
    }

    public static void setReservations(ArrayList<Reservation> reservations) {
        ReservationController.reservations = reservations;
    }

    public static Reservation findReservation(String guestName, String passport){
        for(Reservation reservation: reservations) {
            if(guestName.equals(reservation.getGuest().getName()) &&
                    passport.equals(reservation.getGuest().getpassportNumber())){
                return reservation;
            }
        }
        System.out.println("Room not reserved in, please enter correct room number.");
        return null;
    }
    public static void changingGuestNum(Reservation reservation, int numOfGuests){
        reservation.setNumberOfGuestStaying(numOfGuests);
    }

    public static void reservationRemoveController(String guestName, String passportNum){
        Reservation reservation = findReservation(guestName, passportNum);
        getReservations().remove(reservation);
    }

}
