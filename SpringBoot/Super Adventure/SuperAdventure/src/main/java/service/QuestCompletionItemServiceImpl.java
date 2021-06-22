/**
 * 
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engine.Item;
import engine.QuestCompletionItem;
import repository.QuestCompletionItemRepository;

/**
 * @author bak12
 *
 */
@Service("QuestCompletionItemService")
public class QuestCompletionItemServiceImpl implements QuestCompletionItemService
{
	@Autowired
	public QuestCompletionItemRepository qciRepo;
	private ItemService item;
	
	@Override
	public boolean createQuestCompletionItem(QuestCompletionItem qci)
	{
		return qciRepo.createQuestCompletionItem(qci);
	}

	@Override
	public boolean updateQuestCompletionItem(QuestCompletionItem qci)
	{
		return qciRepo.updateQuestCompletionItem(qci);
	}

	@Override
	public boolean deleteQuestCompletionItem(QuestCompletionItem qci)
	{
		return qciRepo.deleteQuestCompletionItem(qci);
	}

	@Override
	public QuestCompletionItem findQuestCompletionItemById(int Id)
	{
		QuestCompletionItem qci = qciRepo.findQuestCompletionItemById(Id);
		if(qci!=null)
		{
			Item i = item.findItemById(qci.getId());
			qci.setDetails(new Item(i.getId(), i.getName(), i.getPluralName()));
			return qci;
		}
		return null;
	}

	@Override
	public List<QuestCompletionItem> findAllQuestCompletionItems()
	{
		List<Item> items = item.findAllItems();
		List<QuestCompletionItem> qcis = qciRepo.getAllQuestCompletionItems();
		if(!items.isEmpty() && !qcis.isEmpty())
		{
			for(Item i: items)for(QuestCompletionItem qci: qcis)
			{
				if(i.getId() == qci.getId())
				{
					qci.setDetails(new Item(i.getId(), i.getName(), i.getPluralName()));
				}
			}
			return qcis;
		}
		return null;
	}
}