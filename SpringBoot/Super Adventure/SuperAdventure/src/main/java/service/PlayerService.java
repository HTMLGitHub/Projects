/**
 * 
 */
package service;

import java.util.List;
import engine.Player;

/**
 * @author bak12
 *
 */
public interface PlayerService
{
	public boolean createPlayer(Player player);
	public boolean updatePlayer(Player player);
	public boolean deletePlayer(Player player);
	public Player findPlayer(int Id);
	public List<Player> findAllPlayers();
}
