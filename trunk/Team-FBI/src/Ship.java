/**
 * This is a ship class that holds the critical information of a ship
 * 
 * @author Sneha, Guang
 */
public class Ship {
	private int hull;
	private int cargoCapacity;
	private int fuelCapacity;
	private int cost;
	private String name;
	private ShipType st;
	
	private Goods currentGoods;
	
	
	/**
	 * A constructor that takes a shiptype
	 * @param st Ship type that specify which ship to create
	 */
	public Ship(ShipType st){
		this.st=st;
		name=st.getName();
		hull=st.getHull();
		cargoCapacity=st.getCarco();
		cost=st.getCost();
		fuelCapacity=st.getFuel();
	}
	/**
	 * Setter, set the hull strength
	 * @param hull hull strength
	 */
	public void setHull(int hull){
		this.hull = hull;
	}
	/**
	 * Getter, get the hull strength
	 * @return hull hull strength
	 */
	public int getHull(){
		return hull;
	}
	/**
	 * Setter, set the cargo capacity
	 * @param cargo new cargo capacity
	 */
	public void setCargoCapacity(int cargo){
		cargoCapacity = cargo;
	}
	/**
	 * Getter, get the cargo capacity
	 * @return cargoCapacity
	 */
	public int getCargoCapacity(){
		return(cargoCapacity);
	}
	/**
	 * Setter, set the fuel capacity
	 * @param fuel the new fuel capacity
	 */
	public void setFuelCapacity(int fuel){
		fuelCapacity = fuel;
	}
	/**
	 * Getter, get the fuel capacity 
	 * @return fuelCapacity the current fuel capacity
	 */
	public int getFuelCapacity(){
		return(fuelCapacity);
	}
	/**
	 * setter, set the cost of the ship
	 * @param cost the new cost of the ship
	 */
	public void setCost(int cost){
		this.cost = cost;
	}
	/**
	 * Getter, get the cost of the ship
	 * @return
	 */
	public int getCost(){
		return cost;
	}
	/**
	 * Determine if the player is dead, meaning the hull stength of the ship is 0
	 * @return boolean true if dead, false if alive
	 */
	public boolean isDead(){
		if (hull <= 0)
			return true;
		else
			return false;
	}
	/**
	 * Getter, get the name of the ship
	 * @return name the name of the ship
	 */
	public String getName(){
		return name;
	}
	
	public Goods getCurrentGoods() {
		return currentGoods;
	}
	public void setCurrentGoods(Goods currentGoods) {
		this.currentGoods = currentGoods;
	}
	
	/*
	public void setInitialShip(){
		player.ship = ShipType.fighter;
		
	}*/
	
	/*
	public void setFuelAfterMove() {
		throw new UnsupportedOperationException();
	}*/


}