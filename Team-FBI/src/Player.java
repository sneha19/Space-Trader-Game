import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;

/**
 * This is the class that represent a user. It is a info-holder for all the fields a player should have.
 * @author Guang Lu
 *
 */

public class Player implements Serializable {
	private String name;
	private Point position;
	private int cash;
	private int score;
	private int health;
	private int pilot;
	private int fighter;
	private int trader;
	private int engineer;
	private Ship ship;
	private int difficulty;
	private int availableSkillPoints;
	private ShipType st;
	
	/**
	 * The player take a string as input represent the name of the player
	 * @param name the name of the player
	 */
	public Player(String name){
		
		this.name=name;
		cash=1000;
		position= new Point(0,0);
		score=0;
		health=100;
		pilot=0;
		fighter=0;
		trader=0;
		engineer=0;
		availableSkillPoints=16;
		Start s = new Start();
		difficulty=s.getDifficulty();
		ship = new Ship(st.fighter);
	}
	
	//public void computeAvaSkillPoints()
	/**
	 * Getter,return the available skill points 
	 * @return availableSkillPoints
	 */
	public int getAvailableSkillPoints(){
		return availableSkillPoints;
	}
	
	/**
	 * Setter, set the Available Skill Points
	 * @param change + or - points
	 * @return true if set was successful
	 */
	public boolean setAvailableSkillPoints(int change){
		availableSkillPoints+=change;
		return true;
	}
	/**
	 * Setter, set the health of the player
	 * @param health new health
	 * @return true if set was successful
	 */
	public boolean setHealth(int health){
		this.health=health;
		return true;
	}
	/**
	 * Setter,set the cash of the player
	 * @param changeValue how much to add or subtract from current cash
	 * @return true if set was successful
	 */
	public boolean setCash(int changeValue){
		cash+=changeValue;
		return true;
	}
	/**
	 * Setter, set the position of the player
	 * @param newPosition new position
	 * @return true if set was successful
	 */
	public boolean setPosition(Point newPosition){
		position = newPosition;
		return true;
	}
	/**
	 * Setter, set the score of the player
	 * @param changeValue change of points
	 * @return true if set was successful
	 */
	public boolean setScore(int changeValue){
		score+=changeValue;
		return true;
	}
	/**
	 * Setter, set the pilot skill points
	 * @param changeValue change of points
	 * @return true if set was successful
	 */
	public boolean setPilot(int changeValue){
		pilot+=changeValue;
		return true;
	}
	/**
	 * Setter, set the fighter skill points
	 * @param changeValue change of points
	 * @return true if set was successful
	 */
	public boolean setFighter(int changeValue){
		fighter+=changeValue;
		return true;
	}
	/**
	 * Setter, set the trader skill points
	 * @param changeValue change of points
	 * @return true if set was successful
	 */
	public boolean setTrader(int changeValue){
		trader+=changeValue;
		return true;
	}
	/**
	 * Setter, set the engineer skill points
	 * @param changeValue change of points
	 * @return true if set was successful
	 */
	public boolean setEngineer(int changeValue){
		engineer+=changeValue;
		return true;
	}
	/**
	 * Getter, get the player name
	 * @return name player name
	 */
	public String getName(){
		return name;
	}
	/**
	 * Getter, get the health of the player
	 * @return health health of the player
	 */
	public int getHealth(){
		return health;
	}
	/**
	 * Getter, get the cash of the player
	 * @return cash cash of player
	 */
	public int getCash(){
		return cash;
	}
	/**
	 * Getter, get the position of the player
	 * @return position position of the player
	 */
	public Point getPosition(){
		return position;
	}
	/**
	 * Getter, get the current score of the player
	 * @return score score of player
	 */
	public int getScore(){
		return score;
	}
	/**
	 * Getter, get fighter skill points
	 * @return fighter fighter skill points
	 */
	public int getFighter(){
		return fighter;
	}
	/**
	 * Getter, get trader skill points
	 * @return trader trader skill points
	 */
	public int getTrader(){
		return trader;
	}
	/**
	 * Getter, get the engineer skill points
	 * @return engineer engineer skill points
	 */
	public int getEngineer(){
		return engineer;
	}
	/**
	 * Getter, get the pilot skill points
	 * @return pilot pilot skill points
	 */
	public int getPilot(){
		return pilot;
	}
	/**
	 * Setter, set the difficulty of the fame
	 * @param value the difficulty value
	 * @return true if set is successful
	 */
	public boolean setDifficulty(int value){
		difficulty = value;
		return true;
	}
	/**
	 * Getter, get the difficulty of the game
	 * @return difficulty the difficulty of the game
	 */
	public int getDifficulty(){
		return difficulty;
	}
	
	/**
	 * Setter, set a new ship for the player
	 * @param ship new ship
	 * @return true if set is successful
	 */
	public boolean setShip(Ship ship) {
		this.ship=ship;
		return true;
	}
	/**
	 * Getter, get the current ship of the player
	 * @return ship the current ship
	 */
	public Ship getShip(){
		return ship;
	}
	/**
	 * Setter, set the name of the player, this method should only be called when initializing the game after the start screen
	 * @param newName the new name
	 * @return true if set is successful
	 */
	public boolean setName(String newName){
		name=newName;
		return true;
	}
}