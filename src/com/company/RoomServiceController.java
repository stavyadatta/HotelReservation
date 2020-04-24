package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class RoomServiceController {

    public static boolean roomServiceModifier(RoomService roomService, double price, String completeRoomNum){
        Scanner sc = new Scanner(System.in);
        roomService.setCost(price);
        LocalDateTime now = LocalDateTime.now();
        roomService.setDate(now);

       Room room = findingRoom(completeRoomNum);
       if(room == null){
           RoomServiceBoundary.incorrectRoomNum();
           return false;
       }
       room.addRoomService(roomService);
       System.out.println("Your order has been placed!");

       System.out.print("Your order is: ");
       room.printRoomServices();
       return true;
    }

    private static Room findingRoom(String completeRoomNum){
        for(Reservation reservation: ReservationController.getReservations()){
            if(reservation.getReservationStatus() == Reservation.ReservationStatus.CHECKEDIN){
               for(Room room: reservation.getRooms()){
                   if(completeRoomNum.equals(room.getCompleteRoomNumber())){
                       return room;
                   }
               }
            }
        }
        return null;
    }


}
