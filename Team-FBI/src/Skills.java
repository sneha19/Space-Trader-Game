

public class Skills{
 //private int pilotPoints;
 //private int fighterPoints;
 //private int traderPoints;
 //private int engineerPoints;
 private int playerPoints;
 private Player player;
 
 public Skills(Player player)
 {
  this.player = player;
  //this.pilotPoints=player.getPilot();
  //this.fighterPoints=player.getFighter();
  //this.traderPoints=player.getTrader();
  //this.engineerPoints=player.getEngineer();
  playerPoints=player.getAvailableSkillPoints();
 }
 
 
 public void setPilotPoints(int points)
 {
  //pilotPoints += points;
	 player.setPilot(points);
 }
 public void setFighterPoints(int points)
 {
  //fighterPoints += points;
	 player.setFighter(points);
 }
 public void setTraderPoints(int points)
 {
  //traderPoints += points;
	 player.setTrader(points);
 }
 public void setEngineerPoints(int points)
 {
  //engineerPoints += points;
	 player.setEngineer(points);
 }
 public int getPilotPoints()
 {
  //return pilotPoints;
	 return player.getPilot();
 }
 public int getFighterPoints()
 {
  //return fighterPoints;
	 return player.getFighter();
 }
 public int getTraderPoints()
 {
  //return traderPoints;
	 return player.getTrader();
 }
 public int getEngineerPoints()
 {
 // return engineerPoints;
	 return player.getEngineer();
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
 /*
 public void setSkill() {
  throw new UnsupportedOperationException();
 }*/
}