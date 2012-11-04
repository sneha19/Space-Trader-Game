import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Stardock info class, infoholder only
 * @author haytham abutair
 *
 */
public class StarDockInfo {
	Point point;
	Player player;
	Image stardockImage;
	/**
	 * pass in point and player to keep updated for position on grid and current player status
	 * @param p point
	 * @param player current player
	 */
	public StarDockInfo(Point p, Player player)
	{
		point = p;
		this.player = player;
		try {
			stardockImage = ImageIO.read(new File("img/OneStop.png"));
		} catch (IOException e) {
		}
	}

	/**
	 * get the image of the ship
	 * @return shipImage
	 */
	public Image getPic()
	{
		return stardockImage;
	}
	/**
	 * draws the image onto it
	 * @param g graphics
	 * @param p location
	 */
	public void draw(Graphics g,Point p){

		g.drawImage(getPic(), 30*p.x, 30*p.y, null);

	}
}
