import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;



public class Universe {
	//public static final Universe universe = new Universe();

	private String[] planetNames;
	private Planet[] planet;
	private Random rand;
	private ArrayList<Point> positionList;
	private Planet[][] tempPlanets = new Planet[25][20];
	static Player currPlayer;
	public Universe(Player p){
		currPlayer = p;
		try {
			writeFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	planet = new Planet[123];
	
	for(int i=0;i<122;i++){
		String name = planetNames[i];
		planet[i]= new Planet(name);
	}
	
	rand = new Random();
//	Planet p []= new Planet[122];
//	int counter = 122;
//	for(int i=0;i<122;i++){
//		int index = rand.nextInt(counter);
//		p[i]=planet[index];
//		counter--;
//		System.out.println(p[i].getPlanetName());
//	}
//	
//	planet = p;
//	
//	
	
	positionList = new ArrayList<Point>();
	//create all the positions
	for(int x=0;x<25;x++){
		for(int y=0;y<20;y++){
			positionList.add(new Point(x,y));
		}	
	}
	
	//assign locations
	int m=500;
	for(int i=0;i<122;i++){
	int index = rand.nextInt(m);
	planet[i].setLocation(positionList.get(index));
	tempPlanets[positionList.get(index).x][positionList.get(index).y] = planet[i];
	positionList.remove(index);
	m--;
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
	
	//assign zone
//	for(int i=0;i<122;i++){
//		
//			//why create a Zone object? unless you assign each number to return
//			// some level (int) because the Zone class does not do anything with
//			// the number being passed in. Recommend to just make randon int from 
//			// 0 - 5 for each level and each will correspond to a specific zone.
//			// - Haytham
//			//Zone tempZone = new Zone(i);
//			planet[i].setZone(tempZone);
//			tempZoneIndex++;
//			if(tempZoneIndex>=122){
//				break;
//			}
//		}
//		i++;
//	}
//	
//	int tempZoneIndex=0;
//	for(int i=0;i<5;i++){
//		
//		for(int j=0;j<30;j++){
//			//why create a Zone object? unless you assign each number to return
//			// some level (int) because the Zone class does not do anything with
//			// the number being passed in. Recommend to just make randon int from 
//			// 0 - 5 for each level and each will correspond to a specific zone.
//			// - Haytham
//			Zone tempZone = new Zone(i);
//			planet[tempZoneIndex].setZone(tempZone);
//			tempZoneIndex++;
//			if(tempZoneIndex>=122){
//				break;
//			}
//		}
//		i++;
//	}
//	System.out.println("d");
	}
	
	

	
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
		  while ((line = in.readLine()) != null){
			  record[i] = line.trim();
			  i++;
		  }
		  planetNames = record;
		  in.close();
	}

    public void draw(Graphics g) {
    	for(int i = 0; i <25; i++)
    		for(int j = 0; j < 20; j++)
    		{
    			if(tempPlanets[i][j] != null)
    				tempPlanets[i][j].draw(g, null);
    			else{
    				g.setColor(Color.gray);
    				g.drawRect(30*i, 30*j, 30, 30);
    			}
    		}
    	g.drawImage(currPlayer.getShip().getPic(), 30*currPlayer.getPosition().x, 30*currPlayer.getPosition().y, null);
    //	g.fillOval(15*currPlayer.getPosition().x, 15*currPlayer.getPosition().y, 15, 15);
//    
//    	for (Planet p : planet) {
//    			p.draw(g, null);
//    	}
    }
    public Planet[][] getPlanetWithLocation()
    {
    	return tempPlanets;
    }
	public Planet[] getPlanet() {
		// TODO Auto-generated method stub
		return planet;
	}
	
}
