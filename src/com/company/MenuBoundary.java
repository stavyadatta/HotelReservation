package com.company;

import java.util.Scanner;

public class MenuBoundary {
    public static void enterMenu(){
        System.out.println("Please select an option for the menu:\n 1. Create \n 2. Update\n 3. Remove" +
                "\n 4. Display Menu Items");
        Scanner sc = new Scanner(System.in);

        int decision = Integer.parseInt(sc.nextLine());
         switch (decision){
             case 1:
                 System.out.println("Please enter the name of new menu item name: ");
                 String menuItemName = sc.nextLine();
                 System.out.println("Pleas enter a description for the new menu item: ");
                 String menuItemDescription = sc.nextLine();
                 System.out.print("Please enter the price of new menu item: ");
                 double menuItemPrice = Double.parseDouble(sc.nextLine());

                 // creating menu item in arraylist
                 Menu.newMenuItem(menuItemName, menuItemDescription, menuItemPrice);
                 System.out.println("Name has been added successfully!");

                 break;

             case 2:
                 Menu.displayMenuItems();
                 System.out.println("Which menu item would you like to update?");
                 Menu.updateMenuItem();
                 break;

             case 3:
                 Menu.displayMenuItems();
                 System.out.println("Which item would you like to remove?");
                 int idOfRemovalItem = Integer.parseInt(sc.nextLine());
                 Menu.removeMenuItem(idOfRemovalItem);

             case 4:
                 System.out.println("The items in the menu are:");
                 Menu.displayMenuItems();



         }


    }
}
