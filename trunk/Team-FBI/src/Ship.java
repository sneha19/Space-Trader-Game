public abstract class Ship {
	private int hull;
	private int cargoCapacity;
	private int fuelCapacity;
	private int cost;
	public Player player;

	public void setFuelAfterMove() {
		throw new UnsupportedOperationException();
	}
	
	public void setHull(int hull){
		this.hull = hull;
	}
	
	public int gethull(){
		return hull;
	}
	
	public void setCargoCapacity(int cargo){
		cargoCapacity = cargo;
	}
	
	public int getCargoCapacity(){
		return(cargoCapacity);
	}
	
	public void setFuelCapacity(int fuel){
		fuelCapacity = fuel;
	}
	
	public int getFuelCapacity(){
		return(fuelCapacity);
	}
	
	public void setCost(int cost){
		this.cost = cot;
	}
	
	public int getCost(){
		return cost;
	}
	
	
}