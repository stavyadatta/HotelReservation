package com.company;

import java.text.ParseException;
import java.util.Scanner;

public class ReservationBoundary {

    private static int numberOfcheckIn;
    static {
        numberOfcheckIn = 0;
    }

    public static void checkIn() throws ParseException {
        Scanner sc = new Scanner(System.in);
        Reservation reservation = new Reservation();

        System.out.println("Names of the guest u wanna add \n-1 when all the guests have been added");
        int decision = 0;
        while(decision != -1){
            Guest guest = GuestManager.CreateGuest();
            reservation.getGuests().add(guest);
            System.out.print("More guest? press -1 for no and any other number for yes: ");
            decision = Integer.parseInt(sc.nextLine());
        }
        int method = -1;
        do {
            System.out.print("Payment method 1 for card and 2 for cash: ");
            method = Integer.parseInt(sc.nextLine());
            switch (method) {
                case 1:
                    System.out.println("Payment via card");
                    CreditCard creditCard = CreditCardBoundary.enterCreditCardDetails();
                    reservation.setPaymentMethod(creditCard);
                    break;
                case 2:
                    System.out.println("Payment via cash");
                    Cash cash = new Cash();
                    reservation.setPaymentMethod(cash);
                    break;
                default:
                    System.out.println("Please select a number between 1 and 2");
            }
        } while(method < 1 || method > 2);

        // finding what rooms does the user want
        int moreRooms = -2;
        do {
            System.out.println("What kind of room do you want enter the numbers selection");
            Room.printingRoomTypes();
            int decisionRoom = Integer.parseInt(sc.nextLine());
            Room.RoomType roomType = Room.RoomType.values()[decisionRoom];

            System.out.println("What kind of bed do you want");
            Room.printingBedType();
            int decisionBedType = Integer.parseInt(sc.nextLine());
            Room.BedType bedType = Room.BedType.values()[decisionBedType];

            System.out.println("What view do you want");
            Room.printingFacingView();
            int decisionFaceView = Integer.parseInt(sc.nextLine());
            Room.FacingView facingView = Room.FacingView.values()[decisionFaceView];

            // looking for the given details in the hotel
            Room foundRoom = HotelController.findingRoom(roomType, bedType, facingView);
            if (foundRoom == null) {
                System.out.println("Sorry the room was not found!!!!");
            } else {
                System.out.println("The room is found!!! Your room number is: " + foundRoom.getCompleteRoomNumber());
                reservation.getRooms().add(foundRoom);
            }


            System.out.println("Want more rooms? press -1 for no and any other number for yes");
            moreRooms = Integer.parseInt(sc.nextLine());

        }while(moreRooms != -1);


        numberOfcheckIn++;
        reservation.setReservationNumber(numberOfcheckIn);
        System.out.println("Your reservation number is " + reservation.getReservationNumber());

    }



    public static void checkout(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Floor: ");
        int floor = Integer.parseInt(sc.nextLine());
        System.out.print("Room number: ");
        int room_num = Integer.parseInt(sc.nextLine());
        Room room = Hotel.getRooms().get(floor * Hotel.ROOMS_ON_EACH_FLOOR + room_num);
        System.out.println("Check out process \nYour total bill is: ");
    }
}
