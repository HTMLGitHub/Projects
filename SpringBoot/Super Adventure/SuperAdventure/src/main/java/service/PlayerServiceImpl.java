/**
 * 
 */
package service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engine.LivingCreature;
import engine.Player;
import repository.LivingCreatureRepository;
import repository.PlayerRepository;

/**
 * @author bak12
 *
 */
@Service("PlayerService")
public class PlayerServiceImpl implements PlayerService
{
	@Autowired
	public PlayerRepository playerRepo;
	
	@Autowired
	private LivingCreatureRepository creature;
	
	@Override
	public boolean createPlayer(Player player)
	{
		if(creature.createCreature(new LivingCreature(player.getCurrentHitPoints(), player.getMaximumHitPoints())))
		{
			return playerRepo.createPlayer(player);
		}
		return false;
	}

	@Override
	public boolean updatePlayer(Player player)
	{
		if(creature.updateLivingCreature(new LivingCreature(player.getCurrentHitPoints(), player.getMaximumHitPoints())))
		{
			return playerRepo.updatePlayer(player);
		}
		return false;
	}

	@Override
	public boolean deletePlayer(Player player)
	{
		if(creature.deleteLivingCreature(new LivingCreature(player.getCurrentHitPoints(), player.getMaximumHitPoints())))
		{
			return playerRepo.deletePlayer(player);
		}
		return false;
	}

	@Override
	public Player findPlayer(int Id)
	{
		Player player = playerRepo.findPlayerById(Id);
		if(player!=null)
		{
			LivingCreature lc = creature.getCreatureById(player.getId());
			
			player.setCurrentHitPoints(lc.getCurrentHitPoints());
			player.setMaximumHitPoints(lc.getMaximumHitPoints());
			return player;
		}
		return null;
	}

	@Override
	public List<Player> findAllPlayers()
	{
		List<LivingCreature> livingCreatures = creature.getAllCreatures();
		List<Player> players = playerRepo.findAllPlayers();
		if(!livingCreatures.isEmpty()&&!players.isEmpty())
		{
			for(LivingCreature lc: livingCreatures)for(Player p: players)
			{
				if(lc.getId()==p.getId())
				{
					p.setCurrentHitPoints(lc.getCurrentHitPoints());
					p.setMaximumHitPoints(lc.getMaximumHitPoints());
				}
			}
			return players;
		}
		return null;
	}
}
