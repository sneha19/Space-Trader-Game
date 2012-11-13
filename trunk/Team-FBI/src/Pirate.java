import java.util.*;

/** This is a pirate class
 * It makes a pirate, that can be encountered randomly 
 * when a player travels between planets
 * 
 * @author Sneha Ganesh
 * @version 1.0
 */
public class Pirate {
	private Player pirate;
	private ShipType st;
	//private int _numPirate;
	//public UIMain _unnamed_UIMain_;
	//public Goverments _unnamed_Goverments_;
	
	public Pirate(){
		pirate = new Player("Pirate");
		pirate.setCash((int)Math.random(2000)+1);
		int a = Math.random(6)+1;
		Goods g = new Goods((int)Math.random(100)+1,(int)Math.random(100)+1,(int)Math.random(100)+1,(int)Math.random(100)+1,(int)Math.random(100)+1,(int)Math.random(100)+1,(int)Math.random(100)+1,(int)Math.random(100)+1,(int)Math.random(100)+1);
		switch(a){
			case 1:
				pirate.setShip(new Ship(st.fighter));
				break;
			case 2:
				pirate.setShip(new Ship(st.hauler));
				break;
			case 3:
				pirate.setShip(new Ship(st.bulldog));
				break;
			case 4:
				pirate.setShip(new Ship(st.carrier));
				break;
			case 5:
				pirate.setShip(new Ship(st.yellowJacket));
				break;
			case 6:
				pirate.setShip(new Ship(st.destroyer));
				break;
			case 7:
				pirate.setShip(new Ship(st.heat));
				break;
				
	     }
   }
	public Player getMerchant(){
		return merchant;
	}
	
	public void setMerchant(Player player){
		merchant = player;
	}
}