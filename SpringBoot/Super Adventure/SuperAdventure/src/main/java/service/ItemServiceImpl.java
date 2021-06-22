/**
 * 
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engine.Item;
import repository.ItemRepository;

/**
 * @author bak12
 *
 */
@Service("ItemService")
public class ItemServiceImpl implements ItemService
{
	@Autowired
	public ItemRepository itemRepo;

	@Override
	public boolean createItem(Item item)
	{
		return itemRepo.createItem(item);
	}

	@Override
	public boolean deleteItem(Item item)
	{
		return itemRepo.deleteItem(item);
	}

	@Override
	public boolean updateItem(Item item)
	{
		return itemRepo.updateItem(item);
	}

	@Override
	public Item findItemById(int Id)
	{
		return itemRepo.findItemById(Id);
	}

	@Override
	public List<Item> findAllItems()
	{
		return itemRepo.getAllItems();
	}

}
