package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Room {

	public enum RoomType {
        SINGLE, DOUBLE, DELUXE, VIP
    }
	
    public enum BedType {
        SINGLE_BED, DOUBLE_BED, MASTER_BED
    }

	public enum RoomStatus {
        VACANT, OCCUPIED, RESERVED, UNDER_MAINTENANCE
    }

    public enum FacingView {
        CITY_VIEW, SEA_VIEW, PARK_VIEW, POOL_VIEW, MOUNTAIN_VIEW, NO_VIEW
    }
    

    private double roomRate;
    private double  roomWeekendRate;
    private int roomFloor;
    private int roomNumber;
    private String completeRoomNumber;
    private boolean wifiEnabled;
    private boolean smoking;
    private RoomType roomType;
    private BedType bedType;
    private RoomStatus status;
    private FacingView facing;
    private ArrayList<RoomService> roomServices;
    private Reservation reservation;

	public Room(){
		roomServices = new ArrayList<RoomService>();
	}


	public double getRoomRate() {
		return roomRate;
	}
	public void setRoomRate(double roomRate) {
		this.roomRate = roomRate;
	}
	public double getRoomWeekendRate() {
		return roomWeekendRate;
	}
	public void setRoomWeekendRate(double roomWeekendRate) {
		this.roomWeekendRate = roomWeekendRate;
	}
	public int getRoomFloor() {
		return roomFloor;
	}
	public void setRoomFloor(int roomFloor) {
		this.roomFloor = roomFloor;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public boolean isWifiEnabled() {
		return wifiEnabled;
	}
	public void setWifiEnabled(boolean wifiEnabled) {
		this.wifiEnabled = wifiEnabled;
	}
	public boolean isSmoking() {
		return smoking;
	}
	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}
	public RoomType getRoomType() {
		return roomType;
	}
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}
	public BedType getBedType() {
		return bedType;
	}
	public void setBedType(BedType bedType) {
		this.bedType = bedType;
	}
	public RoomStatus getStatus() {
		return status;
	}
	public void setStatus(RoomStatus status) {
		this.status = status;
	}
	public FacingView getFacing() {
		return facing;
	}
	public void setFacing(FacingView facing) {
		this.facing = facing;
	}

	public String getCompleteRoomNumber() {
		return completeRoomNumber;
	}

	public void setCompleteRoomNumber(){
		this.completeRoomNumber = String.format("0%d-0%d", this.roomFloor, this.roomNumber);
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public ArrayList<RoomService> getRoomServices() {
		return this.roomServices;
	}

	public void addRoomService(RoomService roomService) {
		this.roomServices.add(roomService);
	}

	private double totalCostRoomServices(){
		double price = 0.0;
		for(RoomService roomService: this.roomServices){
			price = price + roomService.getCost();
		}
		return price;
	}

	public void printRoomServices(){
		for(RoomService roomService: this.roomServices){
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String time = dtf.format(roomService.getDate());
			System.out.printf("the time is %s\n", time);
			for(MenuItem menuItem: roomService.getItemsSelected()){
				System.out.printf("The item description is %s and name is %s\n", menuItem.getDescription(),
						menuItem.getName());
			}
		}
	}

	public static void printingRoomTypes(){
		for(int i = 0; i<RoomType.values().length;i++){
			System.out.printf("%d for %s\n", i, RoomType.values()[i]);
		}
	}
	public static void printingBedType(){
		for(int i = 0; i<BedType.values().length;i++){
			System.out.printf("%d for %s\n", i, BedType.values()[i]);
		}
	}
	public static void printingFacingView(){
		for(int i = 0; i<FacingView.values().length;i++){
			System.out.printf("%d for %s\n", i, FacingView.values()[i]);
		}
	}
	private void printingRoomService(){
		System.out.println("Item name    Item Description    Price    id");
		for(RoomService roomService: this.getRoomServices()){
			for(MenuItem menuItem: roomService.getItemsSelected()){
				System.out.printf("%s    %s    %.2f    %d \n for room number %s\n",menuItem.getName(),
						menuItem.getDescription(), menuItem.getPrice(),
						menuItem.getId(), this.getCompleteRoomNumber());
			}
		}
	}

	public double roomCost(Date fromDate, Date toDate){
		LocalDate fromLocalDate = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate toLocalDate = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period period = Period.between(fromLocalDate, toLocalDate);
		int diff = period.getDays();
		if(diff <=0){
			diff = 1;
		}

		Calendar fromCal = Calendar.getInstance();
		Calendar toCal = Calendar.getInstance();
		fromCal.setTime(fromDate);
		toCal.setTime(toDate);

		int numOfWeekends = 0;
		while(fromCal.before(toCal)){
			if(Calendar.SATURDAY == fromCal.get(Calendar.DAY_OF_WEEK) ||
					Calendar.SUNDAY == fromCal.get(Calendar.DAY_OF_WEEK)){
				numOfWeekends++;
			}
		}
		if(diff > 1){
			diff = diff - numOfWeekends;
		}

		double price = this.getRoomRate() * diff + this.getRoomWeekendRate() * numOfWeekends
				+ this.totalCostRoomServices();
		this.printingRoomService();
		return price;
	}

	public String roomDetails(){
		String details = String.format("The Room number is %s with room type %s and room cost %.2f",
				this.getCompleteRoomNumber(), this.getRoomType(), this.getRoomRate());

		return details;
	}


}
