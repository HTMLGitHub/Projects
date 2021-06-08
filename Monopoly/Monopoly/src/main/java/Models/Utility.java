/**
 * 
 */
package Models;

import Enums.Color;

/**
 * @author bak12
 *
 */
public class Utility 
{
	private final static String rent = "If one \"Utility\" is owned,\nrent is 4 times amount\nshown on dice.\n\nIf both \"Utilities\" are owned,\nrent is 10 times amount on dice.";
	
	private Utility() {}
	
	public static Property Electric_Company()
	{
		return new Property(12, "Electric Company", rent, 150, 4, Color.White);
	}
	
	public static Property Water_Works()
	{
		return new Property(28, "Water Works", rent, 150, 4, Color.White);
	}
}
