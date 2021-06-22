/**
 * 
 */
package service;

import java.util.List;
import engine.Monster;

/**
 * @author bak12
 *
 */
public interface MonsterService
{
	public boolean createNewMonster(Monster monster);
	public boolean deleteMonster(Monster monster);
	public boolean updateMonster(Monster monster);
	public Monster findMonsterById(int Id);
	public List<Monster> findAllMonsters();	
}
