public class Planet {
	private String planetName;
	//public Player player;
	public Goverments goverments;
	public Point location;
	
	public enum Planets
	{
		 utopia("Utopia",democracy, (3,5)),
		 sparta("Sparta",anarchy,(200,155)),
		 erebus("Erebus",corporateState,(35,185)),
		 pheonix("Pheonix",morarchy,(100,100)),
		 dis("Dis",militaryState,(250,60)),
		 fortuna("Fortuna",democracy,(35,60)),
		 hydra("Hydra",monarchy,(115,90)),
		 pax("Pax",anarchy,(190,140)),
		 sol("Sol",democracy,(50,50)),
		 asgard("Asgard",monrachy,(175,50));
	
	
	public Planets(String planetName, Governments goverments,  Point location)
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
	
	}
	
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
	
	}
	
	public Planet()
	{}
	
}