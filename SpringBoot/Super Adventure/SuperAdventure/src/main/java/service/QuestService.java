/**
 * 
 */
package service;

import java.util.List;

import engine.Quest;

/**
 * @author bak12
 *
 */
public interface QuestService
{
	public boolean createQuest(Quest quest);
	public boolean updateQuest(Quest quest);
	public boolean deleteQuest(Quest quest);
	public Quest findQuestById(int Id);
	public List<Quest> findAllQuests();
}
