package HRPS;

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
    
    private double 	roomRate;
    private double  roomWeekendRate;
    private int roomFloor;
    private int roomNumber;
    private boolean wifiEnabled;
    private boolean smoking;
    private RoomType roomType;
    private BedType bedType;
    private RoomStatus status;
    private FacingView  facing;
    
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
	
}
