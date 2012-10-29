import java.util.Vector;

public class Goods {
	public Goods()
	{
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
	public int getWater() {
		return water;
	}
	public void setWater(int water) {
		this.water += water;
	}
	public int getFurs() {
		return furs;
	}
	public void setFurs(int furs) {
		this.furs += furs;
	}
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food += food;
	}
	public int getOre() {
		return ore;
	}
	public void setOre(int ore) {
		this.ore += ore;
	}
	public int getGames() {
		return games;
	}
	public void setGames(int games) {
		this.games += games;
	}
	public int getFirearms() {
		return firearms;
	}
	public void setFirearms(int firearms) {
		this.firearms += firearms;
	}
	public int getMedicines() {
		return medicines;
	}
	public void setMedicines(int medicines) {
		this.medicines += medicines;
	}
	public int getMachines() {
		return machines;
	}
	public void setMachines(int machines) {
		this.machines += machines;
	}
	public int getNarcotics() {
		return narcotics;
	}
	public void setNarcotics(int natcotics) {
		this.narcotics += natcotics;
	}
	public int getRobots() {
		return robots;
	}
	public void setRobots(int robots) {
		this.robots = robots;
	}
	public int getTotal(){
		return water+furs+food+ore+games+firearms+medicines+machines+narcotics+robots;
	}
	private int water;
	private int furs;
	private int food;
	private int ore;
	private int games;
	private int firearms;
	private int medicines;
	private int machines;
	private int narcotics;
	private int robots;
}