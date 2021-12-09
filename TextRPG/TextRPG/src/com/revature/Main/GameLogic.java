package com.revature.Main;
import java.util.Scanner;

import com.revature.Characters.Enemy;
import com.revature.Characters.Player;
import com.revature.Story.Story;

public class GameLogic
{
	static Scanner scan = new Scanner(System.in);
	static Player player; 
	
	public static boolean isRunning = true;
	
	//random encounters
	public static String[] encounters = {"Battle", "Battle", "Battle", "Rest", "Rest"};
	
	//enemy names
	public static String[] enemies = {"Ogre", "Ogre", "Goblin", "Goblin", "Stone Elemental"};
	
	//Story elements
	public static int place = 0, act = 1;
	public static String[] places = {"Everlasting Mountians", "Haunted Landlines", "Castle of the Evil Emperor", "Throne Room"}; 
	
	//method to get our user input from console
	public static int readInt(String Prompt, int userChoices)
	{
		int input;
		
		do
		{
			System.out.println(Prompt);
			try
			{
				input = Integer.parseInt(scan.next());
			}
			catch(Exception e)
			{
				input = -1;
				System.out.println("Please enter an integer");
			}
		}while(input<1 || input > userChoices);
		return input;
	}
	
	//method to simulate clearing out the console
	public static void clearConsole()
	{
		for(int i = 0; i<100; i++)System.out.println();
	}
	
	//method to print a separator with length 'n'
	public static void printSeparator(int n)
	{
		for(int i = 0; i<n; i++)System.out.print("-");
		System.out.println();
	}
	
	//method to print a heading
	public static void printHeading(String Title)
	{
		printSeparator(30);
		System.out.println(Title);
		printSeparator(30);
	}
	
	//method to stop the game until user enters anything
	public static void Continue()
	{
		System.out.println("\nEnter anything to continue...");
		scan.nextLine();		
	}
	
	//method to start game
	public static void startGame()
	{
		boolean setName = false;
		String name;
		
		//print Title Screen
		clearConsole();
		printSeparator(40);
		printSeparator(30);
		System.out.println("AGE OF EVIL EMPEROR");
		System.out.println("TEXT RPG BY MATTHEW LEE");
		printSeparator(30);
		printSeparator(40);
		Continue();
		
		//getting the player's name
		do
		{
			clearConsole();
			printHeading("What is your character's name");
			name = scan.nextLine();
			
			//asking the player if they the name is correct
			clearConsole();
			printHeading("Your name is: " + name + ". \nIs this correct?");
			System.out.println("(1) Yes! Let's Go!");
			System.out.println("(2) No, I would like to change the name.");
			int input = readInt("-> ", 2);
			
			if(input == 1) setName = true;
		}while(!setName);
		
		//print story intro
		Story.printGameIntro();
		
		//create the new player object with the name
		player = new Player(name);
		
		//print first act intro
		Story.printFirstActIntro();
		
		//setting isRunning to true, so the game can continue
		isRunning = true;
		
		//start main game loop
		gameLoop();
	}
	
	//method that changes the game's values based on player xp
	public static void checkAct()
	{
		//change acts based on xp
		if(player.xp >= 10 && act == 1)
		{
			//increment act and place
			act = 2;
			place = 1;
			
			//story
			Story.printFirstActOutro();
			
			//let the player level up
			player.chooseTrait();
			
			//story
			Story.printSecondActIntro();
			
			//assign new values to enemies
			enemies[0] = "Evil Mercenary";
			enemies[1] = "Goblin";
			enemies[2] = "Wolf Pack";
			enemies[3] = "Henchman of the Evil Emperor";
			enemies[4] = "Scary Stranger";
			
			//assign new values to encounters
			encounters[0] = "Battle";
			encounters[1] = "Battle";
			encounters[2] = "Battle";
			encounters[3] = "Rest";
			encounters[4] = "Shop";
		}
		else if(player.xp >= 50 && act == 2)
		{
			//increment act and place
			act = 3;
			place = 2;
			
			//story
			Story.printSecondActOutro();
			
			//let the player level up
			player.chooseTrait();
			
			//story
			Story.printThirdActIntro();
			
			//assign new values to enemies
			enemies[0] = "Evil Mercenary";
			enemies[1] = "Evil Mercenary";
			enemies[2] = "Henchman of the Evil Emperor";
			enemies[3] = "Henchman of the Evil Emperor";
			enemies[4] = "Henchman of the Evil Emperor";
			
			//assign new values to encounters
			encounters[0] = "Battle";
			encounters[1] = "Battle";
			encounters[2] = "Battle";
			encounters[3] = "Battle";
			encounters[4] = "Shop";
			
			//fully heal the player
			player.hp = player.maxHp;
		}
		else if(player.xp >= 100 && act == 3)
		{
			//increment act and place
			act = 4;
			place = 3;
			
			//story
			Story.printThirdActOutro();
			
			//let the player level up
			player.chooseTrait();
			
			//story
			Story.printFourthActIntro();
			
			//fully heal the player
			player.hp = player.maxHp;
			
			//calling the final battle
			finalBattle();
		}
	}
	
