package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private static ArrayList<MenuItem> menuItems;
   
   public void displayMenuItems() {
	   System.out.println("The MenuItems");
	   for(int i=0;i<menuItems.size();i++) {
		   System.out.println(menuItems.get(i).getName()+"  "+menuItems.get(i).getDescription()+"  "+menuItems.get(i).getPrice());
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

   }
}
