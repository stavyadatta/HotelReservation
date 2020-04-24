package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReservationBoundary {

    private static int numberOfCheckIns;
    static {
        numberOfCheckIns = 0;
    }

    /**
     * Reserves the rooms, takes in the dates and info of the guests and later adds them to
     * to the reservation room array list
     * @throws ParseException
     */

    public static void reserving() throws ParseException {
        Scanner sc = new Scanner(System.in);
        Reservation reservation = new Reservation();

        System.out.println("Names of the guest u wanna add \n-1 when all the guests have been added");
        Guest guest = GuestManager.CreateGuest();

        System.out.print("Number of guests staying: ");
        int numberOfGuestStaying = Integer.parseInt(sc.nextLine());

        // setting the dates
        boolean validDate;
        Date fromDate;
        Date toDate;
        do {
            validDate = true;
            System.out.println("Please enter the start date (DD/MM/YYYY):");
            String dateFromInput = sc.nextLine();
            fromDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateFromInput);

            System.out.println("Please enter the end date (DD/MM/YYYY):  ");
            String dateToInput = sc.nextLine();
            toDate = new SimpleDateFormat("dd/MM/yyyy").parse(dateToInput);

            // checking if from date is after to date and if from date is not before the current date
            LocalDateTime now = LocalDateTime.now();
            Date nowDate = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
            if (!fromDate.before(toDate) || fromDate.before(nowDate)) {
                System.out.println("This is not a valid date!");
                validDate = false;
            }
        }while(!validDate);

        // finding what rooms does the user want
        boolean roomNotAdded = false;
        ArrayList<Room> foundRooms;
        do {
            foundRooms = addingRoom(fromDate, toDate);
            if(foundRooms == null){
                roomNotAdded = true;
                System.out.println("There is no room in the reservation, please add room.");
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

    /**
     *  add rooms and room types to array list of the rooms in the reservation
     * @param fromDate
     * @param toDate
     * @return
     */

    private static ArrayList<Room> addingRoom(Date fromDate, Date toDate){
        Scanner sc = new Scanner(System.in);
        int moreRooms = -2;
        // for combining the foundrooms later
        ArrayList<Room> foundRooms = new ArrayList<Room>();
        Room foundRoom;
        do {
            System.out.println("What kind of room would you like? Please enter the corresponding option.");
            Room.printingRoomTypes();
            int decisionRoom = Integer.parseInt(sc.nextLine());
            Room.RoomType roomType = Room.RoomType.values()[decisionRoom];

            System.out.println("What kind of bed would you like?");
            Room.printingBedType();
            int decisionBedType = Integer.parseInt(sc.nextLine());
            Room.BedType bedType = Room.BedType.values()[decisionBedType];

            System.out.println("Which view would you prefer?");
            Room.printingFacingView();
            int decisionFaceView = Integer.parseInt(sc.nextLine());
            Room.FacingView facingView = Room.FacingView.values()[decisionFaceView];

            // looking for the given details in the hotel
            foundRoom = HotelController.findingRoom(roomType, bedType, facingView, fromDate, toDate);
            if (foundRoom == null) {
                System.out.println("Sorry! A room could not be found for the chosen dates, please try to look for " +
                        "a different room.");
            } else {
                System.out.println("Congratulations! We found a room for you :) \nYour room number is: " + foundRoom.getCompleteRoomNumber());
                foundRooms.add(foundRoom);
            }

            System.out.println("Would you like more rooms? Enter -1 for 'No' or enter any other number for 'Yes'");
            moreRooms = Integer.parseInt(sc.nextLine());

        }while(moreRooms != -1);
        if(foundRooms.size() == 0){
            return null;
        }

        return foundRooms;

    }

    /**
     * Changes the status of the reservation to checkIn, to be noted that the items cant be ordered
     * unless they are not checkedIn
     */

    public static void checkIn(){
        Scanner sc = new Scanner(System.in);
        boolean foundReservation;
        do{
            System.out.println("Please enter the name of the guest:");
            String guestName = sc.nextLine();
            System.out.println("Please enter the passport number:");
            String guestPassportNum = sc.nextLine();
            // this will form the reservation object inside the controller class and not the boundary
            foundReservation = ReservationController.reservationFindings(guestName, guestPassportNum);
            if(!foundReservation){
                System.out.println("Name not found! Please try a different name.");
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

    /**
     * checks out of reservation and deletes them in the process
     */

    public static void checkout(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the guest name for check out:");
        String guestName = sc.nextLine();
        System.out.println("Please enter your passport number:");
        String passport = sc.nextLine();

        // finding the reservation with this room number
        Reservation reservation = ReservationController.findReservation(guestName, passport);
        if(reservation == null){
            System.out.println("Reservation not found! Please try again.");
            return;
        }
        System.out.println("How many rooms would you like to check out of? \n1. One Room \n2. Multiple Rooms");
        int checkOutDecision = Integer.parseInt(sc.nextLine());
        if(checkOutDecision == 1){
            System.out.print("Please enter your room number: ");
            String completeRoomNum = sc.nextLine();
            int removeRoom = -1;
            // going through each and every rooms and break is there to avoid the recursion in case the room is found
            for(Room room: reservation.getRooms()){
                if(completeRoomNum.equals(room.getCompleteRoomNumber())){
                    singleRoomCheckout(room, reservation);
                    removeRoom = reservation.getRooms().indexOf(room);
                    break;
                }

            }
            if(removeRoom == -1) {
                System.out.println("Invalid room number! Please try again.");
                return;
            }
            reservation.getRooms().remove(removeRoom);
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
            System.out.println("Please proceed with the cash payment: ");
            double given_money = Double.parseDouble(sc.nextLine());
            // getting the change back from person
            double change = ((Cash) reservation.getGuest().getPaymentMethod()).change(given_money);
            System.out.printf("Here is your change %.2f. \nHave a good day!", change);
            room.setStatus(Room.RoomStatus.VACANT);
            //reservation.getRooms().remove(room);
        }
        if(reservation.getGuest().getPaymentMethod() instanceof CreditCard){
            System.out.println("Paying by credit card");
            System.out.println("Payment has been processed successfully!");
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
        System.out.println("The amount is " + price);

        if(reservation.getGuest().getPaymentMethod() instanceof Cash){
            System.out.println("Please proceed with the cash payment:");
            double given_money = Double.parseDouble(sc.nextLine());
            double change = ((Cash) reservation.getGuest().getPaymentMethod()).change(given_money);
            System.out.printf("Here is your change %.2f. \nHave a good day!", change);
            for(Room room: reservation.getRooms()){
                room.setStatus(Room.RoomStatus.VACANT);
            }
            reservation.getRooms().clear();
        }
        if(reservation.getGuest().getPaymentMethod() instanceof CreditCard){
            System.out.println("Paying by credit card.");
            System.out.println("Payment processed successfully!");
            for(Room room: reservation.getRooms()){
                room.setStatus(Room.RoomStatus.VACANT);
            }
            reservation.getRooms().clear();
        }
        // remove reservation after checkout n
        ReservationController.reservationRemoveController(reservation.getGuest().getName(),
                reservation.getGuest().getpassportNumber());
    }

    /**
     * updating the reservation
     * @throws ParseException
     */

    public static void updatingReservation() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the name of the guest: ");
        String name = sc.nextLine();
        System.out.print("Please enter the passport number: ");
        String passportNum = sc.nextLine();

        Reservation reservation = ReservationController.findReservation(name, passportNum);
        if(reservation == null){
            System.out.println("The reservation could not be found, please try again!");
            return;
        }
        System.out.println("What would you like to change about this reservation?");
        System.out.println("1. Add a room");
        System.out.println("2. Remove a room");
        System.out.println("3. Change guest details");
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
                System.out.println("Date changed successfully!");
                break;
            case 6:
                String dateString2 = sc.nextLine();
                SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                Date date2 = formatter2.parse(dateString2);
                reservation.setToDate(date2);
                System.out.println("Date changed successfully!");
                break;
        }
    }

    private static void roomRemoval(Reservation reservation){
        Scanner sc = new Scanner(System.in);
        System.out.println("Which room would you like to remove?");
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

    /**
     * To remove reservation
     */

    public static void reservationRemoval(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String guestName = sc.nextLine();
        System.out.println("Please enter your passport number: ");
        String passportNum = sc.nextLine();

        ReservationController.reservationRemoveController(guestName, passportNum);

    }

    public static void printReservation(){
        for(Reservation reservation : ReservationController.getReservations()){
            System.out.println("Name of the Guest: " + reservation.getGuest().getName());
            for(Room room: reservation.getRooms()){
                System.out.println(room.roomDetails());
            }
        }
    }
}
