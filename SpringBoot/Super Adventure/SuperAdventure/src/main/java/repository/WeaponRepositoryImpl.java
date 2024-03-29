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

import engine.Weapon;

/**
 * @author bak12
 *
 */
@Repository("WeaponRepo")
@Transactional
public class WeaponRepositoryImpl implements WeaponRepository
{
	private Logger log = Logger.getLogger(InventoryItemRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createWeapon(Weapon weapon)
	{
		if(sessionFactory.getCurrentSession().save(weapon)!=null)
		{
			log.trace("Weapon Saved");
			return true;
		}
		log.error("Error Saving Weapon");
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Weapon> getAllWeapons()
	{
		log.trace("Finding All Weapons");
		List<Weapon> weapons = sessionFactory.openSession().createQuery("from Weapon").list();
		if(!weapons.isEmpty())
		{
			log.trace("Weapons Found");
			return weapons;
		}
		log.error("No Weapons Found");
		return null;
	}

	@Override
	public Weapon getWeaponById(int Id)
	{
		List<Weapon> weapons = getAllWeapons();
		
		if(!weapons.isEmpty())
		{
			log.trace("Finding Weapon with Id: " + Id);
			for(Weapon w: weapons)
			{
				if(w.getId()==Id)
				{
					log.trace("Weapon Found");
					return w;
				}
			}
			log.error("No Weapon With Id: " + Id + " found");
			return null;
		}
		log.error("No Weapons Found");
		return null;
	}

	@Override
	public boolean updateWeapon(Weapon weapon)
	{
		try
		{
			sessionFactory.getCurrentSession().update(weapon);
		}
		catch(EntityNotFoundException ex)
		{
			log.error("Unable to update Weapon");
			log.error(ex.getMessage());
			return false;
		}
		log.trace("Weapon Updated");
		return true;
	}

	@Override
	public boolean deleteWeapon(Weapon weapon)
	{
		Weapon w = this.getWeaponById(weapon.getId());
		if(w!=null)
		{
			sessionFactory.getCurrentSession().delete(weapon);
			
			w = this.getWeaponById(weapon.getId());
			if(w==null)
			{
				log.trace("Weapon Deleted");
				return true;
			}
		}
		log.error("Error Deleting Weapon");
		return false;
	}
}
