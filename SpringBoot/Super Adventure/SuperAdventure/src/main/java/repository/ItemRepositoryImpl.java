/**
 * 
 */
package repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;
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

	@Override
	public boolean deleteItem(Item item)
	{
		Item i = this.findItemById(item.getId());
		if(i!=null)
		{
			sessionFactory.getCurrentSession().delete(item);
			
			i = this.findItemById(item.getId());
			
			if(i==null)
			{
				log.trace("Item Deleted");
				return true;
			}
		}
		log.error("Could not delete Item");
		return false;
	}

	@Override
	public boolean updateItem(Item item)
	{
		try
		{
			sessionFactory.getCurrentSession().update(item);
		}
		catch(EntityNotFoundException ex)
		{
			log.error("Unable to update Item");
			log.error(ex.getMessage());
			return false;
		}
		log.trace("Item Updated");
		return true;
	}
}
