/**
 * 
 */
package repository;

import java.util.List;

import engine.LootItem;

/**
 * @author bak12
 *
 */
public interface LootItemRepository
{
	public boolean createLootItem(LootItem li);
	public boolean updateLootItem(LootItem li);
	public boolean deleteLootItem(LootItem li);
	public List<LootItem> getAllLootItems();
	public LootItem findLootItemById(int Id);
}
