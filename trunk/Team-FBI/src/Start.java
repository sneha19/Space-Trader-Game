import java.util.*;

  public class Start extends JPanel {
	private final Point startPositon;
	private int level;
	public int goCount;
	public Player Player;
	private JPanel startPanel;
	private JPanel enterName;
	public JTextField name;
	public JButton go;
	
	public Start(){
		goCount = 0;
		startPosition.x = 0;
		startPosition.y = 0;
		startPanel = new Panel("Start Screen");
		enterName = new Panel("Please enter your name")
		name = new JTextField(10);
		go = new JButton("Go");
		go.addActionListener(new GoListener());
		
		add(startPanel);
		add(enterName);
		add(name);

	}
    
   public void setPlayerName(){
	   String text = name.getText();
	   Player = new Player(text);
	}
   
   public void setPlayerLocation(){
	   Player.setLocation(startPosition);
   }
   
   public Player getPlayer(){
	   return Player;
   }
   
   public boolean goIsPressed()
   {
	  if (goCount > 0)
		   return true;
	  else
		  return false;
   }
   
 /** GoListener class
  * Listenes for the go button to be pressed, increaments a goCount when it is pressed
  * @param event it is activated when go is pressed
  */
   private class GoListener implements ActionListener{  
	  public void actionPerformed (ActionEvent event){
		 if (go == event.getSource()) {
			 goCount += 1;
			 setPlayerName();
			 setPlayerLocation();
		 }
     }
  }
  
  
   
	
}