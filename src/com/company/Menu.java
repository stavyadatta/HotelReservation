package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private static ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
	private static int num_of_times_add_new_item_called = 0;

   
   public static void displayMenuItems() {
	   System.out.println("The MenuItems");
	   for(MenuItem menuItem : menuItems) {
	   		System.out.println(menuItem.getName()+"  "+menuItem.getDescription()+"  "+menuItem.getPrice() + " id: " +
					menuItem.getId());
	   }
   }

   public static void newMenuItem(String name, String description, double price){
   	MenuItem menuItem = new MenuItem(name, description, price, num_of_times_add_new_item_called);
   	menuItems.add(menuItem);
   	num_of_times_add_new_item_called++;
   }

   public static void removeMenuItem(int id){
   	for(int i = 0; i<menuItems.size(); i++){
   		if(id == menuItems.get(i).getId()){
   			menuItems.remove(i);
		}
	}
   }

   public static void updateMenuItem(){
	   Scanner sc = new Scanner(System.in);
	   System.out.println("The menu item to be updated here ");
	   System.out.println("Please enter the ID of the menu item to be updated ");
	   int id = Integer.parseInt(sc.nextLine());

	   for(int i = 0; i < menuItems.size(); i++){
	   	if(id == menuItems.get(i).getId()){
	   		System.out.println("The item has been found. Please select the property you would like to change:\n 1. Name " +
					"\n2. Description \n3. Price ");
	   		int decision = Integer.parseInt(sc.nextLine());
	   		switch (decision){
				case 1:
					System.out.println("The original name of the menu item: " + menuItems.get(i).getName());
					System.out.print("\nPlease enter a new name: ");
					String newName = sc.nextLine();
					menuItems.get(i).setName(newName);
					break;

				case 2:
					System.out.println("The original description of the menu item: " + menuItems.get(i).getDescription());
					System.out.print("\nPlease enter a new description: ");
					String newDescription = sc.nextLine();
					menuItems.get(i).setDescription(newDescription);
					System.out.println("Description has been successfully changed!");
					break;

				case 3:
					System.out.println("The original price of the menu item: " + menuItems.get(i).getPrice());
					System.out.print("\nPlease enter the new price: ");
					double newPrice = sc.nextDouble();
					menuItems.get(i).setPrice(newPrice);
					break;

				default:
					System.out.println("Please enter a valid number!");

			}
			//sc.close();


		} else{
	   		System.out.println("Unfortunately, item could not be found.");
		}
	   }


   }

	public static ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}
}
