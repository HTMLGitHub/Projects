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

import engine.InventoryItem;

/**
 * @author bak12
 *
 */
@Repository("InventoryItemRepo")
@Transactional
public class InventoryItemRepositoryImpl implements InventoryItemRepository
{
	private Logger log = Logger.getLogger(InventoryItemRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createInventoryItem(InventoryItem ii)
	{
		if(sessionFactory.getCurrentSession().save(ii) != null)
		{
			log.trace("Inventory Item Saved");
			return true;
		}
		log.error("Error Creating Inventory Item");
		return false;
	}

	@Override
	public boolean removeInventoryItem(InventoryItem ii)
	{
		InventoryItem invent = findInventoryItemById(ii.getId());
		
		if(invent != null)
		{
			sessionFactory.getCurrentSession().delete(ii);
			
			invent = findInventoryItemById(ii.getId());
			
			if(invent == null)
			{
				log.trace("Inventory Item Deleted");
				return true;
			}
		}
		log.error("Error Deleting Inventory Item");
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InventoryItem> getAllInventoryItems()
	{
		log.trace("Finding All Inventory Items");
		List<InventoryItem> ii = sessionFactory.openSession().createQuery("from InventoryItem").list();
		
		if(!ii.isEmpty())
		{
			log.trace("Inventory Items Found");
			return ii;
		}
		log.error("No Inventory Items Found");
		return null;
	}

	@Override
	public InventoryItem findInventoryItemById(int Id)
	{
		List<InventoryItem> invent = getAllInventoryItems();
		
		if(!invent.isEmpty())
		{
			log.trace("Finding Inventory Item with Id: " + Id);
			for(InventoryItem ii: invent)
			{
				if(ii.getId()==Id)
				{
					log.trace("Inventory Item Found");
					return ii;
				}
			}
			log.error("No Inventory Item with Id: " + Id + " found");
			return null;
		}
		log.error("No Inventory Items Found");
		return null;
	}
}