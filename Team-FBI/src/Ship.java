import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;

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
	private int cargoNumber;
	private String name;
	private ShipType st;
	private Goods currentGoods;
	private Image shipImage;
	private double currentFuel;
	private double fuelPerMove;
	
	/**
	 * A constructor that takes a shiptype
	 * @param st Ship type that specify which ship to create
	 */
	public Ship(ShipType st){
		try {
		    shipImage = ImageIO.read(new File("initialship.jpg"));
		} catch (IOException e) {
		}
		this.st=st;
		name=st.getName();
		fuelPerMove = 1.4;
		currentFuel = st.getFuel();
		hull=st.getHull();
		cargoCapacity=st.getCarco();
		cost=st.getCost();
		fuelCapacity=st.getFuel();
		cargoNumber =0;
		currentGoods = new Goods();
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
	public void setFuelPerMove(double fpm)
	{
		fuelPerMove = fpm;
	}
	public double getFuelPerMove()
	{
		return fuelPerMove;
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
	public void setCurrentFuel(double decrease)
	{
		currentFuel -= decrease;
	}
	public double getCurrentFuel()
	{
		return decimalFormat(currentFuel);
	}
	public double decimalFormat(double longDouble)
	{
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(longDouble));
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
	
	public void setCurrentGoods(Goods currentGoods) 
	{
		this.currentGoods = currentGoods;
	}
	
	public int increase(int index){
		if(cargoNumber >= cargoCapacity){
			return 1;
		}
		else{
			switch(index){
		case 0:
			currentGoods.setWater(1);
			cargoNumber+=1;
			break;
		case 1:
			currentGoods.setFurs(1);
			cargoNumber+=1;
			break;
		case 2:
			currentGoods.setFood(1);
			cargoNumber+=1;
			break;
		case 3:
			currentGoods.setOre(1);
			cargoNumber+=1;
			break;
		case 4:
			currentGoods.setGames(1);
			cargoNumber+=1;
			break;
		case 5:
			currentGoods.setFirearms(1);
			cargoNumber+=1;
			break;
		case 6:
			currentGoods.setMedicines(1);
			cargoNumber+=1;
			break;
		case 7:
			currentGoods.setMachines(1);
			cargoNumber+=1;
			break;
		case 8:
			currentGoods.setNarcotics(1);
			cargoNumber+=1;
			break;
		case 9:
			currentGoods.setRobots(1);
			cargoNumber+=1;
			break;
		}
	 return 0;
	  }
	}
	
	public int decrease(int index){
		int flag = 0;
		if(cargoNumber < 0){
			flag = 1;
			return flag;
		}
		else{
			switch(index){
		case 0:
			if(currentGoods.getWater() > 0){
				currentGoods.setWater(-1);
				cargoNumber-=1;
				flag = 0;
				return currentGoods.getWater();
			}
			else{
				return currentGoods.getWater();
			}
			case 1:
			if(currentGoods.getFurs() > 0){
				currentGoods.setFurs(-1);
				cargoNumber-=1;
				flag = 0;
				return currentGoods.getFurs();
			}
			else
			return currentGoods.getFurs();
		case 2:
			if(currentGoods.getFood() > 0){
				currentGoods.setFood(-1);
				cargoNumber-=1;
				return currentGoods.getFood();
			}
			else
				return currentGoods.getFood();
		case 3:
			if(currentGoods.getOre() > 0){
				currentGoods.setOre(-1);
				cargoNumber-=1;
				return currentGoods.getOre();
			}
			else
				return currentGoods.getOre();
		case 4:
			if(currentGoods.getGames() > 0){
				currentGoods.setGames(-1);
				cargoNumber-=1;
				return currentGoods.getGames();
			}
			else
				return currentGoods.getGames();
		case 5:
			if(currentGoods.getFirearms() > 0){
				currentGoods.setFirearms(-1);
				cargoNumber-=1;
				return currentGoods.getFirearms();
			}
			else
				return currentGoods.getFirearms();
		case 6:
			if(currentGoods.getMedicines() > 0){
				currentGoods.setMedicines(-1);
				cargoNumber-=1;
				return currentGoods.getMedicines();
			}
			else
				return currentGoods.getMedicines();
		case 7:
			if(currentGoods.getMachines() > 0){
				currentGoods.setMachines(-1);
				cargoNumber-=1;
				return currentGoods.getMachines();
			}
			else
				return currentGoods.getMachines();
			
		case 8:
			if(currentGoods.getNarcotics() > 0){
				currentGoods.setNarcotics(-1);
				cargoNumber-=1;
				return currentGoods.getNarcotics();
			}
			else
				return currentGoods.getNarcotics();

		case 9:
			if(currentGoods.getRobots() > 0){
				currentGoods.setRobots(-1);
				cargoNumber-=1;
				return currentGoods.getRobots();
			}
			else
				return currentGoods.getRobots();

		}
			return -10000;
	  }
	}
	public void setPicture(String i)
	{
		try {
		    shipImage = ImageIO.read(new File("i"));
		} catch (IOException e) {
		}
	}
	public Image getPic()
	{
		return shipImage;
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