/**
 * 
 */
package repository;

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
	
}