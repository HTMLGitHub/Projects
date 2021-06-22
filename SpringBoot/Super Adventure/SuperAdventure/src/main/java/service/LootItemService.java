/**
 * 
 */
package service;

import java.util.List;

import engine.LootItem;

/**
 * @author bak12
 *
 */
public interface LootItemService
{
	public boolean createLootItem(LootItem li);
	public boolean updateLootItem(LootItem li);
	public boolean deleteLootItem(LootItem li);
	public LootItem findLootItemById(int Id);
	public List<LootItem> findAllLootItems();
}
