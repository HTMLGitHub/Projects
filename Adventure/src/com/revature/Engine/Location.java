package com.revature.Engine;

import java.util.Optional;

public class Location 
{
	private int ID;
	private String Name;
	private String Description;
	private Item ItemRequiredToEnter;
	private Quest QuestAvailableHere;
	private Monster MonsterLivingHere;
	private Location LocationToNorth;
	private Location LocationToEast;
	private Location LocationToSouth;
	private Location LocationToWest;
	
	 
	
	public Location(int iD, String name, String description, Optional<Item> itemRequiredToEnter, Optional<Quest> questAvailableHere,
			Optional<Monster> monsterLivingHere) 
	{
		setID(iD);
		setName(name);
		setDescription(description);
		setItemRequiredToEnter(itemRequiredToEnter);
		setQuestAvailableHere(questAvailableHere);
		setMonsterLivingHere(monsterLivingHere);
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Item getItemRequiredToEnter() {
		return ItemRequiredToEnter;
	}

	public void setItemRequiredToEnter(Optional<Item> itemRequiredToEnter) {
		ItemRequiredToEnter = itemRequiredToEnter.isPresent()?itemRequiredToEnter.get():null;
	}

	public Quest getQuestAvailableHere() {
		return QuestAvailableHere;
	}

	public void setQuestAvailableHere(Optional<Quest> questAvailableHere) {
		QuestAvailableHere = questAvailableHere.isPresent()? questAvailableHere.get():null;
	}

	public Monster getMonsterLivingHere() {
		return MonsterLivingHere;
	}

	public void setMonsterLivingHere(Optional<Monster> monsterLivingHere) {
		MonsterLivingHere = monsterLivingHere.isPresent()?monsterLivingHere.get():null;
	}

	public Location getLocationToNorth() {
		return LocationToNorth;
	}

	public void setLocationToNorth(Location locationToNorth) {
		LocationToNorth = locationToNorth;
	}

	public Location getLocationToEast() {
		return LocationToEast;
	}

	public void setLocationToEast(Location locationToEast) {
		LocationToEast = locationToEast;
	}

	public Location getLocationToSouth() {
		return LocationToSouth;
	}

	public void setLocationToSouth(Location locationToSouth) {
		LocationToSouth = locationToSouth;
	}

	public Location getLocationToWest() {
		return LocationToWest;
	}

	public void setLocationToWest(Location locationToWest) 
	{
		LocationToWest = locationToWest;
	}
}
