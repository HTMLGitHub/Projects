/**
 * 
 */
package Models;

import Enums.Color;

/**
 * @author bak12
 *
 */
public class RailRoad 
{
	private RailRoad() {}
	
	public static Property Reading()
	{
		return new Property(5, "Reading Railroad", 200, 25, Color.Black);
	}
		
	public static Property Pennsylvania()
	{
		return new Property(15, "Pennsylvania Railroad", 200, 25, Color.Black);
	}
	
	public static Property BO()
	{
		return new Property(25, "B & O Railroad", 200, 25, Color.Black);
	}
	
	public static Property ShortLine() 
	{
		return new Property(35, "Short Line", 200, 25, Color.Black);
	}
}
