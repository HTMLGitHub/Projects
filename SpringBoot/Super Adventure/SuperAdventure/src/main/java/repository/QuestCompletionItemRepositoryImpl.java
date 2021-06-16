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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<QuestCompletionItem> getAllQuestCompletionItems()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestCompletionItem findQuestCompletionItemById(int Id)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
