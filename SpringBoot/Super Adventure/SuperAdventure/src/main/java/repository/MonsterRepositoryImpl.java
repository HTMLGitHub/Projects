/**
 * 
 */
package repository;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import engine.Monster;

/**
 * @author bak12
 *
 */
@Repository("MonsterRepo")
@Transactional
public class MonsterRepositoryImpl implements MonsterRepository
{
	private Logger log = Logger.getLogger(InventoryItemRepositoryImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean createMonster(Monster monster)
	{
		if(sessionFactory.getCurrentSession().save(monster)!=null)
		{
			log.trace("Monster Created Successfully");
			return true;
		}		
		log.error("Error Creating Monster");
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Monster> findAllMonsters()
	{
		log.trace("Finding All Monsters");
		List<Monster> monsters = sessionFactory.openSession().createQuery("from Monsters").list();
		if(!monsters.isEmpty())
		{
			log.trace("Monsters Found");
			return monsters;
		}
		log.error("No Montsters Found");
		return null;
	}

	@Override
	public Monster getMonsterById(int Id)
	{
		List<Monster> monster = findAllMonsters();
		
		if(!monster.isEmpty())
		{
			log.trace("Finding Monster With Id: " + Id);
			for(Monster m: monster)
			{
				if(m.getId()==Id)
				{
					log.trace("Monster Found");
					return m;
				}
			}
			log.error("No Monster Found With Id: " + Id);
			return null;
		}
		log.error("No Monsters Found");
		return null;
	}
}