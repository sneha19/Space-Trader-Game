import java.io.Serializable;


public class SaveTemp implements Serializable{


	private Planet[][] plist;
	private StarDockInfo[][] slist;
	private Player player;
	public SaveTemp(Planet[][] plist, StarDockInfo[][] slist, Player player){
		this.plist=plist;
		this.slist=slist;
		this.player=player;
	}
	
	
	public Planet[][] getPlanet(){
		return plist;
	}
	
	public StarDockInfo[][] getStarDock(){
		return slist;
	}
	
	public Player getPlayer(){
		return player;
	}
	
}
