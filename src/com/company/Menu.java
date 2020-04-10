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
	   System.out.println("the menu item to be updated here ");
	   System.out.println("Write the id of menu Item to be updated ");
	   int id = Integer.parseInt(sc.nextLine());

	   for(int i = 0; i < menuItems.size(); i++){
	   	if(id == menuItems.get(i).getId()){
	   		System.out.println("The item is found, what do u want to change about the item\n 1 for name " +
					"2 for description and 3 for price ");
	   		int decision = Integer.parseInt(sc.nextLine());
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
					System.out.println("Description Changed");
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
			//sc.close();


		} else{
	   		System.out.println("Item not found");
		}
	   }


   }

	public static ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}
}
