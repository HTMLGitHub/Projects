/**
 * 
 */
package repository;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import engine.Player;

/**
 * @author bak12
 *
 */
@Repository("PlayerRepo")
@Transactional
public class PlayerRepositoryImpl implements PlayerRepository
{
	private Logger log = Logger.getLogger(InventoryItemRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createPlayer(Player player)
	{
		if(sessionFactory.getCurrentSession().save(player)!=null)
		{
			log.trace("Player Created");
			return true;
		}
		log.error("Error Creating Player");
		return false;
	}

	@Override
	public boolean updatePlayer(Player player)
	{
		try 
		{
			sessionFactory.getCurrentSession().update(player);
		}
		catch(EntityNotFoundException ex)
		{
			log.error("Player Not Found");
			log.error(ex.getMessage());
			return false;
		}
		log.trace("Player Updated");
		return true;
	}

	@Override
	public boolean deletePlayer(Player player)
	{
		Player p = findPlayerById(player.getId());
		
		if(p!=null)
		{
			sessionFactory.getCurrentSession().delete(player);
			
			p = findPlayerById(player.getId());
			
			if(p==null)
			{
				log.trace("Player Deleted");
				return true;
			}
		}
		log.error("Error Deleting Player");
		return false;
	}
	
	@Override
	public Player findPlayerById(int Id)
	{
		List<Player> players = findAllPlayers();
		
		if(!players.isEmpty())
		{
			log.trace("Finding Player With Id: " + Id);
			for(Player p: players)
			{
				if(p.getId()==Id)
				{
					log.trace("Player Found");
				}
			}
			log.error("No Player Found With Id: " + Id);
			return null;
		}
		log.error("No Player Found");
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Player> findAllPlayers()
	{
		log.trace("Finding All Players");
		List<Player> players = sessionFactory.openSession().createQuery("from Player").list();
		if(!players.isEmpty())
		{
			log.trace("Player Found");
			return players;
		}
		log.error("No Players Found");
		return null;		
	}
}