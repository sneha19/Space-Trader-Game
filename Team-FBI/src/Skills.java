import java.util.Vector;
import javax.swing.JPanel;

public class Skills{
 private int pilotPoints;
 private int fighterPoints;
 private int traderPoints;
 private int engineerPoints;
 private int playerPoints = 16;
 Player player;
 public Skills(Player currPlayer)
 {
  player = currPlayer;
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
 public void setSkill() {
  throw new UnsupportedOperationException();
 }
}