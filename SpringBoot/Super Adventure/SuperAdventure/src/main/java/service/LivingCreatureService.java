/**
 * 
 */
package service;

import java.util.List;

import engine.LivingCreature;

/**
 * @author bak12
 *
 */
public interface LivingCreatureService
{
	public boolean createCreature(LivingCreature lc);
	public boolean deleteLivingCreature(LivingCreature lc);
	public boolean updateLivingCreature(LivingCreature lc);
	public LivingCreature getCreatureById(int Id);
	public List<LivingCreature> getAllCreatures();
}
