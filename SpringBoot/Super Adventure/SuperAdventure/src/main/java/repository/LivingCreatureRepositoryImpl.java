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

import engine.LivingCreature;

/**
 * @author bak12
 *
 */
@Repository("LivingCreatureRepo")
@Transactional
public class LivingCreatureRepositoryImpl implements LivingCreatureRepository
{
	private Logger log = Logger.getLogger(InventoryItemRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean createCreature(LivingCreature creature)
	{
		if(sessionFactory.getCurrentSession().save(creature)!=null)
		{
			log.trace("Living Creature Saved");
			return true;
		}
		log.error("Error Creating Living Creature");
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LivingCreature> getAllCreatures()
	{
		log.trace("Finding All Living Creatures");
		List<LivingCreature> lc = sessionFactory.openSession().createQuery("from LivingCreature").list();
		if(!lc.isEmpty())
		{
			log.trace("Living Creatures Found");
			return lc;
		}
		log.error("No Living Creatures Found");
		return null;
	}

	@Override
	public LivingCreature getCreatureById(int id)
	{
		List<LivingCreature> livingCreature = getAllCreatures();
		
		if(!livingCreature.isEmpty())
		{
			log.trace("Finding Living Creature with ID: " + id);
			for(LivingCreature lc: livingCreature)
			{
				if(lc.getId() == id)
				{
					log.trace("Living Creature Found");
					return lc;
				}
			}
			log.error("Living Creature with Id: " + id + " not found" );
			return null;
		}
		log.error("No Living Creature Found");
		return null;
	}
}