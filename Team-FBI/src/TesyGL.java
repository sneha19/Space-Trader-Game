import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class to test the calculatorBuy() method
 * in Trade class
 * @version 1
 * @author Guang Lu
 */
public class TesyGL {
	/**
	 * field trade
	 */
	private Trade trade;
	
	/**
	 * field player
	 */
	private Player player;
	
	/**
	 * field planet
	 */
	private Planet planet;
	
	/**
	 * field techLevel
	 */
	private int techLevel;
	
	/**
	 * set up fixture
	 */
	@Before 
	public void setUp() { 
        player=new Player("Guang");
        planet=new Planet("test planet");
        techLevel=planet.getTechLevel();
        planet.setZone(new Zone(1));
        trade=new Trade(player,planet);
    }
	
	/**
	 * test the method
	 */
	@Test
	public void testCalculatorBuy() {
		int result=trade.calculatorBuy(0);
		int max = 30+(3*techLevel+30*4/100);
		int min = 30-(3*techLevel+30*4/100);
		boolean expected = (result<=max)&&(result>=min);
	    assertTrue(expected);
	}
}