	//the final (last) battle fo the entire game
	private static void finalBattle() 
	{
		//creating the evil emperor and letting the player fight against him
		battle(new Enemy("THE EVIL EMPEROR", 300));
		
		//printing the proper ending
		Story.printGameOutro(player);
		isRunning = false;
		
	}

	//method to calculate a random encounter
	public static void randomEncounter()
	{
		//random number between 0 and the length of the encounters array
		int encounter = (int)(Math.random() * encounters.length);
		
		//calling the respective methods
		if(encounters[encounter].equals("Battle")) randomBattle();
		else if(encounters[encounter].equals("Rest")) takeRest();
		else shop();
	}
	
	private static void takeRest() 
	{
		clearConsole();
		if(player.restsLeft >= 1)
		{
			printHeading("Do you want to take a rest? (" + player.restsLeft + " rest(s) left).");
			System.out.println("(1) Yes\n(2) No, not now.");
			int input = readInt("-> ", 2);
			if(input == 1)
			{
				//player actually wants to rest
				clearConsole();
				if(player.hp < player.maxHp)
				{
					int hpRestored = (int)(Math.random() * (player.xp / 4 + 1) + 10);
					player.hp +=hpRestored;
					
					if(player.hp > player.maxHp) player.hp = player.maxHp;
					
					System.out.println("You took a rest and restored " + hpRestored + " health.");
					System.out.println("You are now at " + player.hp + "/" + player.maxHp  + " health");
					player.restsLeft--;
				}
				else
				{
					System.out.println("You're still at full health. You do not need to rest right now");
					Continue();
				}
			}
		}
	}

	private static void shop() 
	{
		clearConsole();
		printHeading("You meet a mysterious stranger.\nHe offers you something:");
		int price = (int)(Math.random() * (10 + player.potions * 3) + 10 + player.potions);
		
		System.out.println("- Magic Potion: " + price + " gold.");
		printSeparator(20);
		
		//ask the player if her wishes to buy it
		System.out.println("Do you want to buy one?\n(1) Yes!\n(2) No Thank You.");
		int input = readInt("-> ", 2);
		
		//check if the player wants to buy
		if(input == 1)
		{
			clearConsole();
			
			//check if the player has enough gold
			if(player.gold >= price)
			{
				printHeading("You bought a magical potion for " + price + " gold.");
				player.potions++;
				player.gold -= price;
			}
			else
			{
				printHeading("You do not have enough gold. Sorry.");
				Continue();
			}
		}
		else
		{
			printHeading("Your loss.");
			Continue();
		}
	}

	//method to continue the journey
	public static void continueJourney()
	{
		//check if act must be increased
		checkAct();
		
		//check if game is in last act
		if(act != 4) randomEncounter();
	}
	
