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
<<<<<<< .mine
		cargoNumber =0;
=======
		currentGoods = new Goods();
>>>>>>> .r93
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
			currentGoods.setNatcotics(1);
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
			}
			else
				flag = 1;
			break;
		case 1:
			if(currentGoods.getFurs() > 0){
				currentGoods.setFurs(-1);
				cargoNumber-=1;
				flag = 0;
			}
			else
				flag = 1;
			
			break;
		case 2:
			if(currentGoods.getFood() > 0){
				currentGoods.setFood(-1);
				cargoNumber-=1;
				flag = 0;
			}
			else
				flag = 1;
			
			break;
		case 3:
			if(currentGoods.getOre() > 0){
				currentGoods.setOre(-1);
				cargoNumber-=1;
				flag = 0;
			}
			else
				flag = 1;
			
			break;
		case 4:
			if(currentGoods.getGames() > 0){
				currentGoods.setGames(-1);
				cargoNumber-=1;
				flag = 0;
			}
			else
				flag = 1;
			
			break;
		case 5:
			if(currentGoods.getFireamrs() > 0){
				currentGoods.setFirearms(-1);
				cargoNumber-=1;
				flag = 0;
			}
			else
				flag = 1;
			
			break;
		case 6:
			if(currentGoods.getMedicines() > 0){
				currentGoods.setMedicines(-1);
				cargoNumber-=1;
				flag = 0;
			}
			else
				flag = 1;
			
			break;
		case 7:
			if(currentGoods.getMachines() > 0){
				currentGoods.setMachines(-1);
				cargoNumber-=1;
				flag = 0;
			}
			else
				flag = 1;
			
			break;
		case 8:
			if(currentGoods.getNatcotics() > 0){
				currentGoods.setNatcotics(-1);
				cargoNumber-=1;
				flag = 0;
			}
			else
				flag = 1;
			
			break;
		case 9:
			if(currentGoods.getRobots() > 0){
				currentGoods.setRobots(-1);
				cargoNumber-=1;
				flag = 0;
			}
			else
				flag = 1;
			
			break;
		}
	 return flag;
	  }
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