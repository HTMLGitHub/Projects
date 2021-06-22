/**
 * 
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engine.Quest;
import repository.QuestRepository;

/**
 * @author bak12
 *
 */
@Service("QuestService")
public class QuestServiceImpl implements QuestService
{
	@Autowired
	public QuestRepository questRepo;

	@Override
	public boolean createQuest(Quest quest)
	{
		return questRepo.createQuest(quest);
	}

	@Override
	public boolean updateQuest(Quest quest)
	{
		return questRepo.updateQuest(quest);
	}

	@Override
	public boolean deleteQuest(Quest quest)
	{
		return questRepo.deleteQuest(quest);
	}

	@Override
	public Quest findQuestById(int Id)
	{
		return questRepo.getQuestById(Id);
	}

	@Override
	public List<Quest> findAllQuests()
	{
		return questRepo.getAllQuests();
	}

}
