package com.company;

import java.util.ArrayList;

public class ReservationController {
    private static ArrayList<Reservation> reservations;

    static {
        reservations = new ArrayList<Reservation>();
    }

    public static ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public static void settingUpReservationObject(int numberofGuests, Guest guest, Room room, int reservationId){
        Reservation reservation = new Reservation();
        reservation.setNumberOfGuestStaying(numberofGuests);
        reservation.getRooms().add(room);
        reservation.setReservationNumber(reservationId);
        reservation.setGuest(guest);
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
