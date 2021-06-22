/**
 * 
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engine.PlayerQuest;
import engine.Quest;
import repository.PlayerQuestRepository;

/**
 * @author bak12
 *
 */
@Service("PlayerQuestService")
public class PlayerQuestServiceImpl implements PlayerQuestService
{
	@Autowired
	public PlayerQuestRepository pqRepo;
	private QuestService quest;

	@Override
	public boolean createPlayerQuest(PlayerQuest pq)
	{
		return pqRepo.createPlayerQuest(pq);
	}

	@Override
	public boolean updatePlayerQuest(PlayerQuest pq)
	{
		return pqRepo.updatePlayerQuest(pq);
	}

	@Override
	public boolean deletePlayerQuest(PlayerQuest pq)
	{
		return pqRepo.deletePlayerQuest(pq);
	}

	@Override
	public PlayerQuest findPlayerQuest(int Id)
	{
		PlayerQuest pq = pqRepo.getPlayerQuestById(Id);
		if(pq!=null)
		{
			Quest q = quest.findQuestById(pq.getId());
			
			pq.setDetails(new Quest(q.getId(), q.getName(), q.getDescription(), q.getRewardExperiencePoints(), q.getRewardGold()));
			return pq;
		}
		return null;
	}

	@Override
	public List<PlayerQuest> findAllPlayerQuests()
	{
		List<Quest> quests = quest.findAllQuests();
		List<PlayerQuest> pquests = pqRepo.getAllPlayerQuests();
		if(!quests.isEmpty()&&!pquests.isEmpty())
		{
			for(Quest q: quests)for(PlayerQuest pq: pquests)
			{
				if(q.getId()==pq.getId())
				{
					pq.setDetails(new Quest(q.getId(), q.getName(), q.getDescription(), q.getRewardExperiencePoints(), q.getRewardGold()));
				}
			}
			return pquests;
		}
		return null;
	}
}
