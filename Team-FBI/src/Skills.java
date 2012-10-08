
/**
 * Skills class to update the current Players skills
 * @author Haytham Abutair
 *
 */
public class Skills{
 private int playerPoints;
 private Player player;
 
 /**
  * constructor to allow the player to be passed in
  * @param player Current Player
  */
 public Skills(Player player)
 {
  this.player = player;
  playerPoints=player.getAvailableSkillPoints();
 }
 
 /**
  * sets the new pilot Points
  * @param points amount to be added
  */
 public void setPilotPoints(int points)
 {
	 player.setPilot(points);
 }
 
 /**
  * sets the new fighter Points
  * @param points amount to be added
  */
 public void setFighterPoints(int points)
 {
	 player.setFighter(points);
 }
 
 /**
  * sets the new trader Points
  * @param points amount to be added
  */
 public void setTraderPoints(int points)
 {
	 player.setTrader(points);
 }
 
 /**
  * sets the new engineer Points
  * @param points amount to be added
  */
 public void setEngineerPoints(int points)
 {
	 player.setEngineer(points);
 }
 
 /**
  * retrieves the players current pilot points
  * @return current pilot points
  */
 public int getPilotPoints()
 {
	 return player.getPilot();
 }
 
 /**
  * retrieves the players current fighter points
  * @return current fighter points
  */
 public int getFighterPoints()
 {
	 return player.getFighter();
 }
 
 /**
  * retrieves the players current trader points
  * @return current trader points
  */
 public int getTraderPoints()
 {
	 return player.getTrader();
 }
 
 /**
  * retrieves the players current engineer points
  * @return current engineer points
  */
 public int getEngineerPoints()
 {
	 return player.getEngineer();
 }
 
 /**
  * sets players current points
  * @param points points to add on to current points
  */
 public void setCurrPoints(int points)
 {
  playerPoints = playerPoints + points;
 }
 
 /**
  * retrieves the players current points
  * @return current points
  */
 public int getCurrPoints()
 {
  return playerPoints;
 }
 
 
 /**
  * retrieves the player
  * @return current player
  */
 public Player getPlayer(){
	 return player;
 }
 
}