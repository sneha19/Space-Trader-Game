import java.util.Vector;

public class Goods {
	private int water;
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
	public int getNatcotics() {
		return natcotics;
	}
	public void setNatcotics(int natcotics) {
		this.natcotics += natcotics;
	}
	public int getRobots() {
		return robots;
	}
	public void setRobots(int robots) {
		this.robots = robots;
	}
	private int furs = 0;
	private int food = 0;
	private int ore = 0;
	private int games = 0;
	private int firearms = 0;
	private int medicines = 0;
	private int machines = 0;
	private int natcotics = 0;
	private int robots = 0;
	public Vector<Trade> _unnamed_Trade_ = new Vector<Trade>();
}