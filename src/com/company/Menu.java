package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private static ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

   
   public static void displayMenuItems() {
	   System.out.println("The MenuItems");
	   for(MenuItem menuItem : menuItems) {
	   		System.out.println(menuItem.getName()+"  "+menuItem.getDescription()+"  "+menuItem.getPrice() + "\n");
	   }
   }

   public static void newMenuItem(String name, String description, double price){
   	MenuItem menuItem = new MenuItem(name, description, price);
   	menuItems.add(menuItem);
   }

   public static void removeMenuItem(String name){
   	for(int i = 0; i<menuItems.size(); i++){
   		if(name == menuItems.get(i).getName()){
   			menuItems.remove(i);
		}
	}
   }

   public static void updateMenuItem(){
	   Scanner sc = new Scanner(System.in);
	   System.out.println("the menu item to be updated here ");
	   System.out.println("Write the name of menu Item to be updated ");
	   String name = sc.nextLine();

	   for(int i = 0; i < menuItems.size(); i++){
	   	if(name == menuItems.get(i).getName()){
	   		System.out.println("The item is found, what do u want to change about the item\n 1 for name " +
					"2 for description and 3 for price ");
	   		int decision = sc.nextInt();
	   		switch (decision){
				case 1:
					System.out.println("The old name was " + menuItems.get(i).getName());
					System.out.print("\nNew name: ");
					String newName = sc.nextLine();
					menuItems.get(i).setName(newName);
					break;

				case 2:
					System.out.println("This is the old description " + menuItems.get(i).getDescription());
					System.out.print("\nNew description: ");
					String newDescription = sc.nextLine();
					menuItems.get(i).setDescription(newDescription);
					break;

				case 3:
					System.out.println("This is the old price " + menuItems.get(i).getPrice());
					System.out.print("\nNew Price: ");
					double newPrice = sc.nextDouble();
					menuItems.get(i).setPrice(newPrice);
					break;

				default:
					System.out.println("Please put valid number ");

			}
			sc.close();


		}
	   }


   }
}
