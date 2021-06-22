/**
 * 
 */
package service;

import java.util.List;

import engine.QuestCompletionItem;

/**
 * @author bak12
 *
 */
public interface QuestCompletionItemService
{
	public boolean createQuestCompletionItem(QuestCompletionItem qci);
	public boolean updateQuestCompletionItem(QuestCompletionItem qci);
	public boolean deleteQuestCompletionItem(QuestCompletionItem qci);
	public QuestCompletionItem findQuestCompletionItemById(int Id);
	public List<QuestCompletionItem> findAllQuestCompletionItems();
}
