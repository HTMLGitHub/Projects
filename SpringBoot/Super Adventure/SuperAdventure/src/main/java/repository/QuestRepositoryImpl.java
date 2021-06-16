/**
 * 
 */
package repository;

import java.util.List;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Quest> getAllQuests()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Quest getQuestById(int Id)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
