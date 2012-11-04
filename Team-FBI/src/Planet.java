import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
/**
 * The is a class for planets
 * @author team-fbi
 *
 */
public class Planet {
private String planetName;
private Governments governments;
private Point location;
private int techLevel;
private int resources;
private Random rand;
private Color color;
private Zone zone;
/**
 * This is the contructor for a planet, takes a planet name
 * @param planetName
 */
public Planet(String planetName)
{	
	
this.planetName = planetName;
rand = new Random();
techLevel = rand.nextInt(7);
resources = rand.nextInt(13);
governments = new Governments(rand.nextInt(5));
location= new Point(0,0);
color = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));

}
/**
 * getter, return planet name
 * @return
 */
public String getPlanetName()
{
return planetName;
}
/**
 * getter , return goverment
 * @return
 */
public Governments getGoverment()
{	return governments;}
/**
 * getter, get the location of the planet
 * @return
 */
public Point getLocation()
{	return location;}
/**
 * getter, get the tech level of the plant
 * @return
 */
public int getTechLevel()
{
	return techLevel;
}

/**
 * setter, set the planet name
 * @param planetName
 */
public void setPlanetName(String planetName)
{
this.planetName = planetName;
}
/**
 * setter, set the government of the planet
 * @param goverments
 */
public void setGoverment(Governments goverments)
{	
this.governments = goverments;	
}
/**
 * setter, set the location of the planet
 * @param location
 */
public void setLocation(Point location)
{	
this.location = location;
}
/**
 * Draw method, the planet will draw itself
 * @param g graphics
 * @param p	location to draw
 */
public void draw(Graphics g,Point p){
g.setColor(color);
g.fillOval(30*location.x, 30*location.y,30,30);
//g.setColor(Color.gray);
//g.drawRect(30*location.x, 30*location.y, 30, 30);

}
/**
 * getter, for zone
 * @return zone
 */
public Zone getZone()
{
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