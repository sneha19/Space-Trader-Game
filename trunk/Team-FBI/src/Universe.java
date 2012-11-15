// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, com.instantiations.assist.eclipse.arrayIsStoredWithoutCopying
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
/**
 * The universe contains all the planets
 * @author Guang
 *
 */
public class Universe implements Serializable {

	
	
	private String[] planetNames;
	private Planet[] planet;
	private Random rand;
	private ArrayList<Point> positionList;
	private Planet[][] tempPlanets = new Planet[25][20];
	private StarDockInfo[][] tempStarDock = new StarDockInfo[25][20];

	private Player currPlayer;
	//StarDockInfo stdi = new StarDockInfo(null);
	/**
	 * The constructor of the universe
	 * @param p player
	 */
	public Universe(Player p){
		currPlayer = p;
		try {
			writeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	planet = new Planet[128];
	
	for(int i=0;i<122;i++){
		String name = planetNames[i];
		planet[i]= new Planet(name);
	}
	
	rand = new Random();

	//create all the positions
	positionList = new ArrayList<Point>();
	for(int x=0;x<25;x++){
		for(int y=0;y<20;y++){
			positionList.add(new Point(x,y));
		}	
	}
	
	
	//assign locations
	int m=500;
	for(int i=0;i<122;i++){
	int index = rand.nextInt(m);
	if(index == 0)
		index = rand.nextInt(m);
	planet[i].setLocation(positionList.get(index));
	tempPlanets[positionList.get(index).x][positionList.get(index).y] = planet[i];
	positionList.remove(index);
	m--;
	}
	
	for(int i = 0; i < 5; i++)
	{
		int index = rand.nextInt(m-5);
		if(index < 0)
			index = rand.nextInt(m-5);
		if(index < 0)
			index = rand.nextInt(m-5);
		if(index > 0){
		Point point = positionList.get(index);
		tempStarDock[point.x][point.y] = new StarDockInfo(point,currPlayer);
		positionList.remove(index);
		}
	}
	
	for(int i = 0; i < planet.length; i++)
	{
		if(planet[i] != null){
		Planet pl = planet[i];
		
		if(pl.getLocation().x>=0 && pl.getLocation().x <= 7 && pl.getLocation().y>=0 && pl.getLocation().y <= 10)
			pl.setZone(new Zone(1));
		if(pl.getLocation().x > 7 && pl.getLocation().x <= 13 && pl.getLocation().y>=0 && pl.getLocation().y <= 10)
			pl.setZone(new Zone(2));
		if(pl.getLocation().x > 13 && pl.getLocation().x <= 24 && pl.getLocation().y>=0 && pl.getLocation().y <= 10)
			pl.setZone(new Zone(3));
		if(pl.getLocation().x >= 0 && pl.getLocation().x <= 11 && pl.getLocation().y>10 && pl.getLocation().y <= 19)
			pl.setZone(new Zone(4));
		if(pl.getLocation().x > 11 && pl.getLocation().x <= 24 && pl.getLocation().y>10 && pl.getLocation().y <= 19)
			pl.setZone(new Zone(5));
		}
	}
	
	}
	
	

	/**
	 * Get all the planet names from the text file
	 * @throws IOException
	 */
	public void writeFile() throws IOException
	{
		File file = new File("src/planets.txt");
		  FileReader fr = new FileReader(file);
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  BufferedReader in = new BufferedReader(fr);
		  String line;
		  String[] record = new String[122];
		  int i = 0;
		  while ((line = in.readLine()) != null){ // $codepro.audit.disable nullPointerDereference
			  record[i] = line.trim();
			  i++;
		  }
		  planetNames = record;
		  in.close();
	}
	/**
	 * Draw method will draw all the planets according to their position and color.
	 * @param g Graphics
	 */
    public void draw(Graphics g) {
    	for(int i = 0; i <25; i++)
    		for(int j = 0; j < 20; j++)
    		{
    			if(tempPlanets[i][j] != null)
    				tempPlanets[i][j].draw(g, null);
    			if(tempStarDock[i][j] != null)
    				tempStarDock[i][j].draw(g, new Point(i,j));
    		}
    	//g.drawImage(currPlayer.getShip().getPic(), 30*currPlayer.getPosition().x, 30*currPlayer.getPosition().y, null);
    
    }
    
    /**
     * Getter for a temp holder for planers
     * @return tempPlanets
     */
    public Planet[][] getPlanetWithLocation()
    {
    	return tempPlanets;
    }
    public StarDockInfo[][] getStarDocksWithLocation()
    {
    	return tempStarDock;
    }
    /**
     * Getter for the planet array
     * @return planet
     */
    
    public void setPS(Planet[][] p,StarDockInfo[][] s){
    	tempPlanets=p;
    	tempStarDock=s;
    }
    /**
     * reset the image for stardock after load
     */
    public void afterLoad(){
    	for(int i = 0; i <25; i++)
    		for(int j = 0; j < 20; j++)
    		{
    			if(tempStarDock[i][j] != null)
    				tempStarDock[i][j].afterLoad();
    		}
    }
    
    

}