	//printing out the most important information about the player's character
	public static void characterInfo()
	{
		clearConsole();
		printHeading("CHARACTER INFORMATION");
		System.out.println(player.name + "\tHP: " + player.hp +  "/" + player.maxHp);
		printSeparator(20);
		
		//player xp and gold
		System.out.println("XP: " + player.xp + "\tGold: " + player.gold);
		printSeparator(20);
		
		//number of potions
		System.out.println("Potions: " + player.potions);
		printSeparator(20);
		
		//printing the chosen traits
		if(player.numAtkUpgrades> 0)
		{
			System.out.println("Offensive Trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
			printSeparator(20);
		}
		if(player.numDefUpgrades>0)System.out.println("Defensive Trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
		
		Continue();
	}
	
	public static void randomBattle()
	{
		clearConsole();
		printHeading("You encountered an evil minded creature. You'll have to fight it!");
		Continue();
		
		//creating new enemy with random name
		battle(new Enemy(enemies[(int)(Math.random() * enemies.length)], player.xp));
	}
	
	//the mail battle method
	public static void battle(Enemy enemy)
	{
		//main battle loop
		loop: while(true)
		{
			clearConsole();
			printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
			printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
			System.out.println("Choose an action:");
			printSeparator(20);
			
			System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away");
			int input = readInt("->", 3);
			
			//react accordingly to player input
			
			switch(input)
			{
			case 1:
				//Fight
				//calculate damage and damage Took (damage enemy deals to player)
				int dmg = player.attack() - enemy.defend();
				int dmgRecieved = enemy.attack() - player.defend();
				
				//check that the dmg and received is not negative
				if(dmgRecieved < 0)
				{
					//add some dmg if player defends very well
					dmg -= dmgRecieved / 2;
					dmgRecieved = 0;
				}
				if(dmg<0) dmg = 0;
				
				//deal damage to both parties
				player.hp -= dmgRecieved;
				enemy.hp -= dmg;
				
				//print the info of this battle round
				clearConsole();
				printHeading("BATTLE");
				System.out.println("You dealt: " + dmg + " damage to the " + enemy.name + ".");
				printSeparator(15);
				System.out.println("The " + enemy.name + " dealt " + dmgRecieved + " damage to you");
				Continue();
				
				//check if player is still alive
				if(player.hp <= 0)
				{
					playerDied(); //method to end the game
					break loop;
				}
				else if(enemy.hp <= 0)
				{
					//tell the player he's won
					clearConsole();
					printHeading("You defeated the " + enemy.name + "!");
					
					//increase player's xp
					player.xp += enemy.xp;
					System.out.println("You earned " + enemy.xp + " xp!");
					
					//random drops
					boolean addRest = (Math.random() * 5 + 1 <= 2.5);
					int goldEarned = (int)(Math.random() * enemy.xp);
					
					if(addRest)
					{
						player.restsLeft++;
						System.out.println("You gained another rest.");
					}
					if(goldEarned > 0)
					{
						player.gold += goldEarned;
						System.out.println("You collect " + goldEarned + " gold from the " + enemy.name + " corpse!" );
					}
						
					Continue();
					break loop;
				}
				break;
			case 2: 
				//use potion
				clearConsole();
				if(player.potions > 0)
				{
					if(player.hp < player.maxHp)
					{
						//player can drink the potion
						//make sure the player wants to
						printHeading("Do you want to drink a potion? (" + player.potions + " left).");
						System.out.println("(1) Yes/n(2) No, maybe later");
						input = readInt("-> ", 2);
						if(input == 1)
						{
							//player actually took it
							player.hp = player.maxHp;
							clearConsole();
							printHeading("You drank a magic potion. It restored your health back to " + player.maxHp);
							Continue();
						}
					}
					else
					{
						//player health at full already
						printHeading("Your health is already full. Taking a potion would be pointless");
						Continue();
					}
				}
				else
				{
					//player does not have any potions to drink
					printHeading("You do not have any potions to drink.");
					Continue();
				}
				break;
			default:
				//run away
				clearConsole();
				
				//check to make sure the player is not in the last act (final boss battle)
				if(act!=4)
				{
					//chance of escape 35%
					if(Math.random() * 10 + 1 <= 3.5)
					{
						printHeading("You ran away from the " + enemy.name + "!");
						Continue();
						break loop;
					}
					else
					{
						printHeading("You didn't manage to escape.");
						
						//calculate the damage the player takes
						int dmgReceived = enemy.attack();
						System.out.println("In your hurry, you took " + dmgReceived + " damage!");
						Continue();
						
						//check if palyer is still alive
						if(player.hp <= 0)
						{
							playerDied();
						}
					}
				}
				else
				{
					printHeading("RUNNING AWAY FROM THE EVIL EMPEROR IS NOT AN OPTION!");
					Continue();
				}
				break;
			}
		}
	}
	
	public static void playerDied()
	{
		clearConsole();
		printHeading("You Died...");
		printHeading("You earned  " + player.xp + " XP on your journey. Try to earn more next time!");
		System.out.println("Thank you for playing Awaken Online");
		isRunning = false;
	}
	
	public static void printMenu()
	{
		clearConsole();
		printHeading(places[place]);
		System.out.println("Choose an action: ");
		printSeparator(20);
		System.out.println("(1) Continue on your journey");
		System.out.println("(2) Character Information");
		System.out.println("(3) Exit Game");
	}
	
	//main game loop
	public static void gameLoop()
	{
		while(isRunning)
		{
			printMenu();
			int input = readInt("->", 3);
			
			switch(input)
			{
			case 1:
					continueJourney();
					break;
			case 2: 
					characterInfo();
					break;
			default: 
				isRunning = false;
			}
		}
	}
}
