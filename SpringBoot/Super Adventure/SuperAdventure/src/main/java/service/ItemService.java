/**
 * 
 */
package service;

import java.util.List;

import engine.Item;

/**
 * @author bak12
 *
 */
public interface ItemService
{
	public boolean createItem(Item item);
	public boolean deleteItem(Item item);
	public boolean updateItem(Item item);
	public Item findItemById(int Id);
	public List<Item> findAllItems();
}
