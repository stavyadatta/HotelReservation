package com.company;

import jdk.jfr.Percentage;

import java.util.Scanner;

public class HotelBoundary {
    public static void enterHotel(){
        Scanner sc = new Scanner(System.in);
        System.out.print("What room number do you want\nFloor:  ");
        int floorNum = Integer.parseInt(sc.nextLine());
        while(floorNum < 0 || floorNum >= Hotel.FLOORS){
            System.out.println("Choose again\nFloor: ");
            floorNum = Integer.parseInt(sc.nextLine());
        }
        System.out.print("\nroom number: ");
        int roomNum = Integer.parseInt(sc.nextLine());
        while(roomNum < 0 || roomNum >= Hotel.ROOMS_ON_EACH_FLOOR){
            System.out.println("Choose again\nroom number: ");
            roomNum = Integer.parseInt(sc.nextLine());
        }


        System.out.println("What do you want from this room number\n 1 for changing status of the room number" +
                "\n 2 changing the weekday cost of the room number\n 3 changing the weekend cost\n 4 for rooms");

        int decision = Integer.parseInt(sc.nextLine());

        switch (decision){
            case 1:
               HotelController.changeStatus(floorNum*Hotel.ROOMS_ON_EACH_FLOOR + roomNum);
               break;
            case 2:
                System.out.print("What cost do u want: ");
                double price = Double.parseDouble(sc.nextLine());
                HotelController.changing_room_cost(price, roomNum);
            case 4:
                HotelController.printRooms();
                break;

        }
    }

    public static void choosingRoom(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What type of bed do u want");
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
                "The percentage of under maintenance is %.2f\n", percentageOfVacantRooms,
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
