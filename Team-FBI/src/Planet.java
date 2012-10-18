import java.awt.*;
import java.util.Random;

public class Planet {
private String planetName;
private Governments governments;
private Point location;
private int techLevel;
private int resources;
private Random rand;
private Color color;
public Planet(String planetName)
{	
this.planetName = planetName;
rand = new Random();
techLevel = rand.nextInt(8);
resources = rand.nextInt(13);
governments = new Governments(rand.nextInt(5));
location= new Point(0,0);
color = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
}

public String getPlanetName()
{
return planetName;
}

public Governments getGoverment()
{	return governments;}

public Point getLocation()
{	return location;}



public void setPlanetName(String planetName)
{
this.planetName = planetName;
}

public void setGoverment(Governments goverments)
{	
this.governments = goverments;	
}

public void setLocation(Point locaction)
{	
this.location = location;
}

public void draw(Graphics g,Point p){
g.setColor(color);
g.fillOval(p.x, p.y,15,15);
}


}