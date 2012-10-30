/**
 * The zone class representing a solar system
 * @author Guang Lu
 *
 */
public class Zone {
	int zoneLevel;
	/**
	 * Constructor of the zone class
	 * @param i the zone number
	 */
	public Zone(int i){
		zoneLevel = i;
	}
	/**
	 * Getter for zone number
	 * @return zoneLevel representing zone number
	 */
	public int getZone()
	{
		return zoneLevel;
	}
}