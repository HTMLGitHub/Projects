/**
 * 
 */
package repository;

import java.util.List;

import engine.QuestCompletionItem;

/**
 * @author bak12
 *
 */
public interface QuestCompletionItemRepository
{
	public boolean createQuestCompletionItem(QuestCompletionItem qci);
	public boolean updateQuestCompletionItem(QuestCompletionItem qci);
	public boolean deleteQuestCompletionItem(QuestCompletionItem qci);
	public List<QuestCompletionItem> getAllQuestCompletionItems();
	public QuestCompletionItem findQuestCompletionItemById(int Id);
}
