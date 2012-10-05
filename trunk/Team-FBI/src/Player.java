import java.awt.Point;



public class Player {
	private String name;
	private Point position;
	private int cash;
	private int score;
	private int health;
	private int pilot;
	private int fighter;
	private int trader;
	private int engineer;
	
	
	
	//public Skills skills_;
	//public Planet _unnamed_Planet_;
	public UIMain _unnamed_UIMain_;
	public Ship _unnamed_Ship_;
	
	public Player(String Name){
		this.name=name;
		cash=1000;
		position= new Point(0,0);
		score=0;
		health=100;
		pilot=0;
		fighter=0;
		trader=0;
		engineer=0;
	}
	
	public boolean setHealth(int health){
		this.health=health;
		return true;
	}
	
	public boolean setCash(int changeValue){
		cash+=changeValue;
		return true;
	}
	
	public boolean setPosition(Point newPosition){
		position = newPosition;
		return true;
	}
	
	public boolean setScore(int changeValue){
		score+=changeValue;
		return true;
	}
	
	public boolean setPilot(int changeValue){
		pilot+=changeValue;
		return true;
	}
	
	public boolean setFighter(int changeValue){
		fighter+=changeValue;
		return true;
	}
	
	public boolean setTrader(int changeValue){
		trader+=changeValue;
		return true;
	}
	
	public boolean setEngineer(int changeValue){
		engineer+=changeValue;
		return true;
	}
	
	public String getName(){
		return name;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getCash(){
		return cash;
	}
	
	public Point getPosition(){
		return position;
	}
	
	public int getScore(){
		return score;
	}
	
	public int getFighter(){
		return fighter;
	}
	
	public int getTrader(){
		return trader;
	}
	
	public int getEngineer(){
		return engineer;
	}
	
	public int getPilot(){
		return pilot;
	}
	
	public void ChangeShip(Ship aS) {
		throw new UnsupportedOperationException();
	}
}