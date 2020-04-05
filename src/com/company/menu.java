
public class menu {
   private menuItem[] menuItems;
   
   public void displayMenuItems() {
	   System.out.println("The MenuItems");
	   for(int i=0;i<menuItems.length;i++) {
		   System.out.println(menuItems[i].getName()+"  "+menuItems[i].getDescription()+"  "+menuItems[i].getPrice());
	   }
   }
}
