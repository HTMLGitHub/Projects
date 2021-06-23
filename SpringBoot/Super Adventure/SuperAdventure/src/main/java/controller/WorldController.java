/**
 * 
 */
package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.OperatorMessage;

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

/**
 * @author bak12
 *
 */
public interface WorldController
{
	//create 
	public OperatorMessage CreateItem(Item item);
	public OperatorMessage CreateMonster(Monster monster);
	public OperatorMessage CreateQuest(Quest quest);
	public OperatorMessage CreateLocation(Location location);
	public OperatorMessage CreatePlayer(Player player);
	
	//update
	public abstract OperatorMessage UpdateItem(Item item);
	public abstract OperatorMessage UpdateMonster(Monster monster);
	public abstract OperatorMessage UpdateQuest(Quest quest);
	public abstract OperatorMessage UpdateLocation(Location location);
	public abstract OperatorMessage UpdatePlayer(Player player);
	
	//delete
	public abstract OperatorMessage DeleteItem(Item item);
	public abstract OperatorMessage DeleteMonster(Monster monster);
	public abstract OperatorMessage DeleteQuest(Quest quest);
	public abstract OperatorMessage DeleteLocation(Location location);
	public abstract OperatorMessage DeletePlayer(Player player);
	
	//find all
	public abstract List<Item> findAllItems();
	public abstract List<Monster> findAllMonsters();
	public abstract List<Quest> findAllQuests();
	public abstract List<Location> findAllLocations();
	public List<HealingPotion> findAllHealing();
	public List<InventoryItem> findAllInventory();
	public List<LootItem> findAllLootItems();
	public List<QuestCompletionItem> findAllQuestItems();
	public List<Weapon> findAllWeapons();
		
	//find by Id
	public Item ItemById(Item item, HttpServletRequest req);
	public Monster MonsterById(Monster monster, HttpServletRequest req);
	public Quest QuestById(Quest quest, HttpServletRequest req);
	public Location LocationById(Location location, HttpServletRequest req);
	public Player PlayerById(Player player, HttpServletRequest req);
	public HealingPotion PotionById(HealingPotion hp, HttpServletRequest req);
	public InventoryItem InventoryItemById(InventoryItem ii, HttpServletRequest req);
	public LootItem LootItemById(LootItem li, HttpServletRequest req);
	public QuestCompletionItem QuestCompletionItemById(QuestCompletionItem qci, HttpServletRequest req);
	public Weapon WeaponById(Weapon w, HttpServletRequest req);
}
