/**
 * 
 */
package repository;

import java.util.List;

import engine.Player;

/**
 * @author bak12
 *
 */
public interface PlayerRepository
{
	public boolean createPlayer(Player player);
	public boolean updatePlayer(Player player);
	public boolean deletePlayer(Player player);
	public Player findPlayerById(int Id);
	public List<Player> findAllPlayers();
}
