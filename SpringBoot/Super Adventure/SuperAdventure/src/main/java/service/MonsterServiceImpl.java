/**
 * 
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engine.LivingCreature;
import engine.Monster;
import repository.MonsterRepository;

/**
 * @author bak12
 *
 */
@Service("MonsterService")
public class MonsterServiceImpl implements MonsterService
{
	@Autowired
	public MonsterRepository monsterRepo;
	private LivingCreatureService creature;
	
	@Override
	public boolean createNewMonster(Monster monster)
	{
		if(creature.createCreature(new LivingCreature(monster.getCurrentHitPoints(), monster.getMaximumHitPoints())))
		{
			return monsterRepo.createMonster(monster);
		}
		return false;
	}

	@Override
	public Monster findMonsterById(int Id)
	{
		Monster monster = monsterRepo.getMonsterById(Id);
		
		if(monster != null)
		{
			LivingCreature lc = creature.getCreatureById(monster.getId());
			
			monster.setCurrentHitPoints(lc.getCurrentHitPoints());
			monster.setMaximumHitPoints(monster.getMaximumHitPoints());
			return monster;
		}
		return null;
	}

	@Override
	public List<Monster> findAllMonsters()
	{
		List<LivingCreature> livingCreatures = creature.getAllCreatures();
		List<Monster> monsters = monsterRepo.findAllMonsters();
		
		if(!livingCreatures.isEmpty()&&!monsters.isEmpty())
		{
			for(LivingCreature lc: livingCreatures)for(Monster m: monsters)
			{
				if(lc.getId()== m.getId())
				{
					m.setCurrentHitPoints(lc.getCurrentHitPoints());
					m.setMaximumHitPoints(lc.getMaximumHitPoints());
				}
			}
			return monsters;
		}	
		return null;
	}

	@Override
	public boolean deleteMonster(Monster monster)
	{
		if(creature.deleteLivingCreature(new LivingCreature(monster.getCurrentHitPoints(), monster.getMaximumHitPoints())))
		{
			return monsterRepo.deleteMonster(monster);
		}
		return false;
	}

	@Override
	public boolean updateMonster(Monster monster)
	{
		if(creature.updateLivingCreature(new LivingCreature(monster.getCurrentHitPoints(), monster.getMaximumHitPoints())))
		{
			return monsterRepo.updateMonster(monster);
		}
		return false;
	}
}