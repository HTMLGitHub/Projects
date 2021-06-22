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

import engine.HealingPotion;

/**
 * @author bak12
 *
 */
@Repository("HealRepo")
@Transactional
public class HealingPotionRepositoryImpl implements HealingPotionRepository
{
	private Logger log = Logger.getLogger(HealingPotionRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean createHealingPotion(HealingPotion healing)
	{
		if(sessionFactory.getCurrentSession().save(healing) != null)
		{
			log.trace("Healing Potion Added");
			return true;
		}
		log.error("Error Creating Healing Potion");
		return false;
	}

	@Override
	public boolean updateHealingPotion(HealingPotion healing)
	{
		try
		{
			sessionFactory.getCurrentSession().update(healing);
		}
		catch(EntityNotFoundException ex)
		{
			log.error("Unable to update Potion");
			log.error(ex.getMessage());
			return false;
		}
		log.trace("Healing Potion Updated");
		return true;
	}

	@Override
	public boolean deleteHealingPotion(HealingPotion healing)
	{
		HealingPotion hp = this.findHealingById(healing.getId());
		if(hp!=null)
		{
			hp = this.findHealingById(healing.getId());
			if(hp==null)
			{
				log.trace("Healing Potion Deleted");
				return true;
			}
		}
		log.error("Could not delete Healing Potion");
		return false;
	}

	@Override
	public HealingPotion findHealingById(int Id)
	{
		List<HealingPotion> hps = findAllHealingPotions();
		if(!hps.isEmpty())
		{
			log.trace("Finding Healing Potion with Id: " + Id);
			for(HealingPotion hp: hps)
			{
				if(hp.getId() == Id)
				{
					log.trace("Healing Potion Found");
					return hp;
				}
			}
			log.error("No Healing Potion Found with Id: " + Id);
			return null;
		}
		log.error("No Healing Potions Found");
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HealingPotion> findAllHealingPotions()
	{
		log.trace("Finding All Healing Potions");
		List<HealingPotion> hps = sessionFactory.openSession().createQuery("from HealingPotion").list();
		if(!hps.isEmpty())
		{
			log.trace("Healing Potions Found");
			return hps;
		}
		log.error("No Healing Potions Found");
		return null;
	}
}