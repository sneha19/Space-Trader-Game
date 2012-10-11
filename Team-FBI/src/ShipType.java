/**
 * This is the enum type that holds all the ship and their specifications.	
 * @author Sneha, Guang
 *
 */
public enum ShipType {
		
		fighter("Fighter",100,20,100,100),hauler("Hauler",120,100,80,700),bullDog("Bulldog",200,50,50,300),carrier("Carrier",60,150,80,350),yellowJacket("Yellow Jacket",140,30,150,300),destroyer("Destroyer",500,50,100,700),heat("Heat",100,100,100,400);
		private final int hull;
		private final int cargo;
		private final int fuel;
		private final int cost;
		private final String name;
		/**
		 * A constructor that retrieve 5 specs of one ship type
		 * @param name the name of the ship
		 * @param hull the hull strength of the ship
		 * @param cargo the cargo capacity of the ship
		 * @param fuel the fuel capacity of the ship
		 * @param cost the cost of the ship
		 */
		private ShipType(String name,int hull,int cargo,int fuel, int cost){
			this.hull = hull;
	        this.cargo = cargo;
	        this.fuel = fuel;
	        this.cost = cost;
	        this.name=name;
		}
		/**
		 * Getter, get hull strength
		 * @return hull
		 */
		int getHull(){
			return hull;
		}
		/**
		 * Getter, get cargo capacity
		 * @return cargo the cargo capacity
		 */
		int getCarco(){
			return cargo;
		}
		/**
		 * Getter, get the fuel reading of the ship
		 * @return fuel how much fuel does the ship have
		 */
		int getFuel(){
			return fuel;
		}
		/**
		 * Getter, get the cost of the ship
		 * @return cost the cost of the ship
		 */
		int getCost(){
			return cost;
		}
		/**
		 * Getter, get the name of the ship
		 * @return name the name of the ship
		 */
		String getName(){
			return name;
		}
	}