
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.DecimalFormat;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

/**
 * This is a ship class that holds the critical information of a ship
 * 
 * @author Sneha, Guang
 */
public class Ship implements Serializable{
	private int hull;
	private int cargoCapacity;
	private int fuelCapacity;
	private int cost;
	private int cargoNumber;
	private String name;
	private ShipType st;
	private Goods currentGoods;
	private transient Image shipImage;
	private double currentFuel;
	private double fuelPerMove;
	private double maxHull;
	
//	
//	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
//		out.writeObject(new String("shipimg"));
//		ImageWriter writer = (ImageWriter) ImageIO.getImageWritersBySuffix("jpg").next();
//	        writer.setOutput(ImageIO.createImageOutputStream(out));
//	        ImageWriteParam param = writer.getDefaultWriteParam();
//	        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
//	        param.setCompressionQuality(0.85f);
//	        writer.write(null, new IIOImage((RenderedImage) shipImage, null, null), param);
//	}


	/**
	 * A constructor that takes a shiptype
	 * @param st Ship type that specify which ship to create
	 */
	public Ship(ShipType st){
		try {
			shipImage = ImageIO.read(new File("img/shiptest.png"));
		} catch (IOException e) {
		}
		this.st=st;
		name=st.getName();
		fuelPerMove = fuelPerMove();
		currentFuel = st.getFuel();
		hull=st.getHull();
		cargoCapacity=st.getCarco();
		cost=st.getCost();
		fuelCapacity=st.getFuel();
		cargoNumber =0;
		currentGoods = new Goods();
		maxHull = st.getHull();
	}
	public double getMaxHull()
	{
		return maxHull;
	}
	public double fuelPerMove()
	{

		if("fighter".equals(st.name().trim()))
			fuelPerMove = 1.0;
		if("hauler".equals(st.name().trim()))
			fuelPerMove = 1.5;
		if("bullDog".equals(st.name().trim()))
			fuelPerMove = 2.0;
		if("carrier".equals(st.name().trim()))
			fuelPerMove = 1.7;
		if("yellowJacket".equals(st.name().trim()))
			fuelPerMove = 1.3;
		if("destroyer".equals(st.name().trim()))
			fuelPerMove = 2.5;
		if("heat".equals(st.name().trim()))
			fuelPerMove = .9;
		return fuelPerMove;

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
	 * Set the fuel consumption when ship moves
	 * @param fpm
	 */
	public void setFuelPerMove(double fpm)
	{
		fuelPerMove = fpm;
	}
	/**
	 * Get the fuel consumption when ship moves
	 * @return fuelPerMove
	 */
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
	/**
	 * Setter, set current fuel
	 * @param decrease the dcresement value
	 */
	public void setCurrentFuel(double decrease)
	{
		currentFuel -= decrease;
	}
	/**
	 * updated the fuel to increase it
	 * @param increase amount to increase
	 */
	public void updateCurrentFuel(double increase)
	{
		currentFuel += increase;
	}
	/**
	 * Get current Fuel
	 * @return currentFuel
	 */
	public double getCurrentFuel()
	{
		return decimalFormat(currentFuel);
	}
	/**
	 * Change a double to decimal format
	 * @param longDouble
	 * @return decimal format
	 */
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
	/**
	 * Get current goods
	 * @return currentGoods
	 */
	public Goods getCurrentGoods() {
		return currentGoods;
	}
	/**
	 * Set current goods
	 * @param currentGoods
	 */
	public void setCurrentGoods(Goods currentGoods) 
	{
		this.currentGoods = currentGoods;
	}
	/**
	 * Increase the corrent item amount every time player buy stuff
	 * @param index
	 * @return a int, if method go through return 0, otherwise return 1
	 */
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
	/**
	 * Decrese the item amount every time player sell
	 * @param index of the item
	 * @return 0 if fail, 1 if success
	 */
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
	/**
	 * Set the picture of ship
	 * @param i the image of ship
	 */
	public void setPicture(String i)
	{
		try {
			shipImage = ImageIO.read(new File("i"));
		} catch (IOException e) {
		}
	}
	/**
	 * get the image of the ship
	 * @return shipImage
	 */
	public Image getPic()
	{
		return shipImage;
	}
	
	public void afterLoad(){
		try {
			shipImage = ImageIO.read(new File("img/shiptest.png"));
		} catch (IOException e) {
		}
	}
	

}