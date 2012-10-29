import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * This is the class that controls everything and has the main method. 
 * It forms a frame and holds all the necessary panels from other classes.
 * It is the main controller class for the program
 * @author Guang Lu
 *
 */
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
	private MapPanel map;
	private JButton btnStart;
	
	private Universe universe;
	private Trade trade;
	private Planet[] planetlist;
	/**
	 * Constructor
	 */
	public UIMain(){
		
		start = new Start();
		start.setbtnStartActionListener(new StartListener());
		tabPane = new JTabbedPane();
		tabPane.addTab("Welcome",start);
		
		
		
		
		
		frame = new JFrame("Star Trader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600,700));
		frame.setContentPane(tabPane);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	
	
	
	
	/*public void switchScreen(JPanel off,JPanel on){
		off.setVisible(false);
		on.setVisible(true);
		curPanel=on;
		
	}*/
	
	
	/**
	 * Main method that will run the program
	 * @param args input command
	 */
	public static void main(String[] args){
		UIMain uiMain = new UIMain();
		
	}
	
	/**
	 * This is the action listener class for start screen to get the whole game started
	 * @author Guang Lu
	 *
	 */
	private class StartListener implements ActionListener{  
		/**
		 * Method must be implemented from ActionListener interface  
		 */
		public void actionPerformed (ActionEvent event){		 
			  if(start.isDiffed()){
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
	  }
	/**
	 * This is the action listener class for initial skill setting screen
	 * @author Guang Lu
	 *
	 */
	private class NextListener implements ActionListener{
		/**
		 * Method must be implemented from ActionListener interface  
		 */
		public void actionPerformed (ActionEvent e){
			universe = new Universe(player);
			map=new MapPanel(universe,player);
			tabPane.addTab("Map",map);
			tabPane.setSelectedIndex(1);
			skillsGUI.disablebtnNext();
			map.setKeyListener(new KeyController());
			
		}
	}
	
	private class BtnFinishedListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			tabPane.remove(2);
			tabPane.setEnabledAt(0,true);
			tabPane.setEnabledAt(1,true);
		}
	}
	
	private class KeyController implements KeyListener {
		 public KeyController()
		 {
			 map.setFocusable(true);
			// addKeyListener(this);
		 }
	        @Override
	        public void keyPressed(final KeyEvent key) {
	            if (player != null) {

	                int oldX = player.getPosition().x;
	                int oldY = player.getPosition().y;
	                switch (key.getKeyCode()) {
	                    case KeyEvent.VK_RIGHT:
	                    	if(oldX+1 < map.WIDTH && map.checkIfMoveIsValid()){
	                    		//checkIfPlanetIsPresent(currPlayer.getPosition()) 
	                      player.setPosition(new Point(oldX+1, oldY)); //move right
	                      if(map.checkIfPlanetIsPresent(player.getPosition()))
	                    	  createTrade();  
	                      player.getShip().setCurrentFuel(map.getfuelPerMove());
	                    	}
	                        break;
	                    case KeyEvent.VK_LEFT:
	                    	if(oldX-1 >=0  && map.checkIfMoveIsValid()){
	                    		//checkIfPlanetIsPresent(currPlayer.getPosition()) 
	                      player.setPosition(new Point(oldX-1, oldY)); //move left
	                      if(map.checkIfPlanetIsPresent(player.getPosition()))
	                    	  createTrade();  
	                      player.getShip().setCurrentFuel(map.getfuelPerMove());
	                    	}
	                        break;
	                    case KeyEvent.VK_DOWN:
	                    	if(oldY+1 < map.HEIGHT && map.checkIfMoveIsValid()){
	                    		//checkIfPlanetIsPresent(currPlayer.getPosition()) 
	                      player.setPosition(new Point(oldX, oldY+1)); //move down
	                      if(map.checkIfPlanetIsPresent(player.getPosition()))
	                    	  createTrade();  
	                      player.getShip().setCurrentFuel(map.getfuelPerMove());
	                    	}
	                    	break;
	                    case KeyEvent.VK_UP:
	                    	if(oldY-1 >= 0 && map.checkIfMoveIsValid()){
	                      player.setPosition(new Point(oldX, oldY-1)); //move up
	                      System.out.println(player.getPosition());
	                      if(map.checkIfPlanetIsPresent(player.getPosition()))
	                    	  createTrade();          	  
	                    	  player.getShip().setCurrentFuel(map.getfuelPerMove());
	                    	}
	                    	break;
	                }

	            }
	            if(player.getShip().getCurrentFuel() == 0)
	            {
	            	JOptionPane.showMessageDialog(new JFrame(), "Game OVER!");

	            }
               map.updateLables();
	           map. repaint();
	        }
	        
	        public void createTrade()
	        {
	        	
	        	JFrame f = new JFrame("Trade");
	        	int answer = JOptionPane.showConfirmDialog(f, "Trade?");
	            if (answer == JOptionPane.YES_OPTION) {
	            Trade t = new Trade(player, map.planetGrid[player.getPosition().x][player.getPosition().y]);
	        	t.setBtnFinished(new BtnFinishedListener());
	            tabPane.add(t,"Trade");
	        	tabPane.setSelectedIndex(2);
	        	tabPane.setEnabledAt(0,false);
	        	tabPane.setEnabledAt(1,false);
	            }
	        }
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println("typeeeddd");
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