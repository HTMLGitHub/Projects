/**
 * 
 */
package Models;

import java.util.Random;

/**
 * @author bak12
 *
 */
public class Die
{
	private static final int  DIESIDES = 6;
	private static Random rand = new Random();
	
	public Die() {}
	
	public static int Roll(int numOfDie)
	{
		int total = 0;
		
		if(numOfDie==0) return 0;
		int die[] = new int[numOfDie];
		
		for(int i = 0; i<numOfDie; i++)
		{
			die[i] = rand.nextInt(DIESIDES) + 1;
			System.out.println("Die " + (i + 1) + ": " + die[i]);
			total+= die[i];
		}
		
		return total;
	}
	
	public static void main(String args[])
	{
		for(int i = 0; i < 10; i++)
		{
			int roll = Die.Roll(i);
			System.out.println("Die total: " + roll);
			System.out.println();
		}
		
	}
}
