/**
 * 
 */
package com.Revature.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Cards.Card;
import Cards.Chance;
import Cards.Community_Chest;
import Enums.Color;
import Enums.Tokens;
import Models.Player;
import Models.Property;
import Models.RailRoad;
import Models.Utility;

/**
 * @author bak12
 *
 */
public class Game 
{
	private static List<Property> properties = new ArrayList<Property>();
	private static List<Card> chanceCards = new ArrayList<Card>();
	private static List<Card> communityChestCards = new ArrayList<Card>();
	
	public Random random = new Random();
	
	
	public Game()
	{
		initGame();
	}
	
	private void initGame()
	{
		properties = setProperties();
		chanceCards = setCards("Chance");
		communityChestCards = setCards("Community Chest");
		
		Player raceCar = new Player(Tokens.Racecar);
		
		System.out.println(raceCar.getToken().showTaken());
	}
		
	private static List<Property> setProperties()
	{
		List<Property> places = new ArrayList<Property>();
		//Property(index, name, initialCost, rent, buildingCost, color)
		
		places.add(new Property(1, "Mediterranean Avenue", 60, 2, 50, Color.Brown));
		places.add(new Property(3, "Baltic Avenue", 60, 4, 50, Color.Brown));
		
		
		
		places.add(new Property(6, "Oriental Avenue", 100, 6, 50, Color.Light_Blue));
		places.add(new Property(8, "Vermont Avenue", 100, 6, 50, Color.Light_Blue));
		places.add(new Property(9, "Connecticut Avenue", 120, 8, 60, Color.Light_Blue));
		
		places.add(new Property(11, "St. Charles Place", 140, 10, 100, Color.Light_Purple));
		places.add(new Property(13, "States Avenue", 140, 10, 100, Color.Light_Purple));
		places.add(new Property(14, "Virginia Avenue", 160, 12, 100, Color.Light_Purple));
		
		places.add(new Property(16, "St. James Place", 180, 14, 100, Color.Orange));
		places.add(new Property(18, "Tennessee Avenue", 180, 14, 100, Color.Orange));
		places.add(new Property(19, "New York Avenue", 200, 16, 100, Color.Orange));
		
		places.add(new Property(21, "Kentucky Avenue", 220, 18, 150, Color.Red));
		places.add(new Property(23, "Indiana Avenue", 220, 18, 150, Color.Red));
		places.add(new Property(24, "Illinois Avenue", 240, 20, 150, Color.Red));
		
		places.add(new Property(26, "Atlantic Avenue", 260, 22, 150, Color.Yellow));
		places.add(new Property(27, "Ventnor Avenue", 260, 22, 150, Color.Yellow));
		places.add(new Property(29, "Marvin Gardens", 280, 24, 150, Color.Yellow));
		
		places.add(new Property(31, "Pacific Avenue", 300, 26, 200, Color.Green));
		places.add(new Property(32, "North Carolina Avenue", 300, 26, 200, Color.Green));
		places.add(new Property(34, "Pennsylvania Avenue", 320, 28, 200, Color.Green));
		
		places.add(new Property(37, "Park Place", 350, 35, 200, Color.Blue));
		places.add(new Property(39, "Boardwalk", 400, 50, 200, Color.Blue));
		
		places.add(new Property(Utility.Electric_Company()));
		places.add(new Property(Utility.Water_Works()));
		
		places.add(new Property(RailRoad.Reading()));
		places.add(new Property(RailRoad.Pennsylvania()));
		places.add(new Property(RailRoad.BO()));
		places.add(new Property(RailRoad.ShortLine()));
		return places;
	}
	
	private static List<Card> setCards(String set)
	{
		List<Card> cards = new ArrayList<Card>();
		
		if(set.equals("Chance"))
		{
			cards.add(new Card(Chance.Cards()));
		}
		else
		{
			cards.add(new Card(Community_Chest.Cards()));
		}
		
		
		return cards;
	}
}
