/**
 * 
 */
package Enums;

/**
 * @author bak12
 *
 */
public enum Tokens 
{
	Iron(false),
	Dog(false),
	Jockey(false),
	Top_Hat(false),
	Canon(false),
	Wheelbarrel(false),
	Battleship(false),
	Thimble(false),
	Racecar(false),
	Boot(false),
	Bank(true);

	boolean taken;
	Tokens(boolean b) 
	{
		taken = b;
	}
	
	public void setTaken(boolean b)
	{
		taken = b;
	}
	
	public boolean showTaken()
	{
		return taken;
	}
}