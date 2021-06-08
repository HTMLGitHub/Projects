/**
 * 
 */
package engine;

import java.util.Random;

/**
 * @author bak12
 *
 */
public class RandomNumberGenerator
{
	public static Random generator = new Random();
	
	public static int NumberBetween(int min, int max)
	{
		return generator.nextInt(max-min) + min;
	}
}
