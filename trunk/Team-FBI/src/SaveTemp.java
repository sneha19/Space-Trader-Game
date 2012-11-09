import java.io.Serializable;


public class SaveTemp implements Serializable{

	private Player p;
	private Universe u;
	
	public SaveTemp(Player p, Universe u){
		
		this.p=p;
		this.u=u;
		
	}
	
	public Player getPlayer(){
		return p;
	}
	
	
	public Universe getUniverse(){
		return u;
	}
}
