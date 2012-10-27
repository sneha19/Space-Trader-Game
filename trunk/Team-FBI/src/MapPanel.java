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


public class MapPanel extends JPanel {
	public static final int WIDTH = 25;
	 public static final int HEIGHT = 20;
	 int zone = 0;
	 private int xValue;
	 private int yValue;
	 private Color color;
	 public Planet[][] planetGrid = new Planet[WIDTH][HEIGHT];
	 static Player currPlayer = new Player("h");
	 static Universe universe = new Universe(currPlayer);

	 /**
	 * Create the panel.
	 */
	public MapPanel(Universe univ, Player p) {
		this.universe = univ;
		currPlayer = p;
		int i = 0;
		
//		for(Planet p: universe.getPlanet())
//		{
//			if(p != null)
//			{
//				int xCord = universe.getPlanet()[i].getLocation().x;
//				int yCord = universe.getPlanet()[i].getLocation().y;
//				//planetGrid[xCord][yCord] = p;
//				System.out.println("name: " + p.getPlanetName() + " x: " + p.getLocation().x + " y: " + p.getLocation().y);
//			}
//			i++;
//		}
		
		this.setSize(new Dimension(450,450));
		setVisible( true );
//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		repaint();
		
	}
	
	
	 /**
	  * Draw method to draw the playing field
	  * @param g Graphics object
	  * @param tileDimension dimension of the tile
	  */
	 public void draw(Graphics g)
	 {
	 universe.draw(g);
	  KeyController key = new KeyController();
	 }
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 draw(g);
	 }
	 public static void main(String[] args)
	 {
		 MapPanel mp = new MapPanel(universe, currPlayer);
		 JFrame f = new JFrame();
		 f.add(mp);
		 f.setSize(new Dimension(450,450));
		 f.setVisible(true);
		 f.setFocusable(true);
		
	 }
	 private class KeyController extends KeyAdapter {

	        @Override
	        public void keyPressed(final KeyEvent key) {
	        	System.out.println("fgfgf");
	            if (currPlayer != null) {

	                int oldX = currPlayer.getPosition().x;
	                int oldY = currPlayer.getPosition().y;

	                switch (key.getKeyCode()) {
	                    case KeyEvent.VK_RIGHT:
	                      currPlayer.setPosition(new Point(oldX+1, oldY)); //move right
	                      System.out.println("RIGHT");
	                        break;
	                    case KeyEvent.VK_LEFT:
		                      currPlayer.setPosition(new Point(oldX-1, oldY)); //move left
	                        break;
	                    case KeyEvent.VK_DOWN:
		                      currPlayer.setPosition(new Point(oldX, oldY+1)); //move down
	                        break;
	                    case KeyEvent.VK_UP:
		                      currPlayer.setPosition(new Point(oldX, oldY-1)); //move up
	                        break;
	                }

	            }
	            repaint();
	        }
	    }
	 
	

}
