/**
 * 
 */
package service;

import java.util.List;

import engine.PlayerQuest;

/**
 * @author bak12
 *
 */
public interface PlayerQuestService
{
	public boolean createPlayerQuest(PlayerQuest pq);
	public boolean updatePlayerQuest(PlayerQuest pq);
	public boolean deletePlayerQuest(PlayerQuest pq);
	public PlayerQuest findPlayerQuest(int Id);
	public List<PlayerQuest> findAllPlayerQuests();
}
