/**
 * 
 */
package repository;

import java.util.List;

import engine.Quest;

/**
 * @author bak12
 *
 */
public interface QuestRepository
{
	public boolean createQuest(Quest quest);
	public boolean updateQuest(Quest quest);
	public boolean deleteQuest(Quest quest);
	public List<Quest> getAllQuests();
	public Quest getQuestById(int Id);
	
}
