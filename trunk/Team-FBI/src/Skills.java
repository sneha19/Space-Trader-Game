import java.util.Vector;
import javax.swing.JPanel;


public class Skills{
 private int pilotPoints;
 private int fighterPoints;
 private int traderPoints;
 private int engineerPoints;
 private int playerPoints = 16;
 private Player player;
 public Skills(Player currPlayer)
 {
  player = currPlayer;
  this.pilotPoints=player.getPilot();
  this.fighterPoints=player.getFighter();
  this.traderPoints=player.getTrader();
  this.engineerPoints=player.getEngineer();
 }
 
 //public Vector<Player_> unnamed_Player = new Vector<Player_>();
 public void setPilotPoints(int points)
 {
  pilotPoints += points;
 }
 public void setFighterPoints(int points)
 {
  fighterPoints += points;
 }
 public void setTraderPoints(int points)
 {
  traderPoints += points;
 }
 public void setEngineerPoints(int points)
 {
  engineerPoints += points;
 }
 public int getPilotPoints()
 {
  return pilotPoints;
 }
 public int getFighterPoints()
 {
  return fighterPoints;
 }
 public int getTraderPoints()
 {
  return traderPoints;
 }
 public int getEngineerPoints()
 {
  return engineerPoints;
 }
 public void setCurrPoints(int points)
 {
  playerPoints = playerPoints + points;
 }
 public int getCurrPoints()
 {
  return playerPoints;
 }
 
 public Player getPlayer(){
	 return player;
 }
 public void setSkill() {
  throw new UnsupportedOperationException();
 }
}