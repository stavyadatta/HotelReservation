package com.company;

import com.company.Menu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
public class RoomService {
	private LocalDateTime date;
	private double cost;
	private Room room;
	private ArrayList<MenuItem> itemsSelected;
	
	public RoomService(LocalDateTime date, double cost){
		this.date=date;
		this.cost=cost;
	}

	public RoomService(){
		itemsSelected = new ArrayList<MenuItem>();
	}
	


	public LocalDateTime getDate() {
		return this.date;
	}
	
	public double getCost() {
		return this.cost;
	}

	
	public void setDate(LocalDateTime date) {
		this.date=date;
	}
	
	public void setCost(double cost) {
		this.cost=cost;
	}

	public ArrayList<MenuItem> getItemsSelected() {
		return itemsSelected;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
}
