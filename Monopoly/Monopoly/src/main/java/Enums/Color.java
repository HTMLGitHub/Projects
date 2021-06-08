/**
 * 
 */
package Enums;

/**
 * @author bak12
 *
 */
public enum Color 
{
	Brown(0),
	Light_Blue(0),
	Light_Purple(0),
	Orange(0),
	Red(0),
	Yellow(0),
	Green(0),
	Blue(0),
	White(0),
	Black(0);

	int colorSetOwned;
	
	Color(int i) 
	{
		colorSetOwned=i;
	}
	
	public void updatePropertiesOwned(int i)
	{
		colorSetOwned+=i;
	}
	
	public int showColorSetOwned() 
	{
		return colorSetOwned;
	}
}
