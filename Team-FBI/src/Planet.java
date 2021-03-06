// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, fieldJavadoc, fileComment, numericLiterals, tooManyViolations
import java.awt.*; // $codepro.audit.disable importStyle
import java.io.Serializable;
import java.util.Random;
/**
 * The is a class for planets
 * @author team-fbi
 * @version 1
 *
 */
public class Planet  implements Serializable{
private String planetName;

private Governments governments;

private Point location;

private int techLevel;

private int resources;

private Random rand;

private Color color;

private Zone zone;

private Goods goods;

/**
 * This is the contructor for a planet, takes a planet name
 * @param planetName
 */
public Planet(String planetName){
this.planetName = planetName;
rand = new Random();
techLevel = rand.nextInt(7);
resources = rand.nextInt(13);
governments = new Governments(rand.nextInt(5));
location= new Point(0, 0);
color = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
goods = new Goods();
goods.setWater(10 + (rand.nextInt(2 * (1 + techLevel)) - (1 + techLevel)));
goods.setFurs(10 + (rand.nextInt(2 * (1 + techLevel)) - (1 + techLevel)));
goods.setFood(10 + (rand.nextInt(2 * (1 + techLevel)) - (1 + techLevel)));
goods.setFirearms(10 + (rand.nextInt(2 * (1 + techLevel)) - (1 + techLevel)));
goods.setMedicines(10 + (rand.nextInt(2 * (1 + techLevel)) - (1 + techLevel)));
goods.setNarcotics(10 + (rand.nextInt(2 * (1 + techLevel)) - (1 + techLevel)));
goods.setMachines(10 + (rand.nextInt(2 * (1 + techLevel)) - (1 + techLevel)));
goods.setRobots(10 + (rand.nextInt(2 * (1 + techLevel)) - (1 + techLevel)));
goods.setGames(10 + (rand.nextInt(2 * (1 + techLevel)) - (1 + techLevel)));
goods.setOre(10 + (rand.nextInt(2 * (1 + techLevel)) - (1 + techLevel)));

}

/**
 * Getter, get the goods
 * @return goods
 */
public Goods getGoods(){
	return goods;
}

/**
 * getter, return planet name
 * @return planet
 */
public String getPlanetName(){
return planetName;
}

/**
 * getter , return goverment
 * @return gov
 */
public Governments getGoverment(){
	return governments;
	}

/**
 * getter, get the location of the planet
 * @return loc
 */
public Point getLocation(){
	return location;
	}

/**
 * getter, get the tech level of the plant
 * @return lvl
 */
public int getTechLevel(){
	return techLevel;
}

/**
 * setter, set the planet name
 * @param planetName
 */
public void setPlanetName(String planetName){
this.planetName = planetName;
}

/**
 * setter, set the government of the planet
 * @param goverments
 */
public void setGoverment(Governments goverments){
this.governments = goverments;
}

/**
 * setter, set the location of the planet
 * @param location
 */
public void setLocation(Point location){
this.location = location;
}

/**
 * Draw method, the planet will draw itself
 * @param g graphics
 * @param p	location to draw
 */
public void draw(Graphics g, Point p){
g.setColor(color);
g.fillOval(30 * location.x, 30 * location.y, 30, 30);
//g.setColor(Color.gray);
//g.drawRect(30*location.x, 30*location.y, 30, 30);

}

/**
 * getter, for zone
 * @return zone
 */
public Zone getZone(){
	return zone;
}

/**
 * setter, set zone
 * @param z zone number
 */
public void setZone(Zone z){
	zone=z;
}

/**
 * getter, get the color of the planet
 * @return color of planet
 */
public Color getColor(){
	return color;
}


}