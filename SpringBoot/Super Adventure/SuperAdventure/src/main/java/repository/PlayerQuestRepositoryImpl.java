/**
 * 
 */
package repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import engine.PlayerQuest;

/**
 * @author bak12
 *
 */
@Repository("PlayerQuestRepo")
@Transactional
public class PlayerQuestRepositoryImpl implements PlayerQuestRepository
{
	private Logger log = Logger.getLogger(InventoryItemRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean createPlayerQuest(PlayerQuest pq)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePlayerQuest(PlayerQuest pq)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePlayerQuest(PlayerQuest pq)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PlayerQuest> getAllPlayerQuests()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerQuest getPlayerQuestById(int Id)
	{
		// TODO Auto-generated method stub
		return null;
	}

}