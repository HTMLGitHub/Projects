/**
 * 
 */
package repository;

import java.util.List;

import engine.Item;

/**
 * @author bak12
 *
 */
public interface ItemRepository
{
	public boolean createItem(Item item);
	public List<Item> getAllItems();
	public Item findItemById(int id);
}
