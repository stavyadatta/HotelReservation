package com.company;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RoomServiceBoundary {
    public static void initiateRoomService(){
        System.out.println("Order from the menu below");
        Menu.displayMenuItems();

        Scanner sc = new Scanner(System.in);
        int id = -2;
        double price = 0.0;
        RoomService roomService = new RoomService();
        do{
            System.out.println("Select the ids of the items or select -1 to finalize  ");
            id = Integer.parseInt(sc.nextLine());
            if(id == -1){
                break;
            }
            if(id < -1 || id >= Menu.getMenuItems().size()){
                System.out.println("Please choose an appropriate number");
                continue;
            }
            // adding the selected menu item into the array list of the room service object
            roomService.getItemsSelected().add(Menu.getMenuItems().get(id));
            price = price + Menu.getMenuItems().get(id).getPrice();

            System.out.printf("The price of the items selected is %.2f\n", price);

        } while(id!=-1);

        // setting up the room service object instance
        RoomServiceController.roomServiceModifier(roomService, price);

    }
}
