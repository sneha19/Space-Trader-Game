import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Planet {
private String planetName;
//public Player player;
public Goverments goverments;
public Point location;
public int techLevel;
public int resources;

public Planets(String planetName, Governments goverments, Point location)
{	
this.planetName = planetName;
this.goverments = gov;
this.location = location;
}

public String getPlanetName()
{
return planetName;
}

public Goverments getGoverment()
{	return goverments;}

public Point getLocation()
{	return location;}



public String setPlanetName(String planetName)
{
this.planetName = planetName;
}

public Goverments setGoverment(Goverments goverments)
{	
this.goverments = goverments;	
}

public Point setLocation(Point locaction)
{	
this.location = location;
}

public void draw(Graphics g,Point p,Color c){

g.setColor(c);
g.fillOval(p.x, p.y,15,15)
}



public enum PlanetType
{
Acamar("Acamar",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Adahn("Adahn",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Aldea("Aldea",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Andevian("Andevian",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Antedi("Antedi",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Balosnee("Balosnee",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Baratas("Baratas",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Brax("Brax",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Bretel("Bretel",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Calondia("Calondia",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Campor("Campor",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Capelle("Capelle",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Carzon("Carzon",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Castor("Castor",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Cestus("Cestus",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Cheron("Cheron",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Courteney("Courteney",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Daled("Daled",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Damast("Damast",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Davlos("Davlos",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Deneb("Deneb",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Deneva("Deneva",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Devidia("Devidia",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Draylon("Draylon",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Drema("Drema",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Endor("Endor",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Esmee("Esmee",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Exo("Exo",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Ferris("Ferris",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Festen("Festen",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Fourmi("Fourmi",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Frolix("Frolix",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Geulon("Gemulon",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Guinifer("Guinifer",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Hades("Hades",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Hamlet("Hamlet",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Helena("Helena",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Hulst("Hulst",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Iodine("Iodine",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Iralius("Iralius",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Janus("Janus",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Japori("Japori",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Jarada("Jarada",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Jason("Jason",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Kaylon("Kaylon",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Kefka("Khefka",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Kira("Kira",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Klaatu("Klaatu",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Klaestron("Klaestron",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Korma("Korma",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Kravat("Kravat",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Krios("Krios",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Laertes("Laertes",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Largo("Largo",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Lave("Lave",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Ligon("Ligon",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Lowry("Lowry",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Margrat("Magrat",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Malcoria("Malcoria",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Melina("Melina",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Mentar("Mentar",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Merik("Merik",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Mintaka("Mintaka",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Montor("Montor",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Mordan("Mordan",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Myrthe("Myrthe",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Nelvana("Nelvana",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Nix("Nix",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Nyle("Nyle",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Odet("Odet",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Og("Og",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Omega("Omega",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Omphalos("Omphalos",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Orias("Orias",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Othello("Othello",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Parade("Parade",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Penthara("Penthara",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Picard("Picard",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Pollux("Pollux",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Quator("Quator",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Rakhar("Rakhar",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Ran("Ran",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Regulas("Regulas",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Relva("Relva",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Rhymus("Rhymus",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Rochani("Rochani",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Rubicum("Rubicum",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Rutia("Rutia",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Sarpeidon("Sarpeidon",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Sefalla("Sefalla",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Seltrice("Seltrice",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Sigma("Sigma",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Sol("Sol",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Somari("Somari",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Stakoron("Stakoron",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Styris("Styris",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Talani("Talani",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Tamus("Tamus",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Tantalos("Tantalos",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Tanuga("Tanuga",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Tarchannen("Tarchannen",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Terosa("Terosa",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Thera("Thera",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Titan("Titan",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Torin("Torin",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Triacus("Triacus",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Turkana("Turkana",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Tyrus("Tyrus",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Umberlee("Umberlee",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Utopia("Utopia",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Vadera("Vadera",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Vagra("Vagra",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Vandor("Vandor",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Ventax("Ventax",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Xenon("Xenon",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Xerxes("Xerxes",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Yew("Yew",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Yojimbo("Yojimbo",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),	
Zalkon("Zalkon",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256))),
Zuul("Zuul",new Random(8)-1,new Random(13)-1,new Government(new Random(3),new Random(3),new Random(3)),new Color(new Random(256),new Random(256),new Random(256)));

private final String planetname;
private final Governments gov;
private final Point location;
private Color c;
private final int techLevel;
private final int resources;


private Planets(String planetName, int techLevel, int resources, Governments goverments, Color c)
{	
this.planetName = planetName;
this.techLevel = techLevel;
this.resources = resources;
this.goverments = gov;
this.c = c;
}
//public int getTechLevel(){
//return techLevel
//}
}