/**
 * 
 */
package repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import engine.Quest;

/**
 * @author bak12
 *
 */
@Repository("QuestRepo")
@Transactional
public class QuestRepositoryImpl implements QuestRepository
{
	private Logger log = Logger.getLogger(InventoryItemRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createQuest(Quest quest)
	{
		if(sessionFactory.getCurrentSession().save(quest)!=null)
		{
			log.trace("Quest Saved");
			return true;
		}
		log.error("Error Saving Quest");
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Quest> getAllQuests()
	{
		log.trace("Getting All Quests");
		List<Quest> quests = sessionFactory.openSession().createQuery("from Quests").list();
		
		if(!quests.isEmpty())
		{
			log.trace("Quests Found");
			return quests;
		}
		log.error("Error Finding Quests");
		return null;
	}

	@Override
	public Quest getQuestById(int Id)
	{
		List<Quest> quests = getAllQuests();
		if(!quests.isEmpty())
		{
			log.trace("Finding Quests with Id: " + Id);
			for(Quest q: quests)
			{
				if(q.getId()==Id)
				{
					log.trace("Found Quest with Id: " + Id);
					return q;
				}
			}
			log.error("Could Not Find Quest With Id: " + Id);
			return null;
		}
		log.error("No Quests Found");
		return null;
	}

	@Override
	public boolean updateQuest(Quest quest)
	{
		try 
		{
			sessionFactory.getCurrentSession().update(quest);
		}
		catch(EntityNotFoundException ex)
		{
			log.error("Unable to update Quest");
			log.error(ex.getMessage());
			return false;
		}
		log.trace("Quest Updated");
		return true;
	}

	@Override
	public boolean deleteQuest(Quest quest)
	{
		Quest q = this.getQuestById(quest.getId());
		if(q!=null)
		{
			sessionFactory.getCurrentSession().delete(q);
			
			q = this.getQuestById(quest.getId());
			if(q==null)
			{
				log.trace("Quest Deleted");
				return true;
			}
		}
		log.error("Unable to delete Quest");
		return false;
	}
}