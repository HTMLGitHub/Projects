/**
 * 
 */
package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.ajax.OperatorMessage;

import static com.revature.util.OperatorMessageUtil.*;

import engine.HealingPotion;
import engine.InventoryItem;
import engine.Item;
import engine.Location;
import engine.LootItem;
import engine.Monster;
import engine.Player;
import engine.Quest;
import engine.QuestCompletionItem;
import engine.Weapon;
import service.ItemService;
import service.LocationService;
import service.MonsterService;
import service.PlayerService;
import service.QuestService;

/**
 * @author bak12
 *
 */
@Controller("WorldController")
@CrossOrigin(origins="http://localhost:4200")
public class WorldControllerImpl implements WorldController
{
	@Autowired
	private MonsterService creatureService;
	private ItemService itemService;
	private PlayerService playerService;
	private QuestService questService;
	private LocationService locationService;
	
	
	@PostMapping("/registerItem") //localhost:/8080/SuperAdventure/registerItem
	public @ResponseBody OperatorMessage CreateItem(@RequestBody Item item)
	{
		return(itemService.createItem(item))?ITEM_REGISTRATION_SUCCESSFUL: REGISTRATION_ERROR; 
	}


	@Override
	public OperatorMessage CreateMonster(Monster monster)
	{
		return(creatureService.createNewMonster(monster))? MONSTER_REGISTRATION_SUCCESSFUL: REGISTRATION_ERROR;
	}


	@Override
	public OperatorMessage CreateQuest(Quest quest)
	{
		return (questService.createQuest(quest))?QUEST_REGISTRATION_SUCCESSFUL:REGISTRATION_ERROR;
	}


	@Override
	public OperatorMessage CreateLocation(Location location)
	{
		return (locationService.createLocation(location))?LOCATION_REGISTRATION_SUCCESSFUL: REGISTRATION_ERROR;
	}

	@Override
	public OperatorMessage CreatePlayer(Player player)
	{
		return (playerService.createPlayer(player))?PLAYER_REGISTRATION_SUCCESSFUL: REGISTRATION_ERROR;
	}


	@Override
	public OperatorMessage UpdateItem(Item item)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OperatorMessage UpdateMonster(Monster monster)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OperatorMessage UpdateQuest(Quest quest)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OperatorMessage UpdateLocation(Location location)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OperatorMessage UpdatePlayer(Player player)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OperatorMessage DeleteItem(Item item)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OperatorMessage DeleteMonster(Monster monster)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OperatorMessage DeleteQuest(Quest quest)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OperatorMessage DeleteLocation(Location location)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OperatorMessage DeletePlayer(Player player)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Item> findAllItems()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Monster> findAllMonsters()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Quest> findAllQuests()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Location> findAllLocations()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<HealingPotion> findAllHealing()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<InventoryItem> findAllInventory()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<LootItem> findAllLootItems()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<QuestCompletionItem> findAllQuestItems()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Weapon> findAllWeapons()
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Item ItemById(Item item, HttpServletRequest req)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Monster MonsterById(Monster monster, HttpServletRequest req)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Quest QuestById(Quest quest, HttpServletRequest req)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Location LocationById(Location location, HttpServletRequest req)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Player PlayerById(Player player, HttpServletRequest req)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public HealingPotion PotionById(HealingPotion hp, HttpServletRequest req)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public InventoryItem InventoryItemById(InventoryItem ii, HttpServletRequest req)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public LootItem LootItemById(LootItem li, HttpServletRequest req)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public QuestCompletionItem QuestCompletionItemById(QuestCompletionItem qci, HttpServletRequest req)
	{
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Weapon WeaponById(Weapon w, HttpServletRequest req)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
