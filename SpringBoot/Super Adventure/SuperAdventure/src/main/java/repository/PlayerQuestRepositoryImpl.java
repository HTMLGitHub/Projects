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

import engine.PlayerQuest;

/**
 * @author bak12
 *
 */
@Repository("PlayerQuestRepo")
@Transactional
public class PlayerQuestRepositoryImpl implements PlayerQuestRepository
{
	private Logger log = Logger.getLogger(InventoryItemRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean createPlayerQuest(PlayerQuest pq)
	{
		if(sessionFactory.getCurrentSession().save(pq)!=null)
		{
			log.trace("Player Quest Added");
			return true;
		}
		log.error("Error Creating Player Quest");
		return false;
	}

	@Override
	public boolean updatePlayerQuest(PlayerQuest pq)
	{
		try
		{
			sessionFactory.getCurrentSession().update(pq);
		}
		catch(EntityNotFoundException ex)
		{
			log.error("Player Quest Not Found");
			log.error(ex.getMessage());
			return false;
		}
		
		log.trace("Player Quest Updated");
		return true;
	}

	@Override
	public boolean deletePlayerQuest(PlayerQuest pq)
	{
		PlayerQuest playerQuest = getPlayerQuestById(pq.getId());
		if(playerQuest!=null)
		{
			sessionFactory.getCurrentSession().delete(pq);
			
			 playerQuest = getPlayerQuestById(pq.getId());
			 if(playerQuest==null)
			 {
				 log.trace("Player Quest Deleted");
				 return true;
			 }
		}
		log.error("Error Deleting Player Quest");
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PlayerQuest> getAllPlayerQuests()
	{
		log.trace("Finding All Player Quests");
		List<PlayerQuest> pq = sessionFactory.openSession().createQuery("from PlayerQuest").list();
		
		if(!pq.isEmpty())
		{
			log.trace("Player Quests Found");
			return pq;
		}
		log.error("No Player Quests Found");
		return null;
	}

	@Override
	public PlayerQuest getPlayerQuestById(int Id)
	{
		List<PlayerQuest> playerQuests = getAllPlayerQuests();
	
		if(!playerQuests.isEmpty())
		{
			for(PlayerQuest pq: playerQuests)
			{
				if(pq.getId() == Id)
				{
					log.trace("Player Quest Found");
					return pq;
				}
			}
			log.error("Player Quest With Id: " + Id + " not Found");
			return null;
		}
		log.error("No Player Quests Found");
		return null;
	}
}