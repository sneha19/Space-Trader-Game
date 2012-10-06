import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class UIMain {
	//private Random _rand;
	//public Player_ _unnamed_Player__;
	//public Merchant _unnamed_Merchant_;
	//public Pirate _unnamed_Pirate_;
	//public Police _unnamed_Police_;

	private Player player;
	private Start start;
	private Skills skills;
	private SkillsInterface skillsGUI;
	private JFrame frame;
	private JTabbedPane tabPane;
	private MapPanel mapGUI;
	private JButton btnStart;
	
	
	public UIMain(){
		
		start = new Start();
		start.setbtnStartActionListener(new StartListener());
		tabPane = new JTabbedPane();
		tabPane.addTab("Welcome",start);
		
		frame = new JFrame("Star Trader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500,500));
		frame.setContentPane(tabPane);
		frame.pack();
		frame.setVisible(true);
		
		
		
		
		
		
		
	}
	
	public void getGoing(){
		
	}
	
	
	
	
	/*public void switchScreen(JPanel off,JPanel on){
		off.setVisible(false);
		on.setVisible(true);
		curPanel=on;
		
	}*/
	
	
	
	public static void main(String[] args){
		UIMain uiMain = new UIMain();
		
	}
	
	
	private class StartListener implements ActionListener{  
		  public void actionPerformed (ActionEvent event){		 
			  
			  player = new Player("default");
			  player.setName(start.getName());
			  player.setDifficulty(start.getDifficulty());
			  
			  
			  tabPane.remove(0);
			  skills = new Skills(player);
			  skillsGUI= new SkillsInterface(skills);
			  skillsGUI.setbtnNextListener(new NextListener());
			  tabPane.addTab("Skills",skillsGUI);
			  
			  
	     }
	  }
	
	private class NextListener implements ActionListener{
		public void actionPerformed (ActionEvent e){
			mapGUI = new MapPanel(skills.getPlayer());
			tabPane.add(mapGUI,"Map");
			tabPane.setSelectedIndex(1);
			
		}
	}
	
	//every class need a setCurPlayer and getPlayer method!!
	
	
	/*
	public void interactions(int aParameter) {
		throw new UnsupportedOperationException();
	}

	public void move(Player aPlayer) {
		throw new UnsupportedOperationException();
	}

	public void switchPanel(int aParameter) {
		throw new UnsupportedOperationException();
	}

	public void drawMap() {
		throw new UnsupportedOperationException();
	}

	public boolean checkOverlap() {
		throw new UnsupportedOperationException();
	}

	public void displayPlanetStats() {
		throw new UnsupportedOperationException();
	}

	public void displayPlayerStats() {
		throw new UnsupportedOperationException();
	}

	*/
	
}