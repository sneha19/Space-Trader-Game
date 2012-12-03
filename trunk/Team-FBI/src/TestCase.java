// $codepro.audit.disable numericLiterals
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * test cases
 * @author haytham
 * @version 1
 *
 */
public class TestCase {
	/**
	 * ship type
	 */
	private ShipType st;
/**
 * results - output
 */
	private Ship result;

	/**
	 * set up
	 */
	@Before 
	public void setUp() {
		st = ShipType.bullDog;
		result = new Ship(st);
	}

	/**
	 * testing ship
	 * @throws Exception
	 */
	@Test
	public void testShip(){
		setUp(); 
		assertNotNull(result);
		assertEquals("Bulldog", result.getName());
		assertEquals(300, result.getCost());
		assertEquals(false, result.isDead());
		result.setHull(0);
		assertTrue(result.isDead());
		result.setHull(100);
		assertFalse(result.isDead());
		result.setCurrentFuel(50);
		assertEquals(0.0, result.getCurrentFuel(), 0.0);
		result.setCurrentFuel(50505);
		assertTrue(result.isDead());
	}

	/**
	 * test the fuel per move
	 */
	@Test
	public void testFuelPerMove()
	{
		setUp();
		assertEquals(2.0, result.fuelPerMove(), 1.0);
		assertTrue(result.fuelPerMove() > 0);
		assertFalse(result.fuelPerMove() < 0);
		result.setCurrentFuel(5000);
		assertTrue(result.getCurrentFuel() < 0);
		assertTrue(result.isDead());

	}

	/**
	 * test the cargo
	 */
	@Test
	public void testCargo()
	{
		setUp();
		assertEquals(50, result.getCargoCapacity());
		result.setCargoCapacity(-1);
		assertTrue(result.getCargoCapacity() < 0);
		assertFalse(result.getCargoCapacity() > 0);
		result.setCargoCapacity(50);
		assertTrue(result.getCargoCapacity() > 0);


	}

	/**
	 * test the hull
	 */
	@Test
	public void testHull()
	{
		setUp();
		assertEquals(200, result.getHull());
		result.setHull(-1);
		assertTrue(result.getHull() < 0);
		assertFalse(result.getHull() > 0);
		assertTrue(result.isDead());
		assertEquals((int) 200, (int) result.getMaxHull());
	}

	/**
	 * test the fuel capacity
	 */
	@Test
	public void testFuelCapacity()
	{
		setUp();
		assertEquals(50.0, result.getCurrentFuel(), 1.0);
		assertEquals(50, result.getFuelCapacity());
		result.setFuelCapacity(-1);
		assertFalse(result.getFuelCapacity() >= 0);
	}


@Test                                        
public void FillingFuelTest(){//Sneha Ganesh      
 
 ShipType st;
 Ship s = new Ship(st.fighter);
 s.setFuelCapacity(100);
 s.setFuel();
 
                                           
assertFalse("Cannot add fuel when full?", s.canAddMoreFuel());     
s.setFuel(0);                              
assertTrue("Fuel is empty, can travel?", s.canRemoveFuel());
}      
}



