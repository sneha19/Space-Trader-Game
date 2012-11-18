//our file
// $codepro.audit.disable logExceptions, numericLiterals
// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;



/**
 * Stardock info class, infoholder only
 * @author haytham abutair
 * @version 1
 *
 */
public class StarDockInfo  implements Serializable{
	/**
	 * point
	 */
	private Point point; // $codepro.audit.disable variableShouldBeFinal

	/**
	 * player
	 */
	private Player player = null;

	/**
	 * image
	 */
	private transient Image stardockImage;
	
	/**
	 * pass in point and player to keep updated
	 *  for position on grid and current player status
	 * @param p point
	 * @param player current player
	 */
	public StarDockInfo(Point p, Player player){
		point = p;
		this.player = player;
		try {
			stardockImage = ImageIO.read(new File("img/OneStop.png"));
		} catch (IOException e) {
			System.out.println("dont need");
		}
	}

	/**
	 * reset the image of stardock after load
	 */
	public void afterLoad(){
		try {
			stardockImage = ImageIO.read(new File("img/OneStop.png"));
		} catch (IOException e) {
			System.out.println("dont need");
		}
	}

	/**
	 * get the image of the ship
	 * @return shipImage
	 */
	public Image getPic(){
		return stardockImage;
	}

	/**
	 * draws the image onto it
	 * @param g graphics
	 * @param p location
	 */
	public void draw(Graphics g, Point p){

		g.drawImage(getPic(), 30 * p.x, 30 * p.y, null);

	}
}
