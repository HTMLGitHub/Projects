/**
 * 
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engine.InventoryItem;
import engine.Item;
import repository.InventoryItemRepository;

/**
 * @author bak12
 *
 */
@Service("InventoryItemService")
public class InventoryItemServiceImpl implements InventoryItemService
{
	@Autowired
	public InventoryItemRepository inventoryItemRepo;
	private ItemService itemService;
	

	@Override
	public boolean createInventoryItem(InventoryItem ii)
	{
		return inventoryItemRepo.createInventoryItem(ii);
	}

	@Override
	public boolean updateInventoryItem(InventoryItem ii)
	{
		return inventoryItemRepo.updateInventoryItem(ii);
	}

	@Override
	public boolean deleteInventoryItem(InventoryItem ii)
	{
		return inventoryItemRepo.removeInventoryItem(ii);
	}

	@Override
	public InventoryItem findInventoryItemById(int Id)
	{
		InventoryItem ii = inventoryItemRepo.findInventoryItemById(Id);
		if(ii!=null)
		{
			Item item = itemService.findItemById(ii.getId());
			
			ii.setDetails(new Item(item.getId(), item.getName(), item.getPluralName()));
			return ii;
		}
		return null;
	}

	@Override
	public List<InventoryItem> findAllInventoryItems()
	{
		List<Item> items = itemService.findAllItems();
		List<InventoryItem> iis = inventoryItemRepo.getAllInventoryItems();
		if(!items.isEmpty() && !iis.isEmpty())
		{
			for(Item i: items)for(InventoryItem ii: iis)
			{
				if(i.getId()==ii.getId())
				{
					ii.setDetails(new Item(i.getId(), i.getName(), i.getPluralName()));
				}
			}
			return iis;
		}
		return null;
	}

}
