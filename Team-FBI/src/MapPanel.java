import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * GUI to illustrate the graphical side of the screen with planets, ship, movement, ect. 
 * @author Haytham Abutair
 *
 */
public class MapPanel extends JPanel {
	public static final int WIDTH = 25;
	 public static final int HEIGHT = 20;
	 int zone = 0;
	 private int xValue;
	 private int yValue;
	 private Color color;
	 public Planet[][] planetGrid = new Planet[WIDTH][HEIGHT];
	 //static Player currPlayer = new Player("h");
	 //static Universe universe = new Universe(currPlayer);
	 private double fuelPerMove;
	 
	 private Player currPlayer;
	 private Universe universe;
	 
	 JLabel lblFuelRemaining1;
		
		JLabel lblFuelRemaining;
		
		JLabel lblFuelperMove;
		
		JLabel lblFuelPerMove;
		private JLabel lblLocation;
		private JLabel lblCurrLocation;

	 /**
	 * Create the panel through the contructor.
	 */
	public MapPanel(Universe univ, Player p) {
		universe = univ;
		currPlayer = p;
		planetGrid = univ.getPlanetWithLocation();
		int i = 0;
		this.setSize(new Dimension(450,450));
		fuelPerMove = currPlayer.getShip().getFuelPerMove();
		lblFuelRemaining1 = new JLabel("Fuel remaining:");
		
		lblFuelRemaining = new JLabel("New label");
		
		lblFuelperMove = new JLabel("Fuel/per move:");
		
		lblFuelPerMove = new JLabel("New label");
		
		lblLocation = new JLabel("Location:");
		
		lblCurrLocation = new JLabel("[" +currPlayer.getPosition().x + " , " + currPlayer.getPosition().y + "]");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addComponent(lblFuelRemaining1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFuelRemaining)
					.addGap(30)
					.addComponent(lblFuelperMove)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFuelPerMove)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblLocation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCurrLocation)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(428, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFuelRemaining1)
						.addComponent(lblFuelRemaining)
						.addComponent(lblFuelperMove)
						.addComponent(lblFuelPerMove)
						.addComponent(lblLocation)
						.addComponent(lblCurrLocation))
					.addContainerGap())
		);
		lblFuelRemaining.setText(Double.toString(currPlayer.getShip().getCurrentFuel()));
		lblFuelPerMove.setText(Double.toString(currPlayer.getShip().getFuelPerMove()));
		setLayout(groupLayout);
		setVisible( true );
		//this.addKeyListener(new KeyController());
		 
		//KeyController kc = new KeyController();
		 //this.addKeyListener(kc);
		 this.requestFocusInWindow();
		repaint();
		
		 
		
	}
	/**
	 * update all current labels on the screen 
	 */
	public void updateLables()
	{
		lblFuelRemaining.setText(Double.toString(currPlayer.getShip().getCurrentFuel()));
		lblFuelPerMove.setText(Double.toString(currPlayer.getShip().getFuelPerMove()));
		lblCurrLocation.setText("["+currPlayer.getPosition().x + " , " + currPlayer.getPosition().y + "]");
	}
	
	 /**
	  * Draw method to draw the playing field
	  * @param g Graphics object
	  * @param tileDimension dimension of the tile
	  */
	 public void draw(Graphics g)
	 {
	 universe.draw(g);
	 
//	  KeyController key = new KeyController();
	 }
	 /**
	  * used for JPanel over-ride
	  */
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 draw(g);
	 }
	
	/* 
	 public static void main(String[] args)
	 {	
		 Player currPlayer = new Player("a");
		 Universe universe = new Universe(currPlayer);
		 MapPanel mp = new MapPanel(universe, currPlayer);
		 JFrame f = new JFrame();
		 f.getContentPane().add(mp);
		 f.setSize(new Dimension(450,450));
		 f.setVisible(true);
		 f.setFocusable(true);
		 mp.requestFocusInWindow();	
	 }*/
	 
	 
	 /**
	  * checks weather a planet is present in a certain location
	  * @param currLocation current location of ship
	  * @return true if planet is present, false O/W
	  */
	 public Boolean checkIfPlanetIsPresent(Point currLocation)
	 {
		 if(currLocation.x < WIDTH && currLocation.x >=0 && currLocation.y < HEIGHT && currLocation.y >=0){
		 if(planetGrid[currLocation.x][currLocation.y] != null)
			 return true;
		 }
		 return false;
	 }
	 /**
	  * checks to see if a move is allowed
	  * @return true if allowed, false O/W
	  */
	 public boolean checkIfMoveIsValid()
	 {
		 if(currPlayer.getShip().getCurrentFuel() >= currPlayer.getShip().getFuelPerMove())
			 return true;
		 else return false;
	 }
	 
	 /*
	 private class KeyController implements KeyListener {
		 public KeyController()
		 {
			 setFocusable(true);
			// addKeyListener(this);
		 }
	        @Override
	        public void keyPressed(final KeyEvent key) {
	            if (currPlayer != null) {

	                int oldX = currPlayer.getPosition().x;
	                int oldY = currPlayer.getPosition().y;
	                switch (key.getKeyCode()) {
	                    case KeyEvent.VK_RIGHT:
	                    	if(oldX+1 < WIDTH && checkIfMoveIsValid()){
	                    		//checkIfPlanetIsPresent(currPlayer.getPosition()) 
	                      currPlayer.setPosition(new Point(oldX+1, oldY)); //move right
	                      if(checkIfPlanetIsPresent(currPlayer.getPosition()))
	                    	  createTrade();  
	                      currPlayer.getShip().setCurrentFuel(fuelPerMove);
	                    	}
	                        break;
	                    case KeyEvent.VK_LEFT:
	                    	if(oldX-1 >=0  && checkIfMoveIsValid()){
	                    		//checkIfPlanetIsPresent(currPlayer.getPosition()) 
	                      currPlayer.setPosition(new Point(oldX-1, oldY)); //move left
	                      if(checkIfPlanetIsPresent(currPlayer.getPosition()))
	                    	  createTrade();  
	                      currPlayer.getShip().setCurrentFuel(fuelPerMove);
	                    	}
	                        break;
	                    case KeyEvent.VK_DOWN:
	                    	if(oldY+1 < HEIGHT && checkIfMoveIsValid()){
	                    		//checkIfPlanetIsPresent(currPlayer.getPosition()) 
	                      currPlayer.setPosition(new Point(oldX, oldY+1)); //move down
	                      if(checkIfPlanetIsPresent(currPlayer.getPosition()))
	                    	  createTrade();  
	                      currPlayer.getShip().setCurrentFuel(fuelPerMove);
	                    	}
	                    	break;
	                    case KeyEvent.VK_UP:
	                    	if(oldY-1 >= 0 && checkIfMoveIsValid()){
	                      currPlayer.setPosition(new Point(oldX, oldY-1)); //move up
	                      System.out.println(currPlayer.getPosition());
	                      if(checkIfPlanetIsPresent(currPlayer.getPosition()))
	                    	  createTrade();          	  
	                    	  currPlayer.getShip().setCurrentFuel(fuelPerMove);
	                    	}
	                    	break;
	                }

	            }
	            if(currPlayer.getShip().getCurrentFuel() < currPlayer.getShip().getFuelPerMove())
	            {
	            	JOptionPane.showMessageDialog(new JFrame(), "Game OVER!");

	            }
                updateLables();
	            repaint();
	        }
	        
	        public void createTrade()
	        {
	        	
	        	JFrame f = new JFrame("Trade");
	        	int answer = JOptionPane.showConfirmDialog(f, "Trade?");
	            if (answer == JOptionPane.YES_OPTION) {
	        	f.add(new Trade(currPlayer, planetGrid[currPlayer.getPosition().x][currPlayer.getPosition().y]));
	        	f.setVisible(true);
	        	f.setSize(new Dimension(700,700));
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
	    */
	 /**
	  * returns the amount of fuel used per move
	  * @return fuel used
	  */
	public double getfuelPerMove(){
		 return fuelPerMove;
	 }
	/**
	 * keyListener used for this panel
	 * @param k user keylistener
	 * @return true if allowed, false otherwise
	 */
	public boolean setKeyListener(KeyListener k){
		this.addKeyListener(k);
		return true;
	}
}
