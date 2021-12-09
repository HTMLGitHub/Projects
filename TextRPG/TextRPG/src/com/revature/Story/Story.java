/**
 * 
 */
package com.revature.Story;

import com.revature.Characters.Player;
import com.revature.Main.GameLogic;

/**
 * @author bak12
 *Story for the game
 *******Change later*********
 */
public class Story 
{
	public static void printGameIntro()
	{
		printTopper("STORY INTRO");
		System.out.println("You are the last man standing after your village got raided by the hanchmen of the Evil Emperor.");
		System.out.println("Every single one of your friends, family and neighbours got murdered. You are standing in the burning ruins of this once prestigious village.");
		System.out.println("All you want now is revenge, so you begin planning your journey to defeat the evil emperor and free the lands!");
		
		GameLogic.Continue();
	}
	
	public static void printFirstActIntro()
	{
		printTopper("ACT I - INTRO");
		System.out.println("As you begin your journey, you start travelling through the nearby woods to reach the Everlasting Mountians.");
		System.out.println("The Everlasting Mountians are a very dangerous place. It is said that nobody comes back from there alive.");
		System.out.println("\nAfter a long day of walking through the woods, you finally reach the Everlasting Mountians.");
		System.out.println("You don't care about the things you have heard and start your journey to defeat the Evil Emperor.");
		
		GameLogic.Continue();
	}
	
	public static void printFirstActOutro()
	{
		printTopper("ACT I - OUTRO");
		System.out.println("You did it! You crossed the Everlasting Mountians and you are still alive!");
		System.out.println("As you climb down the last hill, you are more than happy to feel hard ground beneath your feet again.");
		System.out.println("\nYou feel empowered and the experience you gained allows you to learn another trait!");
		
		GameLogic.Continue();
	}
	
	public static void printSecondActIntro()
	{
		printTopper("ACT II - INTRO");
		System.out.println("You begin travelling across the landlines of this once well populated countryside.");
		System.out.println("You collected some gold from the monsters you killed along the way.");
		System.out.println("Luckily you know that every once in a while a travelling trader comes across the landlines.");
		System.out.println("You know exactly where the castle of the Evil Emperor is, but you hve to cross the Haunted Landlines first...");
		
		GameLogic.Continue();
	}
	
	public static void printSecondActOutro()
	{
		printTopper("ACT II - OUTRO");
		System.out.println("You managed to cross the Haunted Landlines and you are still alive.");
		System.out.println("You are just a few hours away from your final destination; the castle of the Evil Emperor!");
		System.out.println("You know that you probably can not rest there, so you make a last break to restore some health.");
		System.out.println("\nAfter all you have seen, you feel empowerede to learn another trait!");
		
		GameLogic.Continue();
	}
	
	public static void printThirdActIntro()
	{
		printTopper("ACT III - INTRO");
		System.out.println("You see the huge black castle in front of you.");
		System.out.println("As you stand in front of the gates, you know there is no going back!");
		System.out.println("You are disguised as a mercenary and enter the castle. You do not know how much time you have left before someone discovers you.");
		System.out.println("All you can do now is fight for your life and pray to come out as the winner...");
		
		GameLogic.Continue();
	}
	
	public static void printThirdActOutro()
	{
		printTopper("ACT III - OUTRO");
		System.out.println("You have come so far. You defeated all of the Evil Emperor's minions.");
		System.out.println("As you stand in front of the door to his throne, you recall your lost power and restore your health.");
		System.out.println("You get the chance to learn one last trait before entering the Throne Room");
		
		GameLogic.Continue();
	}
	
	public static void printFourthActIntro()
	{
		printTopper("ACT IV - INTRO");
		System.out.println("You enter the Throne Room of the Evil Emperor.");
		System.out.println("He stares you dead in the eyes. You feel the darkness around you.");
		System.out.println("He takes out the Holy Sword of Darkness, the mightiest weapon known to man!");
		System.out.println("All you can do now is fight for you life and pray to come out as the winner...");
		
		GameLogic.Continue();
	}
		
	public static void printGameOutro(Player player)
	{
		printTopper("Congratulations, " + player.name + "! You defeated the Evil Emperor and saved the world!");
		System.out.println("This game was developed by");
		System.out.println("Matthew Lee");
		System.out.println("I hope you enjoyed it!");
		System.out.println("Enjoy the new saved world!");
		
		GameLogic.Continue();
	}
	
	private static void printTopper(String heading)
	{
		GameLogic.clearConsole();
		GameLogic.printSeparator(30);
		System.out.println(heading);
		GameLogic.printSeparator(30);
	}
}
