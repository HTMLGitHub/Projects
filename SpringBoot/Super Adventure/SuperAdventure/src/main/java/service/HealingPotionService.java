/**
 * 
 */
package service;

import java.util.List;

import engine.HealingPotion;

/**
 * @author bak12
 *
 */
public interface HealingPotionService
{
	public boolean createHealing(HealingPotion hp);
	public boolean updateHealing(HealingPotion hp);
	public boolean deleteHealing(HealingPotion hp);
	public HealingPotion findPotionById(int Id);
	public List<HealingPotion> findAllHealingPotions();
}
