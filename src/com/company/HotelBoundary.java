package com.company;

import jdk.jfr.Percentage;

import java.util.Scanner;

public class HotelBoundary {
    public static void enterHotel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to check room details? \n 1. Yes\n 0.No");
        boolean viewError;
        do {
            viewError = false;
            int viewRooms = Integer.parseInt(sc.nextLine());
            switch (viewRooms) {
                case 0:
                    break;
                case 1:
                    HotelController.printRooms();
                    return;
                default:
                    System.out.println("Please select option 1 or 2");
                    viewError = true;
                    break;
            }
        }while (viewError);

        System.out.print("What room number would you like?\nFloor:  ");
        int floorNum = Integer.parseInt(sc.nextLine());
        while(floorNum < 0 || floorNum >= Hotel.FLOORS){
            System.out.println("Please choose again\nFloor: ");
            floorNum = Integer.parseInt(sc.nextLine());
        }
        System.out.print("\nRoom number: ");
        int roomNum = Integer.parseInt(sc.nextLine());
        while(roomNum < 0 || roomNum >= Hotel.ROOMS_ON_EACH_FLOOR){
            System.out.println("Please choose again\nRoom number: ");
            roomNum = Integer.parseInt(sc.nextLine());
        }


        System.out.println("Please select what you would like to do with this room number\n 1. Change status of the room number" +
                "\n 2. Change the weekday cost of the room number\n 3. Change the weekend cost\n");


        boolean wrongDecision;
        do {
            wrongDecision = false;
            int decision = Integer.parseInt(sc.nextLine());
            switch (decision) {

                case 1:
                    HotelController.changeStatus(floorNum * Hotel.ROOMS_ON_EACH_FLOOR + roomNum);
                    break;
                case 2:
                    System.out.print("Please enter the desired weekday cost: ");
                    double price = Double.parseDouble(sc.nextLine());
                    HotelController.changing_room_cost(price, floorNum * Hotel.ROOMS_ON_EACH_FLOOR + roomNum);
                    break;
                case 3:
                    System.out.println("Please enter the desired weekend cost: ");
                    double weekEndPrice = Double.parseDouble(sc.nextLine());
                    HotelController.changingWeekendRoomRate(weekEndPrice, floorNum * Hotel.ROOMS_ON_EACH_FLOOR + roomNum);
                    break;
                default:
                    System.out.println("Please select a valid option.");
                    wrongDecision = true;
            }
        }while(wrongDecision);
    }

    public static void choosingRoom(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose a bed type");
    }

    public static void roomStats(){
        HotelController.roomOccupancy();
        // printing the total occupancy
    }

    public static void printingRoomStatusOccupancy(int numOfVacant, int numOfOccupied, int numOfReserved, int numOfUnderMaintenance){
        double percentageOfVacantRooms = numOfVacant/Hotel.NUMBER_OF_ROOMS * 100;
        double percentageOfReservedRooms = numOfReserved/Hotel.NUMBER_OF_ROOMS * 100;
        double percentageOfOccupiedRooms = numOfOccupied/Hotel.NUMBER_OF_ROOMS * 100;
        double percentageOfUnderMaintenance = numOfUnderMaintenance/Hotel.NUMBER_OF_ROOMS * 100;

        System.out.printf("The percentage of vacant rooms %.2f\n " +
                "The percentage of reserved rooms is %.2f\n" +
                "The percentage of occupied rooms is %.2f\n" +
                "The percentage of rooms under maintenance is %.2f\n", percentageOfVacantRooms,
                percentageOfReservedRooms, percentageOfOccupiedRooms, percentageOfUnderMaintenance);

    }
    public static void printingRoomTypeOccupancy(Room.RoomStatus roomStatus, int numOfSingleRoom, int numOfDoubleRoom,
                                                 int numOfDeluxeRoom, int numOfVIPRooms, int numOfRooms){
        double percentageOfSingleRoom = numOfSingleRoom/numOfRooms * 100;
        double percentageOfDoubleRoom = numOfDoubleRoom/numOfRooms * 100;
        double percentageOfDeluxeRoom = numOfDeluxeRoom/numOfRooms * 100;
        double percentageOfVIPRooms = numOfVIPRooms/numOfRooms * 100;

        System.out.printf(" For Room Status %s\nThe percentage of Single Rooms is %.2f\n" +
                "The percentage of Double Rooms is %.2f\n" +
                "The percentage of Deluxe Room is %.2f\n" +
                "The percentage of VIP Room is %.2f\n",roomStatus.toString(), percentageOfSingleRoom,
                percentageOfDoubleRoom, percentageOfDeluxeRoom,
                percentageOfVIPRooms);
    }

}
