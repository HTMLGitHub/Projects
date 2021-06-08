package engine;

import java.util.ArrayList;
import java.util.List;

public class World
{
	public static final List<Item> Items = new ArrayList<Item>();
	public static final List<Monster> Monsters = new ArrayList<Monster>();
	public static final List<Quest> Quests = new ArrayList<Quest>();
	public static final List<Location> Locations = new ArrayList<Location>();
	
	
	/**
	 * Creating The World Elements Of Super Adventure
	 * */
	public World()
	{
		PopulateItems();
		PopulateMonsters();
		PopulateQuests();
		PopulateLocations();
	}
	
	/**
	 * Creating All The Items Used In Super Adventure
	 * */
	private static void PopulateItems()
	{
		Items.add(new Weapon(ITEM_ID.RUSTY_SWORD.ordinal(), "Rusty Sword", "Rusty Swords", 0, 5));
		Items.add(new Item(ITEM_ID.RAT_TAIL.ordinal(), "Rat Tail", "Rat Tails"));
		Items.add(new Item(ITEM_ID.PIECE_OF_FUR.ordinal(), "Piece Of Fur", "Pieces Of Fur"));
		Items.add(new Item(ITEM_ID.SNAKE_FANG.ordinal(), "Snake Fang", "Snake Fangs"));
		Items.add(new Weapon(ITEM_ID.CLUB.ordinal(), "Club", "Clubs", 3,10));
		Items.add(new HealingPotion(ITEM_ID.HEALING_POTION.ordinal(), "Healing Potion", "Healing Potions", 5));
		Items.add(new Item(ITEM_ID.SPIDER_FANG.ordinal(), "Spider Fang", "Spider Fangs"));
		Items.add(new Item(ITEM_ID.SPIDER_SILK.ordinal(), "Spider Silk", "Spider Silks"));
		Items.add(new Item(ITEM_ID.ADVENTURE_PASS.ordinal(), "Adventure Pass", "Adventure Passes"));
	}
	
	/**
	 * Creating All The Monsters In Super Adventure
	 * */
	private static void PopulateMonsters()
	{
		Monster rat = new Monster(MONSTER_ID.RAT.ordinal(), "Rat", 5,3,10,3,3);
		rat.setLootTable(new LootItem(ItemById(ITEM_ID.RAT_TAIL.ordinal()), 75, false));
		rat.setLootTable(new LootItem(ItemById(ITEM_ID.PIECE_OF_FUR.ordinal()), 75, true));
		
		Monster snake = new Monster(MONSTER_ID.SNAKE.ordinal(), "Snake", 5,3, 10, 3,3);
		snake.setLootTable(new LootItem(ItemById(ITEM_ID.SNAKE_FANG.ordinal()), 75, false));
		snake.setLootTable(new LootItem(ItemById(ITEM_ID.SNAKESKIN.ordinal()), 75, true));
		
		Monster giantSpider = new Monster(MONSTER_ID.GIANT_SPIDER.ordinal(), "Giant Spider", 20,5,40,10,10);
		giantSpider.setLootTable(new LootItem(ItemById(ITEM_ID.SPIDER_FANG.ordinal()), 75, true));
		giantSpider.setLootTable(new LootItem(ItemById(ITEM_ID.SPIDER_SILK.ordinal()), 20, false));
		
		Monsters.add(rat);
		Monsters.add(snake);
		Monsters.add(giantSpider);
	}
	
	/**
	 * Creating Quests Used In Super Adventure
	 * */
	private static void PopulateQuests()
	{
		Quest clearAlchemistGarden = new Quest (QUEST_ID.CLEAR_ALCHEMIST_GARDEN.ordinal(), "Clear The Alchemist's Garden", 
				"Kill Rats In The Alchemist's Garden, Bring Back 3 Rat Tails. You Will Receive A Healing Potion And 10 Gold Pieces.", 20,10);
		
		clearAlchemistGarden.setQuestCompletionItems(new QuestCompletionItem(ItemById(ITEM_ID.RAT_TAIL.ordinal()), 3));
		clearAlchemistGarden.setRewardItem(ItemById(ITEM_ID.HEALING_POTION.ordinal()));
		
		Quest clearFarmersField = new Quest(QUEST_ID.CLEAR_FARMERS_FIELD.ordinal(), "Clear The Farmer's Field", 
				"Kill Snakes In The Farmer's Field And Bring Back 3 Snake Fangs. You Will Recieve An Adventurer's Pass And 20 Gold Pieces", 20,20);
		clearFarmersField.setQuestCompletionItems(new QuestCompletionItem(ItemById(ITEM_ID.SNAKE_FANG.ordinal()), 3));
		clearFarmersField.setRewardItem(ItemById(ITEM_ID.ADVENTURE_PASS.ordinal()));
		
		Quests.add(clearAlchemistGarden);
		Quests.add(clearFarmersField);
	}
	
