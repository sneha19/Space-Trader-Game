/** Ship class that makes a default ship
 * Also maes a fighter, hauler... shipss
 * 
 * @author Sneha Ganesh
 * @version 1.0 
 */
public class Ship {
	private int hull;
	private int cargoCapacity;
	private int fuelCapacity;
	private int cost;
	public Player player;

	/** Increaments the fuel for a ship
	 * 
	 */
	public void setFuelAfterMove() {
		throw new UnsupportedOperationException();
	}
	
	/** Sets the hull for the ship
	 * @param hull inout variable that hold hull strength
	 */
	public void setHull(int hull){
		this.hull = hull;
	}
	
	/** Getter method for hull
	 * 
	 * @return hull hull strength of ship
	 */
	public int gethull(){
		return hull;
	}
	
	/** Setter method for cargo capacity
	 * 
	 * @param cargo stores cargo capacity of ship
	 */
	public void setCargoCapacity(int cargo){
		cargoCapacity = cargo;
	}
	
	/** Getter method for cargo capacity
	 * 
	 * @return cargoCapacity holds cargo capacity of ship
	 */
	public int getCargoCapacity(){
		return(cargoCapacity);
	}
	
	/**
	 * Sets fuel capcity
	 * @param fuel stores fuel capacity of ship
	 */
	public void setFuelCapacity(int fuel){
		fuelCapacity = fuel;
	}
	
	/** Getter for fuel capacity
	 * 
	 * @return fuelCapacity holds fuel capcity for ship
	 */
	public int getFuelCapacity(){
		return(fuelCapacity);
	}
	
	/** Setter for cost
	 * 
	 * @param cost holds cost for ship
	 */
	public void setCost(int cost){
		this.cost = cot;
	}
	
	/** Getter for cost
	 * 
	 * @return cost holds cost of ship
	 */
	public int getCost(){
		return cost;
	}
	
	/** Checks if the ship is alive or dead i.e. checks hull strength
	 * 
	 * @return hull holds hull strength
	 */
	public boolean isDead(){
		if (hull <= 0)
			return true;
		else
			return false;
	}
	
	/** Sets intial ship type as fighter
	 * 
	 */
	public void setInitialShip(){
		player.Ship = ShipType.fighter;
		
	}
	
	/** Enum class for ShipType
	 * Enumerates the different types of ships
	 * @author Sneha
	 * @version 1.0
	 */
	public enum ShipType {
		
		fighter(100,20,100,100),hauler(120,100,80,700),bullDog(200,50,50,300),carrier(60,150,80,350),yellowJacket(140,30,150,300),destroyer(500,50,100,700),heat(100,100,100,400);
		
		/** Constructor for ShipType
		 * Sets initial values for hull,cargo,fuel and cost
		 * @param hull stores value for hull
		 * @param cargo stores value for cargo Capacity
		 * @param fuel stores value for fuel Capacity
		 * @param cost stores cost of ship
		 */
		private ShipType(int hull,int cargo,int fuel, int cost){
			this.hull = hull;
	        cargoCapacity = cargo;
	        fuelCapacity = fuel;
	        this.cost = cost;
		}
		
		
	
}