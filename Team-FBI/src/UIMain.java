// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, closeInFinally, closeWhereCreated, numericLiterals
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
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 * This is the class that controls everything and has the main method. 
 * It forms a frame and holds all the necessary panels from other classes.
 * It is the main controller class for the program
 * @author Guang Lu
 * @version 1
 *
 */
public class UIMain implements Serializable {
	/**
	 * random
	 */
	private Random random = new Random();

	/**
	 * player
	 */
	private Player player = null;

/**
 * start
 */
	private Start start;

/**
 * skills
 */
	private Skills skills;

/**
 * skills gui
 */
	private SkillsInterface skillsGUI;

/**
 * frame
 */
	private JFrame frame;

/**
 * tab pane
 */
	private JTabbedPane tabPane;

/**
 * map
 */
	private MapPanel map;

/**
 * stardock
 */
	private StarDock stardock = null;

/**
 * universe
 */
	private Universe universe;

	/**
	 * inventory
	 */
	private Inventory inventory = null;

	/**
	 * setting panel
	 */
	private SettingPanel sp = null;

	/**
	 * Constructor
	 */
	public UIMain(){
		
		start = new Start();
		start.setbtnActionListener(new StartListener(), new ContinueListener());
		tabPane = new JTabbedPane();
		tabPane.addTab("Welcome", start);
		frame = new JFrame("Star Trader");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(800, 800));
		
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
		 * @param event
		 */
		public void actionPerformed (ActionEvent event){ 
			  if(start.isDiffed()){
			  player = new Player("default");
			  player.setName(start.getName()); // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.unusedReturnValue
			  player.setDifficulty(start.getDifficulty()); // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.unusedReturnValue

			  tabPane.remove(0);
			  skills = new Skills(player);
			  skillsGUI= new SkillsInterface(skills);
			  skillsGUI.setbtnNextListener(new NextListener());
			  tabPane.addTab("Skills", skillsGUI);
			  
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
		 * @param e event
		 */
		public void actionPerformed (ActionEvent e){
			frame.setSize(new Dimension(800, 800));

			universe = new Universe(player);
			inventory= new Inventory(player);

			map=new MapPanel(universe, player);
			tabPane.addTab("Inventory", inventory);
			tabPane.addTab("Map", map);
			tabPane.setSelectedIndex(2);
			skillsGUI.disablebtnNext();
			map.setKeyListener(new KeyController());
			
			sp=new SettingPanel();
			sp.setSaveListener(new SaveListener());
			sp.setLoadListener(new LoadListener());
			tabPane.addTab("Setting", sp);
			

			
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
		 * @param e  event 
		 */
		public void actionPerformed(ActionEvent e){
			tabPane.remove(3);
			tabPane.setSelectedIndex(2);
			tabPane.setEnabledAt(0, true);
			tabPane.setEnabledAt(1, true);
			tabPane.setEnabledAt(2, true);
			tabPane.setEnabledAt(3, true);
			inventory.update();
			
			
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
		private KeyController(){
			map.setFocusable(true);
			// addKeyListener(this);
		}

		/**
		 * Method must be implemented from ActionListener interface  
		 * @param key
		 */
		public void keyPressed(final KeyEvent key) { // $codepro.audit.disable cyclomaticComplexity
			if (player != null) {
				int letsSeeIfWeGetRandom;
				int randomation = 0;
				int oldX = player.getPosition().x;
				int oldY = player.getPosition().y;
				switch (key.getKeyCode()) { // $codepro.audit.disable missingDefaultInSwitch
				case KeyEvent.VK_RIGHT:
					if(oldX +  1 < map.WIDTH && map.checkIfMoveIsValid()){ // $codepro.audit.disable staticMemberAccess
						//checkIfPlanetIsPresent(currPlayer.getPosition()) 
						player.setPosition(new Point(oldX + 1, oldY)); //move right // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.unusedReturnValue
						player.getShip().setCurrentFuel(map.getfuelPerMove());
						if(map.checkIfPlanetIsPresent(player.getPosition())){
							createTrade();
						}
						else if(map.checkIfStarDockIsPresent(player.getPosition())){ // $codepro.audit.disable danglingElse
							createStarDock();  
						}
						else{
							randomation = random.nextInt(100);
							if(randomation < 25){
								letsSeeIfWeGetRandom = random.nextInt(2);
								randomEventOccured(letsSeeIfWeGetRandom);
							}
						}
					}
					break;
				case KeyEvent.VK_LEFT:
					if(oldX - 1 >= 0  && map.checkIfMoveIsValid()){
						//checkIfPlanetIsPresent(currPlayer.getPosition()) 
						player.setPosition(new Point(oldX - 1, oldY)); //move left // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.unusedReturnValue
						player.getShip().setCurrentFuel(map.getfuelPerMove());
						if(map.checkIfPlanetIsPresent(player.getPosition())){
							createTrade();
						}
						else if(map.checkIfStarDockIsPresent(player.getPosition())){ // $codepro.audit.disable danglingElse
							createStarDock();  
						}

						else{
							randomation = random.nextInt(100);
							if(randomation < 25){
								letsSeeIfWeGetRandom = random.nextInt(2);
								randomEventOccured(letsSeeIfWeGetRandom);
							}
						}
					}
					break;

				case KeyEvent.VK_DOWN:
					if(oldY + 1 < map.HEIGHT && map.checkIfMoveIsValid()){ // $codepro.audit.disable staticMemberAccess
						//checkIfPlanetIsPresent(currPlayer.getPosition()) 
						player.setPosition(new Point(oldX, oldY + 1)); //move down // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.unusedReturnValue
						player.getShip().setCurrentFuel(map.getfuelPerMove());
						if(map.checkIfPlanetIsPresent(player.getPosition())){
							createTrade();
						}
						else if(map.checkIfStarDockIsPresent(player.getPosition())){ // $codepro.audit.disable danglingElse
							createStarDock();  
						}
						else{
							randomation = random.nextInt(100);
							if(randomation < 25){
								letsSeeIfWeGetRandom = random.nextInt(2);
								randomEventOccured(letsSeeIfWeGetRandom);
							}
						}
					}
					break;
				case KeyEvent.VK_UP:
					if(oldY - 1 >= 0 && map.checkIfMoveIsValid()){
						player.setPosition(new Point(oldX, oldY - 1)); //move up // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.unusedReturnValue
						player.getShip().setCurrentFuel(map.getfuelPerMove());
						if(map.checkIfPlanetIsPresent(player.getPosition())){
							createTrade();  
						}
						else if(map.checkIfStarDockIsPresent(player.getPosition())){
							createStarDock();  
						}
						else{
							randomation = random.nextInt(100);
							if(randomation < 25){
								letsSeeIfWeGetRandom = random.nextInt(2);
								randomEventOccured(letsSeeIfWeGetRandom);
							}
						}
					}
					break;
				}

			}
			if(player.getShip().getCurrentFuel() < player.getShip().getFuelPerMove()){ // $codepro.audit.disable nullPointerDereference
				int reply = JOptionPane.showConfirmDialog(null,
						"Unfortunatly your ship ran out of fuel, play again?",
						"SHIP BLEW UP!", JOptionPane.YES_NO_OPTION);
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
			inventory.update();
		}

		/**
		 * This method will create a trade screen when player agree to trade
		 */
		public void createTrade(){
			JFrame f = new JFrame("Trade");
			int answer = JOptionPane.showConfirmDialog(f, "Trade?");
			if (answer == JOptionPane.YES_OPTION) {
				Trade trade = new Trade(player, map.planetGrid
						[player.getPosition().x][player.getPosition().y]);
				trade.setBtnFinished(new BtnFinishedListener()); // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.unusedReturnValue
				tabPane.add(trade, "Trade", 3);
				tabPane.setSelectedIndex(3);
				tabPane.setEnabledAt(0, false);
				tabPane.setEnabledAt(1, false);
				tabPane.setEnabledAt(2, false);
				tabPane.setEnabledAt(4, false);
			}
		}

		/**
		 * create stardock
		 */
		public void createStarDock(){
			JFrame f = new JFrame("Star Dock");
			stardock = new StarDock(player);
			stardock.setBtnFinished(new BtnFinishedListener());
			tabPane.add(stardock, "StarDock", 3);
			tabPane.setSelectedIndex(3);
			tabPane.setEnabledAt(0, false);
			tabPane.setEnabledAt(1, false);
			tabPane.setEnabledAt(2, false);
			tabPane.setEnabledAt(4, false);

		}

		/**
		 * Method must be implemented from ActionListener interface 
		 * @param e key 
		 */
		public void keyReleased(KeyEvent e) {
			System.out.println("Tdfgdgdfdgf");
		}

		/**
		 * Method must be implemented from ActionListener interface 
		 * @param e key 
		 */
		public void keyTyped(KeyEvent e) {
			System.out.println("typeeeddd");
		}

	}

	/**
	 * Randomly generate a event after player move
	 * @param num
	 */
	public void randomEventOccured(int num){ // $codepro.audit.disable cyclomaticComplexity
		//Random random = new Random();
		//int calculateRate;
		// 1 is for trader came and gave you something for free
		String item = null;
		if(num == 0){
			int whichItem = random.nextInt(5) + 1;
			System.out.println(whichItem);
			if(player.getShip().getCargoCapacity() -
					player.getShip().getCurrentGoods().getTotal()
					< whichItem){
				whichItem = player.getShip().getCargoCapacity() - 
				player.getShip().getCurrentGoods().getTotal();
			}
			if(player.getShip().getCargoCapacity() - 
					player.getShip().getCurrentGoods().getTotal() == 0){
				whichItem = -1;
			}
		//	if(player.getShip().getCargoCapacity() >= player.getShip().getCurrentGoods().getTotal() + whichItem){
				switch(whichItem){ // $codepro.audit.disable missingDefaultInSwitch
				case 0:
					player.getShip().getCurrentGoods().setFirearms(whichItem);
					item = "firearms";
					break;
				case 1:
					player.getShip().getCurrentGoods().setFood(whichItem);
					item = "food";
					break;
				case 2:
					player.getShip().getCurrentGoods().setFurs(whichItem);
					item = "furs";
					break;
				case 3:
					player.getShip().getCurrentGoods().setGames(whichItem);
					item = "games";
					break;
				case 4:
					player.getShip().getCurrentGoods().setMachines(whichItem);
					item = "machines";
					break;
				case 5:
					player.getShip().getCurrentGoods().setMedicines(whichItem);
					item = "medicine";
					break;
				case 6:
					player.getShip().getCurrentGoods().setNarcotics(whichItem);
					item = "narcotics";
					break;
				case 7:
					player.getShip().getCurrentGoods().setOre(whichItem);
					item = "ore";
					break;
				case 8:
					player.getShip().getCurrentGoods().setRobots(whichItem);
					item = "robots";
					break;
				case 9:
					player.getShip().getCurrentGoods().setWater(whichItem);
					item = "water";
					break;
				}
				
				//if(player.getShip().getCurrentGoods().)
				//calculateRate = random.nextInt(5);
				if(whichItem != -1){
				JOptionPane.showMessageDialog (null, "A trader came and gave you "
				+ whichItem + " " + item, "Trader", JOptionPane.INFORMATION_MESSAGE);
				}

			}

		else if(num == 1){
			int hit  = random.nextInt(14);
			player.getShip().setHull(player.getShip().getHull() - hit);
			JOptionPane.showMessageDialog (null, "A pirate came and attacked your ship causing "
			+ hit  + " damage leaving your hull to: " + player.getShip().getHull(),
			"Pirate", JOptionPane.INFORMATION_MESSAGE);
			if(player.getShip().isDead()){
				int reply = JOptionPane.showConfirmDialog(null, 
						"Unfortunatly your ships hull was destroyed, play again?",
						"SHIP BLEW UP!", JOptionPane.YES_NO_OPTION);
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
		}
	}

	/**
	 * save the game
	 * @param i slot number
	 */
	public void save(int i) {
		
		Planet[][] plist=universe.getPlanetWithLocation();
		StarDockInfo[][] slist=universe.getStarDocksWithLocation();

			 try { 
				FileOutputStream fos = new FileOutputStream("game" + i + ".ser"); 
				ObjectOutputStream out = new ObjectOutputStream(fos);  
				out.writeObject(player);
				out.writeObject(plist);
				out.writeObject(slist);
				out.flush(); 
				fos.flush();
				out.close(); 
				fos.close();

				}
			catch (IOException e){ 
				System.out.println(e);
				} 
			} 

	/**
	 * load the game
	 * @param i slot number
	 * @return whether the load is successful
	 */
	public boolean load(int i){ 

			try {
				FileInputStream fis = new FileInputStream("game"+i+".ser");
				ObjectInputStream in = new ObjectInputStream(fis);
				player  =(Player) in.readObject();
				Planet[][] plist  =(Planet[][]) in.readObject();
				StarDockInfo[][] slist  =(StarDockInfo[][]) in.readObject();
				in.close(); 
				fis.close();

				player.getShip().afterLoad();
				universe.setPS(plist, slist);
				universe.afterLoad();
				skills = new Skills(player);
				skillsGUI = new SkillsInterface(skills);
				
				map=new MapPanel(universe, player);
				map.setKeyListener(new KeyController());
				inventory=new Inventory(player);
				return true;
				
				}
			catch (Exception e) { 
				System.out.println(e); 
				return false;
			}
			
		
	}

	/**
	 * Action listener for save button in UIMaim
	 * @author Guang Lu
	 *
	 */
	private class SaveListener implements ActionListener{ // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.favorStaticMemberClassesOverNonStatic
		/**
		 * implemented method
		 * @param e ActionEvent
		 */
		public void actionPerformed(ActionEvent e){
			SaveLoadPanel slp = new SaveLoadPanel(0);
			slp.setButtonListener(new SaveInfo());
		}
	}

	/**
	 * Action Listener for load button in UIMain
	 * @author Guang Lu
	 *
	 */
	private class LoadListener implements ActionListener{ // $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.favorStaticMemberClassesOverNonStatic
		/**
		 * implemented method
		 * @param e ActionEvent
		 */
		public void actionPerformed(ActionEvent e){
			SaveLoadPanel slp = new SaveLoadPanel(1);
			slp.setButtonListener(new LoadInfo());
		}
	}

	/**
	 * Action Listener for choosing save slot
	 * @author Guang Lu
	 *
	 */
	private class SaveInfo implements ActionListener{
		/**
		 * string
		 */
		protected String s;

/**
 * dateFormat
 */
		protected DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

/**
 * calender
 */
		protected Calendar cal = Calendar.getInstance();

		/**
		 * implemented method
		 * @param e ActionEvent
		 */
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

		/**
		 * Write the player info out to a text file
		 * @param i
		 * @throws IOException
		 */
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

	/**
	 * Action Listener for load and choosing load slot
	 * @author Guang Lu
	 *
	 */
	private class LoadInfo implements ActionListener{
		/**
		 * implemented method
		 * @param e ActionEvent
		 */
		public void actionPerformed(ActionEvent e) {
			 frame.setSize(new Dimension(800, 800));
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
			
			tabPane.setComponentAt(0, skillsGUI);
			tabPane.setTitleAt(0, "Skills");
			
			if(tabPane.getTabCount()>=2){
				tabPane.setComponentAt(1, inventory);
				tabPane.setComponentAt(2, map);
			}else{
				tabPane.addTab("Inventory", inventory);
				tabPane.addTab("Map", map);
			}
			
			tabPane.setSelectedIndex(2);
			if(tabPane.getTabCount()==3){
				sp=new SettingPanel();
				sp.setSaveListener(new SaveListener());
				sp.setLoadListener(new LoadListener());
				tabPane.addTab("Setting", sp);
			}
			
			map.requestFocus();
			}
		}
	}

	/**
	 * Action Listener for Continue button
	 * @author Guang Lu
	 *
	 */
	private class ContinueListener implements ActionListener{
		/**
		 * implemented method
		 * @param arg0 ActionEvent
		 */
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