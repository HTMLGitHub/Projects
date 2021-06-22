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

import engine.Location;

/**
 * @author bak12
 *
 */
@Repository("LocationRepo")
@Transactional
public class LocationRepositoryImpl implements LocationRepository
{
	private Logger log = Logger.getLogger(InventoryItemRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createLocation(Location location)
	{
		if(sessionFactory.getCurrentSession().save(location)!=null)
		{
			log.trace("Locataion Saved");
			return true;
		}
		log.error("Error Creating Location");
		return false;
	}

	@Override
	public boolean updateLocation(Location location)
	{
		try
		{
			sessionFactory.getCurrentSession().update(location);
		}
		catch(EntityNotFoundException e)
		{
			log.error("Location Not Found");
			log.error(e.getMessage());
			return false;
		}
		log.trace("Location Successfully Updated");
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Location> getAllLocations()
	{
		log.trace("Finding All Locations");
		List<Location> l = sessionFactory.openSession().createQuery("from Locations").list();
		if(!l.isEmpty())
		{
			log.trace("Locations Found");
			return l;
		}
		log.error("No Locations Found");
		return null;
	}
	@Override
	public Location getLocationById(int Id)
	{
		List<Location> locations = getAllLocations();
		
		if(!locations.isEmpty())
		{
			log.trace("Finding Locations with ID: " + Id);
			for(Location l: locations)
			{
				if(l.getId()==Id)
				{
					log.trace("Location Found");
					return l;
				}
			}
			log.error("No Location found with Id: " + Id);
			return null;
		}
		log.error("No Locations Found");
		return null;
	}

	@Override
	public boolean deleteLocation(Location location)
	{
		Location loc = this.getLocationById(location.getId());
		if(loc!=null)
		{
			sessionFactory.getCurrentSession().delete(location);
			loc = this.getLocationById(location.getId());
			if(loc==null)
			{
				log.trace("Location Deleted");
				return true;
			}
		}
		log.error("Could not delete Location");
		return false;
	}
}