package superAdventure;

import java.util.ArrayList;
import java.util.List;

import engine.HealingPotion;
import engine.ITEM_ID;
import engine.InventoryItem;
import engine.LOCATION_ID;
import engine.Location;
import engine.LootItem;
import engine.Monster;
import engine.Player;
import engine.PlayerQuest;
import engine.QuestCompletionItem;
import engine.Weapon;
import engine.World;

public class SuperAdventure
{
	private Player _player;
	private Monster _currentMonster;
	
	private String rtbMessages;
	private String rtbLocation;
	
	public SuperAdventure()
	{
		_player = new Player(10,10,20,0,1);
		MoveTo(World.LocationById(LOCATION_ID.HOME.ordinal()));
		_player.setInventory(new InventoryItem(World.ItemById(ITEM_ID.RUSTY_SWORD.ordinal()), 1));
	}
	
	private void North()
	{
		MoveTo(_player.getCurrentLocation().getLocationToNorth());
	}
	
	private void South() 
	{
		MoveTo(_player.getCurrentLocation().getLocationToSouth());
	}
	
	private void East() 
	{
		MoveTo(_player.getCurrentLocation().getLocationToEast());
	}
	
	private void West() 
	{
		MoveTo(_player.getCurrentLocation().getLocationToWest());
	}
	
	private void MoveTo(Location newLocation)
	{
		//Does location have any required items
		if(!_player.HasRequiredItemToEnterThisLocation(newLocation))
		{
			rtbMessages = "You must have a " + newLocation.getItemRequiredToEnter().getName() + " to enter this location.\n";
			return;
		}
		
		//update the player's current location
		_player.setCurrentLocation(newLocation);
		
		//TODO Show/Hide available movement buttons
		//North_Button.visible = (newLocation.LocationToNorth != null);
		//South_Button.visible = (newLocation.LocationToSouth != null);
		//East_Button.visible = (newLocation.LocationToEast != null);
		//West_Button.visible = (newLocation.LocationToWest != null);
		
		//Display current location name and description
		rtbLocation = newLocation.getName() + "\n" + newLocation.getDescription() + "\n";
		
		
		//Completely heal the player
		_player.setCurrentHitPoints(_player.getMaximumHitPoints());
		
		//TODO Update Hit Points in UI
		//label Hit_Points.text = _player.getCurrentHitPoints.ToString();
		
		//does the location have a quest?
		if(newLocation.getQuestAvailablehere() != null)
		{
			//see if the player already has the quest, an dif they have completed it
			boolean playerAlreadyHasQuest = _player.HasThisQuest(newLocation.getQuestAvailablehere());
			boolean playerAlreadyCompletedQuest = _player.CompletedThisQuest(newLocation.getQuestAvailablehere());
		
			//see if the player already has the quest
			if(playerAlreadyHasQuest)
			{
				//has the player completed the quest
				if(!playerAlreadyCompletedQuest)
				{
					//see if the player has all of the items needed to complete the quest
					boolean playerHasAllItemsToCompleteQuest = _player.HasAllQuestCompletionItems(newLocation.getQuestAvailablehere());
					
					//the player has all items required to complete the quest
					if(playerHasAllItemsToCompleteQuest)
					{
						//display message
						rtbMessages += "\nYou complete the " + newLocation.getQuestAvailablehere().getName() + " quest.\n";
						
						
						//remove quest items from inventory
						_player.RemoveQuestCompletionItems(newLocation.getQuestAvailablehere());
						
						//give quest rewards
						rtbMessages += "You recieve: \n" + newLocation.getQuestAvailablehere().getRewardExperiencePoints() + " experience points, \n" +
						newLocation.getQuestAvailablehere().getRewardGold() + " gold \n" + newLocation.getQuestAvailablehere().getRewardItem().getName() + "\n\n";
						
						
						
						
						_player.setExperiencePoints(_player.getExperiencePoints() + newLocation.getQuestAvailablehere().getRewardExperiencePoints());
						_player.setGold(_player.getGold() + newLocation.getQuestAvailablehere().getRewardGold());
						
						//add the reward item to the player's inventory
						_player.AddItemToInventory(newLocation.getQuestAvailablehere().getRewardItem());
						
						//Mark the quest as competed
						_player.MarkQuestCompleted(newLocation.getQuestAvailablehere());
					}
				}
			}
			else
			{
				//the player does not already have the quest
				
				//display messages
				rtbMessages += "You recieve the " + newLocation.getQuestAvailablehere().getName() + " quest. \n" + newLocation.getQuestAvailablehere().getDescription() +"\nTo complete it, return with:\n";
				
				
				for(QuestCompletionItem qci: newLocation.getQuestAvailablehere().getQuestCompletionItems())
				{
					rtbMessages += qci.getQuantity(); 
					rtbMessages += (qci.getQuantity()==1)? qci.getDetails().getName() : qci.getDetails().getPluralName();
					rtbMessages += "\n";
				}
				
				
				
				
				
				rtbMessages += "\n";
				
				//add the quest to the player's quest list
				_player.setQuests(new PlayerQuest(newLocation.getQuestAvailablehere()));
			}
		}
		
		//does the location have a monster?
		if(newLocation.getMonsterLivingHere() != null)
		{
			rtbMessages += "You see a " + newLocation.getMonsterLivingHere().getName() + "\n";
			
			//make a new monster, using the values from the standard monster in the World.Monster list
			Monster standardMonster = World.MonsterById(newLocation.getMonsterLivingHere().getId());
			
			_currentMonster = new Monster(standardMonster.getId(), standardMonster.getName(), standardMonster.getMaximumDamage(), standardMonster.getRewardExperiencePoints(),
					standardMonster.getRewardGold(), standardMonster.getCurrentHitPoints(), standardMonster.getMaximumHitPoints());
			
			for(LootItem lootItem: standardMonster.getLootTable())
			{
				_currentMonster.setLootTable(lootItem);
			}
			/**TODO set visibility of: weapons, potions
			*cboWeapon.Visible = true
			*cboPotions.visible = true
			*btnUseWeapon.visible = true
			*btnUsePotion.visible = true*/
		}
		else
		{
			_currentMonster = null;
			/**TODO set visibility of: weapons, potions
			*cboWeapon.Visible = false
			*cboPotions.visible = false
			*btnUseWeapon.visible = false
			*btnUsePotion.visible = false*/
		}
		
		//refresh player's inventory list
		UpdateInventoryListInUI();
		  
		//refresh player's quest list
		UpdateQuestListInUI();
		
		//refresh player's weapons combobox
		UpdateWeaponListInUI();
		  
		//refresh player's potions combobox
		UpdatePotionListInUI();
	}
	
