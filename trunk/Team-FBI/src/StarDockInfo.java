import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

/**
 * Stardock info class, infoholder only
 * @author haytham abutair
 *
 */
public class StarDockInfo  implements Serializable{
	Point point;
	Player player;
	Image stardockImage;
	
	
	
	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		out.writeObject(new String("sdImg"));
		ImageWriter writer = (ImageWriter) ImageIO.getImageWritersBySuffix("jpg").next();
	        writer.setOutput(ImageIO.createImageOutputStream(out));
	        ImageWriteParam param = writer.getDefaultWriteParam();
	        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
	        param.setCompressionQuality(0.85f);
	        writer.write(null, new IIOImage((RenderedImage) stardockImage, null, null), param);
	}
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
