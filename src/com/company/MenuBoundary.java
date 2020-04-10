package com.company;

import java.util.Scanner;

public class MenuBoundary {
    public static void enterMenu(){
        System.out.println("What do u want from menu\n 1 for Create \n 2 for update\n 3 for remove" +
                "\n 4 for displaying menu items");
        Scanner sc = new Scanner(System.in);

        int decision = Integer.parseInt(sc.nextLine());
         switch (decision){
             case 1:
                 System.out.println("Entry of new menu item name: ");
                 String menuItemName = sc.nextLine();
                 System.out.println("Entry for new menu item description: ");
                 String menuItemDescription = sc.nextLine();
                 System.out.print("Entry for menu item price: ");
                 double menuItemPrice = Double.parseDouble(sc.nextLine());

                 // creating menu item in arraylist
                 Menu.newMenuItem(menuItemName, menuItemDescription, menuItemPrice);
                 System.out.println("name is added");

                 break;

             case 2:
                 System.out.println("What menu item u wanna update ");
                 Menu.updateMenuItem();
                 break;

             case 3:
                 System.out.println("What item u want to remove ");
                 int idOfRemovalItem = Integer.parseInt(sc.nextLine());
                 Menu.removeMenuItem(idOfRemovalItem);

             case 4:
                 System.out.println("The items in the arraylist");
                 Menu.displayMenuItems();



         }


    }
}
