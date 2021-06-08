/**
 * 
 */
package superAdventure;

import engine.Player;

/**
 * @author bak12
 *
 */
public class SuperAdventure
{
	private static Player player;
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		new GameFrame();
		new GamePanel();
		
		startGame();
	}
	
	private static void startGame()
	{
		player = new Player(10, 10, 20, 0, 1);	
		System.out.println(player);
	}

}
