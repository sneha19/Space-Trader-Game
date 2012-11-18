// $codepro.audit.disable com.instantiations.assist.eclipse.analysis.audit.rule.effectivejava.alwaysOverridetoString.alwaysOverrideToString
import java.io.Serializable;

/**
 * The zone class representing a solar system
 * @author Guang Lu
 * @version 1
 */
public class Zone implements Serializable {
	/**
	 * field zoneLevel
	 */
	private int zoneLevel; // $codepro.audit.disable variableShouldBeFinal -->
	
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
	public int getZone(){
		return zoneLevel;
	}
}