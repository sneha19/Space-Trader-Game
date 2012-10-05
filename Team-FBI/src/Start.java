import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

  public class Start extends JPanel {
	//private Point startPosition;
	private int level;
	private int goCount;
	private Player player;
	private JTextField name;
	private JButton go;
	private JLabel welcomeMsg;
	private JLabel enterName;
	private JButton beginner;
	private JButton easy;
	private JButton normal;
	private JButton hard;
	private JButton impossible;
	
	public Start(){
		setPreferredSize(new Dimension(300,300));
		goCount = 0;
		//startPosition.x=0;
		//startPosition.y=0;
		name = new JTextField(10);
		go = new JButton("Go");
		go.addActionListener(new GoListener());
		welcomeMsg= new JLabel("Star Trader");
		enterName = new JLabel("Enter Name");
		easy = new JButton("Easy");
		beginner = new JButton("Beginner");
		normal= new JButton("Normal");
		hard = new JButton("Hard");
		impossible = new JButton("Impossible");
		
		easy.addActionListener(new DiffListener());
		beginner.addActionListener(new DiffListener());
		normal.addActionListener(new DiffListener());
		hard.addActionListener(new DiffListener());
		impossible.addActionListener(new DiffListener());
		
		
		
		add(welcomeMsg);
		add(enterName);
		add(name);
		add(beginner);
		add(easy);
		add(normal);
		add(hard);
		add(impossible);
		add(go);

	}
    
   public void setPlayerName(){
	   String text = name.getText();
	   player = new Player(text);
	}
   
  /* public void setPlayerLocation(){
	   Player.setPosition(startPosition);
   } */
   
   public boolean setDifficulty(int diff){
	   player.setDifficulty(diff);
	   return true;
   }
   
   
   public Player getPlayer(){
	   return player;
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
			 setVisible(false);
		 }
     }
  }
  
   private class DiffListener implements ActionListener{
	   private String diffString;
	   private int diff;
	   public void actionPerformed(ActionEvent e){
		   diffString=e.getActionCommand();
		   
		   if(diffString=="Beginner"){
			   player.setDifficulty(1);
		   }else if(diffString=="Easy"){
			   player.setDifficulty(2);
		   }else if(diffString=="Normal"){
			   player.setDifficulty(3);
		   }else if(diffString=="Hard"){
			   player.setDifficulty(4);
		   }else{
			   player.setDifficulty(5);
		   }
	   }
   }
  
   
	
}