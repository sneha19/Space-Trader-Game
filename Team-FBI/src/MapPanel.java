import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;


public class MapPanel extends JPanel {
	public static final int WIDTH = 25;
	 public static final int HEIGHT = 20;
	 int zone = 0;
	 private int xValue;
	 private int yValue;
	 private Color color;
	 public Planet[][] planetGrid = new Planet[WIDTH][HEIGHT];
	 static Universe universe = new Universe();

	/**
	 * Create the panel.
	 */
	public MapPanel(Universe univ) {
		this.universe = univ;
		int i = 0;
		for(Planet p: universe.getPlanet())
		{
			if(p != null)
			{
				int xCord = universe.getPlanet()[i].getLocation().x;
				int yCord = universe.getPlanet()[i].getLocation().y;
				//planetGrid[xCord][yCord] = p;
				System.out.println("name: " + p.getPlanetName() + " x: " + p.getLocation().x + " y: " + p.getLocation().y);
			}
			i++;
		}
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
	 public void draw(Graphics g, Dimension tileDimension)
	 {
	  /*
	  for(int i = 0; i < WIDTH; i++)
	  {
	   for(int j = 0; j < HEIGHT; j++)
	   {
	    if(planetGrid[i][j] != null)
	    {
	    	//super.paint(g);
	    		planetGrid[i][j].draw(g, new Point(i,j));
	    //	universe.getPlanet()[i].draw(g, universe.getPlanet()[i].getLocation());
	    }
	    else
	    {
	     g.setColor(Color.white);
	     g.fillRect(i*tileDimension.width, j*tileDimension.height, 2*tileDimension.width, 2*tileDimension.height);
	    } 
	   } */
	  universe.draw(g);
	// }
	 }
	 public void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 draw(g,new Dimension(10,10));
	 }
	 public static void main(String[] args)
	 {
		 MapPanel mp = new MapPanel(universe);
		 JFrame f = new JFrame();
		 f.add(mp);
		 f.setSize(new Dimension(450,450));
		 f.setVisible(true);
		
	 }
	

}
