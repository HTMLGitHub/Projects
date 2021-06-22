/**
 * 
 */
package repository;

import java.util.List;

import engine.LivingCreature;

/**
 * @author bak12
 *
 */
public interface LivingCreatureRepository
{
	public boolean createCreature(LivingCreature creature);
	public boolean updateLivingCreature(LivingCreature creature);
	public boolean deleteLivingCreature(LivingCreature creature);
	public List<LivingCreature> getAllCreatures();
	public LivingCreature getCreatureById(int id);
	
}