	/**
	 * Creating All The Locations In Super Adventure*/
	private static void PopulateLocations()
	{
		/**
		 * Create each location
		 */
		Location home = new Location(LOCATION_ID.HOME.ordinal(), "Home", "Your House. Looks Boring!");
		Location townSquare = new Location(LOCATION_ID.TOWN_SQUARE.ordinal(), "Town Square", "You See A Fountian");
		Location alchemistHut = new Location(LOCATION_ID.ALCHEMIST_HUT.ordinal(), "Alchemnist's Hut", "There Are Many Strange Plants On The Shelves");
		alchemistHut.setQuestAvailablehere(QuestById(QUEST_ID.CLEAR_ALCHEMIST_GARDEN.ordinal()));
		
		Location alchemistGarden = new Location(LOCATION_ID.ALCHEMIST_GARDEN.ordinal(), "Alchemist's Garden", "Many Plants Grow Here");
		alchemistGarden.setMonsterLivingHere(MonsterById(MONSTER_ID.RAT.ordinal()));
		
		Location farmHouse = new Location(LOCATION_ID.FARMHOUSE.ordinal(), "Farm House", "There Is A Small Farmhouse With A Farmer In Front");
		farmHouse.setQuestAvailablehere(QuestById(QUEST_ID.CLEAR_FARMERS_FIELD.ordinal()));
		
		Location farmersField = new Location(LOCATION_ID.FARM_FIELD.ordinal(), "Farmer's Field", "You See Rows Of Vegetables Growing Here!");
		farmersField.setMonsterLivingHere(MonsterById(MONSTER_ID.SNAKE.ordinal()));
		
		Location guardPost = new Location(LOCATION_ID.GUARD_POST.ordinal(), "Guard Post", 
				"There Is A Large, Tough-Looking Guard Here!", ItemById(ITEM_ID.ADVENTURE_PASS.ordinal()));
		
		Location bridge = new Location(LOCATION_ID.BRIDGE.ordinal(), "Bridge", "A Stone Bridge Crosses A Wide River.");
		
		Location spiderField = new Location(LOCATION_ID.SPIDER_FIELD.ordinal(), "Forest", "You See Spider Webs Covering The Trees In This Forest");
		spiderField.setMonsterLivingHere(MonsterById(MONSTER_ID.GIANT_SPIDER.ordinal()));
		
		//Link The locations together
		home.setLocationToNorth(townSquare);
		
		townSquare.setLocationToNorth(alchemistHut);
		townSquare.setLocationToSouth(home);
		townSquare.setLocationToEast(guardPost);
		townSquare.setLocationToWest(farmHouse);
		
		farmHouse.setLocationToEast(townSquare);
		farmHouse.setLocationToWest(farmersField);
		
		farmersField.setLocationToEast(farmHouse);
		
		alchemistHut.setLocationToSouth(townSquare);
		alchemistHut.setLocationToNorth(alchemistGarden);
		
		alchemistGarden.setLocationToSouth(alchemistHut);
		
		guardPost.setLocationToEast(bridge);
		guardPost.setLocationToWest(townSquare);
		
		bridge.setLocationToWest(guardPost);
		bridge.setLocationToEast(spiderField);
		
		spiderField.setLocationToWest(bridge);
		
		/**
		 * Add the Locations To The Static List
		 * */
		Locations.add(home);
		Locations.add(townSquare);
		Locations.add(guardPost);
		Locations.add(alchemistHut);
		Locations.add(alchemistGarden);
		Locations.add(farmHouse);
		Locations.add(farmersField);
		Locations.add(bridge);
		Locations.add(spiderField);
	}
	
	public static Item ItemById(int id)
	{
		for(Item item: Items)
		{
			if(item.getId()==id) return item;
		}
		
		return null;
	}
	
	public static Monster MonsterById(int id)
	{
		for(Monster monster: Monsters)
		{
			if(monster.getId() == id) return monster;
		}
		
		return null;
	}
	
	public static Quest QuestById(int id)
	{
		for(Quest quest: Quests)
		{
			if(quest.getId()==id) return quest;
		}
		
		return null;
	}
	
	public static Location LocationById(int id)
	{
		for(Location location: Locations)
		{
			if(location.getId()== id) return location;
		}
		
		return null;
	}
}