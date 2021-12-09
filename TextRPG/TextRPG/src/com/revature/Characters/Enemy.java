/**
 * 
 */
package com.revature.Characters;

/**
 * @author bak12
 *
 */
public class Enemy extends Character 
{
	//variable to store the player's current xp
	int playerCurrentXp;
	
	//enemy specific constructor	
	public Enemy(String name, int playerCurrentXp) 
	{
		super(name, (int)(Math.random() * playerCurrentXp + playerCurrentXp / 3 + 5), (int)(Math.random() * (playerCurrentXp / 4 + 2) + 1));

		//assigning variable
		this.playerCurrentXp = playerCurrentXp;
	}

	//Enemy specific attack and defense
	@Override
	public int attack() 
	{
		return (int)(Math.random() * (playerCurrentXp / 4 + 1) + xp / 4 + 3);
	}

	@Override
	public int defend() 
	{
		return (int)(Math.random() * (playerCurrentXp / 4 + 1) + xp / 4 + 4);
	}

}
