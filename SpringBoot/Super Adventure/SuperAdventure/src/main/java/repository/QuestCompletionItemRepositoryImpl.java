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

import engine.QuestCompletionItem;

/**
 * @author bak12
 *
 */
@Repository("QuestCompletionItemRepo")
@Transactional
public class QuestCompletionItemRepositoryImpl implements QuestCompletionItemRepository
{
	private Logger log = Logger.getLogger(InventoryItemRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createQuestCompletionItem(QuestCompletionItem qci)
	{
		if(sessionFactory.getCurrentSession().save(qci)!=null)
		{
			log.trace("Quest Completion Item Saved");
			return true;
		}
		log.error("Error Saving Quest Completion Item");
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestCompletionItem> getAllQuestCompletionItems()
	{
		log.trace("Finding all Quest Completion Items");
		List<QuestCompletionItem> qci = sessionFactory.openSession().createQuery("from QuestCompletionItems").list();
		if(!qci.isEmpty())
		{
			log.trace("Quest Completion Items Found");
			return qci;
		}
		log.error("No Quest Completion Items Found");
		return null;
	}

	@Override
	public QuestCompletionItem findQuestCompletionItemById(int Id)
	{
		List<QuestCompletionItem> questItems = getAllQuestCompletionItems();
		
		if(!questItems.isEmpty())
		{
			log.trace("Finding Quest Completion Item With Id: " + Id);
			for(QuestCompletionItem qci: questItems)
			{
				if(qci.getId()==Id)
				{
					log.trace("Quest Completion Item Found");
					return qci;
				}
			}
			log.error("Could Not Find Quest Completion Item With Id: " + Id);
			return null;
		}
		log.error("No Quest Completion Items");
		return null;
	}

	@Override
	public boolean updateQuestCompletionItem(QuestCompletionItem qci)
	{
		try
		{
			sessionFactory.getCurrentSession().update(qci);
		}
		catch(EntityNotFoundException ex)
		{
			log.error("Unable to update Quest Completion Item");
			log.error(ex.getMessage());
			return false;
		}
		log.trace("Quest Completion Item updated");
		return true;
	}

	@Override
	public boolean deleteQuestCompletionItem(QuestCompletionItem qci)
	{
		QuestCompletionItem questItem = this.findQuestCompletionItemById(qci.getId());
		if(questItem!=null)
		{
			sessionFactory.getCurrentSession().delete(qci);
			
			questItem = this.findQuestCompletionItemById(qci.getId());
			if(questItem == null)
			{
				log.trace("Quest Completion Item Deleted");
				return true;
			}
		}
		log.error("Could not delete Quest Completion Item");
		return false;
	}
}