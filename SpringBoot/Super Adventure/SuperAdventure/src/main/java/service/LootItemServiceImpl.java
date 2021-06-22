/**
 * 
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engine.Item;
import engine.LootItem;
import repository.LootItemRepository;

/**
 * @author bak12
 *
 */
@Service("LootItemService")
public class LootItemServiceImpl implements LootItemService
{
	@Autowired
	public LootItemRepository lootItem;
	private ItemService item;
	
	@Override
	public boolean createLootItem(LootItem li)
	{
		if(item.createItem(new Item(li.getId(), li.getDetails().getName(), li.getDetails().getPluralName())))
		{
			return lootItem.createLootItem(li);
		}
		return false;
	}
	@Override
	public boolean updateLootItem(LootItem li)
	{
		if(item.createItem(new Item(li.getId(), li.getDetails().getName(), li.getDetails().getPluralName())))
		{
			return lootItem.updateLootItem(li);
		}
		return false;
	}
	@Override
	public boolean deleteLootItem(LootItem li)
	{
		if(item.createItem(new Item(li.getId(), li.getDetails().getName(), li.getDetails().getPluralName())))
		{
			return lootItem.deleteLootItem(li);
		}
		return false;
	}
	@Override
	public LootItem findLootItemById(int Id)
	{
		LootItem li = lootItem.findLootItemById(Id);
		if(li!=null)
		{
			Item i = item.findItemById(li.getId());
			
			li.setDetails(new Item(i.getId(), i.getName(), i.getPluralName()));
			return li;			
		}
		return null;
	}
	@Override
	public List<LootItem> findAllLootItems()
	{
		List<Item> items = item.findAllItems();
		List<LootItem> LIs = lootItem.getAllLootItems();
		if(!items.isEmpty() && !LIs.isEmpty())
		{
			for(Item i: items)for(LootItem li: LIs)
			{
				if(i.getId()==li.getId())
				{
					li.setDetails(new Item(i.getId(), i.getName(), i.getPluralName()));
				}
			}
			return LIs;
		}
		return null;
	}
	
}