/**
 * 
 */
package repository;

import java.util.List;

import engine.HealingPotion;

/**
 * @author bak12
 *
 */
public interface HealingPotionRepository
{
	public boolean createHealingPotion(HealingPotion healing);
	public boolean updateHealingPotion(HealingPotion healing);
	public boolean deleteHealingPotion(HealingPotion healing);
	public HealingPotion findHealingById(int Id);
	public List<HealingPotion> findAllHealingPotions();
}
