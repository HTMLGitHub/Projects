/**
 * 
 */
package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engine.HealingPotion;
import engine.Item;
import repository.HealingPotionRepository;

/**
 * @author bak12
 *
 */
@Service("HealingPotionService")
public class HealingPotionServiceImpl implements HealingPotionService
{
	@Autowired
	public HealingPotionRepository hpRepo;
	private ItemService itemService;

	@Override
	public boolean createHealing(HealingPotion hp)
	{
		if(itemService.createItem(new Item(hp.getId(), hp.getName(), hp.getPluralName())))
		{
			return hpRepo.createHealingPotion(hp);
		}
		return false;
	}

	@Override
	public boolean updateHealing(HealingPotion hp)
	{
		if(itemService.updateItem(new Item(hp.getId(), hp.getName(), hp.getPluralName())))
		{
			return hpRepo.updateHealingPotion(hp);
		}
		return false;
	}

	@Override
	public boolean deleteHealing(HealingPotion hp)
	{
		if(itemService.deleteItem(new Item(hp.getId(), hp.getName(), hp.getPluralName())))
		{
			return hpRepo.deleteHealingPotion(hp);
		}
		return false;
	}

	@Override
	public HealingPotion findPotionById(int Id)
	{
		HealingPotion hp = hpRepo.findHealingById(Id);
		if(hp!=null)
		{
			Item item = itemService.findItemById(hp.getId());
			
			hp.setName(item.getName());
			hp.setPluralName(item.getPluralName());
			return hp;
		}
		return null;
	}

	@Override
	public List<HealingPotion> findAllHealingPotions()
	{
		List<Item> items = itemService.findAllItems();
		List<HealingPotion> hps = hpRepo.findAllHealingPotions();
		if(!items.isEmpty() && !hps.isEmpty())
		{
			for(Item i: items)for(HealingPotion hp: hps)
			{
				if(i.getId()== hp.getId())
				{
					hp.setName(i.getName());
					hp.setPluralName(i.getPluralName());
				}
			}
			return hps;
		}
		return null;
	}

}
