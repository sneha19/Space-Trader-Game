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
	private String[] planetNames;
	private Planet[] planet;
	private Random rand;
	private ArrayList<Point> positionList;
	
	public static void main(String[] args)
	{
		Universe univ = new Universe();
		System.out.println("GHGHG");
	}
	
	
	public Universe(){
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
	Planet p []= new Planet[122];
	int counter = 122;
	for(int i=0;i<122;i++){
		int index = rand.nextInt(counter);
		p[i]=planet[index];
		counter--;
	}
	
	planet = p;
	
	
	
	positionList = new ArrayList<Point>();
	//create all the positions
	for(int x=0;x<25;x++){
		for(int y=0;y<20;y++){
			positionList.add(new Point(15*x,15*y));
		}	
	}
	
	//assign locations
	int m=500;
	for(int i=0;i<122;i++){
	int index = rand.nextInt(m);
	planet[i].setLocation(positionList.get(index));
	positionList.remove(index);
	m--;
	}
	
	
	//assign zone
	int tempZoneIndex=0;
	for(int i=0;i<5;i++){
		
		for(int j=0;j<30;j++){
			//why create a Zone object? unless you assign each number to return
			// some level (int) because the Zone class does not do anything with
			// the number being passed in. Recommend to just make randon int from 
			// 0 - 5 for each level and each will correspond to a specific zone.
			// - Haytham
			Zone tempZone = new Zone(i);
			planet[tempZoneIndex].setZone(tempZone);
			tempZoneIndex++;
			if(tempZoneIndex>=122){
				break;
			}
		}
		i++;
	}
	
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
	}

    public void draw(Graphics g) {
    	for(int i = 0; i < planet.length; i++)
    	{
    		if(planet[i] != null)
    	planet[i].draw(g, null);
    		else
    			planet[i].emptyDraw(g, null);
    	}
    //	for (Planet p : planet) {
    //			p.draw(g, null);
    //	}
    }
	public Planet[] getPlanet() {
		// TODO Auto-generated method stub
		return planet;
	}
	
}
