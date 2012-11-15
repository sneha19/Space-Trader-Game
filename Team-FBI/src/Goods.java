// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
import java.io.Serializable;
import java.util.Vector;
/**This class will hold all the goods and amount of goods player has
 * @author team-fbi
 * @version 1.0 */
public class Goods  implements Serializable{
	/**Constructor, to set all goods amount to zero at beginning*/
	public Goods(){
		water =0;
		furs = 0;
		food = 0;
		ore = 0;
		games = 0;
		firearms = 0;
		medicines = 0;
		machines = 0;
		narcotics = 0;
		robots = 0;
	}
	
	/** 
	 * getter, get the water amount
	 * @return water */
	public int getWater() {
		return water;
	}
	
	/** 
	 * setter, set the water amount
	 * @param water
	 */
	public void setWater(int water) {
		this.water += water;
	}
	
	/**
	 * getter, get the fur amount
	 * @return fur */
	public int getFurs() {
		return furs;
	}
	
	/**
	 * setter, set the fur amount
	 * @param furs
	 */
	public void setFurs(int furs) {
		this.furs += furs;
	}
	
	/** 
	 * getter, get the food amount
	 * @return food 
	 */
	public int getFood() {
		return food;
	}
	
	/** 
	 * setter, set the food amount
	 * @param food
	 */
	public void setFood(int food) {
		this.food += food;
	}
	
	/**
	 * getter, get the ore amount
	 * @return ore 
	 */
	public int getOre() {
		return ore;
	}
	
	/**
	 * setter, set the ore amount
	 * @param ore
	 */
	public void setOre(int ore) {
		this.ore += ore;
	}
	
	/** 
	 * getter, get the game amount
	 * @return games 
	 */
	public int getGames() {
		return games;
	}
	
	/**
	 * setter, set the game amount
	 * @param games
	 */
	public void setGames(int games) {
		this.games += games;
	}
	
	/** 
	 * getter, get the firearms amount 
	 * @return firearms 
	 */
	public int getFirearms() {
		return firearms;
	}
	
	/**
	 * setter, set the firearms amount
	 * @param firearms
	 */
	public void setFirearms(int firearms) {
		this.firearms += firearms;
	}
	
	/** 
	 * getter, get the medicine amount
	 * @return medicines 
	 */
	public int getMedicines() {
		return medicines;
	}
	
	/**
	 * setter, set the medicine amount
	 * @param medicines
	 */
	public void setMedicines(int medicines) {
		this.medicines += medicines;
	}
	
	/**
	 * getter, get the machine amount
	 * @return machines 
	 */
	public int getMachines() {
		return machines;
	}
	
	/**
	 * setter, set the machines amount
	 * @param machines
	 */
	public void setMachines(int machines) {
		this.machines += machines;
	}
	
	/**
	 * getter, get the narcotics amount
	 * @return narcotics 
	 */
	public int getNarcotics() {
		return narcotics;
	}
	
	/**
	 * setter, set the narcotics amount
	 * @param natcotics
	 */
	public void setNarcotics(int natcotics) {
		this.narcotics += natcotics;
	}
	
	/**
	 * getter, get the robots amount
	 * @return robots 
	 */
	public int getRobots() {
		return robots;
	}
	
	/**
	 * setter, set the robots amount
	 * @param robots
	 */
	public void setRobots(int robots) {
		this.robots += robots;
	}
	
	/**
	 * getter, get the total amount
	 * @return total amount of goods 
	 */
	public int getTotal(){
		return water + furs + food + ore + games + firearms + 
				medicines + machines + narcotics + robots;
	}
	
	/**
	 * Field water.
	 */
	private int water;
	
	/**
	 * Field furs.
	 */
	private int furs;
	
	/**
	 * Field food.
	 */
	private int food;
	
	/**
	 * Field ore.
	 */
	private int ore;
	
	/**
	 * Field games.
	 */
	private int games;
	
	/**
	 * Field firearms.
	 */
	private int firearms;
	
	/**
	 * Field medicines.
	 */
	private int medicines;
	
	/**
	 * Field machines.
	 */
	private int machines;
	
	/**
	 * Field narcotics.
	 */
	private int narcotics;
	
	/**
	 * Field robots.
	 */
	private int robots;
}