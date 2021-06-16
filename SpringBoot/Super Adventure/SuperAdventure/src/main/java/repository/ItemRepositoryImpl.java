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

import engine.Item;

/**
 * @author bak12
 *
 */
@Repository("ItemRepo")
@Transactional
public class ItemRepositoryImpl implements ItemRepository
{
	private Logger log = Logger.getLogger(InventoryItemRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean createItem(Item item)
	{
		if(sessionFactory.getCurrentSession().save(item)!=null)
		{
			log.trace("Item Created");
			return true;
		}
		log.error("Error Creating Item");
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItems()
	{
		log.trace("Finding All Items");
		List<Item> items = sessionFactory.openSession().createQuery("from Items").list();	
		if(!items.isEmpty())
		{
			log.trace("Items Found");
			return items;
		}
		log.error("No Items Found");
		return null;
	}

	@Override
	public Item findItemById(int id)
	{
		List<Item> items = getAllItems();
		
		log.trace("Finding item with ID: " + id);
		if(!items.isEmpty())
		{
			for(Item i: items)
			{
				if(i.getId() == id)
				{
					log.trace("Item Found");
					return i;
				}
			}
			log.error("No item found with ID: " + id);
			return null;
		}
		log.error("No Items Found");
		return null;
	}
}