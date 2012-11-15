// $codepro.audit.disable numericLiterals, enumerationConstantNamingConvention
import java.io.Serializable;

/**
 * This is the enum type that holds all the ship and their specifications.	
 * @author Sneha, Guang
 *
 * @version $Revision: 1.0 $
 */
public enum ShipType  implements Serializable{
		
		/**
		 * Field fighter.
		 */
		fighter("Fighter", 100, 20, 100, 100),
		
		/**
		 * Field hauler.
		 */
		hauler("Hauler", 120, 100, 80 , 700),
		/**
		 * Field bullDog.
		 */
		bullDog("Bulldog", 200, 50, 50, 300),
		
		/**
		 * Field carrier.
		 */
		carrier("Carrier", 60, 150, 80, 350),
		
		/**
		 * Field yellowJacket.
		 */
		yellowJacket("Yellow Jacket", 140,30,150,300),
		
		/**
		 * Field destroyer.
		 */
		destroyer("Destroyer", 500, 50, 100, 700),
		
		/**
		 * Field heat.
		 */
		heat("Heat", 100, 100, 100, 400);
		
		/**
		 * Field hull.
		 */
		private final int hull;
		
		/**
		 * Field cargo.
		 */
		private final int cargo;
		
		/**
		 * Field fuel.
		 */
		private final int fuel;
		
		/**
		 * Field cost.
		 */
		private final int cost;
		
		/**
		 * Field name.
		 */
		private final String name;
		
		/**
		 * A constructor that retrieve 5 specs of one ship type
		 * @param name the name of the ship
		 * @param hull the hull strength of the ship
		 * @param cargo the cargo capacity of the ship
		 * @param fuel the fuel capacity of the ship
		 * @param cost the cost of the ship
		 */
		private ShipType(String name, int hull, int cargo, int fuel,  int cost){
			this.hull = hull;
	        this.cargo = cargo;
	        this.fuel = fuel;
	        this.cost = cost;
	        this.name=name;
		}
		
		/**
		 * Getter,  get hull strength
		 * @return hull 
		 */
		public int getHull(){
			return hull;
		}
		
		/**
		 * Getter,  get cargo capacity
		 * @return cargo the cargo capacity 
		 */
		public int getCarco(){
			return cargo;
		}
		
		/**
		 * Getter,  get the fuel reading of the ship
		 * @return fuel how much fuel does the ship have
		 */
		public int getFuel(){
			return fuel;
		}
		
		/**
		 * Getter,  get the cost of the ship
		 * @return cost the cost of the ship
		 */
		public int getCost(){
			return cost;
		}
		
		/**
		 * Getter,  get the name of the ship
		 * @return name the name of the ship
		 */
		public String getName(){
			return name;
		}
	}