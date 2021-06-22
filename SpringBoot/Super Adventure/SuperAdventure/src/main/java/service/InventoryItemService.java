/**
 * 
 */
package service;

import java.util.List;

import engine.InventoryItem;

/**
 * @author bak12
 *
 */
public interface InventoryItemService
{
	public boolean createInventoryItem(InventoryItem ii);
	public boolean updateInventoryItem(InventoryItem ii);
	public boolean deleteInventoryItem(InventoryItem ii);
	public InventoryItem findInventoryItemById(int Id);
	public List<InventoryItem> findAllInventoryItems();
}
