package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReservationBoundary {

    private static int numberOfCheckIns;
    static {
        numberOfCheckIns = 0;
    }



    public static void reserving() throws ParseException {
        Scanner sc = new Scanner(System.in);
        Reservation reservation = new Reservation();

        System.out.println("Names of the guest u wanna add \n-1 when all the guests have been added");
        Guest guest = GuestManager.CreateGuest();

        System.out.print("Number of guests staying: ");
        int numberOfGuestStaying = Integer.parseInt(sc.nextLine());

        // setting the dates
        System.out.println("Please write from date in dd/MM/yyyy format");
        String dateFromInput = sc.nextLine();
        Date fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateFromInput);

        System.out.println("Please write your to date in dd/MM/yyyy format  ");
        String dateToInput = sc.nextLine();
        Date toDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateToInput);

        // finding what rooms does the user want
        boolean roomNotAdded = false;
        ArrayList<Room> foundRooms;
        do {
            foundRooms = addingRoom(fromDate, toDate);
            if(foundRooms == null){
                roomNotAdded = true;
            } else {
                roomNotAdded = false;
            }
        }while(roomNotAdded);

        System.out.println("Your reservation number is " + numberOfCheckIns);
        // This is to add the reservation along with the info to the reservation arraylist
        ReservationController.settingUpReservationObject(numberOfGuestStaying, guest, foundRooms, numberOfCheckIns, toDate,
                fromDate);
        numberOfCheckIns++;

    }

    private static ArrayList<Room> addingRoom(Date fromDate, Date toDate){
        Scanner sc = new Scanner(System.in);
        int moreRooms = -2;
        // for combining the foundrooms later
        ArrayList<Room> foundRooms = new ArrayList<Room>();
        Room foundRoom;
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
            foundRoom = HotelController.findingRoom(roomType, bedType, facingView, fromDate, toDate);
            if (foundRoom == null) {
                System.out.println("Sorry the room was not found for the following dates, please try to find " +
                        "some other room!!!!");
            } else {
                System.out.println("The room is found!!! Your room number is: " + foundRoom.getCompleteRoomNumber());
                foundRooms.add(foundRoom);
            }

            System.out.println("Want more rooms? press -1 for no and any other number for yes");
            moreRooms = Integer.parseInt(sc.nextLine());

        }while(moreRooms != -1);
        if(foundRooms.size() == 0){
            return null;
        }

        return foundRooms;

    }


    public static void checkIn(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name of the guest please:");
        boolean foundReservation;
        do{
            String guestName = sc.nextLine();
            // this will form the reservation object inside the controller class and not the boundary
            foundReservation = ReservationController.reservationFindings(guestName);
            if(!foundReservation){
                System.out.println("Name not found, try another one");
                //checkIn();
            }
        } while(!foundReservation);
    }

    /**
     *
     * @param completeRoomNums
     * for writing in the room numbers and info from the reservation
     */

    public static void printingReservationDetails(ArrayList<String> completeRoomNums){
        System.out.println("The room numbers are");
        for(String roomNums: completeRoomNums){
            System.out.println(roomNums);
        }
    }



    public static void checkout(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please type the guest name you want to check out of");
        String guestName = sc.nextLine();
        System.out.println("Please type your passport number");
        String passport = sc.nextLine();

        // finding the reservation with this room number
        Reservation reservation = ReservationController.findReservation(guestName, passport);
        if(reservation == null){
            return;
        }
        System.out.println("You want to only check out of one room or multiple, 1 for only one room 2 for all");
        int checkOutDecision = Integer.parseInt(sc.nextLine());
        if(checkOutDecision == 1){
            System.out.print("Type your room number: ");
            String completeRoomNum = sc.nextLine();
            for(Room room: reservation.getRooms()){
                if(completeRoomNum.equals(room.getCompleteRoomNumber())){
                    singleRoomCheckout(room, reservation);
                    reservation.getRooms().remove(room);
                    break;
                }
                if(room.equals(reservation.getRooms().get(reservation.getRooms().size() - 1))){
                    System.out.print("Please input the correct room Number\n");
                    // writing the guest name again
                    checkout();
                }
            }
        } else {
            multiRoomCheckout(reservation);

        }


    }

    private static void singleRoomCheckout(Room room, Reservation reservation){
        Scanner sc = new Scanner(System.in);
        double cost = room.roomCost(reservation.getFromDate(), reservation.getToDate());
        reservation.getGuest().getPaymentMethod().setTotalBill(cost);
        System.out.println("The payment is " + cost);

        if(reservation.getGuest().getPaymentMethod() instanceof Cash){
            System.out.println("Give cash ");
            double given_money = Double.parseDouble(sc.nextLine());
            // getting the change back from person
            double change = ((Cash) reservation.getGuest().getPaymentMethod()).change(given_money);
            System.out.printf("Here is the change %.2f, have a lovely day!!!", change);
            room.setStatus(Room.RoomStatus.VACANT);
            //reservation.getRooms().remove(room);
        }
        if(reservation.getGuest().getPaymentMethod() instanceof CreditCard){
            System.out.println("Paying by credit card");
            System.out.println("Payment done");
            room.setStatus(Room.RoomStatus.VACANT);
            if(reservation.getRooms().size() == 0){
                ReservationController.getReservations().remove(reservation);
            }
            //reservation.getRooms().remove(room);
        }

    }

    private static void multiRoomCheckout(Reservation reservation){
        Scanner sc = new Scanner(System.in);
        double price = reservation.totalReservationCost();
        reservation.getGuest().getPaymentMethod().setTotalBill(price);
        System.out.println("The payment is " + price);

        if(reservation.getGuest().getPaymentMethod() instanceof Cash){
            System.out.println("Give cash");
            double given_money = Double.parseDouble(sc.nextLine());
            double change = ((Cash) reservation.getGuest().getPaymentMethod()).change(given_money);
            System.out.printf("Here is the change %.2f, have a lovely day!!!", change);
            for(Room room: reservation.getRooms()){
                room.setStatus(Room.RoomStatus.VACANT);
            }
            reservation.getRooms().clear();
        }
        if(reservation.getGuest().getPaymentMethod() instanceof CreditCard){
            System.out.println("Paying by credit card");
            System.out.println("Payment done");
            for(Room room: reservation.getRooms()){
                room.setStatus(Room.RoomStatus.VACANT);
            }
            reservation.getRooms().clear();
        }
        // remove reservation after checkout n
        ReservationController.getReservations().remove(reservation);
    }

    public static void updatingReservation() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("What is the name of the guest: ");
        String name = sc.nextLine();
        System.out.print("What is your passport number: ");
        String passportNum = sc.nextLine();

        Reservation reservation = ReservationController.findReservation(name, passportNum);
        if(reservation == null){
            System.out.println("The reservation is not found, please try again");
            return;
        }
        System.out.println("What would you like to change about this reservation");
        System.out.println("1. To add room");
        System.out.println("2. To remove room");
        System.out.println("3. To change guest details");
        System.out.println("4. Change the number of guest staying");
        System.out.println("5. Change the fromDate");
        System.out.println("6. Change the toDate ");

        int decision = Integer.parseInt(sc.nextLine());

        switch (decision){
            case 1:
                ArrayList<Room> addedRooms = addingRoom(reservation.getFromDate(), reservation.getToDate());
                assert addedRooms != null;
                reservation.getRooms().addAll(addedRooms);
                break;
            case 2:
                roomRemoval(reservation);
                break;
            case 3:
                GuestManager.UpdateGuest();
                break;
            case 4:
                System.out.println("Number of guest staying currently " + reservation.getNumberOfGuestStaying());
                System.out.print("New numbers: ");
                int numOfGuests = Integer.parseInt(sc.nextLine());
                ReservationController.changingGuestNum(reservation, numOfGuests);
                break;
            case 5:
                String dateString = sc.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                Date date = formatter.parse(dateString);
                reservation.setFromDate(date);
                System.out.println("Date changed");
                break;
            case 6:
                String dateString2 = sc.nextLine();
                SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                Date date2 = formatter2.parse(dateString2);
                reservation.setToDate(date2);
                System.out.println("Date changed");
                break;
        }
    }

    private static void roomRemoval(Reservation reservation){
        Scanner sc = new Scanner(System.in);
        System.out.println("What room do you want to remove");
        for(Room room: reservation.getRooms()){
            System.out.println(room.getCompleteRoomNumber());
        }
        String roomNum = sc.nextLine();
        int index = -1;
        for(Room room: reservation.getRooms()){
            if(roomNum.equals(room.getCompleteRoomNumber())){
                index = reservation.getRooms().indexOf(room);
            }
        }
        reservation.getRooms().remove(index);
    }
}
