/**
 * 
 */
package engine;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author bak12
 *
 */
@Entity
@Getter @Setter @ToString @EqualsAndHashCode(callSuper=true)
public class Player extends LivingCreature
{
	private int Gold;
	private int ExperiencePoints;
	private int Level;
	
	private Location CurrentLocation;
	
	private List<InventoryItem> Inventory;
	private List<PlayerQuest> Quests;
	
	/**
	 * @param currentHitPoints
	 * @param maximumHitPoints
	 * @param gold
	 * @param experiencePoints
	 * @param level
	 */
	public Player(int currentHitPoints, int maximumHitPoints, int gold, int experiencePoints, int level)
	{
		super(currentHitPoints, maximumHitPoints);
		Gold = gold;
		ExperiencePoints = experiencePoints;
		Level = level;
		Inventory = new ArrayList<InventoryItem>();
		Quests = new ArrayList<PlayerQuest>();
	}

	public void setInventory(InventoryItem inventoryItem)
	{
		Inventory.add(inventoryItem);		
	}
	
	public void setQuests(PlayerQuest playerQuest)
	{
		Quests.add(playerQuest);		
	}
	
	/**
	 * Checks if there is an Item required to enter the new location
	 * Checks if the player has the required item to enter this location**/
	
	public boolean HasRequiredItemToEnterThisLocation(Location location)
	{
		//There is no required item for this location,
		//return true
		if(location.getItemRequiredToEnter() == null) return true;
		
		
		/*
		 * See if the player has the required item in their inventory*/
		for(InventoryItem ii: Inventory) if(ii.getDetails().getId() == location.getItemRequiredToEnter().getId()) return true; /*We found the required item, so return "true"*/
		
		/*We did not find the required item in player's inventory, so return false*/
		return false;
		
	}
	
	public boolean HasThisQuest(Quest quest)
	{
		for(PlayerQuest pq: Quests) if(pq.getDetails().getId()==quest.getId()) return true;
		
		return false;
	}
	
	public boolean CompletedThisQuest(Quest quest)
	{
		for(PlayerQuest pq: Quests) if(pq.getDetails().getId()==quest.getId()) return pq.isIsCompleted();
		
		return false;
	}

	public boolean HasAllQuestCompletionItems(Quest quest)
	{
		//see if the player has all the items needed to complete the quest here
		for(QuestCompletionItem qci: quest.getQuestCompletionItems())
		{
			boolean foundItemInPlayerInventory = false;
			
			//check each item in player's inventory, to see if they have it, and enough of it
			for(InventoryItem ii: Inventory)
			{
				if(ii.getDetails().getId() == qci.getDetails().getId()) // player has the item in their inventory
				{
					foundItemInPlayerInventory = true;
				
					if(ii.getQuantity() < qci.getQuantity()) return false; //the player does not have enough of this item to complete the quest
				}	
			}
			
			if(!foundItemInPlayerInventory) return false; //the player does not have any of this quest completion item in their inventory
		}
		
		return true; // if we got here, then the player must have all the required items, and enough of them to complete the quest.
	}
	
	public void RemoveQuestCompletionItems(Quest quest)
	{
		for(QuestCompletionItem qci: quest.getQuestCompletionItems())
		{
			for(InventoryItem ii: Inventory)
			{
				if(ii.getDetails().getId()==qci.getDetails().getId())
				{
					//subtract the quantity from the player's inventory that was needed to complete the quest
					ii.setQuantity(ii.getQuantity()-qci.getQuantity());
					break;
				}
			}
		}
	}
	
	public void AddItemToInventory(Item itemToAdd)
	{
		for(InventoryItem ii: Inventory)
		{
			if(ii.getDetails().getId() == itemToAdd.getId())
			{
				//they have the item in their inventory, so increase the quantity
				ii.setQuantity(ii.getQuantity() + 1);
				break;
			}
		}
		
		Inventory.add(new InventoryItem(itemToAdd, 1)); //they didnt have the item, so add it their inventory with a quantity of 1
	}
	
	public void MarkQuestCompleted(Quest quest)
	{
		for(PlayerQuest pq: Quests)
		{
			if(pq.getDetails().getId()==quest.getId())
			{
				pq.setIsCompleted(true); //mark is as completed
				break;					
			}
		}
	}
}