	private void UpdateInventoryListInUI()
	{
		/* TODO Auto-generated method stub
		
		dgvInventory.RowHeadersVisible = false;
			
		dgvInventory.ColumnCount = 2;
		dgvInventory.Columns[0].Name = "Name";
		dgvInventory.Columns[0].Width = 197;
		dgvInventory.Columns[1].Name = "Quantity";
		
		dgvInventory.Rows.Clear();
		
		foreach(InventoryItem inventoryItem in _player.Inventory)
		{
			if(inventoryItem.Quantity > 0) dgvInventory.Rows.Add(new[] { inventoryItem.Details.Name, inventoryItem.Quantity.ToString() });
		
	 	}*/	 			
	}
		 
	private void UpdateQuestListInUI()
	{
		/* TODO Auto-generated method stub
		dgvQuests.RowHeadersVisible = false;
			
		dgvQuests.ColumnCount = 2;
		dgvQuests.Columns[0].Name = "Name";
		dgvQuests.Columns[0].Width = 197;
		dgvQuests.Columns[1].Name = "Done?";
		
		dgvQuests.Rows.Clear();
		
		foreach(PlayerQuest playerQuest in _player.Quests) dgvQuests.Rows.Add(new[] { playerQuest.Details.Name, playerQuest.IsCompleted.ToString() });*/	
	
	
	}
	
	private void UpdateWeaponListInUI()
	{
		/* TODO Auto-generated method stub
		List<Weapon> weapons = new ArrayList<Weapon>();
		for(InventoryItem inventoryItem: _player.getInventory())
		{
			if(inventoryItem.getDetails() instanceof Weapon)
			{
				if(inventoryItem.getQuantity() > 0)
				{
					weapons.add((Weapon)inventoryItem.getDetails());
				}
			}
		}
		if(weapons.size() == 0)
		{
			//the player does not have any weapons, so hide the weapon combobox and Use button
			//TODO
			 * cboWeapons.visible = false
			 * btnUseWeapon.visible=fasle
		}
		else
		{			
			 * cboWeapons.datasource = weapons
			 * cboWeapons.displyamember = "name"
			 * cboWeapons.valueMember = "ID"
			 * cboWeapons.selectedIndex = 0;
			 * 
		} */
	}
		
	private void UpdatePotionListInUI()
	{
		/* TODO Auto-generated method stub
		//refresh player's potions combobox
		List<HealingPotion> healingPotions = new ArrayList<HealingPotion>();
		for(InventoryItem inventoryItem: _player.getInventory())
		{
			if(inventoryItem.getDetails() instanceof HealingPotion)
			{
				if(inventoryItem.getQuantity() > 0)
				{
					healingPotions.add((HealingPotion)inventoryItem.getDetails());
				}
			}
		}
		if(healingPotions.size()==0)
		{
			//the player does not have any healing potions, so hide the potion combobox and use button
			* cboPotions.visible = false
			* btnUsePotion.visible=fasle
		}
		else
		{
			 * cboPotions.datasource = healingPotions
			 * cboPotions.displyamember = "name"
			 * cboPotions.valueMember = "ID"
			 * cboPotions.selectedIndex = 0;
			 * 
		}*/
	}
	
	private void btnUseWeapon_Click() 
	{
		
	}
	
	private void btnUsePotion_Click() 
	{
		
	}
}