import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 * This is the class that controls everything and has the main method. 
 * It forms a frame and holds all the necessary panels from other classes.
 * It is the main controller class for the program
 * @author Guang Lu
 *
 */
public class UIMain implements Serializable {
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
	private StarDock stardock;
	
	private Universe universe;
	private Trade trade;
	private Planet[] planetlist;
	private SettingPanel sp;
	//private JMenuBar menuBar;
	//private JMenuItem mntmFile;
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
		frame.setPreferredSize(new Dimension(450,450));
		
		//menuBar = new JMenuBar();
		//frame.setJMenuBar(menuBar);
		
		//mntmFile = new JMenuItem("file");
		//menuBar.add(mntmFile);
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
			frame.setSize(new Dimension(800,800));
			universe = new Universe(player);
			map=new MapPanel(universe,player);
			tabPane.addTab("Map",map);
			tabPane.setSelectedIndex(1);
			skillsGUI.disablebtnNext();
			map.setKeyListener(new KeyController());
			
			sp=new SettingPanel();
			sp.setSaveListener(new SaveListener());
			sp.setLoadListener(new LoadListener());
			tabPane.addTab("Setting",sp);
			

			
		}
	}
	/**
	 * This is the action listener class for the btnFinished in Trade class
	 * @author Guang Lu
	 *
	 */
	private class BtnFinishedListener implements ActionListener{
		/**
		 * Method must be implemented from ActionListener interface  
		 */
		public void actionPerformed(ActionEvent e){
			tabPane.remove(2);
			tabPane.setSelectedIndex(1);
			tabPane.setEnabledAt(0,true);
			tabPane.setEnabledAt(1,true);
			
		}
	}
	/**
	 * This is the key listener class for map screen to move the player around
	 * @author Haytham
	 *
	 */
	private class KeyController implements KeyListener {
		/**
		 * Set the panel to be focusable 
		 */
		public KeyController()
		 {
			 map.setFocusable(true);
			// addKeyListener(this);
		 }
		 	/**
			 * Method must be implemented from ActionListener interface  
			 */
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
	                      if(map.checkIfStarDockIsPresent(player.getPosition()))
	                    	  createStarDock();  
	                      player.getShip().setCurrentFuel(map.getfuelPerMove());
	                    	}
	                        break;
	                    case KeyEvent.VK_LEFT:
	                    	if(oldX-1 >=0  && map.checkIfMoveIsValid()){
	                    		//checkIfPlanetIsPresent(currPlayer.getPosition()) 
	                      player.setPosition(new Point(oldX-1, oldY)); //move left
	                      if(map.checkIfPlanetIsPresent(player.getPosition()))
	                    	  createTrade();  
	                      if(map.checkIfStarDockIsPresent(player.getPosition()))
	                    	  createStarDock();  
	                      player.getShip().setCurrentFuel(map.getfuelPerMove());
	                    	}
	                        break;
	                    case KeyEvent.VK_DOWN:
	                    	if(oldY+1 < map.HEIGHT && map.checkIfMoveIsValid()){
	                    		//checkIfPlanetIsPresent(currPlayer.getPosition()) 
	                      player.setPosition(new Point(oldX, oldY+1)); //move down
	                      if(map.checkIfPlanetIsPresent(player.getPosition()))
	                    	  createTrade();  
	                      if(map.checkIfStarDockIsPresent(player.getPosition()))
	                    	  createStarDock();  
	                      player.getShip().setCurrentFuel(map.getfuelPerMove());
	                    	}
	                    	break;
	                    case KeyEvent.VK_UP:
	                    	if(oldY-1 >= 0 && map.checkIfMoveIsValid()){
	                      player.setPosition(new Point(oldX, oldY-1)); //move up
	                      System.out.println(player.getPosition());
	                      if(map.checkIfPlanetIsPresent(player.getPosition()))
	                    	  createTrade();  
	                      if(map.checkIfStarDockIsPresent(player.getPosition()))
	                    	  createStarDock();  
	                    	  player.getShip().setCurrentFuel(map.getfuelPerMove());
	                    	}
	                    	break;
	                }

	            }
	            if(player.getShip().getCurrentFuel() < player.getShip().getFuelPerMove())
	            {
	            	  int reply = JOptionPane.showConfirmDialog(null, "Unfortunatly your ship ran out of fuel, play again?", "SHIP BLEW UP!", JOptionPane.YES_NO_OPTION);
	                  if (reply == JOptionPane.YES_OPTION) {
	                    //JOptionPane.showConfirmDialog(null, new UIMain(), "", 0);
	                	  UIMain newGame= new UIMain();
	                	  frame.dispose();
	                  }
	                  else {
	                     JOptionPane.showMessageDialog(null, "GOODBYE");
	                     System.exit(0);
	                  }
	            }
               map.updateLables();
	           map. repaint();
	        }
	        /**
	         * This method will create a trade screen when player agree to trade
	         */
	        public void createTrade()
	        {
	        	
	        	JFrame f = new JFrame("Trade");
	        	int answer = JOptionPane.showConfirmDialog(f, "Trade?");
	            if (answer == JOptionPane.YES_OPTION) {
	            Trade t = new Trade(player, map.planetGrid[player.getPosition().x][player.getPosition().y]);
	        	t.setBtnFinished(new BtnFinishedListener());
	            tabPane.add(t,"Trade",2);
	        	tabPane.setSelectedIndex(2);
	        	tabPane.setEnabledAt(0,false);
	        	tabPane.setEnabledAt(1,false);
	            }
	        }
	        public void createStarDock()
	        {
	        	JFrame f = new JFrame("Star Dock");
	        	stardock = new StarDock(player);
	        	stardock.setBtnFinished(new BtnFinishedListener());
		            tabPane.add(stardock,"StarDock");
		        	tabPane.setSelectedIndex(2);
		        	tabPane.setEnabledAt(0,false);
		        	tabPane.setEnabledAt(1,false);
		        	
		            }
	        
	        /**
			 * Method must be implemented from ActionListener interface  
			 */
			public void keyReleased(KeyEvent e) {
			}
			/**
			 * Method must be implemented from ActionListener interface  
			 */
			public void keyTyped(KeyEvent e) {
				//System.out.println("typeeeddd");
			}
	    
	}
		
	
	
	
	public void save() { // Create a file dialog to query the user for a filename. 
		//FileDialog f = new FileDialog(frame, "Save", FileDialog.SAVE); 
		//f.show(); // Display the dialog and block. 
		 //String filename = f.getFile(); // Get the user's response 
		//SaveTemp st = new SaveTemp(player,universe);
		
		int a =1;
		 if (a==1) { // If user didn't click "Cancel". 
			try { // Create the necessary output streams to save the scribble. 
				FileOutputStream fos = new FileOutputStream("nicename.ser"); // Save to file 
				//GZIPOutputStream gzos = new GZIPOutputStream(fos); // Compressed 
				ObjectOutputStream out = new ObjectOutputStream(fos); // Save objects 
				
				
				out.writeObject(player);
				out.writeObject(universe);
				
				out.flush(); // Always flush the output. 
				out.close(); // And close the stream. 
				fos.close();
				} // Print out exceptions. We should really display them in a dialog... 
			catch (IOException e) { System.out.println(e); } 
			} 
			
		
	}
	
	public void load(){ // Create a file dialog to query the user for a filename. 
		//FileDialog f = new FileDialog(frame, "Load Scribble", FileDialog.LOAD); 
		//f.show(); // Display the dialog and block. 
		//String filename = f.getFile(); // Get the user's response 
		int b =1;
		if (b==1) { 
			try { // Create necessary input streams 
				FileInputStream fis = new FileInputStream("nicename.ser"); // Read from file 
				//GZIPInputStream gzis = new GZIPInputStream(fis); // Uncompress 
				ObjectInputStream in = new ObjectInputStream(fis);
				
				//SaveTemp st = (SaveTemp)a;
				//player=st.getPlayer();
				//niverse=st.getUniverse();

				in.close(); 
				fis.close();
				
				map.repaint();
				frame.repaint();
				
				}
			catch (Exception e) { System.out.println(e); 
			}
		}
		
	}
	
	
	private class SaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			save();
		}
	}
	
	private class LoadListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
				load();
		}
	}
	
}