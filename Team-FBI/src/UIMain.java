// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	/**
	 * Constructor
	 */
	public UIMain(){
		
		start = new Start();
		start.setbtnActionListener(new StartListener(),new ContinueListener());
		tabPane = new JTabbedPane();
		tabPane.addTab("Welcome",start);
		frame = new JFrame("Star Trader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800,800));
		
		//menuBar = new JMenuBar();
		//frame.setJMenuBar(menuBar);
		
		//mntmFile = new JMenuItem("file");
		//menuBar.add(mntmFile);
		frame.setContentPane(tabPane);
		frame.pack();
		frame.setVisible(true);
		
		
	}

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

	public void save(int i) {
		
		Planet[][] plist=universe.getPlanetWithLocation();
		StarDockInfo[][] slist=universe.getStarDocksWithLocation();
		
		
		
			 try { 
				FileOutputStream fos = new FileOutputStream("game"+i+".ser"); 
				ObjectOutputStream out = new ObjectOutputStream(fos);  
				out.writeObject(player);
				out.writeObject(plist);
				out.writeObject(slist);
				out.flush(); 
				fos.flush();
				out.close(); 
				fos.close();
	
				
				}
			catch (IOException e) { System.out.println(e); } 
			} 
			
		
	//}
	
	public boolean load(int i){ 

			try {
				FileInputStream fis = new FileInputStream("game"+i+".ser");
				ObjectInputStream in = new ObjectInputStream(fis);
				player  =(Player)in.readObject();
				Planet[][] plist  =(Planet[][])in.readObject();
				StarDockInfo[][] slist  =(StarDockInfo[][])in.readObject();
				in.close(); 
				fis.close();
				
				
				player.getShip().afterLoad();				
				universe.setPS(plist, slist);
				universe.afterLoad();
				skills = new Skills(player);
				skillsGUI = new SkillsInterface(skills);
				
				map=new MapPanel(universe,player);
				map.setKeyListener(new KeyController());
				return true;
				
				}
			catch (Exception e) { 
				System.out.println(e); 
				return false;
			}
			
		
	}

	private class SaveListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			SaveLoadPanel slp = new SaveLoadPanel(0);
			slp.setButtonListener(new SaveInfo());
		}
	}
	
	private class LoadListener implements ActionListener{
		public void actionPerformed(ActionEvent e){	
			SaveLoadPanel slp = new SaveLoadPanel(1);
			slp.setButtonListener(new LoadInfo());
		}
	}
	
	private class SaveInfo implements ActionListener{
		String s;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Save1")){
				save(1);
				try {
					writeInfo(1);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else if(e.getActionCommand().equals("Save2")){
				save(2);
				try {
					writeInfo(2);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}else{
				save(3);
				try {
					writeInfo(3);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		
		public void writeInfo(int i) throws IOException{
			if(i==1){
				s ="src/save1.txt";
			}else if(i==2){
				s ="src/save2.txt";
			}else{
				s="src/save3.txt";
			}
			
			File f = new File(s);
			PrintWriter pw = new PrintWriter(new BufferedWriter( new FileWriter(f)));
			pw.write(player.getName());
			pw.write("--"+dateFormat.format(cal.getTime()));
			pw.flush();
			pw.close();
		}
	}
	
	private class LoadInfo implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			 frame.setSize(new Dimension(800,800));
			 boolean i=false;
			if(e.getActionCommand().equals("Load1")){
				i=load(1);
				
			}else if(e.getActionCommand().equals("Load2")){
				i=load(2);
				
			}else if(e.getActionCommand().equals("Load3")){
				i=load(3);
				
			}
			
			if(i){
			if(tabPane.getTitleAt(0).equals("Start")){
				tabPane.removeTabAt(0);
			}
			
			tabPane.setComponentAt(0,skillsGUI);
			tabPane.setTitleAt(0,"Skills");
			
			if(tabPane.getTabCount()>=2){
				tabPane.setComponentAt(1, map);
			}else{
				tabPane.addTab("Map", map);
			}
			
			tabPane.setSelectedIndex(1);
			if(tabPane.getTabCount()==2){
				sp=new SettingPanel();
				sp.setSaveListener(new SaveListener());
				sp.setLoadListener(new LoadListener());
				tabPane.addTab("Setting", sp);
			}
			
			map.requestFocus();
			}
		}
	}
	
	private class ContinueListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			 player = new Player("default");
			 universe = new Universe(player); 
			 skills = new Skills(player);
			 skillsGUI= new SkillsInterface(skills);
			 
			 
			
			 SaveLoadPanel slp = new SaveLoadPanel(1);
			 slp.setButtonListener(new LoadInfo());
			 
			
		}
	}
}