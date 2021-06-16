/**
 * 
 */
package repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import engine.LootItem;

/**
 * @author bak12
 *
 */
@Repository("LootItemRepo")
@Transactional
public class LootItemRepositoryImpl implements LootItemRepository
{
	private Logger log = Logger.getLogger(InventoryItemRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createLootItem(LootItem li)
	{
		if(sessionFactory.getCurrentSession().save(li)!=null)
		{
			log.trace("Loot Item Created Successfully");
			return true;
		}
		log.error("Error Creating Loot Item");
		return false;
	}

	@Override
	public List<LootItem> getAllLootItems()
	{
		log.trace("Finding all Loot Items");
		@SuppressWarnings("unchecked")
		List<LootItem> LI = sessionFactory.openSession().createQuery("from LootItems").list();
		
		if(!LI.isEmpty())
		{
			log.trace("Loot Items Found");
			return LI;
		}
		log.error("No Loot Items Found");
		return null;
	}

	@Override
	public LootItem findLootItemById(int Id)
	{
		List<LootItem> lootItem = getAllLootItems();
		
		if(!lootItem.isEmpty())
		{
			log.trace("Finding Loot Item with Id: " + Id);
			for(LootItem li: lootItem)
			{
				if(li.getId()==Id)
				{
					log.trace("Loot Item Found");
				}
			}
			log.error("No Loot Item with Id: " + Id + " found");
			return null;
		}
		log.error("No Loot Items Found");
		return null;
	}
}