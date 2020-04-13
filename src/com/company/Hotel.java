package com.company;

import java.util.ArrayList;

public class Hotel {
    public final static int NUMBER_OF_ROOMS = 48;
    private double percentageOfRoomsOccupied;
    private static ArrayList<Room> rooms;
    public final static int FLOORS = 8;
    public final static int ROOMS_ON_EACH_FLOOR = 6;
    private static int running;

    static {
        running = 0;
        rooms = new ArrayList<Room>();
        // creating the whole hotel
        for(int i = 0; i<FLOORS; i++){
            for(int j = 0; j<ROOMS_ON_EACH_FLOOR; j++){
                Room current_room = new Room();
                switch (i){
                    // which floor to have what features
                    case 0:
                        current_room.setRoomFloor(i);
                        current_room.setRoomNumber(j);
                        current_room.setBedType(Room.BedType.SINGLE_BED);
                        current_room.setFacing(Room.FacingView.NO_VIEW);
                        current_room.setRoomType(Room.RoomType.SINGLE);
                        current_room.setCompleteRoomNumber();
                        current_room.setRoomRate(120.23);
                        rooms.add(current_room);
                        break;

                    case 1:
                        current_room.setRoomFloor(i);
                        current_room.setRoomNumber(j);
                        current_room.setBedType(Room.BedType.DOUBLE_BED);
                        current_room.setFacing(Room.FacingView.POOL_VIEW);
                        current_room.setRoomType(Room.RoomType.SINGLE);
                        current_room.setCompleteRoomNumber();
                        current_room.setRoomRate(142.34);
                        rooms.add(current_room);
                        break;

                    case 2:
                        current_room.setRoomFloor(i);
                        current_room.setRoomNumber(j);
                        current_room.setBedType(Room.BedType.DOUBLE_BED);
                        current_room.setFacing(Room.FacingView.PARK_VIEW);
                        current_room.setRoomType(Room.RoomType.DOUBLE);
                        current_room.setCompleteRoomNumber();
                        current_room.setRoomRate(163.34);
                        rooms.add(current_room);
                        break;

                    case 3:
                        current_room.setRoomFloor(i);
                        current_room.setRoomNumber(j);
                        current_room.setBedType(Room.BedType.MASTER_BED);
                        current_room.setFacing(Room.FacingView.POOL_VIEW);
                        current_room.setRoomType(Room.RoomType.DOUBLE);
                        current_room.setCompleteRoomNumber();
                        current_room.setRoomRate(1300.23);
                        rooms.add(current_room);
                        break;

                    case 4:
                        current_room.setRoomFloor(i);
                        current_room.setRoomNumber(j);
                        current_room.setBedType(Room.BedType.DOUBLE_BED);
                        current_room.setFacing(Room.FacingView.PARK_VIEW);
                        current_room.setRoomType(Room.RoomType.DELUXE);
                        current_room.setCompleteRoomNumber();
                        current_room.setRoomRate(3420.23);
                        rooms.add(current_room);
                        break;

                    case 5:
                        current_room.setRoomFloor(i);
                        current_room.setRoomNumber(j);
                        current_room.setBedType(Room.BedType.DOUBLE_BED);
                        current_room.setFacing(Room.FacingView.SEA_VIEW);
                        current_room.setRoomType(Room.RoomType.DELUXE);
                        current_room.setCompleteRoomNumber();
                        current_room.setRoomRate(1450.23);
                        rooms.add(current_room);
                        break;

                    case 6:
                        current_room.setRoomFloor(i);
                        current_room.setRoomNumber(j);
                        current_room.setBedType(Room.BedType.MASTER_BED);
                        current_room.setFacing(Room.FacingView.MOUNTAIN_VIEW);
                        current_room.setRoomType(Room.RoomType.DELUXE);
                        current_room.setCompleteRoomNumber();
                        current_room.setRoomRate(2341.21);
                        rooms.add(current_room);
                        break;

                    case 7:
                        current_room.setRoomFloor(i);
                        current_room.setRoomNumber(j);
                        current_room.setBedType(Room.BedType.DOUBLE_BED);
                        current_room.setFacing(Room.FacingView.CITY_VIEW);
                        current_room.setRoomType(Room.RoomType.VIP);
                        current_room.setCompleteRoomNumber();
                        current_room.setRoomRate(2314.29);
                        rooms.add(current_room);
                        break;
                }
                running++;
            }

        }
    }



    public Hotel(double percentageOfRoomsOccupied) {

        this.percentageOfRoomsOccupied = percentageOfRoomsOccupied;
    }

    public double getPercentageOfRoomsOccupied() {
        return percentageOfRoomsOccupied;
    }

    public static void hotelRooms(){
        for(Room room: rooms){
            System.out.printf("this room number and floor %d and %d with status being %s\n" +
                            "Complete room number being %s with view room type %s, bed type %s and " +
                            "view being %s \n", room.getRoomFloor(),
                    room.getRoomNumber(), room.getStatus(), room.getCompleteRoomNumber(), room.getRoomType(), room.getBedType(),
                    room.getFacing());
        }
        System.out.println("This ran " + rooms.size() + " times");
    }

    public void setPercentageOfRoomsOccupied(double percentageOfRoomsOccupied) {
        this.percentageOfRoomsOccupied = percentageOfRoomsOccupied;
    }

    public static Room getRoom(int index){
        return rooms.get(index);

    }
    public static void change_room_price(double price, int room_num){
        rooms.get(room_num).setRoomRate(price);

    }

    public static void change_weekend_price(double price, int room_num){
        rooms.get(room_num).setRoomWeekendRate(price);
    }

    public static ArrayList<Room> getRooms() {
        return rooms;
    }

    public static void printRooms(){
        for(Room room: rooms){
            System.out.println();
        }
    }
}
