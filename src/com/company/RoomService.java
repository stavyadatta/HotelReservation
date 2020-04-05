import java.util.Date;
public class RoomService {
	private menu menu;
	private Date date;
	private double cost;
	
	public RoomService(menu menu,Date date,double cost){
		this.date=date;
		this.menu=menu;
		this.cost=cost;
	}
	
	public menu getMenu() {
		return this.menu;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public double getCost() {
		return this.cost;
	}
	
	public void setMenu(menu menu) {
		this.menu=menu;
	}
	
	public void setDate(Date date) {
		this.date=date;
	}
	
	public void setCost(double cost) {
		this.cost=cost;
	}
	
	
	
	
	 
}
