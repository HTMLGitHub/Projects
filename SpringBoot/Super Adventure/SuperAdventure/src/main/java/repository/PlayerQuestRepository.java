/**
 * 
 */
package repository;

import java.util.List;

import engine.PlayerQuest;

/**
 * @author bak12
 *
 */
public interface PlayerQuestRepository
{
	public boolean createPlayerQuest(PlayerQuest pq);
	public boolean updatePlayerQuest(PlayerQuest pq);
	public boolean deletePlayerQuest(PlayerQuest pq);
	public List<PlayerQuest> getAllPlayerQuests();
	public PlayerQuest getPlayerQuestById(int Id);
}
