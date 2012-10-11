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
	
	public boolean isDead(){
		if (hull <= 0)
			return true;
		else
			return false;
	}
	
	public void setInitialShip(){
		player.Ship = ShipType.fighter;
		
	}
	
	public enum ShipType {
		
		fighter(100,20,100,100),hauler(120,100,80,700),bullDog(200,50,50,300),carrier(60,150,80,350),yellowJacket(140,30,150,300),destroyer(500,50,100,700),heat(100,100,100,400);
		
		private ShipType(int hull,int cargo,int fuel, int cost){
			this.hull = hull;
	        cargoCapacity = cargo;
	        fuelCapacity = fuel;
	        this.cost = cost;
		}
		
		
	
}