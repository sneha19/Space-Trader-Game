// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString, emptyMethod, numericLiterals, variableShouldBeFinal, lossOfPrecisionInCast, staticMemberAccess, com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.constructorsOnlyInvokeFinalMethods, booleanMethodNamingConvention, com.instantiations.assist.eclipse.analysis.unusedReturnValue, methodChainLength, com.instantiations.assist.eclipse.analysis.avoidSimilarNames
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * GUI to illustrate the graphical side of the screen with planets, ship, movement, ect. 
 * @author Haytham Abutair
 *
 * @version $Revision: 1.0 $
 */
public class MapPanel extends JPanel {
	/**
	 * Field WIDTH.
	 * (value is 25)
	 */
	public static final int WIDTH = 25;
	
	/**
	 * Field HEIGHT.
	 * (value is 20)
	 */
	public static final int HEIGHT = 20;
	
	/**
	 * Field planetGrid.
	 */
	public Planet[][] planetGrid = new Planet[WIDTH][HEIGHT];
	
	/**
	 * Field starDockGrid.
	 */
	public StarDockInfo[][] starDockGrid = new StarDockInfo[WIDTH][HEIGHT];
	
	/**
	 * Field fuelPerMove.
	 */
	private double fuelPerMove;
	
	/**
	 * Field currPlayer.
	 */
	private Player currPlayer;
	
	/**
	 * Field universe.
	 */
	private Universe universe;
	
	/**
	 * Field lblFuelRemaining1.
	 */
	private JLabel lblFuelRemaining1;
	
	/**
	 * Field lblFuelRemaining.
	 */
	private JLabel lblFuelRemaining;
	
	/**
	 * Field lblFuelperMove.
	 */
	private JLabel lblFuelperMove;
	
	/**
	 * Field lblFuelPerMove.
	 */
	private JLabel lblFuelPerMove;
	
	/**
	 * Field lblLocation.
	 */
	private JLabel lblLocation;
	
	/**
	 * Field lblCurrLocation.
	 */
	private JLabel lblCurrLocation;

	/**
	 * Create the panel through the contructor.
	 * @param univ Universe
	 * @param p Player
	 */
	public MapPanel(Universe univ, Player p) {
		universe = univ;
		currPlayer = p;
		planetGrid = univ.getPlanetWithLocation();
		starDockGrid = univ.getStarDocksWithLocation();
		this.setSize(new Dimension(450, 450));
		fuelPerMove = currPlayer.getShip().getFuelPerMove();
		lblFuelRemaining1 = new JLabel("Fuel remaining:");

		lblFuelRemaining = new JLabel("New label");
		lblFuelRemaining.setText(currPlayer.getShip().getCurrentFuel() + "");
		lblFuelperMove = new JLabel("Fuel/per move:");

		lblFuelPerMove = new JLabel("New label");

		lblLocation = new JLabel("Location:");

		lblCurrLocation = new JLabel("[" + currPlayer
				.getPosition().x + " , " + currPlayer.getPosition().y + "]");
		
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
		this.requestFocusInWindow();
		repaint();
		this.addMouseListener(new StatsListener());
	}
	
	/**
	 * update all current labels on the screen 
	 */
	public void updateLables(){
		lblFuelRemaining.setText(Double.toString(currPlayer.getShip().getCurrentFuel()));
		lblFuelPerMove.setText(Double.toString(currPlayer.getShip().getFuelPerMove()));
		lblCurrLocation.setText("[" + currPlayer.getPosition().x  +  " , "  
				+  currPlayer.getPosition().y  +  "]");
	}

	/**
	 * Draw method to draw the playing field
	 * @param g Graphics object
	 */
	public void draw(Graphics g){
		
		universe.draw(g);
    	g.drawImage(currPlayer.getShip().getPic(), 
    			30 * currPlayer.getPosition().x, 
    			30 * currPlayer.getPosition().y, null);


	}
	
	/**
	 * used for JPanel over-ride
	 * @param g Graphics
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image bg = new ImageIcon("img/space.jpg").getImage();
		g.drawImage(bg, 0, 0, getWidth(), getHeight() - 25, this);
		draw(g);
	}

	/**
	 * checks weather a planet is present in a certain location
	 * @param currLocation current location of ship
	 * @return true if planet is present
	 */
	public Boolean checkIfPlanetIsPresent(Point currLocation){
		if(currLocation.x < WIDTH && currLocation.x >= 0 
				&& currLocation.y < HEIGHT && currLocation.y >= 0){
			if(planetGrid[currLocation.x][currLocation.y] != null){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Method checkIfStarDockIsPresent.
	 * @param currLocation Point
	 * @return Boolean
	 */
	public Boolean checkIfStarDockIsPresent(Point currLocation){
		if(currLocation.x < WIDTH && currLocation.x >= 0 
				&& currLocation.y < HEIGHT && currLocation.y >= 0){
			if(starDockGrid[currLocation.x][currLocation.y] != null){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * checks to see if a move is allowed
	 * @return true if allowed, false O/W 
	 */
	public boolean checkIfMoveIsValid(){
		if(currPlayer.getShip().getCurrentFuel() >= 
				currPlayer.getShip().getFuelPerMove()){
			return true;
		}
		return false;
	}

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
	 */
	public void setKeyListener(KeyListener k){
		this.addKeyListener(k);
	}
	
	/**
	 * This is a private class that implements the mouse listener interface. 
	 * It shows the stats of a planet when clicked
	 * @author Guang Lu
	 * @version 1.0
	 */
	private class StatsListener implements MouseListener{
		/**
		 * implemented method
		 * @param e a MouseEvent
		 * @see java.awt.event.MouseListener#mouseClicked(MouseEvent)
		 */
		public void mouseClicked(MouseEvent e){
			Point point = e.getPoint();
			Point targetLocation = new Point((int) Math.ceil(point.x / 30), 
					(int) Math.ceil(point.y / 30));
			Planet[][] list = universe.getPlanetWithLocation();
			
			for(int i=0;i < 25;i++){
				for(int j=0;j < 20;j++){
					if(list[i][j] != null && list[i][j]
							.getLocation().equals(targetLocation)){
						int distance =Math.abs(list[i][j]
								.getLocation().x - currPlayer.getPosition().x) 
								+ Math.abs(list[i][j].getLocation().y 
										- currPlayer.getPosition().y);
						if(distance <= 10){
							Stats stats = new Stats(list[i][j], currPlayer);
							JFrame statsFrame = new JFrame();
							statsFrame.add(stats);
							statsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							statsFrame.setPreferredSize(new Dimension(330, 440));
							statsFrame.pack();
							statsFrame.setVisible(true);
						}
					}
				}
			}
		}
		
		/**
		 * implemented method
		 * @param e a MouseEvent
		 * @see java.awt.event.MouseListener#mouseEntered(MouseEvent)
		 */
		public void mouseEntered(MouseEvent e){
		};
		
		/**
		 * implemented method
		 * @param e a MouseEvent
		 * @see java.awt.event.MouseListener#mouseExited(MouseEvent)
		 */
		public void mouseExited(MouseEvent e){
		};
		
		/**
		 * implemented method
		 * @param e a MouseEvent
		 * @see java.awt.event.MouseListener#mousePressed(MouseEvent)
		 */
		public void mousePressed(MouseEvent e){
		};
		
		/**
		 * implemented method
		 * @param e a MouseEvent
		 * @see java.awt.event.MouseListener#mouseReleased(MouseEvent)
		 */
		public void mouseReleased(MouseEvent e){

		};
	}
}
