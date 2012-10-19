import javax.swing.JPanel;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;


public class MapPanel extends JPanel {
	public static final int WIDTH = 25;
	 public static final int HEIGHT = 20;
	 int zone = 0;
	 private int xValue;
	 private int yValue;
	 private Color color;
	 protected Planet[][] planetGrid = new Planet[HEIGHT][WIDTH];
	 Universe universe = new Universe();

	/**
	 * Create the panel.
	 */
	public MapPanel(Universe univ) {
		this.universe = univ;
		for(int i =0; i < universe.getPlanet().length; i++)
		{
			if(universe.getPlanet()[i] != null){
			int xCord = universe.getPlanet()[i].getLocation().x;
			int yCord = universe.getPlanet()[i].getLocation().y;
			planetGrid[xCord][xCord] = planetGrid[xCord][yCord];
			}
		}
		
	}
	
	
	 /**
	  * Draw method to draw the playing field
	  * @param g Graphics object
	  * @param tileDimension dimension of the tile
	  */
	 public void draw(Graphics g, Dimension tileDimension)
	 {
	  
	  for(int i = 0; i < WIDTH; i++)
	  {
	   for(int j = 0; j < HEIGHT; j++)
	   {
	    if(planetGrid[i][j] != null)
	    {
	    	
//	     g.setColor(Color.gray);
//	    g.drawRect(i*tileDimension.width, j*tileDimension.height, tileDimension.width, tileDimension.height);
    }
	    else
	    {
	     g.setColor(getColor(i,j));
	     g.fillRect(i*tileDimension.width, j*tileDimension.height, tileDimension.width, tileDimension.height);
	    } 
	   } 
	 }
	  
	  
	  
	 }
	

}
