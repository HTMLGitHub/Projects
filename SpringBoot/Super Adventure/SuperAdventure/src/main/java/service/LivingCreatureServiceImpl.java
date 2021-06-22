/**
 * 
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engine.LivingCreature;
import repository.LivingCreatureRepository;

/**
 * @author bak12
 *
 */
@Service("CreatureService")
public class LivingCreatureServiceImpl implements LivingCreatureService
{
	@Autowired
	public LivingCreatureRepository creature;
	
	@Override
	public boolean createCreature(LivingCreature lc)
	{
		return creature.createCreature(lc); 
	}

	@Override
	public boolean deleteLivingCreature(LivingCreature lc)
	{
		return creature.deleteLivingCreature(lc);
	}

	@Override
	public boolean updateLivingCreature(LivingCreature lc)
	{
		return creature.updateLivingCreature(lc);
	}

	@Override
	public LivingCreature getCreatureById(int Id)
	{
		return creature.getCreatureById(Id);
	}

	@Override
	public List<LivingCreature> getAllCreatures()
	{
		return creature.getAllCreatures();
	}

}
